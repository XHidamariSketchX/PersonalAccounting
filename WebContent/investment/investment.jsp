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
				<form name="frm" action="investment_add.do" method="post"
					onsubmit="return check()">
					<fieldset>
						<legend>新增投资</legend>
						<div>
							<label for="investmentType"><a href="investmentType.do">分类</a></label>
							<select name="investmentType" style='width: 147px'>
								<s:iterator value="#request.itList">
									<option value='<s:property value="id" />'>
										<s:property value="investmentTypeName" />
									</option>
								</s:iterator>
							</select> <label for="amount">金额</label> <input type="text" name="amount"
								size="18" maxlength="30" /> <label for="expectedReturn">预计回报</label>
							<input type="text" name="expectedReturn" size="18" maxlength="30" />
						</div>
						<div>
							<label for="createtime">投资时间</label> <input type="text"
								value="<s:date name="#request.currentDate"/>" name="createtime"
								size="18" maxlength="30" /> <label for="returnTime">回收时间</label>
							<input type="text" name="returnTime" size="18" maxlength="30" />
							<label for="remarks">备注</label> <input type="text" name="remarks"
								size="18" maxlength="30" /> <input type="submit" class="buttom"
								value="新增记录" />
						</div>
					</fieldset>
				</form>
			</div>
			<div>
				<table class="list_style" border="1">
					<tr>
						<th class="l1">投资时间</th>
						<th class="l1">回收时间</th>
						<th class="l2">分类</th>
						<th class="l3">投资金额</th>
						<th class="l3">回报</th>
						<th class="l6">备注</th>
						<th class="l7">操作</th>
					</tr>
					<s:set id="count" value="0">
					</s:set>
					<s:set id="countReturn" value="0">
					</s:set>
					<s:iterator value="#request.investmentList" id="investment">
						<s:set id="count" value="#count + amount" />
						<s:set id="countReturn" value="#countReturn + expectedReturn" />
						<tr>
							<td><s:date name="createTime" format="yy-MM-dd" /></td>
							<td><s:date name="returnTime" format="yy-MM-dd" /></td>
							<td><s:property value="investmentType.investmentTypeName" />
							</td>
							<td><s:property value="amount" /></td>
							<td><s:property value="expectedReturn" /></td>
							<td><s:property value="remarks" /></td>
							<s:if test="state==3">
								<td>完成</td>
							</s:if>
							<s:else>
								<td><s:a
										href="investmentModify_init.do?id=%{#investment.id}">修改</s:a>
									<s:a href="investment_remove.do?id=%{#investment.id}">删除</s:a>
								</td>
							</s:else>
						</tr>
					</s:iterator>
					<tr>
						<td></td>
						<td></td>
						<td>总计</td>
						<td><s:property value="#count" /></td>
						<td><s:property value="#countReturn" /></td>
						<td></td>
						<td></td>
						<td></td>
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