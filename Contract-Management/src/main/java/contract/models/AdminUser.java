package contract.models;

public class AdminUser {

	private String userid;
	private String pwd;
	private String name;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public AdminUser(String userid, String pwd, String name) {
		this.userid = userid;
		this.pwd = pwd;
		this.name = name;
	}
	public AdminUser() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
