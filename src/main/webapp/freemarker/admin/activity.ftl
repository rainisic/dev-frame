<style type="text/css">
section.main .operation { margin-bottom: 10px; }
section.main .operation select { width: 150px; padding: 5px; border: 1px silver solid; }
section.main .operation select option { width: 100px; padding: 5px; border: 1px silver solid; }
section.main .operation button { font-size: 13px; }
section.main table { border-collapse: collapse; width: 100%; border: 1px gray solid; text-align: center; }
section.main table tr { border: 1px gray solid; }
section.main table tr:nth-child(odd) { background-color: #FFFFEE; }
section.main table tr:nth-child(even) { background-color: #EEEEFF; }
section.main table tr td, section.main table tr th { border: 1px gray solid; padding: 5px 0; }
section.main table tr td:nth-child(2) { text-align: left; padding: 5px; }
section.main table .modify, section.main table .delete { cursor: pointer; color: blue; margin: 0 10px; }
section.main table .modify:hover, section.main table .delete:hover { color: red; }
#delete-confirm { display: none; text-align: center; }
</style>
<div class="operation">
	<select id="list-status">
		<option value="/activity/admin/list.html">全部</option>
		<option value="/activity/admin/list.html?status=0" <#if status?? && status == 0>selected="selected"</#if>>未发布</option>
		<option value="/activity/admin/list.html?status=1" <#if status?? && status == 1>selected="selected"</#if>>已发布</option>
		<option value="/activity/admin/list.html?status=2" <#if status?? && status == 2>selected="selected"</#if>>已删除</option>
	</select>
	<button>Create</button>
</div>
<#if activities?? && activities?size gt 0>
	<table>
	<tr>
		<th style="width: 40px;">ID</th>
		<th>标题</th>
		<th style="width: 60px;">优先级</th>
		<th style="width: 150px;">状态</th>
		<th style="width: 200px;">发布日期</th>
		<th style="width: 100px;">操作</th>
	</tr>
		<#list activities as activity>
			<tr id="${ activity.id }">
				<td>${ activity.id }</td>
				<td>${ activity.title }</td>
				<td>${ activity.priority }</td>
				<td>${ activity.status }</td>
				<td>${ activity.publishTime?string("yyyy-MM-dd HH:mm:ss") }</td>
				<td><a class="modify">修改</a><a class="delete">删除</a></td>
			</tr>
		</#list>
	</table>
	<div id="delete-confirm" title="删除提示">
		<p>确定要删除该活动？（稍后可以从“已删除”中恢复）</p>
	</div>
<#else>
	<div class="no-content">尚无发布的主题</div>
</#if>
<script type="text/javascript" src="${ project.staticDomain! }/${ project.name! }/js/admin/activity.js"></script>