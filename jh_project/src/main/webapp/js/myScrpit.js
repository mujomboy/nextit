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

function attachSignUp(str){
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