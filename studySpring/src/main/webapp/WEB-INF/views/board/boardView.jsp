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

    <title>next it</title>

  </head>

  <body>
  
  
  <table class="table">
  	<tbody>
  		<tr> <th>넘버</th> <td>${boardInfo.seqNo}</td> </tr>
  		<tr> <th>종류</th> <td>${boardInfo.serviceType}</td> </tr>
  		<tr> <th>제목</th> <td>${boardInfo.title}</td> </tr>
  		<tr> <th>내용</th> <td>${boardInfo.contents}</td> </tr>
  		<tr> <th>조회수</th> <td>${boardInfo.readCount}</td> </tr>
  		<tr> <th>유저IP</th> <td>${boardInfo.usrIp}</td> </tr>
  		<tr> <th>삭제 여부</th> <td>${boardInfo.delAt}</td> </tr>
  		<tr> <th>등록자</th> <td>${boardInfo.regUser}</td> </tr>
  		<tr> <th>등록일</th> <td>${boardInfo.regDt}</td> </tr>
  		<tr> <th>수정자</th> <td>${boardInfo.updUser}</td> </tr>
  		<tr> <th>수정일</th> <td>${boardInfo.updDt}</td> </tr>
  		<tr><td> 
  		
  		<a href="/board/boardListFront.do">	목록 </a> 
  		
  		<c:url var="updateActionUrl" value="/board/boardUpdateFront.do">
  			<c:param name="seqNo" value="${boardInfo.seqNo }"></c:param>
  		</c:url>
  		<a href="${updateActionUrl }">	수정 </a> 
  		
  		
  		<c:url var="deleteActionUrl" value="/board/boardDeleteProc.do">
  			<c:param name="seqNo" value="${boardInfo.seqNo }"></c:param>
  		</c:url>
  		<a href="${deleteActionUrl }">	삭제 </a>
  		
  		</td> 
  		</tr>
  	</tbody>
  </table>

			

  </body>
</html>
    