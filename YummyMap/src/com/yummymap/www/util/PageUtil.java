package com.yummymap.www.util;

/**
  이 클래스를 페이지 이동에 필요한 정보를 계산하고 저장하기 위해서 
  만들어진 유틸리티적인 클래스
 * @author 유태희
 * @since 2020.05.23
 *
 */

public class PageUtil {

	//변수 선언
	private int nowPage; 	// 현재 보고 있는 페이지 
	private int totalPage;	// 총 페이지 수
	private int totalCount;// 총 게시물 수 
	
	private int pageRow; 	// 한 페이지에 보여줄 게시물 수
	private int pageGroup; 	// 한 화면에서 이동 가능한 페이지 수 
	
	private int startPage; 	// 해당 화면에서 보여질 이동 시작 페이지 
	private int endPage; 	// 해당 화면에서 보여질 이동 마지막 페이지
	
	private int startCont; 	// 현재 페이지에서 보여줄 시작 게시물 로우넘버
	private int endCont; 	// 현재 페이지에서 보여줄 마지막 게시물 로우넘버
	
	private int nextPage;  //next 버튼을 위해 만들어둔 변수
	private int prePage;   //pre 버튼을 위해 만들어둔 변수
	
	public PageUtil() {	}
	public PageUtil(int nowPage , int totalCount) {
		this(nowPage , totalCount , 3,3);
	}
	
	public PageUtil(int nowPage , int totalCount , int pageRow , int pageGroup) {
		this.nowPage = nowPage;
		this.totalCount = totalCount;
		this.pageRow = pageRow;
		this.pageGroup= pageGroup;
		
		//나머지 변수를 셋팅해준다.
		calcPage();
		calcStart();
		calcEnd();
		calCont();
//		nextno = endPage + 1;
//		preno = startPage -1;
		
		prePage = (startPage == 1)?(1) : (startPage -1);
		nextPage = (endPage < totalPage)?(endPage + 1) : (endPage);
	}

	//총 페이지 수 계산하는 함수
	public void calcPage() {
		/*
		  총 페이지 수는 총 게시물(totalCount) 수 를 한 화면에 표시할 게시물 갯수(pageRow)로 나누면 된다.
		  단, 경우에 따라서는 한패이지가 증가 가 될수 있다
		*/
		totalPage = (totalCount % pageRow == 0 ) ? (totalCount / pageRow):(totalCount / pageRow + 1 );
	
	}
	
	//시작 페이지를 계산할 함수
	public void calcStart() {
		//현재 보는 페이지의 그룹을 계산하고 
		int tmpGroup = (nowPage - 1) / pageGroup;
		
		//현재 보는 페이지 그룹의 시작 페이지 번호 계산
		startPage = tmpGroup * pageGroup +1 ;
	}
	
	//마지막 페이지를 계산할 함수
	public void calcEnd() {
		//현재 보는 페이지의 그룹을 계산하고 
		int tmpGroup = (nowPage - 1) / pageGroup;
		
		//현재 보는 페이지 그룹의 시작 페이지 번호 계산
		endPage = (tmpGroup  + 1) * pageGroup  ;
		
		if(endPage > totalPage) {
			endPage = totalPage;
		}
	}
	
	//시작과 종료 게시물 번호를 계산하주는 함수
	public void calCont() {
		startCont = (nowPage - 1 ) * pageRow + 1;
		endCont = nowPage * pageRow;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageRow() {
		return pageRow;
	}

	public void setPageRow(int pageRow) {
		this.pageRow = pageRow;
	}

	public int getPageGroup() {
		return pageGroup;
	}

	public void setPageGroup(int pageGroup) {
		this.pageGroup = pageGroup;
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

	public int getStartCont() {
		return startCont;
	}

	public void setStartCont(int startCont) {
		this.startCont = startCont;
	}

	public int getEndCont() {
		return endCont;
	}

	public void setEndCont(int endCont) {
		this.endCont = endCont;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getPrePage() {
		return prePage;
	}
	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
	
	
	
	
}