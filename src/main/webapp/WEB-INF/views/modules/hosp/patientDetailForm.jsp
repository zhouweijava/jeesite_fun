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
					<label class="control-label" for="patient_name">姓名:</label>
					<div class="controls">
						<form:input path="patient_name" htmlEscape="false" maxlength="200" class="required"/>
					</div>
		</div>

	<div class="control-group">
		<label class="control-label" for="patient_name">诊断:</label>
		<div class="controls">
			<form:input path="symptom" htmlEscape="false" maxlength="200" class="required"/>
		</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="patient_name">总费用:</label>
			<div class="controls">
				<form:input path="total_cost" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="patient_name">药费合计:</label>
			<div class="controls">
				<form:input path="drugs" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label" for="patient_name">西药:</label>
			<div class="controls">
				<form:input path="west_medicine" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label" for="patient_name">中成药:</label>
			<div class="controls">
				<form:input path="chinese_medicine" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="patient_name">辅助检查费合计:</label>
			<div class="controls">
				<form:input path="assist_pay" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="patient_name">放射费:</label>
			<div class="controls">
				<form:input path="blas_pay" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label" for="patient_name">化验费:</label>
			<div class="controls">
				<form:input path="test_pay" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label" for="patient_name">检查费:</label>
			<div class="controls">
				<form:input path="check_pay" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label" for="patient_name">统筹支付:</label>
			<div class="controls">
				<form:input path="overall_pay" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label" for="patient_name">个人支付:</label>
			<div class="controls">
				<form:input path="personal_pay" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="patient_name">入院日期:</label>
			<div class="controls">
				<form:input path="admission_day" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label" for="patient_name">结账日期:</label>
			<div class="controls">
				<form:input path="closing_date" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="patient_name">住院天数:</label>
			<div class="controls">
				<form:input path="hospital_day" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label" for="remark">备注:</label>
			<div class="controls">
				<form:textarea path="remark" htmlEscape="false" rows="4" maxlength="200" class="input-xxlarge"/>
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
