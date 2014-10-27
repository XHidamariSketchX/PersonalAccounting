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
	var regCreateTiime= /^\d{4}-\d{1,2}-\d{1,2} (0?[1-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$/;
	if(!regAmount.test(frm.amount.value)){
		alert('金额填写有误！');
		return false;					 
	}
	if(!regCreateTiime.test(frm.createtime.value)){
		alert('时间填写有误！');
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
				<form name="frm" action="historyPurchase_modify.do" method="post"
					onsubmit="return check()">
					<fieldset>
						<legend>修改支出</legend>

						<div>
							<label for="paymentCategory"><a href="category.do">分类</a></label>
							<select name="paymentCategory" style='width: 147px'>
								<s:iterator value="#request.pcList" id="pc">
									<s:if test="%{#pc.id}==#request.payment.paymentCategory.id">
										<option value='<s:property value="id" />' selected="selected">
											<s:property value="paymentCategoryName" />
										</option>
									</s:if>
									<s:else>
										<option value='<s:property value="id" />'>
											<s:property value="paymentCategoryName" />
										</option>
									</s:else>
								</s:iterator>
							</select> <label for="account"><a href="account.do">账户</a></label> <select
								name="account" style='width: 147px'>
								<s:iterator value="#request.accountList" id="account">
									<s:if test="%{#account.id}==#request.payment.account.id">
										<option value='<s:property value="id" />' selected="selected">
											<s:property value="accountName" />
										</option>
									</s:if>
									<s:else>
										<option value='<s:property value="id" />'>
											<s:property value="accountName" />
										</option>
									</s:else>
								</s:iterator>
							</select> <label for="amount">金额</label> <input type="text" name="amount"
								value='<s:property value="#request.hp.amount"/>' size="18"
								maxlength="30" />
						</div>
						<div>
							<label for="createtime">时间</label> <input type="text"
								value="<s:date name="#request.hp.createTime"/>"
								name="createtime" size="18" maxlength="30" /> <label
								for="place">商家</label> <input type="text" name="place"
								value='<s:property value="#request.hp.place"/>' size="18"
								maxlength="30" /> <label for="remarks">备注</label> <input
								type="text" name="remarks"
								value='<s:property value="#request.hp.remarks"/>' size="18"
								maxlength="30" /> <input type="hidden" name="id"
								value='<s:property value="#request.hp.id"/>'> <input
								type="submit" class="buttom" value="修改记录" />
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