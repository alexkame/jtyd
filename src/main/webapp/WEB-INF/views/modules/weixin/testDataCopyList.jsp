<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>我的页面管理</title>
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
		<li class="active"><a href="${ctx}/weixin/testDataCopy/">微信账号列表</a></li>
		<shiro:hasPermission name="weixin:testDataCopy:edit"><li><a href="${ctx}/weixin/testDataCopy/form">微信账号添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="testDataCopy" action="${ctx}/weixin/testDataCopy/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>公众号名称：</label>
				<form:input path="weixinName" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>公众号：</label>
				<form:input path="weixinCode" htmlEscape="false" maxlength="64" class="input-medium"/>
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
				<th>描述</th>
				<th>创建者</th>
				<th>创建时间</th>
				<shiro:hasPermission name="weixin:testDataCopy:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="testDataCopy">
			<tr>
				<td><a href="${ctx}/weixin/testDataCopy/form?id=${testDataCopy.id}">
					${testDataCopy.weixinName}
				</a></td>
				<td>
					${testDataCopy.weixinCode}
				</td>
				<td>
					${testDataCopy.weixinDesc}
				</td>
				<td>
					${testDataCopy.createBy.id}
				</td>
				<td>
					<fmt:formatDate value="${testDataCopy.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="weixin:testDataCopy:edit"><td>
    				<a href="${ctx}/weixin/testDataCopy/form?id=${testDataCopy.id}">修改</a>
					<a href="${ctx}/weixin/testDataCopy/delete?id=${testDataCopy.id}" onclick="return confirmx('确认要删除该我的页面吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>