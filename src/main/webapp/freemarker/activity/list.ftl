<link rel="stylesheet" type="text/css" href="${ project.staticDomain! }/${ project.name! }/css/activity-list.css">
<section class="content">
	<h1>活动列表</h1>
	<hr>
	<ul>
		<#list activities as active>
			<li>
				<time>
					<div class="yearAndMonth">2012.8</div>
					<div class="date">6</div>
				</time>
				<a href="/activity/display/1.html">这是一个新的活动内容这是一个新的活动内容这是一个新的活动内容</a>
			</li>
		</#list>
	</ul>
	<div class="page"><a class="active">1</a><a href="#">2</a><a href="#">3</a><a href="#">4</a><a href="#">5</a></div>
</section>