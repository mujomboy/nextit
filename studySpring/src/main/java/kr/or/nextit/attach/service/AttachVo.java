package kr.or.nextit.attach.service;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class AttachVo {

	private String groupSeqNo;
	private String seqNo;
	private String serviceType;
	private String fileName;
	private String fileDownCnt;
	private String savePath;
	private String saveName;
	private String saveContentType;
	private long saveSize;
	private String usrIp;
	private String delAt;
	private String regUser;
	private String regDt;
	
	@Override
	public String toString() {return ToStringBuilder.reflectionToString(this);}
	
	public String getGroupSeqNo() {return groupSeqNo;}
	public String getSeqNo() {return seqNo;}
	public String getServiceType() {return serviceType;}
	public String getFileName() {return fileName;}
	public String getFileDownCnt() {return fileDownCnt;}
	public String getSavePath() {return savePath;}
	public String getSaveName() {return saveName;}
	public String getSaveContentType() {return saveContentType;}
	public long getSaveSize() {return saveSize;}
	public String getUsrIp() {return usrIp;}
	public String getDelAt() {return delAt;}
	public String getRegUser() {return regUser;}
	public String getRegDt() {return regDt;}
	public void setGroupSeqNo(String groupSeqNo) {this.groupSeqNo = groupSeqNo;}
	public void setSeqNo(String seqNo) {this.seqNo = seqNo;}
	public void setServiceType(String serviceType) {this.serviceType = serviceType;}
	public void setFileName(String fileName) {this.fileName = fileName;}
	public void setFileDownCnt(String fileDownCnt) {this.fileDownCnt = fileDownCnt;}
	public void setSavePath(String savePath) {this.savePath = savePath;}
	public void setSaveName(String saveName) {this.saveName = saveName;}
	public void setSaveContentType(String saveContentType) {this.saveContentType = saveContentType;}
	public void setSaveSize(long saveSize) {this.saveSize = saveSize;}
	public void setUsrIp(String usrIp) {this.usrIp = usrIp;}
	public void setDelAt(String delAt) {this.delAt = delAt;}
	public void setRegUser(String regUser) {this.regUser = regUser;}
	public void setRegDt(String regDt) {this.regDt = regDt;}
	
	
}
