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
	if(frm.accountName.value==""){
		alert('账户名不能为空！');
		return false;
	}
	if(!regAmount.test(frm.balance.value)){
		alert('金额填写有误！');
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
				<form name="frm" action="account_add.do" method="post"
					onsubmit="return check()">
					<fieldset>
						新增账户
						<div>
							<label for="accountName">账户名</label> <input type="text"
								name="accountName" size="18" maxlength="30" /> <label
								for="balance">余额</label> <input type="text" name="balance"
								size="18" maxlength="30" /> <input class=buttom type="submit"
								value="新增"></input>
						</div>
					</fieldset>
				</form>
			</div>
			<div>
				<table class="list_style" border="1">
					<tr>
						<th>账户名</th>
						<th>余额</th>

					</tr>
					<s:iterator value="#request.accountList" id="account">
						<tr>
							<td><s:a href="accountModify_init.do?id=%{#account.id}">
									<s:property value="accountName" />
								</s:a></td>
							<td><s:property value="balance" /></td>

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