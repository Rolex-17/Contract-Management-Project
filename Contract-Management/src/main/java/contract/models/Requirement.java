package contract.models;


public class Requirement {

	private String reqid;
	private String reqtype;
	private String description;
	private String deldate;
	
	public String getReqid() {
		return reqid;
	}
	public void setReqid(String reqid) {
		this.reqid = reqid;
	}
	public String getReqtype() {
		return reqtype;
	}
	public void setReqtype(String reqtype) {
		this.reqtype = reqtype;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDeldate() {
		return deldate;
	}
	public void setDeldate(String deldate) {
		this.deldate = deldate;
	}
	@Override
	public String toString() {
		return "Requirement [reqid=" + reqid + ", reqtype=" + reqtype + ", description=" + description + ", deldate="
				+ deldate + "]";
	}
	
	
	
}
