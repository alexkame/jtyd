<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>推广设置管理</title>
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
	    <li class="active"><a href="${ctx}/weixin/jtydSendTasks/showConfigs">推广设置</a></li>
		<%-- <li class="active"><a href="${ctx}/weixin/jtydSendTasks/">任务列表</a></li> --%>
		<shiro:hasPermission name="weixin:jtydSendTasks:edit"><li><a href="${ctx}/weixin/jtydSendTasks/form">推广设置添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="jtydSendTasks" action="${ctx}/weixin/jtydSendTasks/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>文章编码：</label>
				<form:input path="articleId" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>用户名：</label>
				<form:input path="userName" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>文章编码</th>
				<th>推广平台编码</th>
				<th>用户名</th>
				<th>发送频率</th>
				<th>粉丝特征</th>
				<th>状态，1带执行，2处理中，3已完成，4其他</th>
				<th>自定义推广内容</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="weixin:jtydSendTasks:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="jtydSendTasks">
			<tr>
				<td><a href="${ctx}/weixin/jtydSendTasks/form?id=${jtydSendTasks.id}">
					${jtydSendTasks.articleId}
				</a></td>
				<td>
					${jtydSendTasks.platformId}
				</td>
				<td>
					${jtydSendTasks.userName}
				</td>
				<td>
					${jtydSendTasks.sendRateId}
				</td>
				<td>
					${jtydSendTasks.fansKeywordsId}
				</td>
				<td>
					${jtydSendTasks.flag}
				</td>
				<td>
					${jtydSendTasks.concents}
				</td>
				<td>
					<fmt:formatDate value="${jtydSendTasks.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${jtydSendTasks.remarks}
				</td>
				<shiro:hasPermission name="weixin:jtydSendTasks:edit"><td>
    				<a href="${ctx}/weixin/jtydSendTasks/form?id=${jtydSendTasks.id}">修改</a>
					<a href="${ctx}/weixin/jtydSendTasks/delete?id=${jtydSendTasks.id}" onclick="return confirmx('确认要删除该推广设置吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>