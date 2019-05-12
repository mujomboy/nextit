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
	
	$('input[name=signup_btn').click(function() {
		var checkInfo = $('#check_info');
		var checkInfoCon = $('#check_info_con');
		
		// 필수
		var id = $('input[name=id]');
		var password = $('input[name=password]');
		var confirmPassword = $('input[name=confirm_password]');
		var name = $('input[name=name]');
		
	
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
