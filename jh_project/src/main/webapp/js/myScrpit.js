"use strict"

function attachMain(str1, str2){
	var wrap = document.getElementById("head_wrap");
	
	var textHomeImage = document.createElement("div");
	var mainTextImage = document.createElement("div");
	var subTextImage = document.createElement("div");

	textHomeImage.className = "text-homeimage";
	mainTextImage.className = "maintext-image";
	mainTextImage.setAttribute("data-scrollreveal", "enter top over 1.5s after 0.1s");
	mainTextImage.innerHTML = str1;
	subTextImage.className = "subtext-image";
	subTextImage.setAttribute("data-scrollreveal", "enter bottom over 1.7s after 0.3s");
	subTextImage.innerHTML = str2;
	
	textHomeImage.appendChild(mainTextImage);
	textHomeImage.appendChild(subTextImage);
	
	wrap.appendChild(textHomeImage);
	
}

function attachCenter(str){
	var wrap = document.getElementById("head_wrap");
	
	var textHomeImage = document.createElement("div");
	var mainTextImage = document.createElement("div");
	var subTextImage = document.createElement("div");

	textHomeImage.className = "text-pageheader";
	subTextImage.className = "subtext-image";
	subTextImage.setAttribute("data-scrollreveal", "enter bottom over 1.7s after 0.0s");
	subTextImage.innerHTML = str;
	
	textHomeImage.appendChild(subTextImage);
	
	wrap.appendChild(textHomeImage);
}


function signUp(){
	
	$('input[name=signup_btn]').click(function() {
		var checkInfo = $('#check_info');
		var checkInfoCon = $('#check_info_con');
		
		// 필수
		var id = $('input[name=id]');
		var password = $('input[name=password]');
		var confirmPassword = $('input[name=confirm_password]');
		var name = $('input[name=name]');
		var checkCon = $('#duplication_con');
	
		var isHidden = true;
		
		id.removeClass("error");
		password.removeClass("error");
		confirmPassword.removeClass("error");
		name.removeClass("error");
		
		
		// 적절성 채크 =======================================================================
		//ID
		if(id.val().trim() == ''){
			isHidden = false;
			checkInfoCon.html("ID를 입력하세요");
			id.addClass("error");
			id.focus();
			
		} 
		// 비밀번호
		else if(password.val().trim() == ''){
			isHidden = false;
			checkInfoCon.html("PASSWORD를 입력하세요");
			password.addClass("error");
			password.focus();
		} 
		
		// 비밀번호 확인
		else if((confirmPassword.val().trim() == '') || (password.val() !== confirmPassword.val())){
			isHidden = false;
			checkInfoCon.html("PASSWORD 가 일치 하지 않습니다.");
			confirmPassword.addClass("error");
			confirmPassword.focus();
		}
		
		// 이름 확인
		else if((name.val().trim() == '')){
			isHidden = false;
			checkInfoCon.html("이름을 입력하세요");
			name.addClass("error");
			name.focus();
		}
		
		// 중복검사 확인
		else if(checkCon.attr("class") != 'true'){
			isHidden = false;
			checkInfoCon.html("중복검사를 해주세요");
			checkCon.focus();
		}
		
		console.log(checkCon.attr("class"));
		
		
		checkInfo.attr("hidden", isHidden);
		checkInfoCon.attr("hidden", isHidden);
		
		// 전송 조건 부합
		if(isHidden){
			
			// 선택
			var phone = $('input[name=phone]');
			var age = $('input[name=age]');
			var email = $('input[name=email]');
			
			phone.val(
					($('input[id=phone_first]').val().trim() == '' ? '000' : $('input[id=phone_first]').val().trim())
					+ '-' +
					($('input[id=phone_second]').val().trim() == '' ? '0000' : $('input[id=phone_second]').val().trim()) 
					+ '-' +
					($('input[id=phone_third]').val().trim() == '' ? '0000' : $('input[id=phone_third]').val().trim())
			);
			
			age.val(age.val() == '' ? 0 : age.val());
			
			email.val(email.val() == '' ? 'guest@info.com' : email.val());
			
			document.getElementById("edd_purchase_form").submit();
			
		
		}
	});
}

function login(){
	$('input[id=login_btn]').click(function() {
		
		var id = $('input[name=id]');
		var password = $('input[name=password]');
		
		var isHidden = true;
		
		var checkInfo = $('#check_info');
		var checkInfoCon = $('#check_info_con');
		
		id.removeClass("error");
		password.removeClass("error");
		
		// 적절성 채크 =======================================================================
		//ID
		if(id.val().trim() == ''){
			isHidden = false;
			checkInfoCon.html("ID를 입력하세요");
			id.addClass("error");
			id.focus();
			
		} 
		// 비밀번호
		else if(password.val().trim() == ''){
			isHidden = false;
			checkInfoCon.html("PASSWORD를 입력하세요");
			password.addClass("error");
			password.focus();
		} 
		
		
		checkInfo.attr('hidden', isHidden);
		checkInfoCon.attr('hidden', isHidden);
		
		// 전송
		if(isHidden){
			$('#edd_checkout_cart_form').submit();
		}
	});
}


function duplicationIdCheck(){

	$("#duplication_id").click(function() {
		var id = $('#id');
		var checkCon = $("#duplication_con");
		
		if(id.val().trim() == ''){
			checkCon.html("비어 있음");
			checkCon.css("color", "red");
			checkCon.attr("class", "false");
			console.log("비어있음");
			return;
		}
		
		console.log(id.serialize());
		
		$.ajax('/login/duplicationId.json', {
			method: "POST",
			dataType: "json",
			data: id.serialize(),
			success: function(data, status, xhr){
								
				if(data){
					checkCon.html("사용 불가");
					checkCon.css("color", "red");
					checkCon.attr("class", "false");

					console.log("중복");
				}
				else{
					checkCon.html("사용 가능");
					checkCon.attr("class", "true");
					checkCon.css("color", "green");
					console.log("중복아님");
				}
			},
			error: function(xhr, status, error){
				console.log(error);
			}
		});
		
	});
	
	
	$('input[name=id]').on("keydown",function(e){
		var checkCon = $("#duplication_con");
		checkCon.html("");
		checkCon.attr("class", "false");
	});
}





