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
		attachCenter("로그인");
		window.onload = function() {
			login();
		}
	</script>

	<section class="item content">
		<div class="container toparea">
			<div class="underlined-title">
				<div class="editContent">
					<h1 class="text-center latestitems">LOGIN!</h1>
				</div>
				<div class="wow-hr type_short">
					<span class="wow-hr-h"> <i class="fa fa-hand-o-down"></i>
					</span>
				</div>
			</div>

			<div id="edd_checkout_wrap" class="col-md-8 col-md-offset-2">
				<form id="edd_checkout_cart_form" method="get" action="<c:url value="/login/loginExc.do"/>">
					<div id="edd_checkout_form_wrap">
						<table id="edd_checkout_cart">
							<tbody>
								<tr class="edd_cart_header_row">
									<td><input class="edd-input" type="text" name="id"
										placeholder="ID 입력"></td>
									<th rowspan="2" width="45%"><input type="button"
										id="login_btn" class="edd-submit button" value="로그인"
										style="padding: 10px 20px; margin-left: 20px;"> <a
										href="<c:url value="/login/signUpView.do"/>"> <input
											type="button" class="edd-submit button" value="회원가입"
											style="padding: 10px 20px; margin-left: 15px;">
									</a></th>
								</tr>
								<tr class="edd_cart_header_row">
									<td><input class="edd-input" type="text" name="password"
										placeholder="PASSWORD 입력"></td>
								</tr>
							</tbody>
						</table>
						<p>
							
							<strong id="check_info" ${param.fail ne null ? '' : 'hidden=""' }>주의 : </strong> <span
								id="check_info_con" ${param.fail ne null ? '' : 'hidden=""' }
								style="color: red; font-size: 14px">${param.fail }</span>
						</p>
					</div>
				</form>
			</div>

		</div>
	</section>
</body>
</html>