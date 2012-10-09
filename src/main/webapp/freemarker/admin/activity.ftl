<style type="text/css">
section.main .operation { margin-bottom: 10px; }
section.main .operation select { width: 150px; padding: 5px; border: 1px silver solid; }
section.main .operation select option { width: 100px; padding: 5px; border: 1px silver solid; }
section.main .operation button { font-size: 13px; }
section.main table.content-list { border-collapse: collapse; width: 100%; border: 1px gray solid; text-align: center; }
section.main table.content-list tr { border: 1px gray solid; }
section.main table.content-list tr:nth-child(odd) { background-color: #FFFFEE; }
section.main table.content-list tr:nth-child(even) { background-color: #EEEEFF; }
section.main table.content-list tr td, section.main table tr th { border: 1px gray solid; padding: 5px 0; }
section.main table.content-list tr td:nth-child(2) { text-align: left; padding: 5px; }
section.main table.content-list .modify, section.main table .delete { cursor: pointer; color: blue; margin: 0 10px; }
section.main table.content-list .modify:hover, section.main table .delete:hover { color: red; }
#delete-confirm { display: none; text-align: center; }
#edit-activity { position: fixed; left: 100%; height: 500px; width: 1000px; background-color: white; border: 1px black solid; padding: 20px; }
#edit-activity p span { margin: 0 20px; }
#edit-activity p input { border: 1px silver solid; padding: 5px; }
#edit-activity p input[type=text] { width: 500px; }
#edit-activity p #publishTime, #edit-activity input[type=number] { width: 150px; }
#edit-activity p select { width: 150px; border: 1px silver solid; padding: 5px; }
#edit-activity p input[type=button], #edit-activity p input[type=submit] { width: 80px; background: -webkit-linear-gradient(lightgray 0%,  silver 50%); border-radius: 3px; margin: 5px; }
#edit-activity p input[type=button]:hover, #edit-activity p input[type=submit]:hover { background: -webkit-linear-gradient(silver 0%,  darkgray 50%); }
#edit-activity p input[type=button]:active, #edit-activity p input[type=submit]:active { background: -webkit-linear-gradient(darkgray 0%,  silver 50%); }
#edit-activity textarea { width: 100%; height: 330px; }
#cover { display: none; position: fixed; top: 0; right: 0; bottom: 0; left: 0; background: rgba(0, 0, 0, 0.6); }
</style>
<div class="operation">
	<select id="list-status">
		<option value="/activity/admin/list.html">全部</option>
		<option value="/activity/admin/list.html?status=0" <#if status?? && status == 0>selected="selected"</#if>>未发布</option>
		<option value="/activity/admin/list.html?status=1" <#if status?? && status == 1>selected="selected"</#if>>已发布</option>
	</select>
	<button id="create-activity">新建活动</button>
</div>
<#if activities?? && activities?size gt 0>
	<table class="content-list">
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
				<td><#escape x as x?html>${ activity.title }</#escape></td>
				<td>${ activity.priority }</td>
				<td>
					<#if activity.status == "UNPUBLISHED">
					未发布
					<#elseif activity.status == "PUBLISHED">
					已发布
					</#if>
				</td>
				<td>${ activity.publishTime?string("yyyy/MM/dd") }</td>
				<td><a class="modify">修改</a><a class="delete">删除</a></td>
			</tr>
		</#list>
	</table>
	<div id="delete-confirm" title="删除提示">
		<p>确定要删除该活动？（不可恢复）</p>
	</div>
<#else>
	<div class="no-content">尚无发布的主题</div>
</#if>

<div id="cover"></div>
<div id="edit-activity">
	<form id="edit-activity-form" method="post">
		<p>
			<label for="title">文章标题：</label>
			<input id="title" name="title" type="text" placeholder="请输入活动标题" maxLength="128" autofocus required>
		</p>
		<textarea name="content" class="tinymce"></textarea>
		<p>
			<span>
				<label for="priority">显示级别：</label>
				<input id="priority" name="priority" type="number" value="0" min="0" max="100">
			</span>
			<span>
				<label for="title">文章状态：</label>
				<select id="status" name="status">
					<option value="UNPUBLISHED">未发布</option>
					<option value="PUBLISHED" selected="selected">已发布</option>
				</select>
			</span>
			<span>
				<label for="publishTime">发布日期：</label>
				<input id="publishTime" name="publishTime" type="text" readonly required>
			</span>
		</p>
		<p style="text-align: right;">
			<input id="submit" type="submit" value="保存">
			<input id="cancel" type="button" value="取消">
		</p>
	</form>
</div>
<script type="text/javascript" src="${ project.staticDomain! }/${ project.name! }/js/admin/activity.js"></script>