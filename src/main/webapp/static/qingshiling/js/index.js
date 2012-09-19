$(document).ready(function() {
	
	// Gallery loop.
	setInterval(function() {
		
		var index = $(".layer img.active").index();
		if (index < 4) {
			$(".layer img.active").next().click();
		} else {
			$(".layer img:eq(0)").click();
		}
		
	}, 5000);
	
	// Gallery item clicked.
	$(".layer img").click(function() {
		$(".gallery figure img:visible").animate({
			opacity: 0
		}, 1000, function() {
			$(this).hide();
		});
		$(".gallery figure img:eq(" + $(this).index() + ")").show();
		$(".gallery figure img:eq(" + $(this).index() + ")").animate({
			opacity: 1
		}, 1000);
		$(".layer img.active").removeClass("active");
		$(this).addClass("active");
	});
});
