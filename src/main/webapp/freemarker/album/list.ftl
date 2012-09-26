<link rel="stylesheet" type="text/css" href="${ project.staticDomain! }/${ project.name! }/css/album-list.css">
<section class="content">
	<h1>相册列表</h1>
	<hr>
	<figure class="album">
		<img src="${ project.staticDomain! }/${ project.name! }/images/1.jpg">
		<figcaption>默认相册</figcaption>
		<div>
			<em>这是用于展示的默认相册，如果你没有选择任何相册，那么图片将会被归档至此.</em>
		</div>
	</figure>
	<figure class="album">
		<img src="${ project.staticDomain! }/${ project.name! }/images/1.jpg">
		<figcaption>默认相册</figcaption>
		<div>
			<em>这是用于展示的默认相册，如果你没有选择任何相册，那么图片将会被归档至此.</em>
		</div>
	</figure>
	<figure class="album">
		<img src="${ project.staticDomain! }/${ project.name! }/images/1.jpg">
		<figcaption>默认相册</figcaption>
		<div>
			<em>这是用于展示的默认相册，如果你没有选择任何相册，那么图片将会被归档至此.</em>
		</div>
	</figure>
	<figure class="album">
		<img src="${ project.staticDomain! }/${ project.name! }/images/1.jpg">
		<figcaption>默认相册</figcaption>
		<div>
			<em>这是用于展示的默认相册，如果你没有选择任何相册，那么图片将会被归档至此.</em>
		</div>
	</figure>
	
	<figure class="album">
		<img src="${ project.staticDomain! }/${ project.name! }/images/1.jpg">
		<figcaption>默认相册</figcaption>
		<div>
			<em>这是用于展示的默认相册，如果你没有选择任何相册，那么图片将会被归档至此.</em>
		</div>
	</figure>
	<span class="album justify-fix"></span>
	<span class="album justify-fix"></span>
	<span class="album justify-fix"></span>
</section>

<section class="float">
	<a class="close">Close&nbsp;[x]</a>
	<div class="gallery"></div>
</section>

<script type="text/javascript">
$(document).ready(function() {
	
	$("figure.album").click(function() {
		
		// Load the gallery images.
		$(".float .gallery").load("/album/display/1.html", function() {
		
			// Show the gallery.
			$(".float").fadeIn();
		});
		
		
	});
	
	$(".float .close").click(function() {
		$(".float").fadeOut();
	});
});
</script>