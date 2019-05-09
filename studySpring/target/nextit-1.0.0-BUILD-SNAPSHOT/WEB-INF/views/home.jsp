<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
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

</body>
</html>
