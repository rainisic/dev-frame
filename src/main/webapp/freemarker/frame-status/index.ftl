<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Framework Status | Rain Rhyme Dev Framework</title>
<style type="text/css">
html { width: 100%; height: 100%; margin: 0; padding: 0; font-family: Consolas, "Microsoft Yahei", sans-serif; text-align: center; background: linear-gradient(#ccccff, white); background: -webkit-linear-gradient(#ccccff, white); background: -moz-linear-gradient(#ccccff, white); background: -ms-linear-gradient(#ccccff, white); background: -o-linear-gradient(#ccccff, white); }
body { width: 960px; height: 100%; margin: 0 auto; padding: 0 20px; background-color: white; box-shadow: 0px 0px 20px black; }
h1 { margin: 0; padding: 10px 0; }
p { text-align: left; text-indent: 2em; }
table { width: 100%; border: 1px black solid; border-collapse: collapse; }
table caption { font-weight: bold; }
table th, table td { border: 1px black solid; padding: 5px; }
table th { background-color: #DDD; }
</style>
</head>
<body>
	<#if status?exists>
		<h1>Congratulations!</h1>
		<p>当您看到这个页面时，证明您的基础框架已成功运行，不过您仍需确认下列参数，以保证程序执行过程中不会出现问题。</p>
		<table>
			<caption>框架及依赖参数列表</caption>
			<tr>
				<th style="width: 30%;">参数名称</th>
				<th>参数值</th>
			</tr>
			<tr>
				<td>操作系统</td>
				<td>${ status.system?default("检测操作系统失败") }</td>
			</tr>
			<tr>
				<td>JDK版本</td>
				<td>${ status.jdk?default("未检测到JDK") }</td>
			</tr>
		</table>
	<#else>
		<h1>Error!</h1>
		<p>系统自检失败,请手动检查各项配置是否成功.</p>
	</#if>
</body>
</html>