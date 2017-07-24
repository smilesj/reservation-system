var valueInvalidFlag = true;
$("div.inline_control .tel").keyup("change", function(){

	var tel = $("div.inline_control .tel").val();
	var pattern = /^([0-9]){9,11}$/;
	var result = pattern.test(tel);
	valueInvalidFlag = result;
	$(".agreement").eq(0).find("#chk3").prop("checked", false);
	$(".bk_btn_wrap").addClass("disable");
});

$("div.inline_control .email").keyup("change", function(){
	console.log("email change");
	var email = $("div.inline_control .email").val();
	var pattern = /^([\w\.\-]+)\@([\w]+)\.([\w]+)(([\w\.]+)?)$/;
	var result = pattern.test(email);
	valueInvalidFlag = result;
	$(".agreement").eq(0).find("#chk3").prop("checked", false);
	$(".bk_btn_wrap").addClass("disable");
});

$(".agreement").on("click", function(){
	event.preventDefault();
	if($(this).index() == 0){
		var toggle = !$(this).find("#chk3").prop("checked");
		$(this).find("#chk3").prop("checked", toggle);
		if(toggle && valueInvalidFlag){
			$(".bk_btn_wrap").removeClass("disable");
		}else{
			$(".bk_btn_wrap").addClass("disable");
		}
	}else{
		$(this).addClass("open");		
	}
	
});

// event emitter
class CountControl extends eg.Component {
	init() {
		this.on("minus", this.minus);
		this.on("plus", this.plus);
		this.option("cnt", 0);
	}
	
	minus() {
		var temp = this.option("cnt");
		this.option("cnt", temp-1);
	}
	
	plus() {
		var temp = this.option("cnt");
		this.option("cnt", temp+1);
	}
	
	tminus(){
		this.trigger("minus");
	}
	
	tplus(){
		this.trigger("plus");
	}
	
	getCnt(){
		return this.option("cnt");
	}
}

var countControl = new Array($("div.clearfix").length);
for(var i = 0; i < $("div.clearfix").length; i++){
	countControl[i] = new CountControl();
	countControl[i].init();
}

$("div.clearfix a.ico_minus3").on("click", function(){
	event.preventDefault();
	var index =$(".qty .ico_minus3").index($(this));
	if(countControl[index].getCnt() > 0){
		countControl[index].tminus();
		var num = countControl[index].getCnt();
		$(this).siblings(".count_control_input").attr("value", num);
		if(num <= 0){
			$(this).addClass("disabled");
		}
		var productPrice = Number($(".qty").eq(index).find(".product_price .price").html().replace(",", ""));
		if((productPrice != 0) &&(num >= 0)){
			$(".qty").eq(index).find(".total_price").html(productPrice*num);
			if(num <= 0){
				$(".qty").eq(index).find(".individual_price").removeClass("on_color");
			}
		}
		var date = $(".inline_txt").html().substring(0, $(".inline_txt").html().indexOf("총")+2);
		var totalCount = Number($(".inline_txt").html().substring($(".inline_txt").html().indexOf("총")+2, $(".inline_txt").html().indexOf("총")+3));
		totalCount--;
		$(".inline_txt").html(date+totalCount+"매");
	}
});

$("div.clearfix a.ico_plus3").on("click", function(){
	event.preventDefault();
	var index = $(".qty .ico_plus3").index($(this));
	countControl[index].tplus();
	var num = countControl[index].getCnt();
	$(this).siblings(".count_control_input").attr("value", num);
	if(num > 0){		
		$(this).siblings("a.ico_minus3").removeClass("disabled");
	}
	var productPrice = Number($(".qty").eq(index).find(".product_price .price").html().replace(",", ""));
	if((productPrice != 0) &&(num > 0)){
		$(".qty").eq(index).find(".total_price").html(productPrice*num);
		$(".qty").eq(index).find(".individual_price").addClass("on_color");
	}
	var date = $(".inline_txt").html().substring(0, $(".inline_txt").html().indexOf("총")+2);
	var totalCount = Number($(".inline_txt").html().substring($(".inline_txt").html().indexOf("총")+2, $(".inline_txt").html().indexOf("총")+3));
	totalCount++;
	$(".inline_txt").html(date+totalCount+"매");

});

// 예약하기버튼
$(".bk_btn_wrap").on("click", function(){
	//if(!$(this).hasClass("disable")){
		console.log("예약하기 버튼 클릭");
		var data = {};
		for(var i = 0; i < countControl.length; i++){
			if(i == 0){
				data.generalTicketCount = countControl[i].getCnt();
			}else if(i == 1){
				data.youthTicketCount = countControl[i].getCnt();
			}else{
				data.childTicketCount = countControl[i].getCnt();
			}
		}
		data.productId = $(".title").data("category");
		data.reservationName = $("div.inline_control input[name='name']").val();
		data.reservationTel = $("div.inline_control .tel").val();
		data.reservationEmail = $("div.inline_control .email").val();
		console.log(data);
		
		$.ajax({
			url : "/reserve",
			method : "post",
			data : data,
			success : function(e){
				console.log(e);
			}
		});
		
		//console.log( $(".form_horizontal:input[name='name']").val());
		 //$("div.inline_control .tel").val();
		 //$("div.inline_control .email").val();
	//}
});

