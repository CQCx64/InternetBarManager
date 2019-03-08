<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/InternetBarManager/css/useradd.css">
<link rel="stylesheet" type="text/css" href="/InternetBarManager/css/styles.css">
<title>修改会员信息</title>
<script type="text/javascript" src="/InternetBarManager/My97DatePicker/WdatePicker.js"></script>
</head>
<body >
<div class="wrapper">	
	<p align="center" style="text-shadow:1px 1px 1px #000;color: white;font-size: 35px;font-weight: bold;margin-top: 100px;">请修改会员信息</p>
	<hr width = 50% style="height: 5px;border:none;border-top:5px solid black" />
	<div id="content">
		<form action="/InternetBarManager/usermodify" method="post">
			<table class="useradd">
				<tr>
					<td>会员卡号：</td>
					<td><input type="text" name="userID" readonly value="${userModify.id+10000 }"/></td>
			
					<td>会员姓名：</td>
					<td><input type="text" name="userName" value="${userModify.name }"/></td>
				</tr>
				<tr>
					<td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
					<td>
						<input type="radio" name="sex" value="男" <c:if test="${userModify.sex=='男' }">checked</c:if>>男
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="sex" value="女" <c:if test="${userModify.sex=='女' }">checked</c:if>>女
					</td>
			
					<td>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄：</td>
					<td><input type="text" name="age" value="${userModify.age }"/></td>
				</tr>
				<tr>
					<td>注册日期：</td>
					<td><input type="text" readonly class="Wdate" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})" name="registerDate" value="${userModify.registerdate }"/></td>
				
					<td>身份证号：</td>
					<td><input type="text" name="IDNumber" readonly value="${userModify.idnumber }"/></td>
				</tr>
				<tr>
					<td>手&nbsp;&nbsp;机&nbsp;&nbsp;号：</td>
					<td><input type="text" name="phone" value="${userModify.phone }"/></td>
				
					<td>账户余额：</td>
					<td><input type="text" name="money" value="${userModify.money }"/></td>
				</tr>
				<tr>
					<td colspan="4"><input type="submit" name="btnOK" value="确定" class="useradd-button" style="width:180px"/></td>
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