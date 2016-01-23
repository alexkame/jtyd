<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>推广设置管理</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	$(document).ready(function() {
		
	});
	function page(n, s) {
		$("#pageNo").val(n);
		$("#pageSize").val(s);
		$("#searchForm").submit();
		return false;
	}
	function selectArticle(){
		var weixinCode = $('input[name="weixinUser"]:checked ').val();
		var url = "${ctx}/weixin/jtydSendTasks/getArticleList?weixinCode="+weixinCode+"&rp="+new Date().getTime();
		$("#articleList").load(url,function(){
		
		});
	}
</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/weixin/jtydSendTasks/showConfigs">第一步：选择推广的文章</a></li>
		<li><a href="${ctx}/weixin/jtydSendTasks/getPlatformlist">第二步：选择目标平台</a></li>
		<li  class="active"><a href="${ctx}/weixin/jtydSendTasks/getSendRatelist">第三步：配置发送频率</a></li>
		<li><a href="${ctx}/weixin/jtydSendTasks/getSendTask">第四步：生成任务</a></li>
	</ul>
	已选择的文章是：${weixinArticleName }<br/>
	已选择的选择目标平台是：${jtydPlatformName }<br/>
	已选择的择粉丝特征是：${fansKeywordsName }<br/>
	

	<form:form id="searchForm" modelAttribute="jtydSendTasks"
		action="${ctx}/weixin/jtydSendTasks/" method="post"
		class="breadcrumb form-search">
		<ul class="ul-form">
			<li><label>发送频率：</label>
			        <c:forEach items="${jtydSendRatelist}" var="jtydSendRate">
						<input type="radio" name="jtydSend" value="${jtydSendRate.keywordsDesc}" />${jtydSendRate.keywordsDesc}
		  			 </c:forEach>
			</li>
		</ul>
	</form:form>
	

   
 <center>
<a href="${ctx}/weixin/jtydSendTasks/getPlatformlist"> <input id="btnSubmit" class="btn btn-primary" type="button" value="上一步"/></a>
<a href="${ctx}/weixin/jtydSendTasks/getSendTask"> <input id="btnSubmit" class="btn btn-primary" type="button" value="下一步"/></a>
 </center>
</body>
</html>