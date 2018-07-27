package com.lds.vo;

public class UserInfo {
	  private Integer usid;//   NUMBER not null,
	  private String uname;//  NVARCHAR2(50),
	  private String imname;// NVARCHAR2(50),
	  private String impath;// NVARCHAR2(200),
	  private String imbm;//   NVARCHAR2(50)
	  private String pasd;
	public String getPasd() {
		return pasd;
	}
	public void setPasd(String pasd) {
		this.pasd = pasd;
	}
	public Integer getUsid() {
		return usid;
	}
	public void setUsid(Integer usid) {
		this.usid = usid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getImname() {
		return imname;
	}
	public void setImname(String imname) {
		this.imname = imname;
	}
	public String getImpath() {
		return impath;
	}
	public void setImpath(String impath) {
		this.impath = impath;
	}
	public String getImbm() {
		return imbm;
	}
	public void setImbm(String imbm) {
		this.imbm = imbm;
	}
	  
	  

}
