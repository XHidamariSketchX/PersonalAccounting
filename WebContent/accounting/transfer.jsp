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
				<form name="frm" action="transfer_add.do" method="post"
					onsubmit="return check()">
					<fieldset>
						<legend>转账</legend>

						<div>
							<label for="outAccount">转出</label> <select name="outAccount"
								style='width: 147px'>
								<s:iterator value="#request.accountList">
									<option value='<s:property value="id" />'>
										<s:property value="accountName" />
									</option>
								</s:iterator>
							</select> <label for="inAccount">转入</label> <select name="inAccount"
								style='width: 147px'>
								<s:iterator value="#request.accountList">
									<option value='<s:property value="id" />'>
										<s:property value="accountName" />
									</option>
								</s:iterator>
							</select>
						</div>
						<div>
							<label for="amount">金额</label> <input type="text" name="amount"
								size="18" maxlength="30" /> <label for="createtime">时间</label>
							<input type="text" value="<s:date name="#request.currentTime"/>"
								name="createtime" size="18" maxlength="30" /> <input
								type="submit" class="buttom" value="转入" />
						</div>
					</fieldset>
				</form>
			</div>
			<div>
				<table class="list_style" border="1">
					<tr>
						<th class="l1">时间</th>
						<th class="l2">转出账户</th>
						<th class="l3">转入账户</th>
						<th class="l4">金额</th>
					</tr>
					<s:iterator value="#request.transferList">
						<tr>
							<td><s:date name="createTime" format="yy-MM-dd" /></td>
							<td><s:property value="outAccount.accountName" /></td>
							<td><s:property value="inAccount.accountName" /></td>
							<td><s:property value="amount" /></td>
						</tr>
					</s:iterator>
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