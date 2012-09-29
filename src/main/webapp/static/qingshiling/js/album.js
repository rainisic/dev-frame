$(document).ready(function() {

	// Album click action.
	$("figure.album").click(function() {

		var target = this;
		
		// Block UI
		$.blockUI({
			message: "相册加载中，请稍候…",
			css: { 
				border: "none", 
				padding: "15px", 
				backgroundColor: "#000", 
				"border-radius": "10px",
				"font-size": "28px",
				opacity: 0.5, 
				color: "#fff" 
			}
		}); 
		
		// Load the gallery images.
		$(".float .gallery").load("/album/display/" + $(target).attr("id") + ".html", function() {
		
			// Unblock UI.
			$.unblockUI();
			
			// Show the gallery.
			$(".float").fadeIn();
		});
	});
	
	// Album close button click action.
	$(".float .close").click(function() {
		$(".float").fadeOut();
	});
});