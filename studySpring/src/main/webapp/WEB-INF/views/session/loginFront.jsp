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

<title>로그인 </title>

</head>

<body>

<c:if test="${!empty loginInfo }">
	${loginInfo.usrId }<br>
	${loginInfo.usrName } 님 로그인 함.
</c:if>

<c:if test="${loginInfo == null }">
	<form action="/session/actionLoginProc.do" method="post">
		<table class="table">
			<tbody>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="userId" value="${cUsrId }"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="userPwd"></td> 
				</tr>
				<tr>
					<th>아이디 기억하기</th>
					<td><input type="checkbox" name="remember" value="idSave" ${idSave }></td>
				</tr>
				<tr>
					<th colspan="2">
						<button type="submit">로그인</button>
					</th>
				</tr>
			</tbody>
		</table>
	</form>
</c:if>
</body>
</html>
