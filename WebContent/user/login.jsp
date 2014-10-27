<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<script language="JavaScript">	
	function check(){
		var frm=document.frm;
		if(frm.username.value==""){
			alert('用户名不能为空！');
			return false;
		} 
		if(frm.password.value==""){
			alert('密码不能为空！');
			return false;
		}
		else{
			return true;
		}
	}
</script>
<style type="text/css">
<!--
body {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	color: #666666;
	background: #fff;
	text-align: center;
}

* {
	margin: 0;
	padding: 0;
}

a {
	color: #1E7ACE;
	text-decoration: none;
}

a:hover {
	color: #000;
	text-decoration: underline;
}

h3 {
	font-size: 14px;
	font-weight: bold;
}

pre, p {
	color: #1E7ACE;
	margin: 4px;
}

input, select, textarea {
	padding: 1px;
	margin: 2px;
	font-size: 11px;
}

.buttom {
	padding: 1px 10px;
	font-size: 12px;
	border: 1px #1E7ACE solid;
	background: #D0F0FF;
}

#formwrapper {
	width: 450px;
	margin: 15px auto;
	padding: 20px;
	text-align: left;
	border: 1px solid #A4CDF2;
}

fieldset {
	padding: 10px;
	margin-top: 5px;
	border: 1px solid #A4CDF2;
	background: #fff;
}

fieldset legend {
	color: #1E7ACE;
	font-weight: bold;
	padding: 3px 20px 3px 20px;
	border: 1px solid #A4CDF2;
	background: #fff;
}

fieldset label {
	float: left;
	width: 120px;
	text-align: right;
	padding: 4px;
	margin: 1px;
}

fieldset div {
	clear: left;
	margin-bottom: 2px;
}

.center {
	text-align: center;
}

.clear {
	clear: both;
}
-->
</style>
<link rel="stylesheet" href="../layout/style.css" type="text/css">
</head>
<body>
	<div id="masthead">
		<jsp:include page="../layout/userNav.jsp"></jsp:include>
		<h1 id="siteName">Personal Accounting</h1>
	</div>
	<div id="pagecell">
		<div id="formwrapper">
			<form name="frm" action="login.do" method="post"
				onsubmit="return check()">
				<fieldset>
					<legend>
						用户登录
						<s:property value="#request.loginMsg" />
					</legend>
					<div>
						<label for="username">用户名</label> <input type="text"
							name="username" size="18" maxlength="30" /> <br />
					</div>
					<div>
						<label for="password">密码</label> <input type="password"
							name="password" size="18" maxlength="30" /> <br />
					</div>

					<div class="center">
						<input type="submit" class="buttom" value="登录" />
					</div>
				</fieldset>
			</form>
			<br />
		</div>
		<div id="siteInfo">
			<jsp:include page="../layout/siteinfo.jsp"></jsp:include>
		</div>
	</div>
</body>

</html>