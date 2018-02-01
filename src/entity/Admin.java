package entity;

public class Admin {
		private int adminid;
		private String username;
		private String password;
		
		public Admin() {
			super();
		}
	
		public Admin(int adminid, String username, String password) {
			this.adminid = adminid;
			this.username = username;
			this.password = password;
		}
	
		public int getAdminid() {
			return adminid;
		}
	
		public void setAdminid(int adminid) {
			this.adminid = adminid;
		}
	
		public String getUsername() {
			return username;
		}
	
		public void setUsername(String username) {
			this.username = username;
		}
	
		public String getPassword() {
			return password;
		}
	
		public void setPassword(String password) {
			this.password = password;
		}
		
		
		

}
