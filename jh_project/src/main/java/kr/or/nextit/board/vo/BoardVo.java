package kr.or.nextit.board.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class BoardVo {

	private int num;
	private int seqNo;
	private String kind;
	private String pwd;
	private String title;
	private String ctnt;
	private int readCount;
	private String userIp;
	private String delAt;
	private String regUser;
	private String regDate;
	private String updDate;
	
	@Override
	public String toString() {return ToStringBuilder.reflectionToString(this);}

	public String getKind() {return kind;}

	public void setKind(String kind) {this.kind = kind;}

	public String getPwd() {return pwd;}

	public void setPwd(String pwd) {this.pwd = pwd;}

	public String getTitle() {return title;}

	public void setTitle(String title) {this.title = title;}

	public String getCtnt() {return ctnt;}

	public void setCtnt(String ctnt) {this.ctnt = ctnt;}

	public int getReadCount() {return readCount;}

	public void setReadCount(int readCount) {this.readCount = readCount;}

	public String getUserIp() {return userIp;}

	public void setUserIp(String userIp) {this.userIp = userIp;}

	public String getDelAt() {return delAt;}

	public void setDelAt(String delAt) {this.delAt = delAt;}

	public String getRegUser() {return regUser;}

	public void setRegUser(String regUser) {this.regUser = regUser;}

	public String getRegDate() {return regDate;}

	public void setRegDate(String regDate) {this.regDate = regDate;}

	public String getUpdDate() {return updDate;}

	public void setUpdDate(String updDate) {this.updDate = updDate;}
	
	public int getNum() {return num;}

	public void setNum(int num) {this.num = num;}

	public int getSeqNo() {return seqNo;}

	public void setSeqNo(int seqNo) {this.seqNo = seqNo;}
}
