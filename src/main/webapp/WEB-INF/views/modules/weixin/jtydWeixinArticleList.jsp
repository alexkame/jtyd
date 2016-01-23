<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>微信文章管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/weixin/jtydWeixinArticle/">微信文章列表</a></li>
		<shiro:hasPermission name="weixin:jtydWeixinArticle:edit"><li><a href="${ctx}/weixin/jtydWeixinArticle/form">微信文章添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="jtydWeixinArticle" action="${ctx}/weixin/jtydWeixinArticle/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>公众号名称：</label>
				<form:input path="weixinName" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>公众号：</label>
				<form:input path="weixinCode" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>文章标题：</label>
				<form:input path="articleName" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>公众号名称</th>
				<th>公众号</th>
				<th>文章标题</th>
				<th>文章地址</th>
				<th>文章内容</th>
				<th>创建时间</th>
				<th>更新者</th>
				<shiro:hasPermission name="weixin:jtydWeixinArticle:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="jtydWeixinArticle">
			<tr>
				<td><a href="${ctx}/weixin/jtydWeixinArticle/form?id=${jtydWeixinArticle.id}">
					${jtydWeixinArticle.weixinName}
				</a></td>
				<td>
					${jtydWeixinArticle.weixinCode}
				</td>
				<td>
					${jtydWeixinArticle.articleName}
				</td>
				<td>
					<%-- ${jtydWeixinArticle.articleUrl} --%>
					<%-- <a href="${ctx}/weixin/jtydWeixinArticle/redirectUrl?jtyd_userid=123&jtyd_article_id=321&jtyd_article_url=${jtydWeixinArticle.articleUrl}">跳转</a> --%>
					 <c:set var="articleUrl" value="${jtydWeixinArticle.articleUrl}"></c:set>     
					 <c:choose>  
					    <c:when test="${fn:length(articleUrl) > 50}">  
					        <a href="${jtydWeixinArticle.articleUrl}" target="_blank"><c:out value="${fn:substring(articleUrl, 0, 50)}......" />  </a>
					    </c:when>  
					   <c:otherwise>  
					        <a href="${jtydWeixinArticle.articleUrl}" target="_blank"><c:out value="${articleUrl}" /></a>
					    </c:otherwise>  
					</c:choose> 
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
				<td>
					<fmt:formatDate value="${jtydWeixinArticle.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${jtydWeixinArticle.updateBy.id}
				</td>
				<shiro:hasPermission name="weixin:jtydWeixinArticle:edit"><td>
    				<a href="${ctx}/weixin/jtydWeixinArticle/form?id=${jtydWeixinArticle.id}">修改</a>
					<a href="${ctx}/weixin/jtydWeixinArticle/delete?id=${jtydWeixinArticle.id}" onclick="return confirmx('确认要删除该微信文章吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>