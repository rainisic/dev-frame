<#assign tiles=JspTaglibs["http://tiles.apache.org/tags-tiles"]>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="description" content="">
<meta name="keywords" content="">
<title>${ pageTitle?default("dev-frame") } | Dev-Frame</title>
<@tiles.insertAttribute name="header" />
</head>
<body>
	<@tiles.insertAttribute name="body" />
	<@tiles.insertAttribute name="footer" />
</body>
</html>