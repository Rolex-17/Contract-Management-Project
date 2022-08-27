package contract.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Supplier {
	private String supid;
	@Size(min=4,max=50,message = "Name must have atleast 4 characters")
	@NotEmpty(message="Supplier name is required")
	private String name;
	@Size(min=10,max=10,message = "Phone must have 10 numbers")
	@NotEmpty(message="Phone is required")
	private String phone;
	@NotEmpty(message="Password is required")
	@Size(min = 6,max=20,message = "Password must contains atleast 6 characters")
	private String pwd;
	@NotEmpty(message="Confirm Passowrd is required")
	private String cpwd;
	@NotEmpty(message="Address is required")
	private String address;
	
	
	public String getSupid() {
		return supid;
	}
	public void setSupid(String supid) {
		this.supid = supid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCpwd() {
		return cpwd;
	}
	public void setCpwd(String cpwd) {
		this.cpwd = cpwd;
	}
	@Override
	public String toString() {
		return "Supplier [supid=" + supid + ", name=" + name + ", phone=" + phone + ", pwd=" + pwd + ", address="
				+ address + "]";
	}
	
}
