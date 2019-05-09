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

<title>next it</title>

</head>

<body>
	<table class="table">
		<thead>
			<tr>
				<td colspan="4" style="text-align:right;">
					<c:url var='insertUrl' value="/board/boardInsertForm.do"></c:url>
					<a href="${insertUrl }">등록</a>
				</td>
			</tr>
			<tr>
				<th>순번</th>
				<th>제목</th>
				<th>조회수</th>
				<th>작성자</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${boardList }" var="boardVo">
			<c:url var="viewUrl" value="/board/boardViewFront.do">
				<c:param name="seqNo" value="${boardVo.seqNo }"></c:param>
			</c:url>
				<tr>
					<td>${boardVo.num }</td>
					<td>
						<a href="${viewUrl}">				
							${boardVo.title }
						</a>
					</td>
					<td>${boardVo.readCount }</td>
					<td>${boardVo.regUser }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>



</body>
</html>
