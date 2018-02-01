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
import javax.servlet.http.HttpSession;

import dao.DormDao;

public class AdminServlet extends HttpServlet {


	public AdminServlet() {
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
		if(action==null || action.equals("")){
			response.sendRedirect("index.jsp");
		}else if(action.equals("register")){
			this.register(request,response);
		}else if(action.equals("login")){
			this.login(request,response);
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sql = "select * from dormadmin where username=? and password=?";
		Object[] o = {username, password};
		DormDao d = new DormDao();
		try {
			List list = d.loginAdmin(sql, o);
			if(list.get(0)!=null){
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				request.getRequestDispatcher("page/mainpage.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("page/error.jsp").forward(request, response);
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

	private void register(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		DormDao d = new DormDao();
		String sql = "insert into DormAdmin values (seq_dormadmin.nextval, ? , ?)";
		Object[] o = {username, password};
		try {
			d.insertAdmin(sql, o);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("index.jsp").forward(request,response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
