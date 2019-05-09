<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="mvc">
<meta name="author" content="kjh">

<title>회원관리 (리스트)</title>

<script type="text/javascript" defer="defer">
$(function(){
	
		$frm = $('#searchVo');
		
		$('button[type=submit]', $frm).click(function(e){
			e.preventDefault();
		
			$('input[name=curPage]', $frm).val(1);
			$frm.submit();
		});
	
		
		$(".goPage").click(function(){
			
			
			var curPage = $(this).data("curpage");
			$('input[name=curPage]').val(curPage);
			$frm.submit();
		});
});
</script>






</head>

<body>
	${userTitle }  <br>
	<form id="searchVo" action="" method="get">
		<input type=hidden name="curPage" value="${searchVo.curPage }">
		<table class="table">
			<tr>
				<th>검색 조건</th>
				<th>
					<select name="searchType">
						<option value="usr_id" ${param.searchType == 'usr_id' ? 'selected="selected"':'' }> 아이디</option>
						<option value="usr_name" ${param.searchType == 'usr_name' ? 'selected="selected"':'' }> 이름</option>
						<option value="usr_email" ${param.searchType == 'usr_email' ? 'selected="selected"':'' }> 이메일</option>
					</select>
				</th>
				<th>검색어</th>
				<th> <input type="text" name="searchText" value="${searchText }"> </th>
				<th><button type="submit">검색</button> </th>
			</tr>
		</table>
	</form>



	<table class="table">
		<tr>
			<th>순번</th>
			<th>아이디</th>
			<th>이름</th>
			<th>이메일</th>
			<th>핸드폰</th>
			<th>아이피</th>
			<th>가입일</th>
		</tr>
		<c:forEach var="m" items="${memberList}">
			<c:url var="viewUrl" value="/member/memberView.do">
				<c:param name="seqNo" value="${m.seqNo }"></c:param>
			</c:url>
			<tr>
				<td>${m.num }</td>
				<td>
					<a href="${viewUrl }">
					${m.usrId }
					</a>
				</td>
				<td>${m.usrName }</td>
				<td>${m.usrEmail }</td>
				<td>${m.usrHp }</td>
				<td>${m.usrIp }</td>
				<td>${m.regDt }</td>
			</tr>
		</c:forEach>
	</table>
	
	<nav>
		<ul class="pagination pagination-lg">
			
			<!-- 이전 버튼 -->
			<c:choose>
				<c:when test="${searchVo.startPage == 1 }">
					<li>
						<a aria-label="previous" class="page-link">
							<span aria-hidden="true"> << 이전 </span>
						</a>
					</li>
				</c:when>
				<c:otherwise>
					<li>
						<a href="#" data-curpage="${searchVo.startPage - 1}" class="prev goPage page-link" | aria-label="previous">
							<span aria-hidden="true"> << 이전 </span>
						</a>
					</li>
				</c:otherwise>
			</c:choose>
			
			<c:forEach var="i" begin="${searchVo.startPage }" end="${searchVo.endPage }">
				<c:choose>
					<c:when test="${i == searchVo.curPage }">
						<li class="active"> <a class="page-link">${i }</a></li>
					</c:when>
					<c:otherwise>
						<li>
							<a href='#' data-curpage="${i}" class="page-link goPage">${i}</a>
						</li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			
			
			<!--  다음 버튼  -->
			<c:choose>
				<c:when test="${searchVo.endPage < searchVo.totalPageCount}">
					<li>
						<a href="#" data-curpage="${searchVo.endPage + 1}" class="page-link next goPage" | aria-label="Next" title="Next">
							<span aria-hidden="true"> 다음 >> </span>
						</a>
					</li>
				</c:when>
				<c:otherwise>
					<li>
						<a aria-label="Next" title="Next" class="page-link">
							<span aria-hidden="true"> 다음 >></span>
						</a>
					</li>
				</c:otherwise>
			</c:choose>
			
			
		</ul>
	</nav>
	
</body>
</html>
