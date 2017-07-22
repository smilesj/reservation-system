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