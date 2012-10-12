<link rel="stylesheet" type="text/css" href="${ project.staticDomain! }/${ project.name! }/css/admin/album.css">
<div class="operation">
	<button id="create">添加照片</button>
</div>
<#if pictures?? && pictures?size gt 0>
	<ul>
		<#list pictures as picture>
			<li>
				<figure>
					<img src="${ uploadLocation! }/${ (picture.path)!"default-cover.jpg" }">
					<figurecaption>${ picture.name }</figurecaption>
				</figure>
				<article>${ picture.description }</article>
				<div>
					<button class="modify">修改</button>
					<button class="delete">删除</button>
				</div>
			</li>
		</#list>
	</ul>
	<div id="delete-confirm" title="删除提示">
		<p>确定要删除该照片？（不可恢复）</p>
	</div>
<#else>
	<div class="no-content">尚无照片</div>
</#if>

<div id="edit-dialog" title="编辑照片">
	<form id="edit-form" method="post">
		<input id="id" name="id" type="hidden" value="0">
		<p>
			<label for="name">照片名称：</label>
			<input id="name" name="name" type="text" placeholder="请输入照片名称" maxLength="10" autofocus required>
		</p>
		<p>
			<label for="description">照片描述：</label>
			<textarea id="description" name="description" placeholder="请输入照片描述"></textarea>
		</p>
		<input id="submit" type="submit" style="display: none;">
	</form>
</div>
<script type="text/javascript" src="${ project.staticDomain! }/${ project.name! }/js/admin/album.js"></script>