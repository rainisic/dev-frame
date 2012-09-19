{
	// Gallery timer.
	var timer;
}

$(document).ready(function() {

	// Initialize all components.
	initComponents();

	// Add action listener.
	actionListener();
});

/**
 * Initialize all components.
 */
function initComponents() {

	// Initialize components.
	$(".gallery figure img:gt(0)").hide();

	// Gallery loop.
	timer = setInterval(galleryLoop, 5000);
}

/**
 * Action listener.
 */
function actionListener() {

	// Gallery item clicked.
	$(".layer img").click(galleryClickActionPerformed);
}

/**
 * Gallery button click action performed.
 * 
 * @param event
 *            the click event.
 */
function galleryClickActionPerformed(event) {

	// Effect
	$(".gallery figure img:visible").slideUp("normal");
	$(".gallery figure img:eq(" + $(event.target).index() + ")").slideDown("normal");
	$(".layer img.active").removeClass("active");
	$(event.target).addClass("active");

	// Reset timer.
	clearInterval(timer);
	timer = setInterval(galleryLoop, 5000);
}

/**
 * For gallery loop timer.
 */
function galleryLoop() {

	var index = $(".layer img.active").index();
	if (index < 4) {
		$(".layer img.active").next().click();
	} else {
		$(".layer img:eq(0)").click();
	}
}