package kr.or.nextit.board.service;

import org.apache.commons.lang3.builder.ToStringBuilder;

import kr.or.nextit.com.cmm.PagingVo;

public class BoardSearchVo extends PagingVo{

	private String searchText;
	private String searchType;
	private String seqNo;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	
	
}
