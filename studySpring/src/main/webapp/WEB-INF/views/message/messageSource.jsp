<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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

	<spring:message code="fail.common.msg"></spring:message><br>
	<spring:message code="fail.common.sql"></spring:message><br>
	<spring:message code="fail.common.sql" arguments="111, 222"></spring:message><br>
	<spring:message var="errorMsg" code="errors.required" arguments="입력 하고자, 하는 이름은" argumentSeparator="^"></spring:message><br>
	${errorMsg }
		${errorMsg }

</body>
</html>
