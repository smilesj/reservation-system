$(function(){
	console.log("gggg");
	$(".removebtn").on("click", remove);
	// $(".removebtn").on("click", "input[name=id]", remove);
	$(".updatebtn").on("click", update2);
});

function remove(){
	var elem = $(this).parent("li");
	var id = $(this).siblings("input[name=id]").val(); // 형제노드찾기
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

function update2(){
	var id = $(this).siblings("input[name=id]").val();
	var name = $(this).siblings("input[name=name]").val();
	console.log("update btn click "+id +"/"+name);
	$.ajax({
		method:'POST',
		url:"/category/update",
		data:{
			"id" : id,
			"name" : name
		}
	});
}