package entity;

public class Building {
	private int bid;
	private String buildingnumber;
	private int dormnumber;
	
	
	public Building() {
		super();
	}


	public Building(int bid, String buildingnumber, int dormnumber) {
		super();
		this.bid = bid;
		this.buildingnumber = buildingnumber;
		this.dormnumber = dormnumber;
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


	@Override
	public String toString() {
		return "Building [bid=" + bid + ", buildingnumber=" + buildingnumber
				+ ", dormnumber=" + dormnumber + "]";
	}

	
}
