<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="mvc">
<meta name="author" content="kjh">

<title>${title }</title>
<style>
	
	.numberOver{
		padding: 10px;
		color: red;
		font-size: 1.6em;
		cursor: pointer;
	}
	.numberOut{
		padding: 10px;
		color: #777;
		font-size: 1.5em;
		cursor: pointer;
	}
	
	.curPageNumber{
		padding: 10px;
		color: red;
		font-size: 1.5em;
		cursor: pointer;
	}
</style>

<script src="<c:url value="/js/boardScript.js"/>"></script>
</head>
<body>
	<script>
		'use strict'
		
		attachCenter(document.getElementsByTagName('title')[0].innerHTML);
		window.onload = function() {
			var type = document.getElementsByTagName("legend")[0].innerHTML;
			setBoard(type);
			
			/*
				1. 검색 조건에 맞는 자료 갯수 구하기
				2. 페이징 세팅
				3. 검색 조건에 맞는 자료 구하기
				4. 자료 배치
			*/
			len = 13;						// 페이지당 나열할 아이템 갯수
			var page = 1;					// 시작 페이지 1
			
			// setList(len) -> paging() -> paging().setting -> paging.setPageItemFirstAndLast(page) ->
			// searchItem(paging.getFirst(), paging.getLast(), s_title, s_kind) ->
			setList(page, true);   
			
			setBoardList(true);					// 검색 버튼 세팅
		}
	</script>


	<section class="item content">
		<div class="container toparea">
		
			<div class="underlined-title">
				<div class="editContent">
					<h1 class="text-center latestitems">${message }</h1>
				</div>
				<div class="wow-hr type_short">
					<span class="wow-hr-h"> <i class="fa fa-book"></i>
					</span>
				</div>
			</div>
		
			<!-- 글 리스트 폼 + 글 세부 내용 보기 -->
			<div id="edd_checkout_form_wrap" class="edd_clearfix">
				<fieldset>
					<legend>${who }</legend>
					
					<input type="button" value="검색" id="search_btn" style="float: right;margin-bottom: 10px">
					<input type="text" placeholder="제목 검색" id="search_title" style="float: right;line-height: normal;padding: 5px;margin-right: 10px">	
					<select style="float: right;margin-right: 10px;padding: 5px" id="kind"></select>
					
						
					<table class="table">
						<thead>
							<tr>
								<th style="width: 10%">순번</th><th style="width: 10%">종류</th><th>제목</th><th style="width: 10%">조회수</th><th style="width: 10%">등록자</th>
							</tr>
						</thead>
						
						<tbody>
						

						</tbody>
						<tfoot>
							
						</tfoot>
					</table>
						
						
					<a href="<c:url value="/board/boardWriteView.${choiceType == 0 ? 'do/0' : 'member/1' }"/>">
						<input type="button"  id="edd-purchase-button" value="글쓰기" style="float: right;">
					</a>
			
				</fieldset>
				
			</div>
			
			
		</div>
	</section>


</body>
</html>
