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
	var regCreateTime= /^\d{4}-\d{1,2}-\d{1,2} (0?[1-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$/;
	if(!regAmount.test(frm.amount.value)){
		alert('金额填写有误！');
		return false;					 
	}
	if(!regCreateTime.test(frm.createtime.value)){
		alert('时间填写有误！');
		return false;	
	}
	if(frm.returnTime.value!=""&&!regCreateTime.test(frm.returnTime.value)){
		alert('时间填写有误');
		return false;
	}
	if(frm.expectedReturn.value!=""&&!regAmount.test(frm.expectedReturn.value)){
		alert('金额填写有误！');
		return false;	
	}
	else{
		return true;
	}
		
	
}
</script>
<link rel="stylesheet" href="../layout/style.css" type="text/css">
</head>
<body>
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
				<form name="frm" action="investment_modify.do" method="post"
					onsubmit="return check()">
					<fieldset>
						<legend>新增投资</legend>
						<div>
							<input type="hidden" name="id"
								value="<s:property value="#request.investment.id" />"> <label
								for="investmentType"><a href="category.do">分类</a></label> <select
								name="investmentType" style='width: 147px'>
								<s:iterator value="#request.itList">
									<option value='<s:property value="id" />'>
										<s:property value="investmentTypeName" />
									</option>
								</s:iterator>
							</select> <label for="amount">金额</label> <input type="text" name="amount"
								value='<s:property value="#request.investment.amount" />'
								size="18" maxlength="30" /> <label for="expectedReturn">预计回报</label>
							<input type="text" name="expectedReturn"
								value='<s:property value="#request.investment.expectedReturn" />'
								size="18" maxlength="30" />
						</div>
						<div>
							<label for="createtime">投资时间</label> <input type="text"
								name="createtime"
								value="<s:date name="#request.investment.createTime"/>"
								size="18" maxlength="30" /> <label for="returnTime">回收时间</label>
							<input type="text" name="returnTime"
								value="<s:date name="#request.investment.returnTime"/>"
								size="18" maxlength="30" /> <label for="remarks">备注</label> <input
								type="text" name="remarks"
								value='<s:property value="#request.investment.remarks" />'
								size="18" maxlength="30" /> <input type="submit" class="buttom"
								value="修改" />
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