<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ pageTitle!"Dev Frame" } | ${ project.title!"Rain Rhyme Internet Studio" }</title>
<style type="text/css">
html, body { margin: 0; padding: 0; font-size: 13px; font-family: "Microsoft Yahei", Sans, Sans-Serif; }
form { position: absolute; }
</style>
</head>
<body>
	<#if result?? && result == "failure">
		<p style="color: red;">用户名或密码错误！</p>
	</#if>
	<form action="/validate.html" method="post">
		<p>
			<label>用户名：</label>
			<input id="username" name="username" type="text" autofocus required>
		</p>
		<p>
			<label>密码：</label>
			<input id="password" name="password" type="password" autofocus required>
		</p>
		<p>
			<input id="submit" type="submit" value="登录">
			<input id="reset" type="reset" value="重置">
		</p>
	</form>
</body>
</html>