$(function(){
	console.log("main js load");
	var anchor = document.getElementsByClassName("anchor");
	for(var i = 0; i < anchor.length; i++) {
		anchor[i].addEventListener("click", anchorClick, false);
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
