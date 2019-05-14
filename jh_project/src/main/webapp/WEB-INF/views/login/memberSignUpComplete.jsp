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
	<script>
		attachCenter("가입 완료");
	</script>


	<section class="item content">
		<div class="container toparea">
			<div class="underlined-title">
				<div class="editContent">
					<h1 class="text-center latestitems">SIGN UP COMPLETE!</h1>
				</div>
				<div class="wow-hr type_short">
					<span class="wow-hr-h"> <i class="fa fa-hand-o-down"></i>
					</span>
				</div>
			</div>
		</div>
	</section>
	
	<div class="item content">
		<div class="container">
			<div class="row">
				<div class="col-md-4" style="margin-left: 33%">
					<i class="fa fa-bullhorn infoareaicon"></i>
					<div class="infoareawrap">
						<h1 class="text-center subtitle">가입이 완료 되었습니다.</h1>
						<h1 class="text-center subtitle">감사합니다.</h1>
						<p class="text-center">
							<a href="<c:url value="/"/>">
								<input type="button" class="edd-submit button" value="메인화면" style="margin-right:15px;">
							</a>
							<a href="<c:url value="/login/loginView.do"/>">
								<input type="button" class="edd-submit button" value="로그인">
							</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
