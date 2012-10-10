<link rel="stylesheet" type="text/css" href="${ project.staticDomain! }/${ project.name! }/css/admin/activity.css">
<div class="operation">
	<select id="list-status">
		<option value="/activity/admin/list.html">全部</option>
		<option value="/activity/admin/list.html?status=0" <#if status?? && status == 0>selected="selected"</#if>>未发布</option>
		<option value="/activity/admin/list.html?status=1" <#if status?? && status == 1>selected="selected"</#if>>已发布</option>
	</select>
	<button id="create">新建活动</button>
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
<div id="edit-dialog">
	<form id="edit-form" method="post">
		<input id="id" name="id" type="hidden" value="0">
		<p>
			<label for="title">文章标题：</label>
			<input id="title" name="title" type="text" placeholder="请输入活动标题" maxLength="128" autofocus required>
		</p>
		<textarea id="content" name="content" class="tinymce"></textarea>
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
				<input id="publishTime" name="publishTime" type="text" pattern="^(19|20)[0-9]{2}/[0-9]{2}/[0-9]{2}$" required>
			</span>
		</p>
		<p style="text-align: right;">
			<input id="submit" type="submit" value="保存">
			<input id="cancel" type="button" value="取消">
		</p>
	</form>
</div>
<script type="text/javascript" src="${ project.staticDomain! }/${ project.name! }/js/admin/activity.js"></script>