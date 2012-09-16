<style type="text/css">
.content h1 { margin: 0; padding: 10px 0; }
.content p { text-align: left; text-indent: 2em; }
.content table { width: 100%; border: 1px black solid; border-collapse: collapse; }
.content table caption { font-weight: bold; }
.content table th, table td { border: 1px black solid; padding: 5px; }
.content table th { background-color: #DDD; }
</style>
<div class="content">
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
</div>