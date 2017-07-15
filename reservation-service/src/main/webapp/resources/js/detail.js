$(function(){

	$(".section_store_details .bk_more").on("click", function(){

		if($(".section_store_details ._open").css("display") != 'none'){
			$(".section_store_details .store_details").removeClass("close3");
			$(".section_store_details ._open").css("display", "none");
			$(".section_store_details ._close").css("display", "block");
		}else{
			$(".section_store_details .store_details").addClass("close3");
			$(".section_store_details ._open").css("display", "block");
			$(".section_store_details ._close").css("display", "none");
		}
	});
	
	$(".section_info_tab .info_tab_lst ._detail").on("click", function() {
		event.preventDefault();
		$(".section_info_tab .info_tab_lst").find("a").removeClass("active");
		$(this).children("a").addClass("active");
		$(".detail_area_wrap").removeClass("hide");
		$(".detail_location").addClass("hide");
	});
	
	$(".section_info_tab .info_tab_lst ._path").on("click", function() {
		event.preventDefault();
		$(".section_info_tab .info_tab_lst").find("a").removeClass("active");
		$(this).children("a").addClass("active");
		$(".detail_area_wrap").addClass("hide");
		$(".detail_location").removeClass("hide");
	});
		
});