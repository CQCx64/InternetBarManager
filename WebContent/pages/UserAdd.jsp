<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/InternetBarManager/css/useradd.css">
<link rel="stylesheet" type="text/css" href="/InternetBarManager/css/styles.css">
<title>添加新会员</title>
<script type="text/javascript" src="/InternetBarManager/My97DatePicker/WdatePicker.js"></script>
</head>
<body >
<div class="wrapper">
	<p align="center" style="text-shadow:1px 1px 1px #000;color: white;font-size: 35px;font-weight: bold;margin-top: 100px;">请录入新会员信息</p>
		<hr width = 50% style="height: 5px;border:none;border-top:5px solid black" />
			<div id="content">
			<form action="/InternetBarManager/useradd" method="post">
				<table class="useradd">
					<tr>
	<%-- 					<td>会员卡号：</td>
						<td><input type="text" name="userID" readonly value="${userNum+10001 }"/></td> --%>
				
						<td colspan="2" style="text-align: right">会员姓名：</td>
						<td colspan="2" style="text-align: left"><input type="text" name="userName" /></td>
					</tr>
					<tr>
						<td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
						<td>
							<input type="radio" name="sex" value="男" checked>男
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="sex" value="女">女
						</td>
				
						<td>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄：</td>
						<td><input type="text" name="age" /></td>
					</tr>
					<tr>
						<td>注册日期：</td>
						<td><input type="text" readonly class="Wdate" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})" name="registerDate" /></td>
					
						<td>身份证号：</td>
						<td><input type="text" name="IDNumber" /></td>
					</tr>
					<tr>
						<td>手&nbsp;&nbsp;机&nbsp;&nbsp;号：</td>
						<td><input type="text" name="phone" /></td>
					
						<td>账户余额：</td>
						<td><input type="text" name="money" value="0" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" name="btnOK" value="确定" class="useradd-button"/></td>
						<td colspan="2"><input type="reset" name="btnReset" value="重置"  class="useradd-button"/></td>
					</tr>
				</table>
			</form>
		</div>
		<ul class="bg-bubbles">
				<li></li>	
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
		</ul>
	</div>

</body>
</html>