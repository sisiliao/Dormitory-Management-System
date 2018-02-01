/*
 * 可能出现的问题:这里的date是util.date类型的
 */
package entity;

import java.util.Date;

public class Visitor {
	private int vid;
	private String vname;
	private int sid;
	private Date vdate;
	private String videncard;
	private String vidennum;
	private String vreason;
	private String vtel;
	public Visitor() {
		super();
	}
	public Visitor(int vid, String vname, int sid, Date vdate,
			String videncard, String vidennum, String vreason, String vtel) {
		super();
		this.vid = vid;
		this.vname = vname;
		this.sid = sid;
		this.vdate = vdate;
		this.videncard = videncard;
		this.vidennum = vidennum;
		this.vreason = vreason;
		this.vtel = vtel;
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public Date getVdate() {
		return vdate;
	}
	public void setVdate(Date vdate) {
		this.vdate = vdate;
	}
	public String getVidencard() {
		return videncard;
	}
	public void setVidencard(String videncard) {
		this.videncard = videncard;
	}
	public String getVidennum() {
		return vidennum;
	}
	public void setVidennum(String vidennum) {
		this.vidennum = vidennum;
	}
	public String getVreason() {
		return vreason;
	}
	public void setVreason(String vreason) {
		this.vreason = vreason;
	}
	public String getVtel() {
		return vtel;
	}
	public void setVtel(String vtel) {
		this.vtel = vtel;
	}
	
	
}
