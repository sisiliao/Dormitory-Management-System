package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Admin;
import entity.Building;
import entity.Dorms;

public class DormDao extends DBUtils {
	//用户（管理员）注册
	public int insertAdmin(String sql, Object[] o) throws SQLException{
		int i=0;
		i = this.myInsert(sql, o);
		this.myClose();
		return i;
	}
	//判断管理员登陆
	public List loginAdmin(String sql, Object[] o) throws SQLException{
		rs = this.getRs(sql, o);
		List list = new ArrayList();
		try {
			while(rs.next()){
				Admin admin = new Admin();
				admin.setAdminid(rs.getInt(1));
				admin.setUsername(rs.getString(2));
				admin.setPassword(rs.getString(3));
				list.add(admin);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.myClose();
		return list;
	}
	//宿舍表list
	public List dormList(String sql, Object[] o) throws SQLException{
		rs = this.getRs(sql, o);
		List list = new ArrayList();
		try {
			while(rs.next()){
				Dorms dorm = new Dorms();
				dorm.setDid(rs.getInt("did"));
				dorm.setBid(rs.getInt("bid"));
				dorm.setDname(rs.getInt("dname"));
				dorm.setDmaxnum(rs.getInt("dmaxnum"));
				dorm.setDactualnum(rs.getInt("dactualnum"));
				dorm.setDtype(rs.getString("dtype"));
				dorm.setDgender(rs.getString("dgender"));
				dorm.setBuildingnumber(rs.getString("buildingnumber"));
				list.add(dorm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.myClose();
		return list;
	}
	
	//拿到dorm表的总条数
	public int getCount() throws SQLException{
		int i = 0;
		String sql = "select count(*) count from dorms";
		Object[] o ={};
		rs = this.getRs(sql, o);
			try {
				if(rs.next()){
					i=rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		this.myClose();
		return i;
	}
	
	//分页方法
	public List pageList(int page) throws SQLException{
		List list = new ArrayList();
		int index1, index2;
		index1 = 10*page-10;
		index2 = 10*page;
		String sql = "select t.did, t.buildingnumber, t.dname, t.dmaxnum, t.dactualnum, t.dtype, t.dgender from (select b.*, d.*, rownum rn from building b,dorms d where d.bid=b.bid) t where rn>? and rn<=?";
		Object[] o = {index1, index2};
		rs = this.getRs(sql, o);
		while(rs.next()){
			Dorms dorm = new Dorms();
			dorm.setDid(rs.getInt("did"));
//			dorm.setBid(rs.getInt("bid"));
			dorm.setDname(rs.getInt("dname"));
			dorm.setDmaxnum(rs.getInt("dmaxnum"));
			dorm.setDactualnum(rs.getInt("dactualnum"));
			dorm.setDtype(rs.getString("dtype"));
			dorm.setDgender(rs.getString("dgender"));
			dorm.setBuildingnumber(rs.getString("buildingnumber"));
			list.add(dorm);
		}
		this.myClose();
		return list;
	}
}
