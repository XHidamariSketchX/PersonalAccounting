<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome</title>
<style type="text/css">
<!--
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

.enter {
	text-align: center;
}

.clear {
	clear: both;
}
-->
</style>
<link rel="stylesheet" href="layout/style.css" type="text/css">

</head>
<body>
	<div id="masthead">
		<jsp:include page="layout/userNav.jsp"></jsp:include>
		<h1 id="siteName">
			Personal Accounting</br> 你不理财，财不理你！ 把握你的金钱，勒紧你的钱包！ </br> 理财从记帐开始，记账就从今天<a
				href="user/login.jsp">开始！</a></br>
		</h1>
	</div>
</body>
</html>