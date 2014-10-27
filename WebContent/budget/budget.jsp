<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script language="JavaScript">	
function check(){
	var frm=document.frm;
	var regAmount=/^\d+(\.\d{1,2})?$/;
	var regCreateTiime= /^\d{4}-\d{1,2}-\d{1,2} (0?[1-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$/;
	if(frm.application.value==""){
		alert("用途不能为空");
		return false;
	}
	if(!regAmount.test(frm.amount.value)){
		alert('金额填写有误！');
		return false;					 
	}
	if(frm.place.value==""){
		alert('商家不能为空');
		return false;	
	}
	else{
		return true;
	}
}
</script>
<link rel="stylesheet" href="../layout/style.css" type="text/css">
</head>
<body onmousemove="closesubnav(event);">
	<div id="masthead">
		<jsp:include page="../layout/userNav.jsp"></jsp:include>
		<h1 id="siteName">Personal Accounting</h1>
	</div>

	<div id="pagecell">
		<div id="pagecell_top">
			<s:include value="../layout/globallink.jsp"></s:include>
		</div>
		<jsp:include page="leftNev.jsp"></jsp:include>
		<div id="content">
			<div class="feature">
				<form name="frm" action="budget_add.do" method="post"
					onsubmit="return check()">
					<fieldset>
						<legend>新增支出</legend>
						<div>
							<label for="application">用途</label> <input type="text"
								name="application" /> <label for="amount">金额</label> <input
								type="text" name="amount" /> <label for="place">商家</label> <input
								type="text" name="place" size="18" maxlength="30" /> <input
								type="submit" class="buttom" value="新增记录" />
						</div>
					</fieldset>
				</form>
			</div>
			<div>
				<table class="list_style" border="1">
					<tbody>
						<tr>
							<th class="l1">时间</th>
							<th class="l2">用途</th>
							<th class="l3">金额</th>
							<th class="l5">商家</th>
							<th class="l6">状态</th>
						</tr>
						<s:set id="count" value="0">
						</s:set>
						<s:iterator value="#request.budgetList" id="budget">
							<s:set id="count" value="#count + amount" />
							<tr>
								<td><s:date name="createTime" format="yy-MM-dd" /></td>
								<td><s:property value="application" /></td>
								<td><s:property value="amount" /></td>
								<td><s:property value="place" /></td>
								<td><s:if test="state==1">
										<s:a href="budget_achieve.do?id=%{#budget.id}">完成</s:a>
									</s:if> <s:if test="state==2">已完成</s:if> <s:a
										href="budget_remove.do?id=%{#budget.id}">删除</s:a></td>
							</tr>
						</s:iterator>
						<tr>
							<td></td>
							<td>总计</td>
							<td><s:property value="#count" /></td>
							<td></td>
							<td></td>
						</tr>
					</tbody>

				</table>

			</div>
		</div>
		<div id="siteInfo">
			<jsp:include page="../layout/siteinfo.jsp"></jsp:include>
		</div>
	</div>
	<br>
</body>
</html>