<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html lang="ko">
  <head>
   	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="mvc">
    <meta name="author" content="kjh">

    <title>회원가입</title>

</head>
<body>
	<form action="/member/memberUpdateProc.do" method="get">
		<input type="hidden" name="seqNo" value="${m.seqNo }">
		<table class="table">
			<tbody>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="usrId" class="form-control" value="${m.usrId }" readonly="readonly"></td>
				</tr>
				<tr>
					<th>암호</th>
					<td><input type="password" name="usrPwd" class="form-control" value="${m.usrPwd }"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="usrName" class="form-control"value="${m.usrName }"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="usrEmail" class="form-control"value="${m.usrEmail }"></td>
				</tr>
				<tr>
					<th>핸드폰</th>
					<td><input type="text" name="usrHp" class="form-control"value="${m.usrHp }"></td>
				</tr>
				<tr>
					<th>팩스</th>
					<td><input type="text" name="usrFax" class="form-control"value="${m.usrFax }"></td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<select name="usrGender">
							<option value="M" ${m.usrGender == 'M' ? "selected='selected'" : "" }>남성</option>
							<option value="W" ${m.usrGender == 'W' ? "selected='selected'" : "" }>여성</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>나이</th>
					<td><input type="text" name="usrAge" class="form-control" value="${m.usrAge }"></td>
				</tr>
				<tr>
					<th colspan="2">
					<input type="submit" value="수정">
					</th>
				</tr>
				
			</tbody>
		</table>
	</form>
			

</body>
</html>
    