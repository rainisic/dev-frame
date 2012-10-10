<link rel="stylesheet" type="text/css" href="${ project.staticDomain! }/${ project.name! }/css/admin/ticket.css">
<div class="operation">
	<button id="create">添加门票</button>
</div>
<#if tickets?? && tickets?size gt 0>
	<table class="content-list">
		<tr>
			<th style="width: 40px;">ID</th>
			<th>门票</th>
			<th style="width: 200px;">价格</th>
			<th style="width: 200px;">操作</th>
		</tr>
		<#list tickets as ticket>
			<tr id="${ ticket.id }">
				<td>${ ticket.id }</td>
				<td>${ ticket.name }</td>
				<td>${ ticket.price }</td>
				<td><a class="modify">修改</a><a class="delete">删除</a></td>
			</tr>
		</#list>
	</table>
	<div id="delete-confirm" title="删除提示">
		<p>确定要删除该门票？（不可恢复）</p>
	</div>
<#else>
	<div class="no-content">尚无销售的门票</div>
</#if>

<div id="edit-dialog" title="编辑门票">
	<form id="edit-form" method="post">
		<input id="id" name="id" type="hidden" value="0">
		<p>
			<label for="name">门票名称：</label>
			<input id="name" name="name" type="text" placeholder="请输入门票名称" maxLength="255" autofocus required>
		</p>
		<p>
			<label for="price">门票价格：</label>
			<input id="price" name="price" type="number" placeholder="请输入门票价格" min="0" max="32768" required>
		</p>
		<input id="submit" type="submit" style="display: none;">
	</form>
</div>
<script type="text/javascript" src="${ project.staticDomain! }/${ project.name! }/js/admin/ticket.js"></script>