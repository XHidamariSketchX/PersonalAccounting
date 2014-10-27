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
		if(frm.investmentTypeName.value==""){
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
						<form action="investmentType_add.do" method="post" name="frm"
							onsubmit="return check()">

							<label for="investmentTypeName">投资分类</label> <input type="text"
								name="investmentTypeName" size="18" maxlength="30" /> <input
								class=buttom type="submit" value="新增分类"></input>
						</form>
					</div>
				</fieldset>
			</div>
			<div>
				<table class="list_style" border="1">
					<tr>
						<th>分类</th>
						<th>操作</th>
					</tr>
					<s:iterator value="#request.itList" id="investmentType">
						<tr>
							<td><s:a
									href="investmentTypeModify_init.do?id=%{#investmentType.id}">
									<s:property value="investmentTypeName" />
								</s:a></td>
							<td><s:a
									href="investmentTypeModify_init.do?id=%{#investmentType.id}">修改</s:a>
							</td>
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