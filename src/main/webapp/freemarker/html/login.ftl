<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ pageTitle!"Dev Frame" } | ${ project.title!"Rain Rhyme Internet Studio" }</title>
<style type="text/css">
html { margin: 0; padding: 0; font-size: 13px; font-family: "Microsoft Yahei", Sans, Sans-Serif; background-color: #FBFBFB; text-align: center; }
body { width: 342px; margin: 0 auto; margin-top: 15%; }
p.error { border: 1px #C00 solid; background-color: #FEE; padding: 10px; border-radius: 3px; }
form { margin: 0 auto; width: 300px; border: 1px silver solid; background-color: white; border-radius: 3px; box-shadow: 0px 2px 10px darkgray; padding: 20px; text-align: left; color: gray; }
form input[type="text"], form input[type="password"] { outline: 0; width: 100%; border: 1px #DDD solid; font-size: 20px; padding: 5px 0; margin: 5px 0; border-radius: 3px; background-color: #FBFBFB; box-shadow: 1px 1px 2px rgba(200, 200, 200, 0.2) inset; }
form input[type="text"]:focus, form input[type="password"]:focus { border-color: gray; }
#submit, #reset { padding: 5px 30px; border: 1px silver solid; border-radius: 3px; cursor: pointer; }
#submit:hover, #reset:hover { background-color: lightgray; }
#submit:active, #reset:active { background-color: gray; }
</style>
</head>
<body>
	<#if result?? && result == "failure">
		<p class="error">用户名或密码错误！</p>
	</#if>
	<form action="/validate.html" method="post">
		<p>
			<label>用户名</label>
			<input id="username" name="username" type="text" autofocus required>
		</p>
		<p>
			<label>密码</label>
			<input id="password" name="password" type="password" required>
		</p>
		<p style="text-align: center;">
			<input id="submit" type="submit" value="登录">
			<input id="reset" type="reset" value="重置">
		</p>
	</form>
</body>
</html>