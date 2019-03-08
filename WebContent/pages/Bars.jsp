<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="/InternetBarManager/css/navi.css">
<link rel="stylesheet" type="text/css"
	href="/InternetBarManager/css/bars.css">
<title>连锁门店信息展示</title>
<script type="text/javascript" src="../jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?key=&v=1.1&services=true"></script>
</head>

<body style="background: url('/InternetBarManager/Pic/bc.jpg');">
	<ul class="nav">
		<li><a href="/InternetBarManager/index">主页</a></li>
		<li><a href="/InternetBarManager/userquery">会员管理</a></li>
		<li><a href="/InternetBarManager/comquery">机器管理</a></li>
		<li style="float: right"><a href="">关于</a></li>
		<li style="float: right" class="drop-down"><a href="">管理员：${adminInfo.name }</a>
			<ul class="drop-down-content">
				<li><a href="/InternetBarManager/pages/AdPwdModify.jsp">更改密码</a></li>
				<li><a href="/InternetBarManager/logout">注销</a></li>
			</ul></li>
		<li><a href="/InternetBarManager/pos">区域管理</a></li>
		<li><a class="active" href="/InternetBarManager/bar">连锁门店信息</a></li>
	</ul>

	<div id="content">
		<table class="bar-tab">
			<tr>
				<th>门店信息</th>
				<th style="width: 33%">地图位置</th>
			</tr>
			<c:forEach var="b" items="${allbar }">
				<tr>
					<td>NO.${b.bid }<br> <br> 店名：${b.bname }<br> <br>
						详细地址：${b.baddress }<br><br>门店热线：${b.phone }
					</td>
					<td>
						<div style="width: 397px; height: 350px; border: #ccc solid 1px;"
							id="dituContent_${b.bid }"></div>
					</td>
				</tr>
			</c:forEach>
		</table>

	</div>
</body>

<script type="text/javascript" src="../js/baidumap.js" charset="GBK"></script>
</html>