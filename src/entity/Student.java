package entity;

public class Student {
	private int sid;
	private int did;
	private String sname;
	private String sgender;
	private String smajor;
	private String sclass;
	private String stel;
	private String snumber;
	private int dname;
	private int dmaxnum;
	private int dactualnum;
	private String dtype;
	private String dgender;
	private int bid;
	private String buildingnumber;
	private int dormnumber;
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [bid=" + bid + ", buildingnumber=" + buildingnumber
				+ ", dactualnum=" + dactualnum + ", dgender=" + dgender
				+ ", did=" + did + ", dmaxnum=" + dmaxnum + ", dname=" + dname
				+ ", dormnumber=" + dormnumber + ", dtype=" + dtype
				+ ", sclass=" + sclass + ", sgender=" + sgender + ", sid="
				+ sid + ", smajor=" + smajor + ", sname=" + sname
				+ ", snumber=" + snumber + ", stel=" + stel + "]";
	}
	public Student(int sid, int did, String sname, String sgender,
			String smajor, String sclass, String stel, String snumber) {
		super();
		this.sid = sid;
		this.did = did;
		this.sname = sname;
		this.sgender = sgender;
		this.smajor = smajor;
		this.sclass = sclass;
		this.stel = stel;
		this.snumber = snumber;
	}
	
	public int getDname() {
		return dname;
	}
	public void setDname(int dname) {
		this.dname = dname;
	}
	public int getDmaxnum() {
		return dmaxnum;
	}
	public void setDmaxnum(int dmaxnum) {
		this.dmaxnum = dmaxnum;
	}
	public int getDactualnum() {
		return dactualnum;
	}
	public void setDactualnum(int dactualnum) {
		this.dactualnum = dactualnum;
	}
	public String getDtype() {
		return dtype;
	}
	public void setDtype(String dtype) {
		this.dtype = dtype;
	}
	public String getDgender() {
		return dgender;
	}
	public void setDgender(String dgender) {
		this.dgender = dgender;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBuildingnumber() {
		return buildingnumber;
	}
	public void setBuildingnumber(String buildingnumber) {
		this.buildingnumber = buildingnumber;
	}
	public int getDormnumber() {
		return dormnumber;
	}
	public void setDormnumber(int dormnumber) {
		this.dormnumber = dormnumber;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSgender() {
		return sgender;
	}
	public void setSgender(String sgender) {
		this.sgender = sgender;
	}
	public String getSmajor() {
		return smajor;
	}
	public void setSmajor(String smajor) {
		this.smajor = smajor;
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	public String getStel() {
		return stel;
	}
	public void setStel(String stel) {
		this.stel = stel;
	}
	public String getSnumber() {
		return snumber;
	}
	public void setSnumber(String snumber) {
		this.snumber = snumber;
	}
	
	
}
