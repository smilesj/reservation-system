var start = 0;
$(function(){
	
	$(".event_tab_lst .item").on("click", anchorClick);

	var size = $(".visual_img").children().outerWidth(); //*	// 이미지 한 개의사이즈
	var len = $(".visual_img").children().length-2; //*
	var cnt = 0; //*
	var interval = null;
	var timeout = null;
	var startInterval = {};
	
	$(".visual_img").css('width', len*size);
		
	// 즉시 실행함수
	(startInterval = function(){
		interval = setInterval(nextVisualRolling, 2000);
	})();
	
	// 이전버튼
	//$(".prev_inn").on("click", preVisualRolling);
	// 다음버튼
	//$(".nxt_inn").on("click", nextVisualRolling);
	
	function clearEvent(){
		clearInterval(interval);
		clearTimeout(timeout);
		timeout = setTimeout(startInterval, 2000);
	}
	
//	function preVisualRolling() {
//		if(cnt <= 0){
//			cnt = len;
//			$(".item").animate({'right': +(cnt*size)+'px'}, 0);
//		}
//		cnt--;
//		$(".item").animate({'right': +(cnt*size)+'px'}, 'normal');
//		clearEvent();
//	}
		
//	function nextVisualRolling(){
//		cnt++;
//		$(".item").animate({'left': -(cnt*size)+'px'}, 'normal');
//		if(cnt == len){
//			cnt = 0;
//			$(".item").animate({'left': '0px'}, 0);
//		}
//		clearEvent();
//	}
		
	// 더보기
	$(".more .btn").on("click", getMore);
	
	getProductList();
});

$(window).scroll(function() {
    if ($(window).scrollTop() == $(document).height() - $(window).height()) {
    	getMore();
    }
});

function getMore(){
	start++;	
	var categoryId = $(".active").parent().attr("data-category");
	
	var rest = "";
	if(categoryId == 0)
		rest = start;
	else
		rest = categoryId+"/start/"+start;
	
	$.ajax({
		method : "GET",
		url : "/api/products/"+rest
	}).done(function(data){

		var leftSize = $(".lst_event_box:first .item").length;
		var rightSize = $(".lst_event_box:last .item").length;
		
		$.each(data.list, function(index, product){
			var dummy = $("#project-item-template").html();
			var template = Handlebars.compile(dummy);
			var source = product;
			
			var item = template(source);

			if(leftSize > rightSize){
				if(index%2 == 1){
					$(".lst_event_box:first").append(item);
				}else{
					$(".lst_event_box:last").append(item);
				}
			}else{
				if(index%2 == 0){
					$(".lst_event_box:first").append(item);
				}else{
					$(".lst_event_box:last").append(item);
				}
			}
		});	
	});
}

function anchorClick() {
	$(".anchor").removeClass("active");
	$(this).find(".anchor").addClass("active");
	var categoryId = $(this).attr("data-category");
	start = 0;
	getProductList(categoryId);
}

function getProductList(categoryId){
	var rest = "";
	if(categoryId == 0 || categoryId == undefined)
		rest = start;
	else
		rest = categoryId+"/start/"+start;

	$(".lst_event_box:first").empty();
	$(".lst_event_box:last").empty();
	$.ajax({
		method : "GET",
		url : "/api/products/"+rest
	}).done(function(data){
		$(".event_lst_txt .pink").html(data.cnt+"개"); // 카테고리별 상품 총 개수
		
		$.each(data.list, function(index, product){
			var dummy = $("#project-item-template").html();
			var template = Handlebars.compile(dummy);
			var source = product;
			
			var item = template(source);
			if(index%2 == 0){
				$(".lst_event_box:first").append(item);
			}else{
				$(".lst_event_box:last").append(item);
			}
		});		
	});
}


