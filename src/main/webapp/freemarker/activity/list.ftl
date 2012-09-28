<link rel="stylesheet" type="text/css" href="${ project.staticDomain! }/${ project.name! }/css/activity-list.css">
<section class="content">
	<h1>活动列表</h1>
	<hr>
		<#if activities?? && activities?size gt 0>
			<ul>
				<#list activities as active>
					<li>
						<time>
							<div class="yearAndMonth">${ active.publishTime?string("yyyy-MM") }</div>
							<div class="date">${ active.publishTime?string("dd") }</div>
						</time>
						<a href="/activity/display/${ active.id }.html">${ active.title }</a>
					</li>
				</#list>
			</ul>
			<div class="page">
				<#list 1..page.count as i>
					<a <#if i == page.index>class="active"<#else>href="/activity/page/${ i }.html"</#if>>${ i }</a>
				</#list>
			</div>
		<#else>
			<p class="no-content">尚无发布的主题</p>
		</#if>
</section>