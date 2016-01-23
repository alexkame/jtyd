<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>微薄用户管理</title>
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
		<li class="active"><a href="${ctx}/weixin/jtydWeiboUser/">微薄用户列表</a></li>
		<shiro:hasPermission name="weixin:jtydWeiboUser:edit"><li><a href="${ctx}/weixin/jtydWeiboUser/form">微薄用户添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="jtydWeiboUser" action="${ctx}/weixin/jtydWeiboUser/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>用户昵称：</label>
				<form:input path="userName" htmlEscape="false" maxlength="30" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>用户userID</th>
				<th>用户昵称</th>
				<th>粉丝特征</th>
				<th>关注数量</th>
				<th>粉丝数量</th>
				<th>微薄数量</th>
				<th>用户地址</th>
				<shiro:hasPermission name="weixin:jtydWeiboUser:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="jtydWeiboUser">
			<tr>
				<td> 
					${jtydWeiboUser.userId}
				 </td>
				<td>
					${jtydWeiboUser.userName}
				</td>
				<td>
					${jtydWeiboUser.grabTag}
				</td>
				<td>
					${jtydWeiboUser.attentions}
				</td>
				<td>
					${jtydWeiboUser.fans}
				</td>
				<td>
					${jtydWeiboUser.sendCount}
				</td>
				
				<td>
					<a href="http://weibo.com/${jtydWeiboUser.url}" target="_blank">${jtydWeiboUser.url} </a>
				</td>
				<shiro:hasPermission name="weixin:jtydWeiboUser:edit"><td>
    				<a href="${ctx}/weixin/jtydWeiboUser/form?id=${jtydWeiboUser.id}">修改</a>
					<a href="${ctx}/weixin/jtydWeiboUser/delete?id=${jtydWeiboUser.id}" onclick="return confirmx('确认要删除该微薄用户吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>