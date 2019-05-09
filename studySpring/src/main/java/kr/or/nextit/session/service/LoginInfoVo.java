package kr.or.nextit.session.service;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class LoginInfoVo {

	private String seqNo;
	private String usrId;
	private String usrName;
	private String usrEmail;
	private String usrHp;
	private String usrFax;
	private String usrGender;
	private String usrAge;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

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
	
	
}
