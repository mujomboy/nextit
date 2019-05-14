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
		$('#btn').on("click", function(e){
			
			e.preventDefault();
			
			$.ajax('/json/testData.json',{
				method: "POST",
				dataType: "json",
				data:{
					
				},
				success: function(data, status, xhr){
					console.log(data);
					/* alert(data);
					alert(JSON.stringify(data)); */
					
					$.each(data, function(key, value){
						console.log(value);
						var rs = "";
						rs += '<tr>';
						rs += '<th> ' + key + ' </th>';
						rs += '<th> ' + value + ' </th>';
						rs += '</tr>'
						
						
						
						$('#dis').append(rs);
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

	<button id="btn">map test</button>
	
	<table class="table">
		<tbody id="dis">
			
		</tbody>
	</table>
	
</body>
</html>
