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
	<div id="pageNav">
		<div id="sectionLinks">
			<h3 align="center">
				总支出
				<s:property value="#session.balance.totalPayment" />
			</h3>
			<h3 align="center">
				总收入
				<s:property value="#session.balance.totalIncome" />
			</h3>
			<a href="payment.do">支出</a> <a href="income.do">收入</a> <a
				href="transfer.do">转账</a> <a href="category.do">分类</a> <a
				href="account.do">账户</a>
		</div>
		<div class="relatedLinks">
			<h3>Related Link Category</h3>
		</div>
	</div>
</body>
</html>