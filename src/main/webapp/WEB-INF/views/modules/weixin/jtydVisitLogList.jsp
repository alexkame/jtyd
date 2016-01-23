<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>平台用户管理</title>
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
		<li class="active"><a href="${ctx}/weixin/jtydVisitLog/">平台用户列表</a></li>
		<shiro:hasPermission name="weixin:jtydVisitLog:edit"><li><a href="${ctx}/weixin/jtydVisitLog/form">平台用户添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="jtydVisitLog" action="${ctx}/weixin/jtydVisitLog/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>用户昵称：</label>
				<form:input path="userName" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>文章名称：</label>
				<form:input path="articleName" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>用户id</th>
				<th>用户昵称</th>
				<th>微信文章id</th>
				<th>文章名称</th>
				<th>用户IP</th>
				<th>访问时间</th>
				<th>浏览器类型</th>
				<th>客户端类型</th>
				<th>省份</th>
				<th>市县</th>
				<!-- <th>更新时间</th> -->
				<!-- <th>备注信息</th> -->
				<%-- <shiro:hasPermission name="weixin:jtydVisitLog:edit"><th>操作</th></shiro:hasPermission> --%>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="jtydVisitLog">
			<tr>
				<td> 
					${jtydVisitLog.wbuserId}
				</td>
				<td> 
					${jtydVisitLog.userName}
				</td>
				<td>
					${jtydVisitLog.articleId}
				</td>
				<td>
					${jtydVisitLog.articleName}
				</td>
				<td>
					${jtydVisitLog.visitIp}
				</td>
				<td>
					<fmt:formatDate value="${jtydVisitLog.visitDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${jtydVisitLog.browserType}
				</td>
				<td>
					${jtydVisitLog.clientType}
				</td>
				<td>
					${jtydVisitLog.province}
				</td>
				<td>
					${jtydVisitLog.city}
				</td>
				<%-- <td>
					<fmt:formatDate value="${jtydVisitLog.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td> --%>
				<%-- <td>
					${jtydVisitLog.remarks}
				</td> --%>
				<%-- <shiro:hasPermission name="weixin:jtydVisitLog:edit"><td>
    				<a href="${ctx}/weixin/jtydVisitLog/form?id=${jtydVisitLog.id}">修改</a>
					<a href="${ctx}/weixin/jtydVisitLog/delete?id=${jtydVisitLog.id}" onclick="return confirmx('确认要删除该平台用户吗？', this.href)">删除</a>
				</td></shiro:hasPermission> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>