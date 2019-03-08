<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>区域管理</title>
<link rel="stylesheet" href="css/notifications.css">
<script type="text/javascript" src="../jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/call.js"></script>
<link rel="stylesheet" type="text/css"
	href="/InternetBarManager/css/navi.css">
<link rel="stylesheet" type="text/css"
	href="/InternetBarManager/css/posinfo.css">
<script type="text/javascript" src="jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	function posmodify(posno) {
		$.ajax({
			url : "/InternetBarManager/posmodify",
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			async : true, // 是否为异步请求
			cache : false, // 是否缓存结果
			type : "get",
			dataType: "json",
			data : {posno:posno},
			success : function(data, textStatus) {
				// Result为后端post函数传递来的数据，这里写结果操作代码
				
				$("#posid").val(data.id);
				$("#posname").val(data.name);
				$("#posprice").val(data.price);
				$("#poscpu").val(data.cpu);
				$("#posboard").val(data.board);
				$("#posgraphics").val(data.graphics);
				$("#possata").val(data.sata);
				$("#posssd").val(data.ssd);
				$("#posmemory").val(data.memory);
				$("#posmonitor").val(data.monitor);
				var modify = document.getElementById('modify');
				modify.style.display="block";
				
			},
			error : function(xhr, status, errMsg) {
				alert("修改失败!");
			}
		});
	}
	
	function cancel() {
		var modify = document.getElementById('modify');
		modify.style.display="none";
	}
</script>
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
		<li><a class="active" href="/InternetBarManager/pos">区域管理</a></li>
		<li><a href="/InternetBarManager/bar">连锁门店信息</a></li>
	</ul>
	<div id="content">
		<table class="pos-tab">
			<tr>
				<th style="width: 8%">区域名</th>
				<th style="width: 5%">区域收费/小时</th>
				<th style="width: 10%">CPU配置</th>
				<th style="width: 15%">主板配置</th>
				<th style="width: 20%">显卡配置</th>
				<th style="width: 15%">机械硬盘配置</th>
				<th style="width: 15%">固态硬盘配置</th>
				<th style="width: 10%">内存配置</th>
				<th>显示器配置</th>
			</tr>
			<c:forEach var="p" items="${pos }" varStatus="no">
				<tr onclick="posmodify(${no.count})">
					<td>${p.name }</td>
					<td>${p.price }￥</td>
					<td>${p.cpu }</td>
					<td>${p.board }</td>
					<td>${p.graphics }</td>
					<td>${p.sata }</td>
					<td>${p.ssd }</td>
					<td>${p.memory }</td>
					<td>${p.monitor }</td>
				</tr>

			</c:forEach>
		</table>

	</div>
	<div class="modify" id="modify">
		<form method="post" action="/InternetBarManager/posmodify">
			<table class="pos-modify">
				<tr>
					<td colspan="10" style="text-align: center; font-size: 25px;">区域信息修改</td>
				</tr>
				<tr>
					<td>区域编号：</td>
					<td><input name="posid" id="posid" value="" readonly /></td>
					<td>区域名：</td>
					<td><input name="posname" id="posname" value="" /></td>
					<td>区域收费：</td>
					<td><input name="posprice" id="posprice" value="" />/时</td>
					<td>CPU配置：</td>
					<td><input name="poscpu" id="poscpu" value="" /></td>
					<td>主板配置：</td>
					<td><input name="posboard" id="posboard" value="" /></td>
				</tr>

				<tr>
					<td>显卡配置：</td>
					<td><input name="posgraphics" id="posgraphics" value="" /></td>
					<td>机械硬盘配置：</td>
					<td><input name="possata" id="possata" value="" /></td>
					<td>固态硬盘配置：</td>
					<td><input name="posssd" id="posssd" value="" /></td>
					<td>内存配置：</td>
					<td><input name="posmemory" id="posmemory" value="" /></td>
					<td>显示器配置：</td>
					<td><input name="posmonitor" id="posmonitor" value="" /></td>
				</tr>
				<tr>
					<td colspan="5" style="border: none; text-align: center;"><input
						type="submit" value="确定" /></td>
					<td colspan="5" style="border: none; text-align: center;"><input
						type="button" value="取消" onclick="cancel()"/></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>