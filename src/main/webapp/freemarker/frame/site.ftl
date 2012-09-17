<#assign tiles=JspTaglibs["http://tiles.apache.org/tags-tiles"]>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="description" content="${ seo.keywords?default("") }">
<meta name="keywords" content="${ seo.description?default("") }">
<title>${ pageTitle?default("Dev Frame") } | ${ projectName?default("Rain Rhyme Internet Studio") }</title>
<@tiles.insertAttribute name="header" />
</head>
<body>
	<@tiles.insertAttribute name="body" />
	<@tiles.insertAttribute name="footer" />
</body>
</html>