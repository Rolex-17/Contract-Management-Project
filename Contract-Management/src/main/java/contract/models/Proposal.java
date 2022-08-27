package contract.models;


public class Proposal {

	private int propid;
	private String reqid;
	private String pdate;
	private int quotation;
	private String supid;
	private String supname;
	private String status="Submitted";
	
	
	public String getSupname() {
		return supname;
	}
	public void setSupname(String supname) {
		this.supname = supname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSupid() {
		return supid;
	}
	public void setSupid(String supid) {
		this.supid = supid;
	}
	public int getPropid() {
		return propid;
	}
	public void setPropid(int propid) {
		this.propid = propid;
	}
	public String getReqid() {
		return reqid;
	}
	public void setReqid(String reqid) {
		this.reqid = reqid;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	public int getQuotation() {
		return quotation;
	}
	public void setQuotation(int quotation) {
		this.quotation = quotation;
	}
	
	
}
