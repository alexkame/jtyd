<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>微薄用户管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/weixin/jtydWeiboUser/">微薄用户列表</a></li>
		<li class="active"><a href="${ctx}/weixin/jtydWeiboUser/form?id=${jtydWeiboUser.id}">微薄用户<shiro:hasPermission name="weixin:jtydWeiboUser:edit">${not empty jtydWeiboUser.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="weixin:jtydWeiboUser:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="jtydWeiboUser" action="${ctx}/weixin/jtydWeiboUser/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">用户userID：</label>
			<div class="controls">
				<sys:treeselect id="userId" name="userId" value="${jtydWeiboUser.userId}" labelName="" labelValue="${jtydWeiboUser.}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="required" allowClear="true" notAllowSelectParent="true"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">用户昵称：</label>
			<div class="controls">
				<form:input path="userName" htmlEscape="false" maxlength="30" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">base_address：</label>
			<div class="controls">
				<form:input path="baseAddress" htmlEscape="false" maxlength="30" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">gender：</label>
			<div class="controls">
				<form:input path="gender" htmlEscape="false" maxlength="1" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">sex：</label>
			<div class="controls">
				<form:input path="sex" htmlEscape="false" maxlength="10" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">emotion：</label>
			<div class="controls">
				<form:input path="emotion" htmlEscape="false" maxlength="10" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">birthday：</label>
			<div class="controls">
				<input name="birthday" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${jtydWeiboUser.birthday}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">blood：</label>
			<div class="controls">
				<form:input path="blood" htmlEscape="false" maxlength="1" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">constellation：</label>
			<div class="controls">
				<form:input path="constellation" htmlEscape="false" maxlength="3" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">intro：</label>
			<div class="controls">
				<form:input path="intro" htmlEscape="false" maxlength="70" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">blog：</label>
			<div class="controls">
				<form:input path="blog" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">msn：</label>
			<div class="controls">
				<form:input path="msn" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">qq：</label>
			<div class="controls">
				<form:input path="qq" htmlEscape="false" maxlength="10" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">school：</label>
			<div class="controls">
				<form:input path="school" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">company：</label>
			<div class="controls">
				<form:input path="company" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">company_addr：</label>
			<div class="controls">
				<form:input path="companyAddr" htmlEscape="false" maxlength="30" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">company_job：</label>
			<div class="controls">
				<form:input path="companyJob" htmlEscape="false" maxlength="30" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">tag：</label>
			<div class="controls">
				<form:input path="tag" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">attentions：</label>
			<div class="controls">
				<form:input path="attentions" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">fans：</label>
			<div class="controls">
				<form:input path="fans" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">send_count：</label>
			<div class="controls">
				<form:input path="sendCount" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">grab_tag：</label>
			<div class="controls">
				<form:input path="grabTag" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">class_tag：</label>
			<div class="controls">
				<form:input path="classTag" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">fetched_time：</label>
			<div class="controls">
				<input name="fetchedTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${jtydWeiboUser.fetchedTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">用户地址：</label>
			<div class="controls">
				<form:input path="url" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="weixin:jtydWeiboUser:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>