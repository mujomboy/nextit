<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html lang="ko">
  <head>
   	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="mvc">
    <meta name="author" content="kjh">

    <title>회원가입</title>

<script type="text/javascript">


	var joinInfo = {status:false, checkId:"", message:""};

	$(function(){
		
		$('#memberInsert').on('submit', function(e){
			
			e.preventDefault();
			console.log('가입버튼 클릭');
			console.log($('#memberInsert').serialize());
			console.log($('#memberInsert'));
			
			console.log("아이디 채크 여부 " + joinInfo.status);
			
			var userId = $('input[name=usrId]').val();
			
			if(joinInfo.status && joinInfo.checkId == userId){
				console.log("회원가입")
			} else {
				console.log("아이디 중복 채크를 다시");
				return false;
			}
			
			$.ajax('/json/insertMemberInfo.json',{
				method: "POST",
				dataType: "json",
				data: $('#memberInsert').serialize(),
				success: function(data, status, xhr){
					console.log(data);
					
					if(data.status){
						location.href="/json/memberListFront.do";
					}
					
					console.log("joinInfo :" + joinInfo);
				},
				error : function(jqXhr, textStatus, errorMessage){
					console.log(jqXhr);
					console.log(textStatus);
					console.log(errorMessage);
				}
			});
			
		});
		
		$('#idCheck').on('click', function(e){
			e.preventDefault();
			console.log('중복채크 클릭');
			console.log($('#memberInsert').serialize());
			
			$.ajax('/json/findIdCheckProc.json',{
				method: "POST",
				dataType: "json",
				data: $('#memberInsert').serialize(),
				success: function(data, status, xhr){
					console.log(data);
					
					if(data.status){
						joinInfo = data;
					}
					
					for(var key in data)
						console.log(key + " : " + data[key]);
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
	<form action="" method="post" id="memberInsert">
		<table class="table">
			<tbody>
				<tr>
					<th>아이디</th>
					<td>
					<input type="text" name="usrId" class="form-control">
					<button id="idCheck" class="btn btn-default" type="button" onmousedown="test()">중복채크</button>
					</td>
				</tr>
				<tr>
					<th>암호</th>
					<td><input type="password" name="usrPwd" class="form-control"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="usrName" class="form-control"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="usrEmail" class="form-control"></td>
				</tr>
				<tr>
					<th>핸드폰</th>
					<td><input type="text" name="usrHp" class="form-control"></td>
				</tr>
				<tr>
					<th>팩스</th>
					<td><input type="text" name="usrFax" class="form-control"></td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<select name="usrGender">
							<option value="M">남성</option>
							<option value="W">여성</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>나이</th>
					<td><input type="text" name="usrAge" class="form-control"></td>
				</tr>
				<tr>
					<th colspan="2">
					<input type="submit" value="등록">
					</th>
				</tr>
				
			</tbody>
		</table>
	</form>
			
	<script>
		function test(){
			console.log($('#memberInsert').serialize());
		}
	</script>
</body>
</html>
    