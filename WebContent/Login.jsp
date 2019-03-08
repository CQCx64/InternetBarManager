<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎使用网咖管理系统</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
<link rel="stylesheet" type="text/css" href="css/navi.css">
<link rel="stylesheet" type="text/css" href="/InternetBarManager/css/styles.css">
</head>
<body >
<div class="wrapper">
	<c:if test="${param.info==1 }"><%out.print("<script>alert('密码错误！')</script>"); %></c:if>
	<c:if test="${param.info==2 }"><%out.print("<script>alert('账户错误！')</script>"); %></c:if>
	
	<ul>
		<li style="float: right"><a href="">关于</a></li>
		<li style="float: right"><a href="">未登录</a></li>
	</ul>
	
	<div>
		<h1 align=center style="text-shadow:1px 1px 1px #000;margin-top:5%;margin-bottom:2%;font-size: 50px;color :white">欢迎使用网咖管理系统</h1>
	</div>
	
	<hr width = 800px style="height: 5px;border:none;border-top:5px solid black"/> 
	
	<div id="content">
	    <div class="login-header">
	        	<span style="color: white">请先登录</span>
	    </div>
	    <form action="login" method="post">
	        <div class="login-input-box">
	            <span class="icon icon-user"></span>
	            <input type="text" name="txtAdmin" placeholder="请输入账号" />
	        </div>
	        <div class="login-input-box">
	            <span class="icon icon-password"></span>
	            <input type="password" name="password" placeholder="请输入密码 " />
	        </div>
	    	<div class="remember-box">
		        <!-- <label>
		            <input type="checkbox">&nbsp;记住密码
		        </label> -->
		    </div>
		    <div class="login-button-box">
		        <input type="submit" value="Login"></input>
		    </div>
	    </form>
	</div>
	<ul class="bg-bubbles" style="background: none">
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