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
	<table class="table ">
		<tr> <th>아이디</th> <td>${memberInfo.usrId }</td> </tr>
		<tr> <th>이름</th> <td>${memberInfo.usrName }</td> </tr>
		<tr> <th>이메일</th> <td>${memberInfo.usrEmail }</td> </tr>
		<tr> <th>핸드폰</th> <td>${memberInfo.usrHp }</td> </tr>
		<tr> <th>팩스</th> <td>${memberInfo.usrFax }</td> </tr>
		<tr> <th>성별</th> <td>${memberInfo.usrGender }</td> </tr>
		<tr> <th>나이</th> <td>${memberInfo.usrAge }</td> </tr>
		<tr> <th>IP</th> <td>${memberInfo.usrIp }</td> </tr>
		<tr> <th>삭제여부</th> <td>${memberInfo.delAt }</td> </tr>
		<tr> <th>등록자</th> <td>${memberInfo.regUser }</td> </tr>
		<tr> <th>등록일</th> <td>${memberInfo.regDt }</td> </tr>
		<tr> <th>수정자</th> <td>${memberInfo.updUser }</td> </tr>
		<tr> <th>수정일</th> <td>${memberInfo.updDt }</td> </tr>
		<tr> 
			<td>
				<c:url var="updateUrl" value="/member/memberUpdateFront.do">
					<c:param name="seqNo" value="${memberInfo.seqNo }"></c:param>
				</c:url>
			 	<a href="${updateUrl }">수정</a> </td>
			<td>
			 	<c:url var="deleteUrl" value="/member/memberDeleteProc.do">
			 		<c:param name="seqNo" value="${memberInfo.seqNo }"></c:param>
			 	</c:url>
				<a href="${deleteUrl }">삭제</a> 
			</td>
		</tr>
	</table>

</body>
</html>
