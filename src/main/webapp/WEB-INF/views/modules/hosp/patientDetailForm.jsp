<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>患者用户信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#name").focus();
			$("#inputForm").validate();
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/hosp/patientDetail/">患者用户信息列表</a></li>
		<li class="active"><a href="${ctx}/hosp/patientDetail/form?id=${patientDetail.id}">患者用户信息<shiro:hasPermission name="hosp:patientDetail:edit">${not empty patientDetail.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="hosp:patientDetail:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	
	<form:form id="inputForm" modelAttribute="patientDetail" action="${ctx}/hosp/patientDetail/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<tags:message content="${message}"/>
		<div class="control-group">
			<label class="control-label" for="patient_name">名称:</label>
			<div class="controls">
				<form:input path="patient_name" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="remarks">备注:</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="200" class="input-xxlarge"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="hosp:patientDetail:edit">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
