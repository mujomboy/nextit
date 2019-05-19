<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
</head>
<body>

	<script>
		attachCenter(document.getElementsByTagName('title')[0].innerHTML);
		window.onload = function() {
			var type = document.getElementsByTagName("legend")[0].innerHTML;
			setBoard(type);
			setBoardWrite(type);
		}
	</script>


	<section class="item content">
		<div class="container toparea">
		
		
		
			<div class="underlined-title">
				<div class="editContent">
					<h1 class="text-center latestitems">${message }</h1>
				</div>
				<div class="wow-hr type_short">
					<span class="wow-hr-h"> <i class="fa fa-book"></i>
					</span>
				</div>
			</div>
		
		
		
				<div id="edd_checkout_form_wrap" class="edd_clearfix">
					<form id="edd_purchase_form" class="edd_form" action="<c:url value='/board/boardWriteExc.do/${choiceType }'/>"
						method="POST">
						<fieldset>
							<legend>${who }</legend>
							
							<input type="hidden" value="${loginInfo eq null ? 'GUEST' : loginInfo.id}" name="regUser">
							
							<!-- 제목 -->
							<p>
								<label for="title" style="width: 10%; display: inline-block;"> 
									제목 
									<span class="edd-required-indicator">*</span>
								</label>
								<input type="password" name="pwd" placeholder="비밀번호 입력" style="width:8em; padding: 0px;float: right;line-height:normal;" maxlength="6">
								<select style="float: right; margin-right: 10px" name="kind" id="kind">
								</select>
								
								<input class="edd-input required" type="text" name="title" id="title"
									placeholder="제목 입력" value="" maxlength="90" spellcheck="false" >
							</p>
						
							<!-- 내용 -->
							
							<p>
								<label for="ctnt" style="width: 10%; display: inline-block;"> 내용 </label>
								<textarea rows="20" cols="" name="ctnt" id="ctnt" style="width: 100%" placeholder="내용입력" spellcheck="false"></textarea>
								
							</p>
							
							<p style="font-size: 13px">
								* 는 필수 입력 사항 입니다.
							
								<strong id="check_info" hidden="true">주의 : </strong> 
								<span id="check_info_con" hidden="true" style="color: red; font-size: 14px"></span>
								
								<a href="<c:url value="/board/boardListView.do/${choiceType }"/>" style="float: right;">
									<input type="button" class="edd-submit button" name="board_list_btn" value="목록" >
								</a>
								
								<input type="button" class="edd-submit button" name="board_write_btn" value="등록" style="float: right;margin-right: 10px">
								
							</p>
							
						<input type="reset" id="reset_info" hidden='hidden'>
						</fieldset>
					</form>
				</div>
			</div>

	</section>
	

</body>
</html>