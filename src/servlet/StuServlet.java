package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DormDao;
import dao.StuDao;

public class StuServlet extends HttpServlet {

	public StuServlet() {
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
			}else if(action.equals("newstu")){
				this.newstu(request, response);
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	private void newstu(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		StuDao sd = new StuDao();
		int page=1;
		if(request.getParameter("page")!=null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		int count = sd.getNewCount();
		int pageCount = 1;
		if(count%15==0){
			pageCount = count/15;
		}else{
			pageCount = count/15+1;
		}
		List list = sd.pageListNewStu(page);
		StringBuffer pageString = new StringBuffer("");
		for(int i = 1; i<=pageCount; i++){
			pageString.append("<a href='StuServlet?action=newstu&page="+i+"'>&nbsp;&nbsp;["+i+"]</a>");
		}
		request.setAttribute("stu", list);
		request.setAttribute("pageString", pageString);
		request.getRequestDispatcher("page/newstu.jsp").forward(request, response);		
	}


	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sgender = request.getParameter("sgender");
		sgender = new String(sgender.getBytes("iso-8859-1"),"utf-8");
		int sid = Integer.parseInt(request.getParameter("sid"));
		List building = new ArrayList();
		if(sgender.equals("男")){
			building.add("一栋");
			building.add("二栋");
			building.add("五栋");
		}else{
			building.add("三栋");
			building.add("四栋");
			building.add("六栋");			
		}
		//从数据库中拿到所有楼栋的宿舍集合，保存到request中。
		request.setAttribute("building", building);
		request.setAttribute("sid",sid);
		request.getRequestDispatcher("page/updatestudorm.jsp").forward(request, response);
	}


	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	private void add(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	private void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		StuDao sd = new StuDao();
		int page=1;
		if(request.getParameter("page")!=null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		int count = sd.getCount();
		int pageCount = 1;
		if(count%15==0){
			pageCount = count/15;
		}else{
			pageCount = count/15+1;
		}
		List list = sd.pageList(page);
		StringBuffer pageString = new StringBuffer("");
		for(int i = 1; i<=pageCount; i++){
			pageString.append("<a href='StuServlet?page="+i+"'>&nbsp;&nbsp;["+i+"]</a>");
		}
		request.setAttribute("stu", list);
		request.setAttribute("pageString", pageString);
		request.getRequestDispatcher("page/student.jsp").forward(request, response);
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
