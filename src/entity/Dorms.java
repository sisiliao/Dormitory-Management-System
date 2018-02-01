package entity;

public class Dorms {
	private int did;
	private int bid;
	private int dname;
	private int dmaxnum;
	private int dactualnum;
	private String dtype;
	private String dgender;
	private String buildingnumber;
	public Dorms() {
		super();
	}
	public Dorms(int did, int bid, int dname, int dmaxnum, int dactualnum,
			String dtype, String dgender) {
		super();
		this.did = did;
		this.bid = bid;
		this.dname = dname;
		this.dmaxnum = dmaxnum;
		this.dactualnum = dactualnum;
		this.dtype = dtype;
		this.dgender = dgender;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
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
	public void setBuildingnumber(String buildingnumber) {
		this.buildingnumber = buildingnumber;
	}
	public String getBuildingnumber() {
		return buildingnumber;
	}
	@Override
	public String toString() {
		return "Dorms [bid=" + bid + ", buildingnumber=" + buildingnumber
				+ ", dactualnum=" + dactualnum + ", dgender=" + dgender
				+ ", did=" + did + ", dmaxnum=" + dmaxnum + ", dname=" + dname
				+ ", dtype=" + dtype + "]";
	}
	
	
}
