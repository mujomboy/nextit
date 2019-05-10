<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	${userTitle }  
</h1>

<P>  The time on the server is ${serverTime}. </P>


get post test

<a href="/test/getTest.do">aa</a>
<br>

<form action="/test/getTest.do" method="get">
	<input type="text" name="title"><br>
	<button type="submit">get test Event</button>
</form>

<hr>

<form action="/test/postTest.daum" method="post">
	title<input type="text" name="title"><br>
	name<input type="text" name="name"><br>
	age <input type="text" name="age"><br>
	<button type="submit">post test Event</button>
	
</form>

<spring:message code="fail.common.msg"></spring:message><br>
	<spring:message code="fail.common.sql"></spring:message><br>
	<spring:message code="fail.common.sql" arguments="111, 222"></spring:message><br>
	<spring:message var="errorMsg" code="errors.required" arguments="입력 하고자, 하는 이름은" argumentSeparator="^"></spring:message><br>
	${errorMsg }
		${errorMsg }


</body>
</html>
