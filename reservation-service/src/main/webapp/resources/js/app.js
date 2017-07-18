$(function(){
	
	$(".modifybtn").on("click", modify);
	$(".removebtn").on("click", remove);

});

function remove(){
	var elem = $(this).parent("td");
	var id = $(this).siblings("input[name=id]").val(); // 형제노드찾기
	$.ajax({
		method:'GET',
		url:"/category/delete",
		data:{
			"id" : id
		}, 
		success:function(data){
			elem.remove();
		}
	});
}

function modify(){
	var id = $(this).siblings("input[name=id]").val();
	var name = $(this).siblings("input[name=name]").val();
	$.ajax({
		method:'POST',
		url:"/category/update",
		data:{
			"id" : id,
			"name" : name
		}
	});
}