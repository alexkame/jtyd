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
		<li><a href="${ctx}/weixin/jtydSendTasks/getSendRatelist">第三步：配置发送频率</a></li>
		<li  class="active"><a href="${ctx}/weixin/jtydSendTasks/getSendTask">第四步：生成任务</a></li>
	</ul>
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
		 
		</tbody>
	</table>	
<center>
<a href="${ctx}/weixin/jtydSendTasks/showConfigs"> <input id="btnSubmit" class="btn btn-primary" type="button" value="取消"/></a>
<a href="${ctx}/weixin/jtydSendTasks/getSendRatelist"> <input id="btnSubmit" class="btn btn-primary" type="button" value="确定"/></a>
 </center>
</body>
</html>