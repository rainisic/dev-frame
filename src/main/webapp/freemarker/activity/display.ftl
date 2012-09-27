<link rel="stylesheet" type="text/css" href="${ project.staticDomain! }/${ project.name! }/css/activity-display.css">
<style type="text/css">
.text p { text-indent: 2em; }
</style>
<section class="content">
	<p class="breadcrumb-list"><a href="/index.html">首页</a>&nbsp;›&nbsp;<a href="/activity/page/1.html">活动详情</a>&nbsp;›&nbsp;${ activity.title }</p>
	<header>
		<h1>${ activity.title }</h1>
		<time>
			<div class="yearAndMonth">${ activity.publishTime?string("yyyy-MM") }</div>
			<div class="date">${ activity.publishTime?string("dd") }</div>
		</time>
	</header>
	<section class="text">${ activity.content }</section>
</section>