$("div.inline_control .tel").keyup("change", function(){

	var tel = $("div.inline_control .tel").val();
	var pattern = /^[0-9]+/;
	var result = pattern.test(tel);
	console.log(result);
});

$("div.inline_control .email").keyup("change", function(){
	console.log("email change");
	// [a-zA-Z0-9\_]+@[a-zA-Z0-9\_]+\.[a-zA-Z0-9]{2,}
});

$(".agreement").on("click", function(){
	event.preventDefault();
	$(this).addClass("open");
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
		console.log("hi plus> " + this.option("cnt"));
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
});




