<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<script src="<c:url value="/js/myScript.js"/>"></script>

<!--  사이트 매쉬  hEAD                                       -->
<!--  사이트 매쉬  hEAD                                       -->
<!--  사이트 매쉬  hEAD                                       -->
<sitemesh:write property='head' />


<link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css"
	rel="stylesheet">
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Dosis:200,300,400,500,600,700"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:200,300,400,500,600,700"
	rel="stylesheet">


<title><sitemesh:write property='title' /></title>

<!-- <style type="text/css">
	.container{
	min-width: 1170px;
} -->
</style>
</head>
<body>

	<!-- HEADER =============================-->
	<header class="item header margin-top-0">
		<div class="wrapper">
			<nav role="navigation"
				class="navbar navbar-white navbar-embossed navbar-lg navbar-fixed-top">
				<div class="container">
					<div class="navbar-header">
						<button data-target="#navbar-collapse-02" data-toggle="collapse"
							class="navbar-toggle" type="button">
							<i class="fa fa-bars"></i> <span class="sr-only">Toggle
								navigation</span>
						</button>
						<a href="/" class="navbar-brand brand"> 홈페이지 </a>
					</div>
					<div id="navbar-collapse-02" class="collapse navbar-collapse">
						<ul class="nav navbar-nav navbar-right">
						<c:choose>
							<c:when test="${loginInfo eq null}">
								<li class="propClone"><a href="<c:url value="/login/signUpView.do"/>">회원가입</a></li>
								<li class="propClone"><a href="<c:url value="/login/loginView.do"/>">로그인</a></li>
							</c:when>
							<c:otherwise>
								<c:url value="/" var="logOut">
									<c:param name="out" value="out"></c:param>
								</c:url>
								<li class="propClone"><a href="<c:url value="/member/myPageView.do"/>">마이페이지</a></li>
								<li class="propClone"><a href="${logOut }">로그아웃</a></li>
							</c:otherwise>
						</c:choose>
							
							
							<li class="propClone"><a href="<c:url value="/ing/ing.do"/>">공사중</a></li>
							<li class="propClone"><a href="/">공사중</a></li>
							<li class="propClone"><a href="/">공사중</a></li>
							<li class="propClone"><a href="/">공사중</a></li>
						</ul>
					</div>
				</div>
			</nav>
			<div class="container">
				<div class="row">
					<div class="col-md-12 text-center" id="head_wrap"></div>
				</div>
			</div>
		</div>
	</header>


	<!-- 사이트 매쉬 바디                                           -->
	<!-- 사이트 매쉬 바디                                           -->
	<!-- 사이트 매쉬 바디                                           -->
	<sitemesh:write property='body' />



	<!-- CALL TO ACTION =============================-->
	<section class="content-block" style="background-color: #00bba7;">
		<div class="container text-center">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="item"
						data-scrollreveal="enter top over 0.4s after 0.1s">
						<h1 class="callactiontitle">
							
							로그인 유저 이름 : ${loginInfo != null ? loginInfo.name : "GUEST"} 
						</h1>
					</div>
				</div>
			</div>
		</div>
	</section>


	<!-- FOOTER =============================-->
	<div class="footer text-center">
		<div class="container">
			<div class="row">
				<p class="footernote">Connect with Scorilo</p>
				<ul class="social-iconsfooter">
					<li><a href="#"><i class="fa fa-phone"></i></a></li>
					<li><a href="#"><i class="fa fa-facebook"></i></a></li>
					<li><a href="#"><i class="fa fa-twitter"></i></a></li>
					<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
					<li><a href="#"><i class="fa fa-pinterest"></i></a></li>
				</ul>
				<p>
					Shared by <i class="fa fa-love"></i><a
						href="https://bootstrapthemes.co">BootstrapThemes</a>

				</p>
			</div>
		</div>
	</div>

	<!-- SCRIPTS =============================-->
	<script src="<c:url value="/js/jquery-.js"/>"></script>
	<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/js/anim.js"/>"></script>


</body>
</html>