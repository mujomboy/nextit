

"use strict"

var print;

var len;

var s_title;
var s_kind;

var curPageRem;


// 리스트 생성
function setList(page, isSearch = false){
	
	page = parseInt(page);
	
//	print = function(append){
//		
//		$("tbody").html($("tbody").html() + '<tr><td colspan="3">' + append +'</td></tr>');
//	}
	
	
	// 검색 세팅인 경우
	if(isSearch){
		s_title = $('input[id=search_title]').val().trim();
		s_kind = $('#kind > option:selected').val();
		curPageRem = -100;
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
			paging.setting(amount);									// 세팅
			// 일반 페이지 세팅
			if(page > -300){
				page = paging.setPageItemFirstAndLast(page);		// 페이지에 해당하는 번호 리턴
				curPageRem = page;									// 현재 페이지 저장
			} else {
				
				switch(page){
				case -300 : page = 1; break;
				case -301 : page = curPageRem - 1; break;
				case -302 : page = curPageRem + 1; break;
				case -303 : page = paging.getPageLen(); break;
				}
				
				page = paging.setPageItemFirstAndLast(page);
				curPageRem = page;
			}
			
			// 3. 자료 검색
			searchItem(paging.getFirst(), paging.getLast(), s_title, s_kind);
			
			// 4. 페이징 넘버 버튼 생성
			paging.setButtonRange(page);
			
			setPageButton(paging.getFirstPage(), paging.getLastPage(), page);
		
	}, 'text')
}


// 페이징 세팅
function Paging(){
	var amount;								// 총 자료 갯수
	var itemLimitLen;						// 페이지당 자료 나열 갯수
	
	var pageLen;							// 총 페이지 갯수
	
	var first;								// 나열할 페이지의 시작 번호
	var last;								// 나열할 페이지의 마지막 번호
	
	var firstPage;							// 시작 페이지 버튼
	var lastPage;							// 마지막 페이지 버튼
	
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
		
//		print("총개수 " + amount);
//		print("페이지당 아이템 나열 갯수 " + itemLimitLen);
//		print("페이지 수 " + pageLen);
		
	}
	
	// 페이지에 따른 시작 번호 끝 번호 계산
	this.setPageItemFirstAndLast = function(page){
		if(page < 1) page = 1;					// 페이지가 1보다 작으면 1로 세팅
		else if(page > pageLen) page = pageLen;	// 페이지가 최대페이지 보다 클때 최대페이지로 세팅
		
		
		last = amount - (page -1) * itemLimitLen;			// 페이지에 보여줄 마지막 순번
		first = last - (itemLimitLen - 1);// 페이지에 보여줄 첫번째 순번
		
		if(first < 1) first = 1;
		
		return page;
	}
	
	// 페이징 버튼 범위 세팅
	this.setButtonRange = function(page){
		
		firstPage = lastPage = page;
		
		console.log("firstPage : " + firstPage);
		console.log("lastPage : " + lastPage);
		for(var i = 0 ; i < 5 ; i++){
			firstPage -= 1;
			if(firstPage < 1){
				firstPage = 1;
				lastPage += 1;
			}
		}
		
		console.log("firstPage : " + firstPage);
		console.log("lastPage : " + lastPage);
		for(var i = 0 ; i < 4 ; i++){
			lastPage += 1;
			if(lastPage > pageLen){
				lastPage = pageLen;
				firstPage -= 1;
				if(firstPage < 1) firstPage = 1;
			}
		}
		
		console.log("firstPage : " + firstPage);
		console.log("lastPage : " + lastPage);
	}
	
	this.getFirst = function(){return first;}
	this.getLast = function(){return last;}
	this.getFirstPage = function(){return firstPage;}
	this.getLastPage = function(){return lastPage;}
	this.getPageLen = function(){return pageLen;}
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
	body.empty();
	
	
	var str = '';
	
	for(var i in data){
		
		var tempStr = '';
		tempStr = '<tr>';
		tempStr += '<td>'+ data[i].num + '</td>';
		tempStr += '<td>'+ data[i].kind + '</td>';
		tempStr += '<td>'+ data[i].title + '</td>';
		tempStr += '<td>'+ data[i].readCount + '</td>';
		tempStr += '<td>'+ data[i].regUser + '</td>';
		tempStr += '</tr>';
		
		str = tempStr + str;
	}
	
	body.append(str);
	
	
}



// 페이징 버튼 배치
function setPageButton(firstPage, lastPage, curPage){
	
	var foot = $('tfoot');
	foot.empty();
	
	var str = '';
	
	str += '<tr><td colspan = "5" style="padding-top: 20px">';
	str += '<strong name="idx_first" class="numberOut"> &lt&lt </strong> <strong name="idx_left" class="numberOut"> &lt </strong>'
		
	for(var i = firstPage ; i <= lastPage ; i++){
		if(i == curPage) str+= '<strong class="curPageNumber">' + i + '</strong>';
		else str+= '<strong name="idx" class="numberOut">' + i + '</strong>';
	}
	
	str += '<strong name="idx_right" class="numberOut"> &gt </strong> <strong name="idx_last" class="numberOut"> &gt&gt </strong>';
	str += '</td></tr>';
	
	foot.append(str);
	
	console.log('[ '+firstPage + ' ]' + ' ' + '[ '+curPage + ' ]' + ' '+ '[ '+lastPage + ' ]');
	
	
//	style="padding: 10px;font-size: 1.5em;"
	
	// 숫자 버튼 클릭 이벤트 등록
	$('strong[name=idx]').on("click", function(e) {
		console.log("클릭함 " + this.innerHTML );
		setList(this.innerHTML, false);
	});
	
	
	// 가장 첫 페이지
	$('strong[name=idx_first]').on("click", function(e) {
		console.log("클릭함 " + this.innerHTML );
		setList(-300, false);
	});
	
	// 왼쪽으로 한칸 이동
	$('strong[name=idx_left]').on("click", function(e) {
		console.log("클릭함 " + this.innerHTML );
		setList(-301, false);
	});
	
	// 오른쪽으로 한칸 이동
	$('strong[name=idx_right]').on("click", function(e) {
		console.log("클릭함 " + this.innerHTML );
		setList(-302, false);
	});
	
	// 가장 첫 페이지로 이동
	$('strong[name=idx_last]').on("click", function(e) {
		console.log("클릭함 " + this.innerHTML );
		setList(-303, false);
	});
	
	// 효과 설정
	$('strong[name=idx], strong[name=idx_first], strong[name=idx_left], strong[name=idx_right], strong[name=idx_last]').on("mouseover", function(e) {
		this.setAttribute("class", "numberOver");
	});
	
	$('strong[name=idx], strong[name=idx_first], strong[name=idx_left], strong[name=idx_right], strong[name=idx_last]').on("mouseout", function(e) {
		this.setAttribute("class", "numberOut");
	});
	
}


















/////////////////////////////////////////////
//검색 보드 리스트 세팅
function setBoardList(){
	// 검색 클릭
	$('input[id=search_btn]').click(function(){
		setList(1, true) 				
	});
}