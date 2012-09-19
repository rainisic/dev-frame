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
	<@tiles.insertAttribute name="body" />
	<@tiles.insertAttribute name="footer" />
</body>
</html>