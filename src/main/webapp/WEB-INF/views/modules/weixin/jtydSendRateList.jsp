<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>发送频率管理</title>
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
		<li class="active"><a href="${ctx}/weixin/jtydSendRate/">发送频率列表</a></li>
		<shiro:hasPermission name="weixin:jtydSendRate:edit"><li><a href="${ctx}/weixin/jtydSendRate/form">发送频率添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="jtydSendRate" action="${ctx}/weixin/jtydSendRate/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>描述：</label>
				<form:input path="keywordsDesc" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>描述</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="weixin:jtydSendRate:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="jtydSendRate">
			<tr>
				<td><a href="${ctx}/weixin/jtydSendRate/form?id=${jtydSendRate.id}">
					${jtydSendRate.keywordsDesc}
				</a></td>
				<td>
					<fmt:formatDate value="${jtydSendRate.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${jtydSendRate.remarks}
				</td>
				<shiro:hasPermission name="weixin:jtydSendRate:edit"><td>
    				<a href="${ctx}/weixin/jtydSendRate/form?id=${jtydSendRate.id}">修改</a>
					<a href="${ctx}/weixin/jtydSendRate/delete?id=${jtydSendRate.id}" onclick="return confirmx('确认要删除该发送频率吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>