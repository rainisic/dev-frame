<link rel="stylesheet" type="text/css" href="${ project.staticDomain! }/${ project.name! }/css/admin/album.css">
<div class="operation">
	<button id="create">添加相册</button>
</div>
<#if albums?? && albums?size gt 0>
	<ul>
		<#list albums as album>
			<li id="${ album.id }">
				<figure>
					<a href="/album/picture/admin/list.html?id=${ album.id }"><img src="${ uploadLocation! }/${ (album.cover.path)!"default-cover.jpg" }"></a>
					<figurecaption>${ album.name }</figurecaption>
				</figure>
				<article>${ album.description }</article>
				<#if album.id == 1>
					<div style="line-height: 200px;">系统相册无法操作</div>
				<#else>
					<div>
						<button class="modify">修改</button>
						<button class="delete">删除</button>
					</div>
				</#if>
			</li>
		</#list>
	</ul>
	<div id="delete-confirm" title="删除提示">
		<p>确定要删除该相册？（不可恢复）</p>
	</div>
<#else>
	<div class="no-content">尚无相册</div>
</#if>

<div id="edit-dialog" title="编辑相册">
	<form id="edit-form" method="post">
		<input id="id" name="id" type="hidden" value="0">
		<p>
			<label for="name">相册名称：</label>
			<input id="name" name="name" type="text" placeholder="请输入相册名称" maxLength="10" autofocus required>
		</p>
		<p>
			<label for="description">相册描述：</label>
			<textarea id="description" name="description" placeholder="请输入相册描述"></textarea>
		</p>
		<input id="submit" type="submit" style="display: none;">
	</form>
</div>
<script type="text/javascript" src="${ project.staticDomain! }/${ project.name! }/js/admin/album.js"></script>