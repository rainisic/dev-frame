<#assign tiles=JspTaglibs["http://tiles.apache.org/tags-tiles"]>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>${ pageTitle!"Dev Frame" } | ${ project.title!"Rain Rhyme Internet Studio" }</title>
<link rel="stylesheet" type="text/css" href="${ project.staticDomain! }/${ project.name! }/css/admin/common.css">
<link rel="stylesheet" type="text/css" href="${ project.staticDomain! }/common/js/jquery/jquery-ui.css">
<script type="text/javascript" src="${ project.staticDomain! }/common/js/jquery/jquery.js"></script>
<script type="text/javascript" src="${ project.staticDomain! }/common/js/jquery/jquery-ui.js"></script>
<script type="text/javascript" src="${ project.staticDomain! }/common/js/tiny_mce/jquery.tinymce.js"></script>
</head>
<body>
	<header>
		<h1>${ project.title!"Rain Rhyme Internet Studio" }内部系统</h1>
	</header>
	<nav>
		<a <#if forum?? && forum == "admin" >class="active"<#else>href="/admin/index.html"</#if>>首页</a>
		<a <#if forum?? && forum == "activity" >class="active"<#else>href="/activity/admin/list.html"</#if>>活动详情</a>
		<a <#if forum?? && forum == "album" >class="active"<#else>href="/album/admin/list.html"</#if>>漂流风采</a>
		<a <#if forum?? && forum == "ticket" >class="active"<#else>href="/ticket/admin/list.html"</#if>>门票管理</a>
		<a <#if forum?? && forum == "order" >class="active"<#else>href="/order/admin/list.html"</#if>>订单管理</a>
	</nav>
	<section class="main">
		<@tiles.insertAttribute name="body" />
	</section>
	<footer>Copyright © 2012 by <a href="http://www.rainisic.com/rain-rhyme-internet-studio/">Rain Rhyme Internet Studio</a>. All rights reserved.</footer>
</body>
</html>