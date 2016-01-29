<%@ page contentType="text/html;charset=UTF-8"%>
 
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE html>
<html>
<head>
	<title><sitemesh:title default="欢迎光临"/> - ${site.title}</title>
	
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
	 
	           <a href="">
					<img src="${pageContext.request.contextPath}/static/index/img/logo.png">
				</a>   
	                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
					  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
					  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<ul id="nav-ul">
			 
					
				 
				<a href="">
					<li>文章阅读</li>
				</a>
				<a href="">
					<li>使用申请</li>
				</a>
				<a href="">
					<li>关于我们</li>
				</a>
				<a href="${pageContext.request.contextPath}/a">
					<li>管理登录

					
					</li>
				</a>
			</ul>
		</nav>
							<!-- JiaThis Button BEGIN -->
<div id="ckepop">
<span class="jiathis_txt">分享到：</span>
<a class="jiathis_button_tsina">新浪微博</a>
<a href="http://www.jiathis.com/share" class="jiathis jiathis_txt jiathis_separator jtico jtico_jiathis" target="_blank">更多</a>
<a class="jiathis_counter_style"></a>
</div>
<script type="text/javascript" src="http://v2.jiathis.com/code/jia.js" charset="utf-8"></script>
<!-- JiaThis Button END -->
		<main id="index-main">
			<img src="${pageContext.request.contextPath}/static/index/img/show-1.png" />
			<section style="height: 430px;"  class="module dark">
				
				<div class="left">
					<h2>企业数据服务</h2>
					<p>数据个性化定制</p>
					<p>提供大数据平台</p>
					<p>实时计算</p>
					 
				</div>
				<div class="right">
					<img src="${pageContext.request.contextPath}/static/index/img/module1.png" />
				</div>
			</section>

			<section style="height: 430px;"  class="module light">
			<br/><br/>
				<div class="right">
					<h2>推送平台</h2>
					<p>微信</p>
					<p>微博</p>
					<p>知乎</p>
					 
				</div>
				<div class="left">
					<img src="${pageContext.request.contextPath}/static/index/img/module1.png" />
				</div>
			</section>

			<section style="height: 430px;"  class="module dark">
			<br/><br/>
				<div class="left">
					<h2>合作伙伴</h2>
					<p>京东商城</p>
					<p>天猫</p>
					<p>招商网</p>
					<p>县域经济论坛</p>
				</div>
				<div class="right">
					<img src="${pageContext.request.contextPath}/static/index/img/module1.png" />
				</div>
			</section>
		</main>
		<footer>
		 	<p>关于我们&nbsp;|&nbsp;联系我们&nbsp;|&nbsp;营销中心&nbsp;|&nbsp;友情链接&nbsp;|&nbsp;销售联盟 </p> 
			<p>©2015 www.wmjtyd.com 版权所有     京ICP备15057593号-1</p>	 
		</footer>	
</body>
</html>