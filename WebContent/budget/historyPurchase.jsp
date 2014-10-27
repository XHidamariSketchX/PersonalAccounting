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
	if(!regAmount.test(frm.amount.value)){
		alert('金额填写有误！');
		return false;					 
	}
	if(!regCreateTiime.test(frm.createtime.value)){
		alert('时间填写有误！');
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
				<form name="frm" action="historyPurchase_add.do" method="post"
					onsubmit="return check()">
					<fieldset>
						<legend>添加历史支出</legend>

						<div>
							<label for="paymentCategory">分类</label> <select
								name="paymentCategory" style='width: 147px'>
								<s:iterator value="#request.pcList">
									<option value='<s:property value="id" />'>
										<s:property value="paymentCategoryName" />
									</option>
								</s:iterator>
							</select> <label for="account">账户</label> <select name="account"
								style='width: 147px'>
								<s:iterator value="#request.accountList">
									<option value='<s:property value="id" />'>
										<s:property value="accountName" />
									</option>
								</s:iterator>
							</select> <label for="amount">金额</label> <input type="text" name="amount" />
						</div>
						<div>
							<label for="createtime">时间</label> <input type="text"
								value="<s:date name="#request.currentDate"/>" name="createtime"
								size="18" maxlength="30" /> <label for="place">商家</label> <input
								type="text" name="place" size="18" maxlength="30" /> <label
								for="remarks">备注</label> <input type="text" name="remarks"
								size="18" maxlength="30" /> <input type="submit" class="buttom"
								value="新增记录" />
						</div>
					</fieldset>
				</form>
			</div>
			<div>
				<table class="list_style" border="1">
					<tbody>
						<tr>
							<th class="l1">时间</th>
							<th class="l2">分类</th>
							<th class="l3">金额</th>
							<th class="l4">账户</th>
							<th class="l5">商家</th>
							<th class="l6">备注</th>
							<th class="l7">l7</th>
						</tr>
						<s:set id="count" value="0">
						</s:set>
						<s:iterator value="#request.hpList" id="hp">
							<s:set id="count" value="#count + amount" />
							<tr>
								<td><s:date name="createTime" format="yy-MM-dd" /></td>
								<td><s:property value="paymentCategory.paymentCategoryName" />
								</td>
								<td><s:property value="amount" /></td>
								<td><s:property value="account.accountName" /></td>
								<td><s:property value="place" /></td>
								<td><s:property value="remarks" /></td>
								<td><s:a href="historyPurchaseModify_init.do?id=%{#hp.id}">修改</s:a>
									<s:a href="historyPurchase_remove.do?id=%{#hp.id}">删除</s:a></td>
							</tr>
						</s:iterator>
						<tr>
							<td></td>
							<td>总计</td>
							<td><s:property value="#count" /></td>
							<td></td>
							<td></td>
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