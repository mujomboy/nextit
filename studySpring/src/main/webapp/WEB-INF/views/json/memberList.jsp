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

<script type="text/javascript">
"use strict"


$(function(){
	$('#btnMemberList').on("click", function(e){
		
		e.preventDefault();
		
		$.ajax('/json/memberListProc.json',{
			method: "POST",
			dataType: "json",
			data:{
				
			},
			success: function(data, status, xhr){
				
				$('#memberList').empty();
					
				$.each(data, function(idx, value){
					console.log(value);
					var rs = "";
					rs += '<tr>';
					rs += '<th> ' + value.usrId + ' </th>';
					rs += '<th> ' + value.usrName + ' </th>';
					rs += '<th> ' + value.usrEmail + ' </th>';
					rs += '<th> ' + value.usrHp + ' </th>';
					rs += '<th> ' + value.regUser + ' </th>';
					rs += '</tr>'
					
					
					
					$('#memberList').append(rs);
				});
				
			},
			error : function(jqXhr, textStatus, errorMessage){
				console.log(jqXhr);
				console.log(textStatus);
				console.log(errorMessage);
			}
		});
	});
});

$(function(){
	
	$("#searchVo").submit(function(e) {
		var e = e || window.Event;
		e.preventDefault();
		
		console.log($('#searchVo').serialize());
		
	
		$.ajax('/json/memberListProc.json',{
			method: "POST",
			dataType: "json",
			data: $('#searchVo').serialize(),
			success: function(data, status, xhr){
				
				$('#memberList').empty();
					
				$.each(data, function(idx, value){
					console.log(value);
					var rs = "";
					rs += '<tr>';
					rs += '<th> ' + value.usrId + ' </th>';
					rs += '<th> ' + value.usrName + ' </th>';
					rs += '<th> ' + value.usrEmail + ' </th>';
					rs += '<th> ' + value.usrHp + ' </th>';
					rs += '<th> ' + value.regUser + ' </th>';
					rs += '</tr>'
					
					
					
					$('#memberList').append(rs);
				});
				
			},
			error : function(jqXhr, textStatus, errorMessage){
				console.log(jqXhr);
				console.log(textStatus);
				console.log(errorMessage);
			}
		});
	});
	
});
</script>

</head>
<body>

	<form action="" method="get" id="searchVo">
		<input type="hidden" name=curPage" value="1">
		<table class="table">
			<tr>
				<th>검색 조건</th>
				<th>
					<select name="searchType">
						<option value="usr_id">아이디</option>
						<option value="usr_name">이름</option>
						<option value="usr_email">이메일</option>
					</select>
				</th>
				<th>검색어</th>
				<th><input type="text" name="searchText"></th>
				<th>
					<button id="btnSearchEvent" type="submit">검색</button>
				</th>
				<th>
					<a href="/json/memberInsertFront.do">회원 가입</a>
				</th>
			</tr>
		</table>
	</form>



	<table class="table">
		<thead>
			<tr>
				<th colspan="5">
					<button id="btnMemberList">검색</button>
				</th>
			</tr>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>이메일</th>
				<th>핸드폰</th>
				<th>가입일</th>
			</tr>
		</thead>
		<tbody id="memberList">
		
		</tbody>
	</table>

</body>
</html>
