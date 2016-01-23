<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>推广设置管理</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	$(document).ready(function() {
		$("input[name='weixinUser']:eq(0)").attr("checked",'checked'); 
		selectArticle();
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
	function next(){
		var weixinArticleCode = $('input[name="weixinArticle"]:checked ').val();
		var weixinArticleName = $('#'+weixinArticleCode).html();
		//alert(weixinArticleCode);
		//alert(weixinArticleName);
		if(null==weixinArticleCode||weixinArticleCode==""){
			alert("请选择文章！");
			return false;
		}
		//不知道为啥需要俩次转码
		window.location.href=encodeURI(encodeURI("${ctx}/weixin/jtydSendTasks/getPlatformlist?weixinArticleCode="+weixinArticleCode+"&weixinArticleName="+weixinArticleName));
	}
</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a>第一步：选择推广的文章</a></li>
		<li><a href="${ctx}/weixin/jtydSendTasks/getPlatformlist">第二步：选择目标平台</a></li>
		<li><a href="${ctx}/weixin/jtydSendTasks/getSendRatelist">第三步：配置发送频率</a></li>
		<li><a href="${ctx}/weixin/jtydSendTasks/getSendTask">第四步：生成任务</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="jtydSendTasks"
		action="${ctx}/weixin/jtydSendTasks/" method="post"
		class="breadcrumb form-search">
		<ul class="ul-form">
			<li><label>推广文章：</label>
					<c:forEach items="${jtydWeixinUserlist}" var="jtydWeixinUser">
						<input type="radio" onclick="selectArticle()"  name="weixinUser" value="${jtydWeixinUser.weixinCode}" />${jtydWeixinUser.weixinName}
		  			 </c:forEach>
			</li>
		</ul>
	</form:form>
	 
   <div id="articleList">
      <%-- <table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
			    <th>文章标题</th>
				<th>文章地址</th>
				<th>公众号名称</th>
				<th>公众号</th>
				<!-- <th>文章内容</th> -->
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="jtydWeixinArticle">
			<tr>
			     <td>
					<input type="radio" name="weixinArticle" value="${jtydWeixinArticle.id}" />
					<span id="${jtydWeixinArticle.id}">${jtydWeixinArticle.articleName}</span>
				</td>
				<td>
					 <c:set var="articleUrl" value="${jtydWeixinArticle.articleUrl}"></c:set>     
					 <c:choose>  
					    <c:when test="${fn:length(articleUrl) > 90}">  
					        <a href="${jtydWeixinArticle.articleUrl}" target="_blank" title="${jtydWeixinArticle.articleUrl}"><c:out value="${fn:substring(articleUrl, 0, 90)}......" />  </a>
					    </c:when>  
					   <c:otherwise>  
					      <c:out value="${articleUrl}" />  
					    </c:otherwise>  
					</c:choose> 
				</td>
				<td>
				
					${jtydWeixinArticle.weixinName}
				</td>
				<td>
					${jtydWeixinArticle.weixinCode}
				</td>
				
				<td>
					 <c:set var="articleContent" value="${jtydWeixinArticle.articleContent}"></c:set>     
					 <c:choose>  
					    <c:when test="${fn:length(articleContent) > 50}">  
					        <c:out value="${fn:substring(articleContent, 0, 50)}......" />  
					    </c:when>  
					   <c:otherwise>  
					      <c:out value="${articleContent}" />  
					    </c:otherwise>  
					</c:choose> 
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table> --%>
	</div>
 <center>
<a href="${ctx}/weixin/jtydSendTasks/showConfigs"> <input id="btnSubmit" class="btn btn-primary" type="button" value="取消"/></a>
<a onclick="next()"> <input id="btnSubmit" class="btn btn-primary" type="button" value="下一步"/></a>
 </center>
</body>
</html>