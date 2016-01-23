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
		<li class="active"><a href="${ctx}/weixin/jtydWeixinUser/">微信公众号列表</a></li>
		<shiro:hasPermission name="weixin:jtydWeixinUser:edit"><li><a href="${ctx}/weixin/jtydWeixinUser/form">公众号添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="jtydWeixinUser" action="${ctx}/weixin/jtydWeixinUser/" method="post" class="breadcrumb form-search">
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
				<th>更新时间</th>
				<shiro:hasPermission name="weixin:jtydWeixinUser:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="jtydWeixinUser">
			<tr>
				<td><a href="${ctx}/weixin/jtydWeixinUser/form?id=${jtydWeixinUser.id}">
					${jtydWeixinUser.weixinName}
				</a></td>
				<td>
					${jtydWeixinUser.weixinCode}
				</td>
				<td>
					${jtydWeixinUser.weixinDesc}
				</td>
				<td>
					${jtydWeixinUser.createBy.id}
				</td>
				<td>
					<fmt:formatDate value="${jtydWeixinUser.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="weixin:jtydWeixinUser:edit"><td>
    				<a href="${ctx}/weixin/jtydWeixinUser/form?id=${jtydWeixinUser.id}">修改</a>
					<a href="${ctx}/weixin/jtydWeixinUser/delete?id=${jtydWeixinUser.id}" onclick="return confirmx('确认要删除该微信文章吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>