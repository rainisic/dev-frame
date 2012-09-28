<!--[if lte IE 8]>
<script type="text/javascript" src="${ project.staticDomain! }/${ project.name! }/js/index.ie.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="${ project.staticDomain! }/${ project.name! }/css/index.css">
<section class="content">
	<div class="gallery">
		<figure>
			<a href="/album/list.html"><img src="${ project.staticDomain! }/${ project.name! }/images/1.jpg"></a>
			<a href="/album/list.html"><img src="${ project.staticDomain! }/${ project.name! }/images/2.jpg"></a>
			<a href="/album/list.html"><img src="${ project.staticDomain! }/${ project.name! }/images/3.jpg"></a>
			<a href="/album/list.html"><img src="${ project.staticDomain! }/${ project.name! }/images/4.jpg"></a>
			<a href="/album/list.html"><img src="${ project.staticDomain! }/${ project.name! }/images/5.jpg"></a>
		</figure>
		<div class="layer">
			<img class="active" src="${ project.staticDomain! }/${ project.name! }/images/1.jpg">
			<img src="${ project.staticDomain! }/${ project.name! }/images/2.jpg">
			<img src="${ project.staticDomain! }/${ project.name! }/images/3.jpg">
			<img src="${ project.staticDomain! }/${ project.name! }/images/4.jpg">
			<img src="${ project.staticDomain! }/${ project.name! }/images/5.jpg">
		</div>
	</div>
	<aside class="quicklunch">
		<p class="info">
			<em>惊险漂流，自主烧烤，真人CS…查看更多活动，请<b>猛击↓这里</b>！</em>
			<a class="go-button" href="/activity/page/1.html">活动详情</a>
		</p>
		<hr size="1px">
		<p class="order">
			<em>已经心动啦？想要提前预订您的精彩旅行生活，请<b>猛击↓这里</b>！</em>
			<a class="go-button" href="/order/create.html">立刻订票</a>
		</p>
		<hr size="1px">
		<p class="direction">
			<em>已经订票？OK，快来开始我们的快乐旅途！请最后<b>猛击↓这里</b>！</em>
			<a class="go-button" href="/direction.html">如何前往</a>
		</p>
	</aside>
	<section class="topics">
		<header><h1>最新活动</h1></header>
			<#if activities?? && activities?size gt 0>
				<ul>
					<#list activities as activity>
						<li><span class="col-80 left"><a href="/activity/display/${ activity.id }.html">${ activity.title }</a></span><span class="col-18 right">${ activity.publishTime?string("yyyy-MM-dd HH:mm:ss") }</span></li>
					</#list>
				</ul>
				<footer>«&nbsp;<a href="/activity/page/1.html">查看全部活动</a>&nbsp;»</footer>
			<#else>
				<p class="no-content">尚无发布的主题</p>
			</#if>
	</section>
</section>
<script type="text/javascript" src="${ project.staticDomain! }/${ project.name! }/js/index.js"></script>