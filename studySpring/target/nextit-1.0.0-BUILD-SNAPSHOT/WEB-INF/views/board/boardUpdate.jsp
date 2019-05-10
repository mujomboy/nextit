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
<form action="/board/boardUpdateProc.do" method="POST">
<table class="table">
	<tbody>
  		<tr> <th>넘버</th> <td> <input type="text" name="seqNo" value="${boardInfo.seqNo}" readonly="readonly"></td> </tr>
  		<tr> <th>종류</th> <td>
  			<select name="serviceType">
  				<option value="NOTICE" ${boardInfo.serviceType == "NOTICE" ? 'selected="selected"' : '' }>공지사항</option>
  				<option value="FAQ" ${boardInfo.serviceType == "FAQ" ? 'selected="selected"' : '' }>질의응답</option>
  				<option value="DATA" ${boardInfo.serviceType == "DATA" ? 'selected="selected"' : '' }>자료실</option>
  			</select>  		
  		</td> </tr>
  		<tr> <th>제목</th> <td><input type="text" name="title" value="${boardInfo.title}"></td> </tr>
  		<tr> <th>내용</th> <td><textarea rows="20" cols="80" name="contents">${boardInfo.contents}</textarea> </td> </tr>
  		<tr> <th>조회수</th> <td>${boardInfo.readCount}</td> </tr>
  		<tr> <th>유저IP</th> <td>${boardInfo.usrIp}</td> </tr>
  		<tr> <th>삭제 여부</th> <td>${boardInfo.delAt}</td> </tr>
  		<tr> <th>등록자</th> <td>${boardInfo.regUser}</td> </tr>
  		<tr> <th>등록일</th> <td>${boardInfo.regDt}</td> </tr>
  		<tr> <th>수정자</th> <td>${boardInfo.updUser}</td> </tr>
  		<tr> <th>수정일</th> <td>${boardInfo.updDt}</td> </tr>
  		<tr>
  			<th>
				<button  type="submit"> 수정 </button>  			
  			</th>
  		
  		</tr>
  	</tbody>
</table>
</form>


</body>
</html>
