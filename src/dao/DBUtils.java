package dao;

import java.sql.*;

public class DBUtils {
	public Connection conn;
	public PreparedStatement ps;
	public ResultSet rs;
	
	public Connection createConn(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "dorm", "dorm");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public PreparedStatement createPs(String sql, Object[] o){
		try {
			ps = conn.prepareStatement(sql);
			for(int i=1;i<=o.length;i++){
				ps.setObject(i, o[i-1]);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
	}
	
	public ResultSet getRs(String sql, Object[] o){
		this.createConn();
		this.createPs(sql, o);
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public int myInsert(String sql, Object[] o){
		int i=0;
		this.createConn();
		this.createPs(sql, o);
		try {
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public void myClose() throws SQLException{
		if(rs!=null)rs.close();
		if(ps!=null)ps.close();
		if(conn!=null)conn.close();
	}
	
}
