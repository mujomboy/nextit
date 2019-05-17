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

<title>자유 게시판</title>

</head>
<body>
	<script>
		attachCenter("자유 게시판");
		window.onload = function() {

		}
	</script>


	<section class="item content">
		<div class="container toparea">
		
			<div class="underlined-title">
				<div class="editContent">
					<h1 class="text-center latestitems">FREE BOARD</h1>
				</div>
				<div class="wow-hr type_short">
					<span class="wow-hr-h"> <i class="fa fa-book"></i>
					</span>
				</div>
			</div>
		

seqNo primary key
type not null
password 
title not null
contents 
read_count default 0 not null
user_ip not null
del_at 'N'
reg_user default 'guest' not null
reg_date default sysdate
upd_date default sysdate


		</div>
	</section>


</body>
</html>
