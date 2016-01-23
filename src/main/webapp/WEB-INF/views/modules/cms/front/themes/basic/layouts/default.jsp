<%@ page contentType="text/html;charset=UTF-8"%>
 
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE html>
<html>
<head>
	<title><sitemesh:title default="欢迎光临"/> - ${site.title} - Powered By JeeSite</title>
	
	<!-- Baidu tongji analytics --><script>var _hmt=_hmt||[];(function(){var hm=document.createElement("script");hm.src="//hm.baidu.com/hm.js?82116c626a8d504a5c0675073362ef6f";var s=document.getElementsByTagName("script")[0];s.parentNode.insertBefore(hm,s);})();</script>
	<sitemesh:head/>
	
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/index/css/style.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/index/css/flexslider.css" />
		<script src="${pageContext.request.contextPath}/static/index/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/index/js/jquery.mmenu.min.all.js"></script>
		<script src="${pageContext.request.contextPath}/static/index/js/jquery.flexslider.js"></script>
		<script src="${pageContext.request.contextPath}/static/index/js/o-script.js"></script>
</head>
<body>
	<nav>
			<a href=""><img src="${pageContext.request.contextPath}/static/index/img/logo2.png"></a>
			<ul id="nav-ul">
				<a href="">
					<li>服务中心</li>
				</a>
				<a href="">
					<li>文章阅读</li>
				</a>
				<a href="">
					<li>帐号排行</li>
				</a>
				<a href="">
					<li>客户端</li>
				</a>
				<a href="">
					<li>关于我们</li>
				</a>
			</ul>
		</nav>
		<main id="index-main">
			<!-- 图片播放功能 -->
			<section id="picture">
				<div class="bannerPane">
					<section class="slider">
						<div class="flexslider">
							<ul class="slides">
								<li>
									<a href="javascript:;"></a><img src="${pageContext.request.contextPath}/static/index/img/show-1.png" /></a>
								</li>
								<li>
									<a href="javascript:;"></a><img src="${pageContext.request.contextPath}/static/index/img/show-2.png" /></a>
								</li>
								<li>
									<a href="javascript:;"></a><img src="${pageContext.request.contextPath}/static/index/img/show-3.png" /></a>
								</li>
								<li>
									<a href="javascript:;"></a><img src="${pageContext.request.contextPath}/static/index/img/show-4.png" /></a>
								</li>
							</ul>
						</div>
					</section>
				</div>
				<div>
					<button class="button" id="download">立即下载</button>
					<button class="button">管理平台</button>
				</div>
			</section>
			<section class="module dark">
				<div class="left">
					<h2>编辑器</h2>
					<p>支持多账号、多平台管理</p>
					<p>丰富的样式选择，也可编写个性化脚本</p>
					<p>文章素材可灵活的组合和推送</p>
					<p>
						<button class="button">管理平台</button>
					</p>
				</div>
				<div class="right">
					<img src="${pageContext.request.contextPath}/static/index/img/module1.png" />
				</div>
			</section>

			<section class="module light">
				<div class="right">
					<h2>微站</h2>
					<p>精选历史文章展示</p>
					<p>帐号间的推荐传播</p>
					<p>新业务的入口</p>
					<p>
						<button class="button">管理平台</button>
					</p>
				</div>
				<div class="left">
					<img src="${pageContext.request.contextPath}/static/index/img/module1.png" />
				</div>
			</section>

			<section class="module dark">
				<div class="left">
					<h2>开发模式</h2>
					<p>任意搜索历史文章</p>
					<p>自动匹配发布日期</p>
					<p>
						<button class="button">管理平台</button>
					</p>
				</div>
				<div class="right">
					<img src="${pageContext.request.contextPath}/static/index/img/module1.png" />
				</div>
			</section>
		</main>
		<footer>
			<p>友情链接： 微信客户端 微信电脑版 微信文章 微信表情 微信电脑客户端 就要阿里云 aicpa 微信公众平台导航 微信开店货源 微信电脑版 </p>
			<p>微信网 微信公众平台 微信导航 手机软件开发 爱趣味 美丽家装修一道自媒体平台</p>
			<p>©2014 aiweibang.com 版权所有     京ICP备14055170号-2    京公网安备11010502024234</p>
		</footer>	
</body>
</html>