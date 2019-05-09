package kr.or.nextit.member.service;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class MemberVo {

	private int num;
	private String seqNo;
	private String usrId;
	private String usrPwd;
	private String usrName;
	private String usrEmail;
	private String usrHp;
	private String usrFax;
	private String usrGender;
	private String usrAge;
	private String usrIp;
	private String delAt;
	private String regUser;
	private String regDt;
	private String updUser;
	private String updDt;
	
	
	
	public String toString() {return ToStringBuilder.reflectionToString(this);}



	public String getSeqNo() {
		return seqNo;
	}



	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}



	public String getUsrId() {
		return usrId;
	}



	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}



	public String getUsrName() {
		return usrName;
	}



	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}



	public String getUsrEmail() {
		return usrEmail;
	}



	public void setUsrEmail(String usrEmail) {
		this.usrEmail = usrEmail;
	}



	public String getUsrHp() {
		return usrHp;
	}



	public void setUsrHp(String usrHp) {
		this.usrHp = usrHp;
	}



	public String getUsrFax() {
		return usrFax;
	}



	public void setUsrFax(String usrFax) {
		this.usrFax = usrFax;
	}



	public String getUsrGender() {
		return usrGender;
	}



	public void setUsrGender(String usrGender) {
		this.usrGender = usrGender;
	}



	public String getUsrAge() {
		return usrAge;
	}



	public void setUsrAge(String usrAge) {
		this.usrAge = usrAge;
	}



	public String getUsrIp() {
		return usrIp;
	}



	public void setUsrIp(String usrIp) {
		this.usrIp = usrIp;
	}



	public String getDelAt() {
		return delAt;
	}



	public void setDelAt(String delAt) {
		this.delAt = delAt;
	}



	public String getRegUser() {
		return regUser;
	}



	public void setRegUser(String regUser) {
		this.regUser = regUser;
	}



	public String getRegDt() {
		return regDt;
	}



	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}



	public String getUpdUser() {
		return updUser;
	}



	public void setUpdUser(String updUser) {
		this.updUser = updUser;
	}



	public String getUpdDt() {
		return updDt;
	}



	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}



	public String getUsrPwd() {
		return usrPwd;
	}



	public void setUsrPwd(String usrPwd) {
		this.usrPwd = usrPwd;
	}



	public int getNum() {
		return num;
	}



	public void setNum(int num) {
		this.num = num;
	}
	
	
}
