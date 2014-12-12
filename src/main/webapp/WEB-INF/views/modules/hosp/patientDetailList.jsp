<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>患者用户信息管理</title>
	<meta name="decorator" content="default"/>
	<%@include file="/WEB-INF/views/include/dialog.jsp" %>
	<script src="${ctxStatic}/bootstrap-table/bootstrap-table.min.js" type="text/javascript"></script>
	<link href="${ctxStatic}/bootstrap-table/bootstrap-table.min.css" rel="stylesheet" />
	<script type="text/javascript">
		$(document).ready(function() {
			// 表格排序
			//tableSort({callBack : page});

			$("#btnExport").click(function(){
				top.$.jBox.confirm("确认要导出患者数据吗？","系统提示",function(v,h,f){
					if(v == "ok"){
						$("#searchForm").attr("action","${ctx}/hosp/patientDetail/export").submit();
					}
				},{buttonsFocus:1});
				top.$('.jbox-body .jbox-icon').css('top','55px');
			});

			$("#btnImport").click(function(){
				$.jBox($("#importBox").html(), {title:"导入数据", buttons:{"关闭":true},
					bottomText:"导入文件不能超过5M，仅允许导入“xls”或“xlsx”格式文件！"});
			});
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").attr("action","${ctx}/hosp/patientDetail/").submit();
			return false;
		}

	</script>
</head>
<body>
	<div id="importBox" class="hide">
		<form id="importForm" action="${ctx}/hosp/patinetDetail/import" method="post" enctype="multipart/form-data"
		  style="padding-left:20px;text-align:center;" class="form-search" onsubmit="loading('正在导入，请稍等...');"><br/>
			<input id="uploadFile" name="file" type="file" style="width:330px"/><br/><br/>　　
			<input id="btnImportSubmit" class="btn btn-primary" type="submit" value="   导    入   "/>
			<a href="${ctx}/hosp/patientDetail/import/template">下载模板</a>
		</form>
	</div>

	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/hosp/patientDetail/">患者用户信息列表</a></li>
		<shiro:hasPermission name="hosp:patientDetail:edit"><li><a href="${ctx}/hosp/patientDetail/form">患者用户信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="patientDetail" action="${ctx}/hosp/patientDetail/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>患者姓名 ：</label><form:input path="patient_name" htmlEscape="false" maxlength="50" class="input-small"/>
		&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
		&nbsp;<input id="btnExport" class="btn btn-primary" type="button" value="导出"/>
		<!--&nbsp;<input id="btnImport" class="btn btn-primary" type="button" value="导入"/>-->
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
		<tr>
			<th>姓名</th>
			<th>诊断</th>
			<th>总费用</th>
			<th>药费合计</th>
			<th>西药</th>
			<th>中成药</th>
			<th>辅助检查费合计</th>
			<th>放射费</th>
			<th>化验费</th>
			<th>检查费</th>
			<th>统筹支付</th>
			<th>个人支付</th>
			<th>入院日期</th>
			<th>结账日期</th>
			<th>住院天数</th>
			<!--<th>医生</th>
			<th>社保</th>
			<th>少儿</th>
			<th>城镇</th>
			<th>城乡</th>
			<th>社保外伤</th>
			<th>城乡外伤</th>
			<th>科室</th>
			<th>高额</th>
			<th>备注</th>-->
			<shiro:hasPermission name="hosp:patientDetail:edit"><th>操作</th></shiro:hasPermission>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="patientDetail">
			<tr>
				<td><a href="${ctx}/hosp/patientDetail/form?id=${patientDetail.id}">${patientDetail.patient_name}</a></td>
				<td>${patientDetail.symptom}</td>
				<td>${patientDetail.total_cost}</td>
				<td>${patientDetail.drugs}</td>
				<td>${patientDetail.west_medicine}</td>
				<td>${patientDetail.chinese_medicine}</td>
				<td>${patientDetail.assist_pay}</td>
				<td>${patientDetail.blas_pay}</td>
				<td>${patientDetail.test_pay}</td>
				<td>${patientDetail.check_pay}</td>
				<td>${patientDetail.overall_pay}</td>
				<td>${patientDetail.personal_pay}</td>
				<td>${patientDetail.admission_day}</td>
				<td>${patientDetail.closing_date}</td>
				<td>${patientDetail.hospital_day}</td>
				<!--<td>${patientDetail.doctor_name}</td>
				<td>${patientDetail.is_shebao}</td>
				<td>${patientDetail.is_shaoer}</td>
				<td>${patientDetail.is_chengzhen}</td>
				<td>${patientDetail.is_chengxiang}</td>
				<td>${patientDetail.sb_waishang}</td>
				<td>${patientDetail.cx_waishang}</td>
				<td>${patientDetail.dept}</td>
				<td>${patientDetail.is_gaoe}</td>
				<td>${patientDetail.remark}</td>-->
				<shiro:hasPermission name="hosp:patientDetail:edit"><td>
    				<a href="${ctx}/hosp/patientDetail/form?id=${patientDetail.id}">修改</a>
					<a href="${ctx}/hosp/patientDetail/delete?id=${patientDetail.id}" onclick="return confirmx('确认要删除该患者用户信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
