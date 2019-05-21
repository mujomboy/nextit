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

<script>

	window.onload = function(){
		//----HOVER CAPTION---//	  
		jQuery(document).ready(function($) {
			$('.fadeshop').hover(function() {
				$(this).find('.captionshop').fadeIn(150);
			}, function() {
				$(this).find('.captionshop').fadeOut(150);
			});
		});
	}
	
</script>
</head>
<body>

	<script>
		attachMain("PROJECT", "HOMEPAGE");
	</script>
	
	
	<div class="item content">
		<div class="container toparea">
			<div class="underlined-title">
				<div class="editContent">
					<h1 class="text-center latestitems">BOARDS</h1>
				</div>
				<div class="wow-hr type_short">
					<span class="wow-hr-h"> <i class="fa fa-user"></i>
					</span>
				</div>
			</div>
			<div class="row text-center">
				<div class="col-md-4">
					<div class="col editContent" style="padding-top: 30px">
						<a href="<c:url value='/board/boardListView.do/0'/>" style="font-weight: bold; cursor:pointer;">자유 게시판</a>
					</div>
				</div>
				<div class="col-md-4">
					<div class="col editContent" style="padding-top: 30px">
						<a href="<c:url value='/board/boardListView.do/1'/>" style="font-weight: bold; cursor:pointer;">멤버 게시판</a>
					</div>
				</div>
				<div class="col-md-4 editContent">
					<div class="col">
						
					</div>
				</div>
			</div>
		</div>
	</div>



<%-- 


	<!-- LATEST ITEMS =============================-->
	<section class="item content">
		<div class="container">


			<div class="underlined-title">
				<div class="editContent">
					<h1 class="text-center latestitems">LATEST ITEMS</h1>
				</div>
				<div class="wow-hr type_short">
					<span class="wow-hr-h"> <i class="fa fa-star"></i> <i
						class="fa fa-star"></i> <i class="fa fa-star"></i>
					</span>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<div class="productbox">
						<div class="fadeshop">
							<div class="captionshop text-center" style="display: none;">
								<h3>Item Name</h3>
								<p>This is a short excerpt to generally describe what the
									item is about.</p>
								<p>
									<a href="#" class="learn-more detailslearn"><i
										class="fa fa-shopping-cart"></i> Purchase</a> <a href="#"
										class="learn-more detailslearn"><i class="fa fa-link"></i>
										Details</a>
								</p>
							</div>
							<span class="maxproduct"><img
								src="<c:url value="images/product1-1.jpg"/>" alt=""></span>
						</div>
						<div class="product-details">
							<a href="#">
								<h1>Calypso Theme</h1>
							</a> <span class="price"> <span class="edd_price">$49.00</span>
							</span>
						</div>
					</div>
				</div>
				<!-- /.productbox -->
				<div class="col-md-4">
					<div class="productbox">
						<div class="fadeshop">
							<div class="captionshop text-center" style="display: none;">
								<h3>Item Name</h3>
								<p>This is a short excerpt to generally describe what the
									item is about.</p>
								<p>
									<a href="#" class="learn-more detailslearn"><i
										class="fa fa-shopping-cart"></i> Purchase</a> <a href="#"
										class="learn-more detailslearn"><i class="fa fa-link"></i>
										Details</a>
								</p>
							</div>
							<span class="maxproduct"><img
								src="<c:url value="images/product2.jpg"/>" alt=""></span>
						</div>
						<div class="product-details">
							<a href="#">
								<h1>FastSell Theme</h1>
							</a> <span class="price"> <span class="edd_price">$49.00</span>
							</span>
						</div>
					</div>
				</div>
				<!-- /.productbox -->
				<div class="col-md-4">
					<div class="productbox">
						<div class="fadeshop">
							<div class="captionshop text-center" style="display: none;">
								<h3>Item Name</h3>
								<p>This is a short excerpt to generally describe what the
									item is about.</p>
								<p>
									<a href="#" class="learn-more detailslearn"><i
										class="fa fa-shopping-cart"></i> Purchase</a> <a href="#"
										class="learn-more detailslearn"><i class="fa fa-link"></i>
										Details</a>
								</p>
							</div>
							<span class="maxproduct"><img
								src="<c:url value="images/product2-3.jpg" />" alt=""></span>
						</div>
						<div class="product-details">
							<a href="#">
								<h1>Biscaya Theme</h1>
							</a> <span class="price"> <span class="edd_price">$49.00</span>
							</span>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
	</section>
 --%>

	<!-- BUTTON =============================-->
<!-- 	<div class="item content">
		<div class="container text-center">
			<a href="shop.html" class="homebrowseitems">Browse All Products
				<div class="homebrowseitemsicon">
					<i class="fa fa-star fa-spin"></i>
				</div>
			</a>
		</div>
	</div>
	<br />


	AREA =============================
	<div class="item content">
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<i class="fa fa-microphone infoareaicon"></i>
					<div class="infoareawrap">
						<h1 class="text-center subtitle">General Questions</h1>
						<p>Want to buy a theme but not sure if it's got all the
							features you need? Trouble completing the payment? Or just want
							to say hi? Send us your message and we will answer as soon as
							possible!</p>
						<p class="text-center">
							<a href="#">- Get in Touch -</a>
						</p>
					</div>
				</div>
				/.col-md-4 col
				<div class="col-md-4">
					<i class="fa fa-comments infoareaicon"></i>
					<div class="infoareawrap">
						<h1 class="text-center subtitle">Theme Support</h1>
						<p>Theme support issues prevent the theme from working as
							advertised in the demo. This is a free and guaranteed service
							offered through our support forum which is found in each theme.</p>
						<p class="text-center">
							<a href="#">- Select Theme -</a>
						</p>
					</div>
				</div>
				/.col-md-4 col
				<div class="col-md-4">
					<i class="fa fa-bullhorn infoareaicon"></i>
					<div class="infoareawrap">
						<h1 class="text-center subtitle">Hire Us</h1>
						<p>If you wish to change an element to look or function
							differently than shown in the demo, we will be glad to assist
							you. This is a paid service due to theme support requests solved
							with priority.</p>
						<p class="text-center">
							<a href="#">- Get in Touch -</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
 -->

 <!-- TESTIMONIAL =============================-->
	<!--	<div class="item content">
		<div class="container">
			<div class="col-md-10 col-md-offset-1">
				<div class="slide-text">
					<div>
						<h2>
							<span class="uppercase">Awesome Support</span>
						</h2>
						<p>The support... I can only say it's awesome. You make a
							product and you help people out any way you can even if it means
							that you have to log in on their dashboard to sort out any
							problems that customer might have. Simply Outstanding!</p>
						<i class="fa fa-star"></i><i class="fa fa-star"></i><i
							class="fa fa-star"></i><i class="fa fa-star"></i><i
							class="fa fa-star"></i>
					</div>
				</div>
			</div>
		</div>
	</div> -->


</body>
</html>
