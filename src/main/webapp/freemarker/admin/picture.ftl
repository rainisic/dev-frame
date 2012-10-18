<link rel="stylesheet" type="text/css" href="${ project.staticDomain! }/${ project.name! }/css/admin/picture.css">
<div class="operation">
	<button id="create">添加照片</button>
</div>
<#if pictures?? && pictures?size gt 0>
	<ul id="${ album }">
		<#list pictures as picture>
			<li id="${ picture.id }">
				<figure>
					<img src="${ uploadLocation! }/${ (picture.path)!"default-cover.jpg" }">
					<figurecaption>${ picture.name }</figurecaption>
				</figure>
				<article>${ picture.description }</article>
				<div>
					<button class="modify">修改</button>
					<button class="set-cover">设为封面</button>
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

<div id="create-dialog" title="添加图片">
	<form id="create-form" action="/album/picture/admin/publish.html" method="post" enctype="multipart/form-data">
		<input name="album.id" type="hidden" value="${ album }">
		<p>
			<label for="upload-file">选择文件：</label>
			<input id="upload-file" name="pictureFile" type="file" accept="image/*" required>
		</p>
		<p>
			<label for="create-name">照片名称：</label>
			<input id="create-name" name="name" type="text" placeholder="请输入照片名称" maxLength="10" autofocus required>
		</p>
		<p>
			<label for="create-description">照片描述：</label>
			<textarea id="create-description" name="description" placeholder="请输入照片描述"></textarea>
		</p>
		<input id="create-submit" type="submit" style="display: none;">
	</form>
</div>

<div id="edit-dialog" title="编辑照片">
	<form id="edit-form" action="/album/picture/admin/update.html" method="post">
		<input id="edit-id" name="id" type="hidden" value="0">
		<input name="album.id" type="hidden" value="${ album }">
		<p>
			<label for="edit-name">照片名称：</label>
			<input id="edit-name" name="name" type="text" placeholder="请输入照片名称" maxLength="10" autofocus required>
		</p>
		<p>
			<label for="edit-description">照片描述：</label>
			<textarea id="edit-description" name="description" placeholder="请输入照片描述"></textarea>
		</p>
		<input id="edit-submit" type="submit" style="display: none;">
	</form>
</div>
<script type="text/javascript" src="${ project.staticDomain! }/${ project.name! }/js/admin/picture.js"></script>