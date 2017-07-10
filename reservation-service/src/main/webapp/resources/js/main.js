$(function(){
	
	var anchor = document.getElementsByClassName("anchor");
	for(var i = 0; i < anchor.length; i++) {
		anchor[i].addEventListener("click", anchorClick, false);
	}

	var size = $(".visual_img").children().outerWidth();	// 이미지 한 개의사이즈
	var len = $(".visual_img").children().length-2;
	var cnt = 0;
	var interval = null;
	var timeout = null;
	var startInterval = {};
	
	$(".visual_img").css('width', len*size);
		
	// 즉시 실행함수
	(startInterval = function(){
		interval = setInterval(preVisual, 2000);
	})();
	
	// 이전버튼
	$(".prev_inn").on("click", preVisual);
	// 다음버튼
	$(".nxt_inn").on("click", nextVisual);
	
	function clearEvent(){
		clearInterval(interval);
		clearTimeout(timeout);
		timeout = setTimeout(startInterval, 2000);
	}
	
	function preVisual() {
		cnt--;
		$(".item").animate({'right': +(cnt*size)+'px'}, 'normal');
		if(cnt <= 0){
			cnt = len;
			$(".item").animate({'right': +(cnt*size)+'px'}, 0);
		}
		clearEvent();
	}
		
	function nextVisual(){
		cnt++;
		$(".item").animate({'left': -(cnt*size)+'px'}, 'normal');
		if(cnt == len){
			cnt = 0;
			$(".item").animate({'left': '0px'}, 0);
		}
		clearEvent();
	}
	
});

function anchorClick() {
	console.log("anchor click");
	var anchor = document.getElementsByClassName("anchor");
	for(var i = 0; i < anchor.length; i++) {
		anchor[i].classList.remove("active");
	}
	this.classList.add("active");
}


