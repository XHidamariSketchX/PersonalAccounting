<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript">
	function check(){
		var frm=document.frm;
		if(frm.paymentCategoryName.value==""){
			alert("分类名不能为空");
			return false;
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
				<fieldset>
					<div>
						<form action="paymentCategory_modify.do" method="post" name="frm"
							onsubmit="return check()">
							<input type="hidden" name="id"
								value='<s:property value="#request.paymentCategory.id"/>'>
							<label for="paymentCategoryName">支出分类</label> <input type="text"
								name="paymentCategoryName"
								value='<s:property value="#request.paymentCategory.paymentCategoryName"/>'
								size="18" maxlength="30" /> <input class=buttom type="submit"
								value="修改支出分类"></input>
						</form>
					</div>
				</fieldset>
				<fieldset>
					<div>
						<form action="incomeCategory_modify.do" method="post" name="frm"
							onsubmit="return check()">
							<input type="hidden" name="id"
								value='<s:property value="#request.incomeCategory.id"/>'>
							<label for="incomeCategoryName">收入分类</label> <input type="text"
								name="incomeCategoryName"
								value='<s:property value="#request.incomeCategory.incomeCategoryName" />'
								size="18" maxlength="30" /> <input class=buttom type="submit"
								value="修改收入分类"></input>
						</form>
					</div>
				</fieldset>
			</div>
		</div>
		<div id="siteInfo">
			<jsp:include page="../layout/siteinfo.jsp"></jsp:include>
		</div>
	</div>
	<br>
</body>
</html>