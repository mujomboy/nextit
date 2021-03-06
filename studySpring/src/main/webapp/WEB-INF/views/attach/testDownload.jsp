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

<title>next it</title>

</head>

<body>

	<table class="table">
		<c:forEach var="vo" items="${attachList }">
		<c:url var="downloadUrl" value="/attach/FileDownload.do">
			<c:param name="seqNo" value="${vo.seqNo }"></c:param>
		</c:url>
			<tr>
				<td>
					${vo.seqNo}
					${vo.fileName}
					${vo.saveSize}
				</td>
				<td>미리보기
					<img alt="" src="${downloadUrl}" width="150px" height="150px">
				</td>
				<td>
					<a href="${downloadUrl}">
						다운로드
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
