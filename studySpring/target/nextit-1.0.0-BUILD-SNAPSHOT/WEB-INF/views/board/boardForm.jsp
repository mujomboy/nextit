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
	
<form action="/board/boardInsertProc.do" method="POST">
	<table class="table">
		<tbody>
			<tr>
				<th>
					게시판 종류
				</th>
				<td>
					<select name="serviceType">
						<option value="FAQ">faq</option>
						<option value="notice">notice</option>
						<option value="data">data</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>
					제목
				</th>
				<td>
					<input type="text" name="title">
				</td>
			</tr>
			<tr>
				<th>
					내용
				</th>
				<td>
					<textarea name="contents" rows="30" cols="80"></textarea>
				</td>
			</tr>
			<tr>
				<th colspan="2">
					<button type="submit">저장</button>
				</th>
			</tr>
		</tbody>
		
	</table>
</form>


</body>
</html>
