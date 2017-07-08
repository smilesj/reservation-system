$(function(){
	var updatebtn = document.getElementsByClassName("modifybtn");
	for(var i = 0; i < updatebtn.length; i++) {
		updatebtn[i].addEventListener("click", modify, true);
	}
	
	var removebtn = document.getElementsByClassName("removebtn");
	for(var i = 0; i < removebtn.length; i++) {
		removebtn[i].addEventListener("click", remove, true);
	}
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