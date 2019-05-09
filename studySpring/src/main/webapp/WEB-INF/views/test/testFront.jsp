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

    <title> ${title }</title>

  </head>

  <body>

	${title }

	<form action="" method="get">
		<input type="number" name="dan"> 단 <br>
		<button type="submit">전송</button>
	</form>			
	
	<pre>
		<c:forEach var="item" items="${helloList }">
			${item }
		</c:forEach>
	</pre>

  </body>
</html>
    