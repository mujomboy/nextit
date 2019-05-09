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

    <title><sitemesh:write property='title'/>ff</title>
	<sitemesh:write property='head'/>
  </head>

  <body>
  
  <table border="1">
  	<tr>
  		<td>좌측메뉴</td>
  		<td>
			<sitemesh:write property='body'/>
  		
  		</td>
  	</tr>
  </table>
			

  </body>
</html>
    