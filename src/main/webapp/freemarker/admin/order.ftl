<link rel="stylesheet" type="text/css" href="${ project.staticDomain! }/${ project.name! }/css/admin/order.css">
<#if orders?? && orders?size gt 0>
	<table class="content-list">
		<tr>
			<th style="width: 40px;">ID</th>
			<th style="width: 80px;">联系人</th>
			<th style="width: 100px;">联系电话</th>
			<th style="width: 200px;">E-mail</th>
			<th style="width: 100px;">QQ</th>
			<th>订票内容</th>
			<th>备注</th>
			<th style="width: 200px;">提交时间</th>
			<th style="width: 50px;">操作</th>
		</tr>
		<#list orders as order>
			<tr id="${ order.id }">
				<td>${ order.id }</td>
				<td>${ order.contact }</td>
				<td>${ order.phone }</td>
				<td>${ order.email }</td>
				<td>${ order.qq }</td>
				<td>${ order.ticketInfo }</td>
				<td>${ order.remark }</td>
				<td>${ order.createTime?string("yyyy-MM-dd HH:mm:ss") }</td>
				<td><a class="delete">删除</a></td>
			</tr>
		</#list>
	</table>
	<div id="delete-confirm" title="删除提示">
		<p>确定要删除该订单？（不可恢复）</p>
	</div>
<#else>
	<div class="no-content">尚无提交的订单</div>
</#if>
<script type="text/javascript" src="${ project.staticDomain! }/${ project.name! }/js/admin/order.js"></script>