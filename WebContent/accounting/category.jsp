<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript">
	function checkpaymentFrm(){
		if(document.paymentFrm.paymentCategoryName.value==""){
			alert("分类名不能为空");
			return false;
		}
			return true;
	}
	function checkincomeFrm() {
		if(document.incomeFrm.incomeCategoryName.value==""){
			alert("分类名不能为空");
			return false;
		}
			return true;
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
				<fieldset>
					<div>
						<form action="paymentCategory_add.do" method="post"
							name="paymentFrm" onsubmit="return checkpaymentFrm()">

							<label for="paymentCategoryName">支出分类</label> <input type="text"
								name="paymentCategoryName" size="18" maxlength="30" /> <input
								class=buttom type="submit" value="新增支出分类"></input>
						</form>
					</div>
				</fieldset>
				<fieldset>
					<div>
						<form action="incomeCategory_add.do" method="post"
							name="incomeFrm" onsubmit="return checkincomeFrm()">
							<label for="incomeCategoryName">收入分类</label> <input type="text"
								name="incomeCategoryName" size="18" maxlength="30" /> <input
								class=buttom type="submit" value="新增收入分类"></input>
						</form>
					</div>
				</fieldset>
			</div>
			<div>
				<table width="100%">
					<tr>
						<td>
							<table class="list_style" border="1">
								<tr>
									<th>ID</th>
									<th>支出分类</th>

								</tr>
								<s:iterator value="#request.pcList" id="paymentCategory">
									<tr>
										<td><s:property value="id" /></td>
										<td><s:a
												href="paymentCategoryModify_init.do?id=%{#paymentCategory.id}">
												<s:property value="paymentCategoryName" />
											</s:a></td>

									</tr>
								</s:iterator>
							</table>
						</td>
						<td>
							<table class="list_style" border="1">
								<tr>
									<th>ID</th>
									<th>收入分类</th>

								</tr>
								<s:iterator value="#request.icList" id="incomeCategory">
									<tr>
										<td><s:property value="id" /></td>
										<td><s:a
												href="incomeCategoryModify_init.do?id=%{#incomeCategory.id}">
												<s:property value="incomeCategoryName" />
											</s:a></td>

									</tr>
								</s:iterator>
							</table>
						</td>
					</tr>
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