<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="mvc">
<meta name="author" content="kjh">
<title>Insert title here</title>
</head>
<body>
	<script>
		attachCenter("회원 가입");
		window.onload = function() {
			signUp();
		}
	</script>

	<section class="item content">
		<div class="container toparea">
			<div class="underlined-title">
				<div class="editContent">
					<h1 class="text-center latestitems">SIGN UP!</h1>
				</div>
				<div class="wow-hr type_short">
					<span class="wow-hr-h"> <i class="fa fa-user"></i>
					</span>
				</div>
			</div>

			<div id="edd_checkout_wrap" class="col-md-8 col-md-offset-2">
				<div id="edd_checkout_form_wrap" class="edd_clearfix">
					<form id="edd_purchase_form" class="edd_form" action="<c:url value='/login/signUpExc.do'/>"
						method="POST">
						<fieldset id="user_info">
							<legend>Personal Info</legend>

							<p>
								<label class="edd-label" for="id"> ID <span
									class="edd-required-indicator">*</span>
								</label> <input class="edd-input required" type="text" name="id" id="id"
									placeholder="id 입력" value="">
							</p>

							<p>
								<label class="edd-label" for="password"> PASSWORD <span
									class="edd-required-indicator">*</span>
								</label> <input class="edd-input required" type="password" id="password"
									name="password" placeholder="password 입력" value="">
							</p>

							<p>
								<label class="edd-label" for="comfirm_password"> CONFIRM
									PASSWORD <span class="edd-required-indicator">*</span>
								</label> <input class="edd-input required" type="password"
									name="confirm_password" placeholder="password 확인" value=""
									id="comfirm_password">
							</p>

							<p>
								<label class="edd-label" for="name"> NAME <span
									class="edd-required-indicator">*</span>
								</label> <input class="edd-input required" type="text" name="name"
									placeholder="이름 입력" value="" id="name">
							</p>

							<p>
								<label class="edd-label" for="phone_first"> PHONE </label> <input
									type="hidden" value="" name="phone"> <input
									class="edd-input" type="text" id="phone_first" value=""
									maxlength="3" style="width: 3em"> - <input
									class="edd-input" type="text" id="phone_second" value=""
									maxlength="4" style="width: 4em"> - <input
									class="edd-input" type="text" id="phone_third" value=""
									maxlength="4" style="width: 4em">
							</p>

							<p>
								<label class="edd-label" for="age"> AGE </label> <input
									class="edd-input" type="number" name="age" id="age"
									placeholder="나이 입력" value="">
							</p>

							<p>
								<label class="edd-label" for="email"> EMAIL </label> <input
									class="edd-input" type="email" name="email" id="email"
									placeholder="이메일 입력" value="">
							</p>

							<br>
							<p style="font-size: 13px">* 는 필수 입력 사항 입니다.</p>
						</fieldset>
						<fieldset id="submit_info">
							<p>
								<strong id="check_info" hidden="true">주의 : </strong> <span
									id="check_info_con" hidden="true"
									style="color: red; font-size: 14px">ddd</span>
							</p>
							<input type="button" class="edd-submit button"
								id="edd-purchase-button" name="signup_btn" value="회원가입"
								onclick="signUp()">
						</fieldset>
					</form>
				</div>
			</div>

		</div>
	</section>


</body>
</html>