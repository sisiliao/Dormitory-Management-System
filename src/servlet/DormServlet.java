package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BuildingDao;
import dao.DormDao;
import entity.Building;

public class DormServlet extends HttpServlet {

	public DormServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
			try {
			if(action==null || action.equals("")||action.equals("select")){
				this.select(request, response);
			}else if(action.equals("add")){
				this.add(request, response);
			}else if(action.equals("delete")){
				this.delete(request, response);
			}else if(action.equals("update")){
				this.update(request, response);
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		int did = Integer.parseInt(request.getParameter("did"));
		int dname = Integer.parseInt(request.getParameter("dname"));
		int dmaxnum = Integer.parseInt(request.getParameter("dmaxnum"));
		int dactualnum = Integer.parseInt(request.getParameter("dactualnum"));
		String dtype = request.getParameter("dtype");
		try {
			dtype = new String(dtype.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql = "update dorms set dname=?, dmaxnum=?, dactualnum=?, dtype=? where did=?";
		Object[] o = {dname, dmaxnum, dactualnum, dtype, did};
		DormDao dd = new DormDao();
		int i;
		try {
			i = dd.insertAdmin(sql, o);
			if(i>0)this.select(request, response);
			else{
				response.sendRedirect("error.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
		int did = Integer.parseInt(request.getParameter("did"));
		String sql = "delete from Dorms where did = ?";
		Object[] o = {did};
		DormDao dd = new DormDao();
		int i = dd.insertAdmin(sql, o);
		if(i>0)this.select(request, response);
		else{
			response.sendRedirect("error.jsp");
		}
		
	}
	
	//添加宿舍，同时改变了楼栋表中的宿舍数量
	private void add(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String buildingnumber=request.getParameter("buildingnumber");
		buildingnumber = new String(buildingnumber.getBytes("iso-8859-1"),"utf-8");
		int dname = Integer.parseInt(request.getParameter("dname"));
		String dgender = request.getParameter("dgender");
		dgender = new String(dgender.getBytes("iso-8859-1"),"utf-8");
		int dmaxnum = Integer.parseInt(request.getParameter("dmaxnum"));
		int dactualnum = Integer.parseInt(request.getParameter("dactualnum"));
		String dtype = request.getParameter("dtype");
		dtype = new String(dtype.getBytes("iso-8859-1"),"utf-8");
		BuildingDao bd = new BuildingDao();
		String bsql = "select * from building where buildingnumber=?";
		Object[] bo ={buildingnumber};
		List list = new ArrayList();
		list = bd.buidingList(bsql, bo);
		Building building = (Building)list.get(0);
		int bid = building.getBid();
		String sql = "insert into dorms values(seq_dorm.nextval,?,?,?,?,?,?)";
		Object[] o = {bid, dname, dmaxnum, dactualnum, dtype, dgender};
		DormDao dd = new DormDao();
		int i = dd.insertAdmin(sql, o);
		if(i>0){
			//楼栋表中将宿舍数量+1：dormnumber
			int dormnumber = building.getDormnumber()+1;
			String sqldormnumber = "update building set dormnumber=? where bid=?";
			Object[] doo={dormnumber, bid};
			bd.addBuilding(sqldormnumber, doo);
			this.select(request, response);
		}
		else{
			response.sendRedirect("error.jsp");
		}
		
//		String sql = "insert into building values(seq_building.nextval, ? , ?)";
//		Object[] o ={buildingnumber, dormnumber};
//		BuildingDao bd = new BuildingDao();
//		int i = bd.addBuilding(sql, o);
//		if(i>0)this.select(request, response);
//		else{
//			response.sendRedirect("error.jsp");
//		}
	}

	private void select(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		DormDao dd = new DormDao();
		int page=1;
		if(request.getParameter("page")!=null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		int count = dd.getCount();
		int pageCount = 1;
		if(count%10==0){
			pageCount = count/10;
		}else{
			pageCount = count/10+1;
		}
		List list = dd.pageList(page);
		StringBuffer pageString = new StringBuffer("");
		for(int i = 1; i<=pageCount; i++){
			pageString.append("<a href='DormServlet?page="+i+"'>&nbsp;&nbsp;["+i+"]</a>");
		}
		request.setAttribute("dorm", list);
		request.setAttribute("pageString", pageString);
		request.getRequestDispatcher("page/dorm.jsp").forward(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
