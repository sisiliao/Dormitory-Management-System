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

import dao.BuildingDao;

public class BuildingServlet extends HttpServlet {

	public BuildingServlet() {
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
		if(action==null || action.equals("")||action.equals("select")){
			this.select(request, response);
		}else if(action.equals("add")){
			this.add(request, response);
		}else if(action.equals("delete")){
			this.delete(request, response);
		}else if(action.equals("update")){
			this.update(request, response);
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int bid = Integer.parseInt(request.getParameter("bid"));
		String buildingnumber = request.getParameter("buildingnumber");
		buildingnumber = new String(buildingnumber.getBytes("iso-8859-1"),"utf-8");
		int dormnumber = Integer.parseInt(request.getParameter("dormnumber"));
		String sql = "update building set buildingnumber=? , dormnumber=? where bid=?";
		Object[] o = {buildingnumber, dormnumber, bid};
		BuildingDao bd = new BuildingDao();
		int i = bd.addBuilding(sql, o);
		if(i>0)this.select(request, response);
		else{
			response.sendRedirect("error.jsp");
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int bid = Integer.parseInt(request.getParameter("bid"));
		System.out.println(bid);
		String sql = "delete from building where bid=?";
		Object[] o = {bid};
		BuildingDao bd = new BuildingDao();
		int i = bd.addBuilding(sql, o);
		if(i>0)this.select(request, response);
		else{
			response.sendRedirect("error.jsp");
		}
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String buildingnumber=request.getParameter("buildingnumber");
		buildingnumber = new String(buildingnumber.getBytes("iso-8859-1"),"utf-8");
		int dormnumber=Integer.parseInt(request.getParameter("dormnumber"));
		String sql = "insert into building values(seq_building.nextval, ? , ?)";
		Object[] o ={buildingnumber, dormnumber};
		BuildingDao bd = new BuildingDao();
		int i = bd.addBuilding(sql, o);
		if(i>0)this.select(request, response);
		else{
			response.sendRedirect("error.jsp");
		}
		
	}

	private void select(HttpServletRequest request, HttpServletResponse response) {
		String sql = "select * from building order by bid asc";
		Object[] o ={};
		BuildingDao bd = new BuildingDao();
		List list = new ArrayList();
		try {
			list = bd.buidingList(sql, o);
			request.setAttribute("building", list);
			request.getRequestDispatcher("page/building.jsp").forward(request, response);
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

	public void init() throws ServletException {
		// Put your code here
	}

}
