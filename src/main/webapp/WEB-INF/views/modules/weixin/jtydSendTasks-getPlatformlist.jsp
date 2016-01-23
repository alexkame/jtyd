<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>推广设置管理</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	$(document).ready(function() {
		//$("input[name='jtydPlatform']:eq(0)").attr("checked",'checked'); 
	});
	 
	function selectJtydPlatform(){
		var jtydPlatform = $('input[name="jtydPlatform"]:checked ').val();
		var url = "${ctx}/weixin/jtydSendTasks/getArticleList?weixinCode="+weixinCode+"&rp="+new Date().getTime();
		$("#articleList").load(url,function(){
		
		});
	}
	//selectFansKeywords
	function next(){
		var jtydPlatformCode = $('input[name="jtydPlatform"]:checked ').val();
		var jtydPlatformName = $('#jp'+jtydPlatformCode).html();
		
		var fansKeywordsCode = $('input[name="fansKeywords"]:checked ').val();
		var fansKeywordsName = $('#fk'+fansKeywordsCode).html();
		
		var weixinArticleCode =$("#weixinArticleCode").val();
		var weixinArticleName =$("#weixinArticleName").html();
		//alert(jtydPlatformCode+"="+jtydPlatformName);
		//alert(fansKeywordsCode+"="+fansKeywordsName);
		 
		if(null==jtydPlatformCode||jtydPlatformCode==""){
			alert("请选择平台！");
			return false;
		}
		if(null==fansKeywordsCode||fansKeywordsCode==""){
			alert("请选择粉丝特征！");
			return false;
		}
		/* var url = encodeURI(encodeURI("${ctx}/weixin/jtydSendTasks/getSendRatelist?weixinArticleCode="
				+$("#weixinArticleCode").val() +"&weixinArticleName="+$("#weixinArticleName").val()
				+"&jtydPlatformCode="+jtydPlatformCode
				+"&jtydPlatformName="+jtydPlatformName
				+"&fansKeywordsCode="+fansKeywordsCode
				+"&fansKeywordsName="+fansKeywordsName));
		$.post(url,function(){
		
		}); */
		
		alert(encodeURI(encodeURI("${ctx}/weixin/jtydSendTasks/getSendRatelist?weixinArticleCode="
				+weixinArticleCode 
				+"&weixinArticleName="+weixinArticleName 
				+"&jtydPlatformCode="+jtydPlatformCode
				+"&jtydPlatformName="+jtydPlatformName
				+"&fansKeywordsCode="+fansKeywordsCode
				+"&fansKeywordsName="+fansKeywordsName)));
		//不知道为啥需要俩次转码
		  window.location.href=encodeURI(encodeURI("${ctx}/weixin/jtydSendTasks/getSendRatelist?weixinArticleCode="
				+weixinArticleCode 
				+"&weixinArticleName="+weixinArticleName 
				+"&jtydPlatformCode="+jtydPlatformCode
				+"&jtydPlatformName="+jtydPlatformName
				+"&fansKeywordsCode="+fansKeywordsCode
				+"&fansKeywordsName="+fansKeywordsName));  
	}
</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/weixin/jtydSendTasks/showConfigs">第一步：选择推广的文章</a></li>
		<li  class="active"><a>第二步：选择目标平台</a></li>
		<li><a href="${ctx}/weixin/jtydSendTasks/getSendRatelist">第三步：配置发送频率</a></li>
		<li><a href="${ctx}/weixin/jtydSendTasks/getSendTask">第四步：生成任务</a></li>
	</ul>
	
	已选择的文章是：<span id="weixinArticleName">${weixinArticleName }</span> <input id="weixinArticleCode" type="hidden" value="${weixinArticleCode }"/>
	<form:form id="searchForm" modelAttribute="jtydSendTasks"
		action="${ctx}/weixin/jtydSendTasks/" method="post"
		class="breadcrumb form-search">
		<ul class="ul-form">
			<li><label style="width:110px">请选择目标平台：</label>
					<c:forEach items="${jtydPlatformlist}" var="jtydPlatform">
						<input type="radio" name="jtydPlatform" value="${jtydPlatform.platformCode}" />
						<span id="jp${jtydPlatform.platformCode}">${jtydPlatform.platformName}</span>
		  			 </c:forEach>
			</li>
		</ul>
	</form:form>
	<%-- 	<form:form id="searchForm" modelAttribute="jtydSendTasks"
		action="${ctx}/weixin/jtydSendTasks/" method="post"
		class="breadcrumb form-search">
		<ul class="ul-form">
			<li><label style="width:110px">请选择登录用户：</label>
					<c:forEach items="${jtydPlatformlist}" var="jtydPlatform">
						<input type="radio" name="jtydPlatform" value="${jtydPlatform.platformCode}" />${jtydPlatform.platformName}
		  			 </c:forEach>
			</li>
		</ul>
	</form:form> --%>
    <form:form id="searchForm" modelAttribute="jtydSendTasks"
		action="${ctx}/weixin/jtydSendTasks/" method="post"
		class="breadcrumb form-search">
		<ul class="ul-form">
			<li><label style="width:110px">请选择粉丝特征：</label>
			<c:forEach items="${jtydFansKeywordslist}" var="jtydFansKeywords">
						<input type="radio" name="fansKeywords" value="${jtydFansKeywords.flag}" />
						<span id="fk${jtydFansKeywords.flag}">${jtydFansKeywords.keywords}</span>
		  			 </c:forEach>
		 	<%-- <form:select path="category" class="required input-xlarge">
					<form:options items="${jtydFansKeywordslist}" itemLabel="jtydFansKeywords.flag" itemValue="jtydFansKeywords.keywords" htmlEscape="false"/>
				</form:select>   --%>
			</li>
		</ul>
	</form:form>
 <center>
<a href="${ctx}/weixin/jtydSendTasks/showConfigs"> <input id="btnSubmit" class="btn btn-primary" type="button" value="上一步"/></a>
<a onclick="next()" > <input id="btnSubmit" class="btn btn-primary" type="button" value="下一步"/></a>
 </center>
</body>
</html>