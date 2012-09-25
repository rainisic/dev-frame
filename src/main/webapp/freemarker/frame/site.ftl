<#assign tiles=JspTaglibs["http://tiles.apache.org/tags-tiles"]>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="description" content="${ seo.keywords! }">
<meta name="keywords" content="${ seo.description! }">
<title>${ pageTitle!"Dev Frame" } | ${ project.title!"Rain Rhyme Internet Studio" }</title>
<@tiles.insertAttribute name="header" />
</head>
<body>
	<div class="limit">
		<header class="site-header">
			<div class="logo"></div>
			<nav class="navigator">
				<ul>
					<li><a <#if forum?? && forum == "index.html" >class="active"<#else>href="/index.html"</#if>>首页</a></li>
					<li><a <#if forum?? && forum == "introduction.html" >class="active"<#else>href="/introduction.html"</#if>>白河漂流</a></li>
					<li><a <#if forum?? && forum == "album" >class="active"<#else>href="/album/list.html"</#if>>漂流风采</a></li>
					<li><a <#if forum?? && forum == "activity" >class="active"<#else>href="/activity/page/1.html"</#if>>活动详情</a></li>
					<li><a <#if forum?? && forum == "order" >class="active"<#else>href="/order/create.html"</#if>>预约订票</a></li>
					<li><a <#if forum?? && forum == "direction.html" >class="active"<#else>href="/direction.html"</#if>>如何前往</a></li>
					<li><a <#if forum?? && forum == "about.html" >class="active"<#else>href="/about.html"</#if>>关于我们</a></li>
				</ul>
			</nav>
		</header>
		<section class="main-section">
			<@tiles.insertAttribute name="body" />
			<@tiles.insertAttribute name="footer" />
		</section>
	</div>
</body>
</html>