<link rel="stylesheet" type="text/css" href="${ project.staticDomain! }/${ project.name! }/css/album-list.css">
<section class="content">
	<h1>相册列表</h1>
	<hr>
	<#list albums as album>
		<figure id="${ album.id }" class="album">
			<img src="${ uploadLocation! }/${ (album.cover.path)!"default-cover.jpg" }">
			<figcaption>${ album.name! }</figcaption>
			<div>
				<em>${ album.description! }</em>
			</div>
		</figure>
	</#list>
	<span class="album justify-fix"></span>
	<span class="album justify-fix"></span>
	<span class="album justify-fix"></span>
</section>

<section class="float">
	<a class="close">Close&nbsp;[x]</a>
	<div class="gallery"></div>
</section>

<script type="text/javascript" src="${ project.staticDomain! }/common/js/jquery-blockui/jquery.blockUI.js"></script>
<script type="text/javascript" src="${ project.staticDomain! }/${ project.name! }/js/album.js"></script>