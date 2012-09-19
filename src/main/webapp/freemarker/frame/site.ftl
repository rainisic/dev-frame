<#assign tiles=JspTaglibs["http://tiles.apache.org/tags-tiles"]>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="description" content="${ seo.keywords! }">
<meta name="keywords" content="${ seo.description! }">
<title>${ pageTitle!"Dev Frame" } | ${ projectName!"Rain Rhyme Internet Studio" }</title>
<@tiles.insertAttribute name="header" />
</head>
<body>
	<div class="limit">
		<header class="site-header">
			<div class="logo"></div>
			<nav class="navigator">
				<ul>
					<li><a class="active">首页</a></li>
					<li><a href="#">白河漂流</a></li>
					<li><a href="#">活动详情</a></li>
					<li><a href="#">预约订票</a></li>
					<li><a href="#">如何前往</a></li>
					<li><a href="#">关于我们</a></li>
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