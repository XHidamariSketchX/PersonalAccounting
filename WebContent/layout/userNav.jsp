<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="userNav">
		<div id="topLink">
			<s:if test="#session.loginuser==null">
				<a href="/PersonalAccount/user/login.jsp" class="glink"
					onmouseover="ehandler(event,menuitem1);"> 登录 </a>
			</s:if>
			<s:if test="#session.loginuser!=null">
				<a href="/PersonalAccount/user/modify.jsp"><s:property
						value="#session.loginuser.username" /> </a>
			</s:if>
			<s:if test="#session.loginuser==null">
				<a href="/PersonalAccount/user/regist.jsp" class="glink"
					onmouseover="ehandler(event,menuitem2);"> 注册 </a>
			</s:if>
			<s:if test="#session.loginuser!=null">
				<a href="/PersonalAccount/user/logout.do"> 退出 </a>
			</s:if>
		</div>
	</div>
</body>
</html>