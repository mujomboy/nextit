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


<script type="text/javascript" defer="defer">
	$(function(){
		
		$(".btn_file_new").on("click", function(){
			var fileView = "";
			fileView = '<div>';
			fileView +='	<input type="file" name="attachFiles">';
			fileView +='	<button type="button" ';	
			fileView +='	class="btn_file_remove form-control">삭제</button>';	
			fileView +='</div>';
			$(".file_area").append(fileView);
		});
		
		$(".file_area").on("click", ".btn_file_remove", function(){
			$(this).parent().remove();
			console.log($(this));
			console.log($(this).parent());
		});
		
		
		
		$("#fileVo").on("submit", function(e){
			
			e.preventDefault();
			alert();
			
			$(this).ajaxSubmit({
				type :'post',
				url : "/attach/ajaxFileUploadProc.json",
				data: $('#fileVo').serialize(),
				success: function(msg){
					alert(msg);
					alert(JSON.stringify(msg));
				},
				error : function(jqXhr, textStatus, errorMessage){
					console.log(errorMessage);
				}
			});
		});
	})
</script>
</head>

<body>

	<!-- enctype="multipart/form-data" 첨부파일을 하기 위한 필수 -->
	<!-- method="post" 첨부파일은 post 방식에서만 됨. 필수 -->
	<form id="fileVo" name="fileVo" method="post" enctype="multipart/form-data">
			<input type="text" name="serviceType" value="NOTICE">
			<table class="table">
				<tbody>
					<tr>
						<th>제목</th>
						<td><input type="text" name=boTitle" size="60"> </td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td>
						
							<div class="file_area">
								<div>
									<button type="button" class="btn_file_new form-control">추가</button>
								</div>
								<div>
									<input type="file" name="attachFiles">
									<button type="button" class="btn_file_remove form-control">삭제</button>
								</div>
							</div>
							
							
						</td>
					</tr>
					<tr>
						<td colspan="2"> <button type="submit" class="form-control">저장</button> </td>
					</tr>
				</tbody>
			</table>
	</form>

</script>
</body>
</html>
