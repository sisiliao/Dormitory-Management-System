package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Dorms;
import entity.Student;

public class StuDao extends DBUtils {
	public int getCount() throws SQLException{
		int i = 0;
		String sql = "select count(*) count from v_stu";
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
	
	public List pageList(int page) throws SQLException{
		List list = new ArrayList();
		int index1, index2;
		index1 = 15*page-15;
		index2 = 15*page;
		String sql = "select * from (select t.*, rownum rn from V_STU t) t where rn>? and rn<=?";
		Object[] o = {index1, index2};
		rs = this.getRs(sql, o);
		while(rs.next()){
			Student stu = new Student();
			//属性重新写
			stu.setSid(rs.getInt("sid"));
			stu.setSname(rs.getString("sname"));
			stu.setSgender(rs.getString("sgender"));
			stu.setSmajor(rs.getString("smajor"));
			stu.setSclass(rs.getString("sclass"));
			stu.setStel(rs.getString("stel"));
			stu.setSnumber(rs.getString("Snumber"));
			stu.setDid(rs.getInt("did"));
			stu.setDname(rs.getInt("dname"));
			stu.setDmaxnum(rs.getInt("dmaxnum"));
			stu.setDactualnum(rs.getInt("dactualnum"));
			stu.setDtype(rs.getString("dtype"));
			stu.setDgender(rs.getString("dgender"));
			stu.setBid(rs.getInt("bid"));
			stu.setBuildingnumber(rs.getString("buildingnumber"));
			stu.setDormnumber(rs.getInt("dormnumber"));
			list.add(stu);
		}
		this.myClose();
		return list;
	}
	
	public int getNewCount() throws SQLException{
		int i = 0;
		String sql = "select count(*) count from student where did is null";
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
	
	public List pageListNewStu(int page) throws SQLException{
		List list = new ArrayList();
		int index1, index2;
		index1 = 15*page-15;
		index2 = 15*page;
		//sql语句要重写
		String sql = "select * from (select s.*, rownum rn from student s where did is null) where rn>? and rn<=?";
		Object[] o = {index1, index2};
		rs = this.getRs(sql, o);
		while(rs.next()){
			Student stu = new Student();
			//属性重新写
			stu.setSid(rs.getInt("sid"));
			stu.setSname(rs.getString("sname"));
			stu.setSgender(rs.getString("sgender"));
			stu.setSmajor(rs.getString("smajor"));
			stu.setSclass(rs.getString("sclass"));
			stu.setStel(rs.getString("stel"));
			stu.setSnumber(rs.getString("Snumber"));
			list.add(stu);
		}
		this.myClose();
		return list;
	}
}
