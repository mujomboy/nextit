<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<script>
		attachCenter("마이 페이지");
		window.onload = function() {
			
		}
	</script>


	<section class="item content">
		<div class="container toparea">
			<div class="underlined-title">
				<div class="editContent">
					<h1 class="text-center latestitems">MY PAGE</h1>
				</div>
				<div class="wow-hr type_short">
					<span class="wow-hr-h"> <i class="fa fa-user"></i>
					</span>
				</div>
			</div>
			<div id="edd_checkout_wrap" class="col-md-8 col-md-offset-2">
			<table class="table" id="edd_checkout_cart">
				<tr class="edd_cart_header_row">
					<th>아이디</th>
					<td>${loginVo.id }</td>
				</tr>
				<tr class="edd_cart_header_row">
					<th>비밀번호</th>
					<td>dd</td>
				</tr>
				<tr class="edd_cart_header_row">
					<th>이름</th>
					<td>dd</td>
				</tr>
				<tr class="edd_cart_header_row">
					<th>연락처</th>
					<td>dd</td>
				</tr>
				<tr class="edd_cart_header_row">
					<th>나이</th>
					<td>dd</td>
				</tr>
				<tr class="edd_cart_header_row">
					<th>이메일</th>
					<td>dd</td>
				</tr>
			</table>
			</div>
			
		</div>
	</section>
</body>
</html>