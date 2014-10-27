<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<script language="JavaScript">	
function check(){
	var frm=document.frm;
	var regUsername=/^[\u4E00-\u9FA5\uf900-\ufa2d\w]{4,16}$/;
	var regEmail= /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
	if(!regUsername.test(frm.username.value)){
		alert('用户名只 能用 中文、英文、数字、下划线、4-16个字符！');
		return false;					 
	}
	if(frm.password.value==""){
		alert('密码不能为空！');
		return false;
	}
	if(frm.confirm_password.value!=frm.password.value){
		alert('两次密码输入不一样');
		return false;
	}
	if(!regEmail.test(frm.email.value)){
		alert('邮箱格式不正确');
		return false;
	}
	else{
		return true;
	}
}
</script>
<style type="text/css">
<!--
bodys {
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
			<form name="frm" action="regist.do" method="post"
				onsubmit="return check()">
				<fieldset>
					<legend>
						用户注册
						<s:property value="#request.registMsg" />
					</legend>

					<div>
						<label for="username">用户名</label> <input type="text"
							name="username" value="" size="20" maxlength="30" /> *<br />
					</div>
					<div>
						<label for="password">密码</label> <input type="password"
							name="password" size="18" maxlength="15" /> *<br />
					</div>
					<div>
						<label for="confirm_password">重复密码</label> <input type="password"
							name="confirm_password" size="18" maxlength="15" /> *<br />
					</div>
					<div>
						<label for="email">电子邮箱</label> <input type="text" name="email"
							value="" size="20" maxlength="150" /> *<br />
					</div>
					<div class="center">
						<input name="create791" type="submit" class="buttom" value="提交" />
						<input name="Submit" type="reset" class="buttom" value="重置" />
					</div>

				</fieldset>
			</form>
		</div>
		<div id="siteInfo">
			<jsp:include page="../layout/siteinfo.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>