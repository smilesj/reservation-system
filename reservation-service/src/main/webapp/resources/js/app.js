$(function(){
	console.log("gkgkgkgk");
	//var el = document.getElementById("input:button");
	//el.addEventListener("click", remove);
	$(".removebtn").on("click", remove);
});

function remove(){
	var elem = $(this).parent("li");
	var id = $(this).siblings("input[name=id]").val();
	console.log(id);
	$.ajax({
		method:'GET',
		url:"/category/delete",
		data:{
			"id" : id
		}, 
		success:function(data){
			console.log(data);
			elem.remove();
		}
	});
}