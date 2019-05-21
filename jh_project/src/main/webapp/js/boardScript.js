

"use strict"

var print;

var len;

var s_title;
var s_kind;


// 리스트 생성
function setList(page, isSearch = false){
		
	print = function(append){
		
		$("tbody").html($("tbody").html() + '<tr><td colspan="3">' + append +'</td></tr>');
	}
	
	
	// 검색 세팅인 경우
	if(isSearch){
		s_title = $('input[id=search_title]').val().trim();
		s_kind = $('#kind > option:selected').val();
	}
	
	// 1. 총 아이템 갯수 구하기
	$.post('/board/amountItem.json', {
		title : s_title,
		kind : s_kind}, 
		function(data, textStatus, req) {
			console.log(data);
			
			var amount = data;				// 아이템 총 갯수
			
			// 2. 페이징 생성
			var paging = new Paging();	
			paging.setting(amount);						// 세팅
			paging.setPageItemFirstAndLast(page);		// 페이지에 해당하는 번호 리턴
			
			// 3. 자료 검색
			searchItem(paging.getFirst(), paging.getLast(), s_title, s_kind);
		
	}, 'text')
}


// 페이징 세팅
function Paging(){
	var amount;								// 총 자료 갯수
	var itemLimitLen;						// 페이지당 자료 나열 갯수
	
	var pageLen;							// 총 페이지 갯수
	
	var first;								// 나열할 페이지의 시작 번호
	var last;								// 나열할 페이지의 마지막 번호
	
	
	// 세팅
	this.setting = function(p_amount){
		
		
		amount = parseInt(p_amount);				// 총 자료	
		itemLimitLen = parseInt(len);				// 페이지당 자료 나열 갯수
		
		// 페이지 길이
		pageLen = parseInt(amount / itemLimitLen);
		var temp = (amount % itemLimitLen) > 0 ? 1 : 0;
		pageLen += temp;
		
		first = 1;
		last = itemLimitLen;
		
		print("총개수 " + amount);
		print("페이지당 아이템 나열 갯수 " + itemLimitLen);
		print("페이지 수 " + pageLen);
		
	}
	
	// 페이지에 따른 시작 번호 끝 번호 계산
	this.setPageItemFirstAndLast = function(page){
		if(page < 1) page = 1;					// 페이지가 1보다 작으면 1로 세팅
		else if(page > pageLen) page = pageLen;	// 페이지가 최대페이지 보다 클때 최대페이지로 세팅
		
		first = amount - (page * itemLimitLen) + 1;	// 페이지에 보여줄 첫번째 순번
		last = first + itemLimitLen - 1;			// 페이지에 보여줄 마지막 순번
		
		if(last < 1) last = 1;
	}
	this.getFirst = function(){return first;}
	this.getLast = function(){return last;}
}


// 검색 조건에 맞는 자료 구하기
function searchItem(firstItem, lastItem, p_title, p_kind){

	$.ajax('/board/searchBoardList.json', {
		method : 'POST',
		dataType: 'json',
		data:  {
			title : p_title,
			kind : p_kind,
			start : firstItem,
			end : lastItem
		},
		success: function(data, status, xhr){
			console.log(data);
			setItemChart(data);
			
		},
		error: function(){}		
	});
}


// 자료 배치
function setItemChart(data){
	var body = $('tbody');
	
	console.log(data[0]);
	
	var str = '';
	
	for(var item in data){
		
		str += '<tr>';
		str += '<td>';
		
		str += '</tr>';
	}
	
	
}






















/////////////////////////////////////////////
//검색 보드 리스트 세팅
function setBoardList(){
	// 검색 클릭
	$('input[id=search_btn]').click(function(){
		setList(1, true) 				
	});
}