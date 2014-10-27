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
	if(!regAmount.test(frm.amount.value)){
		alert('金额填写有误！');
		return false;					 
	}
	if(frm.accountName.value==""){
		alert('账户名不能为空！');
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
				<form action="investmentAccount_modify.do" method="post">
					<fieldset>
						修改账户
						<div>
							<input type="hidden" name="id"
								value="<s:property value="#request.account.id" />"> <label
								for="accountName">账户名</label> <input type="text"
								name="accountName"
								value='<s:property value="#request.account.accountName" />'
								size="18" maxlength="30" /> <label for="balance">余额</label> <input
								type="text" name="balance"
								value='<s:property value="#request.account.balance" />'
								size="18" maxlength="30" /> <input class=buttom type="submit"
								value="修改"></input>
						</div>
					</fieldset>
				</form>
			</div>

		</div>
		<div id="siteInfo">
			<jsp:include page="../layout/siteinfo.jsp"></jsp:include>
		</div>
	</div>
	<br>
</body>
</html>