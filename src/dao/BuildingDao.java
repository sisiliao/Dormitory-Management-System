package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Building;

public class BuildingDao extends DBUtils {
	//buiding list
	public List buidingList(String sql, Object[] o) throws SQLException{
		rs = this.getRs(sql, o);
		List list = new ArrayList();
		try {
			while(rs.next()){
				Building b = new Building();
				b.setBid(rs.getInt(1));
				b.setBuildingnumber(rs.getString(2));
				b.setDormnumber(rs.getInt(3));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.myClose();
		return list;
	}
	public int addBuilding(String sql, Object[] o){
		int i = this.myInsert(sql, o);
		return i;
	}
}
