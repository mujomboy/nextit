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
			signUp();
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
				<div id="edd_checkout_form_wrap">
				<form id="edd_purchase_form" class="edd_form" action="<c:url value='/member/myPageUpdate.do'/>" method="POST">
					<table id="edd_checkout_cart">
						<tr class="edd_cart_header_row">
							<th>아이디</th>
							<td>
								<input type="hidden" name="id" value="${loginInfo.id }" id="duplication_con" class="true">
								${loginInfo.id }
							</td>
						</tr>
						<tr class="edd_cart_header_row">
							<th>비밀번호</th>
							<td><input class="edd-input" type="password"
								placeholder="password 확인" name="password"
								style="margin-bottom: 4px"> <input class="edd-input"
								type="hidden" value="${loginInfo.password }" name="confirm_password">
							</td>
						</tr>
						<tr class="edd_cart_header_row">
							<th>이름</th>
							<td><input class="edd-input" type="text" placeholder="이름 입력"
								name="name" value="${loginInfo.name }"></td>
						</tr>
						<tr class="edd_cart_header_row">
							<th>연락처</th>
							<td><input type="hidden" value="" name="phone"> <input
								class="edd-input" type="text" id="phone_first"
								value="${nums[0] }" maxlength="3" style="width: 3em"> -
								<input class="edd-input" type="text" id="phone_second"
								value="${nums[1] }" maxlength="4" style="width: 4em"> -
								<input class="edd-input" type="text" id="phone_third"
								value="${nums[2] }" maxlength="4" style="width: 4em"></td>
						</tr>
						<tr class="edd_cart_header_row">
							<th>나이</th>
							<td><input class="edd-input" type="number"
								placeholder="나이 입력" name="age" value="${loginInfo.age }">
							</td>
						</tr>
						<tr class="edd_cart_header_row">
							<th>이메일</th>
							<td><input class="edd-input" type="text"
								placeholder="이메일 입력" name="email" value="${loginInfo.email }">
							</td>
						</tr>
						<tr class="edd_cart_header_row">
							<th>가입일</th>
							<td>${loginInfo.regDate }</td>
						</tr>
					</table>
					<p>
						<strong id="check_info" hidden="true">주의 : </strong> <span
							id="check_info_con" hidden="true"
							style="color: red; font-size: 14px"></span>
					</p>
					<input type="button" class="edd-submit button"
						id="edd-purchase-button" name="signup_btn" value="수정">
					</form>
				</div>
			</div>

		</div>
	</section>

</body>
</html>