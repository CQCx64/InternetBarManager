<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员密码修改</title>
<link rel="stylesheet" type="text/css" href="/InternetBarManager/css/adpwdmodify.css">
</head>
<body style="background:url('/InternetBarManager/Pic/bc1.jpg');">

	<h1 align="center">请修改密码</h1>
	<hr width = 50% style="height: 5px;border:none;border-top:5px solid black" />
	
	<div id="content">
		<form action="/InternetBarManager/pwdmodify" method="post">
			<table class="pwdModify">
				<tr>
					<td style="text-align: right" width="50%" >管理员账号：</td>
					<td style="text-align: left"><input type="text" name="adminName" readonly value="${adminInfo.name }" /></td>
				</tr>
				<tr>
					<td style="text-align: right">旧&nbsp;&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
					<td style="text-align: left"><input type="password" name="pwdOld" /></td>
				</tr>
				<tr>
					<td style="text-align: right">新&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码：</td>
					<td style="text-align: left"><input type="password" name="pwd" /></td>
				</tr>
				<tr>
					<td style="text-align: right">请确认密码：</td>
					<td style="text-align: left"><input type="password" name="pwdConfirm" /></td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="确定"  class="pwdModify-button"/>
					</td>
					<td>
						<input type="reset" value="重置"  class="pwdModify-button"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
</body>
</html>