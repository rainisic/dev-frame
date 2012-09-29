<#if pictures?? && pictures?size gt 0>
	<figure id="galleria">
		<#list pictures as picture >
			<img data-title="图片：${ picture.name! }" data-description="描述：${ picture.description! }" src="${ uploadLocation! }/${ picture.path! }">
		</#list>
	</figure>
	<script src="${ project.staticDomain! }/common/js/galleria/galleria-1.2.8.min.js"></script>
	<script>
	// Set galleria height.
	$("#galleria").css("height", $(window).height());
	
	// Load the classic theme
	Galleria.loadTheme("${ project.staticDomain! }/common/js/galleria/galleria.classic.min.js");
	
	// Initialize Galleria
	Galleria.run("#galleria");
	</script>
<#else>
	<div style="font-size: 36px; text-align: center; margin-top: 100px; color: white; ">这个相册里还没有图片</div>
</#if>
