<link rel="stylesheet" type="text/css" href="${ project.staticDomain! }/${ project.name! }/css/order.css">
<section class="content">
	<h1>新建订单</h1>
	<p class="black ml-40">订单说明：</p>
	<p class="black indent ml-40">请填写真实有效的个人信息，以保证您的订单更快速的被管理员审核通过。</p>
	<p class="black indent mb-20 ml-40">审核通过的订单，将由我处通过您的联系方式与您联系。</p>
	<form id="publishOrderForm" action="/order/publish.html" method="post">
		<h2>订单详情</h2>
		<table id="ticket-table">
			<caption></caption>
			<tr>
				<th style="width: 50%;">种类</th>
				<th style="width: 20%;">价格（元）</th>
				<th style="width: 30%">个数（张）</th>
			</tr>
			<#list tickets as ticket>
				<tr>
					<td>${ ticket.name }</td>
					<td>${ ticket.price }</td>
					<td style="background-color: #EEFFEE;"><input class="ticket-count" name="count" type="number" min="0" value="0"></td>
				</tr>
			</#list>
			<tr class="fw-bold">
				<td>合计：</td>
				<td colspan="2"><a id="totalPrice">0</a>元</td>
			</tr>
		</table>
		<h2>联系方式</h2>
		<p>
			<label for="contact"><a class="red">*&nbsp;</a>联系人：</label>
			<input id="contact" name="contact" type="text">
		</p>
		<p>
			<label for="phone"><a class="red">*&nbsp;</a>联系电话：</label>
			<input id="phone" name="phone" type="text">
		</p>
		<p>
			<label for="email">邮箱：</label>
			<input id="email" name="email" type="text">
		</p>
		<p>
			<label for="qq">QQ：</label>
			<input id="qq" name="qq" type="text">
		</p>
		<p>
			<label for="remark" class="va-top">备注：</label>
			<textarea id="remark" name="remark"></textarea>
		</p>
		<p style="text-align: center;">
			<input class="go-button" type="submit" value="提交订单">
			<input class="go-button" type="reset" value="重新填写">
		</p>
	</form>
</section>
<div class="hint">
	<h1></h1>
</div>
<script type="text/javascript" src="${ project.staticDomain! }/common/js/jquery-form/jquery.form.js"></script>
<script type="text/javascript" src="${ project.staticDomain! }/common/js/jquery-blockui/jquery.blockUI.js"></script>
<script type="text/javascript" src="${ project.staticDomain! }/${ project.name! }/js/order-create.js">
</script>