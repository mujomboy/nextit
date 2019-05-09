package kr.or.nextit.com.cmm;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;


@SuppressWarnings("serial")
public class PagingVo implements Serializable{
	
	private int totalCount;			// 전체레코드 갯수
	private int curPage = 1;		// 현재 페이지
	private int screenSize;			// 화면에 보이는 레코드 수
	private int totalPageCount;		// 총 페이지 수
	private int startRow;			// 시작 행 번호
	private int endRow;				// 끝 행 번호
	
	private int pageBlockSize;		// 화면에 보여지는 페이지 수
	private int startPage;			// 시작 페이지 번호
	private int endPage;			// 끝 페이지 번호
	
	
	public void pageSetting() {
		
		if(curPage < 1) curPage = 1;
		if(screenSize < 1) screenSize = 10;
		if(pageBlockSize < 1) pageBlockSize = 5;
		
		totalPageCount = (totalCount - 1) / screenSize + 1;
		startRow = (curPage - 1) * screenSize + 1;
		endRow = curPage * screenSize;
		
		startPage = ((curPage - 1) / pageBlockSize) * pageBlockSize + 1;
		endPage = startPage + pageBlockSize - 1;
		
		if(totalPageCount < endPage) endPage = totalPageCount;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(int screenSize) {
		this.screenSize = screenSize;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getPageBlockSize() {
		return pageBlockSize;
	}

	public void setPageBlockSize(int pageBlockSize) {
		this.pageBlockSize = pageBlockSize;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	
}
