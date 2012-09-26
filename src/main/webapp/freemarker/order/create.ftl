<link rel="stylesheet" type="text/css" href="${ project.staticDomain! }/${ project.name! }/css/order.css">
<section class="content">
	<h1>新建订单</h1>
	<form action="" method="post">
		<p class="gray">订单说明：</p>
		<p class="gray indent">请填写真实有效的个人信息，以保证您的订单更快速的被管理员审核通过。</p>
		<p class="gray indent mb-20">审核通过的订单，将由我处通过您的联系方式与您联系。</p>
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