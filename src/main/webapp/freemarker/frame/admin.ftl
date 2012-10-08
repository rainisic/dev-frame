<#assign tiles=JspTaglibs["http://tiles.apache.org/tags-tiles"]>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>${ pageTitle!"Dev Frame" } | ${ project.title!"Rain Rhyme Internet Studio" }</title>
<style type="text/css">
html, body { margin: 0; padding: 0; font-size: 13px; font-family: "Microsoft Yahei", Sans, Sans-Serif; background-color: #DFE8F6; }
a { text-decoration: none; color: black; border: none; }
h1 { font-family: "宋体"; letter-spacing: 0.2em; }
table { border-collapse: collapse; }
.no-content { text-align: center; margin: 50px 0; }
body > header { position: fixed; top: 5px; right: 5px; left: 5px; height: 60px; line-height: 60px; }
body > header h1 { margin: 0; margin-left: 10px; }
body > nav { position: fixed; top: 65px; bottom: 25px; left: 5px; width: 200px; background-color: white; border: 1px #99BCE8 solid; }
body > nav a { display: block; height: 30px; line-height: 30px; text-align: center; margin: 3px; letter-spacing: 0.5em; }
body > nav a.active { background-color: #DFE8F6; border: 1px #A3BAE9 dotted; font-weight: bold; }
body > section { position: fixed; top: 65px; right: 5px; bottom: 25px; left: 210px; background-color: white; border: 1px #99BCE8 solid; padding: 10px; }
body > footer { position: fixed; right: 5px; bottom: 0px; left: 5px; height: 25px; font-size: 10px; text-align: center; line-height: 25px; }
</style>
<link rel="stylesheet" type="text/css" href="${ project.staticDomain! }/common/js/jquery/jquery-ui.css">
<script type="text/javascript" src="${ project.staticDomain! }/common/js/jquery/jquery.js"></script>
<script type="text/javascript" src="${ project.staticDomain! }/common/js/jquery/jquery-ui.js"></script>
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