<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
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
	href="/InternetBarManager/css/userinfo.css">
<title>会员信息管理</title>

<link rel="stylesheet" href="css/notifications.css">
<script type="text/javascript" src="../jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/call.js"></script> 
<script type="text/javascript">
	function openWindow(url) {
		window
				.open(
						url,
						'添加新会员',
						'height=680, width=1000, top=0, left=0,toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no');
	}
	function openAlert(message) {
		alert(message);
	}
	function Action(url) {
		document.search.action = url;
		document.search.submit();
	}
</script>

</head>
<body style="background: url('/InternetBarManager/Pic/bc.jpg');">

	<ul class="nav">
		<li><a href="/InternetBarManager/index">主页</a></li>
		<li><a class="active" href="/InternetBarManager/userquery">会员管理</a></li>
		<li><a href="/InternetBarManager/comquery">机器管理</a></li>
		<li style="float: right"><a href="">关于</a></li>
		<li style="float: right" class="drop-down"><a href="">管理员：${adminInfo.name }</a>
			<ul class="drop-down-content">
				<li><a href="/InternetBarManager/pages/AdPwdModify.jsp">更改密码</a></li>
				<li><a href="/InternetBarManager/logout">注销</a></li>
			</ul></li>
		<li><a href="/InternetBarManager/pos">区域管理</a></li>
		<li><a href="/InternetBarManager/bar">连锁门店信息</a></li>
	</ul>

	<div class="user-search">
		<form name="search" style="width: 97%" method="post">
			<label style="font-size: 18px; color: white;">会员卡号：</label> <input
				type="text" name="txtUserId"
				<c:if test="${queryID=='0' }">value=""</c:if>
				<c:if test="${queryID!='0' }">value="${queryID }"</c:if> /> <label
				style="font-size: 18px; color: white;">会员姓名：</label> <input
				type="text" name="txtUserName"
				<c:if test="${queryName==null }">value=""</c:if>
				<c:if test="${queryName!=null }">value="${queryName }"</c:if> /> <input
				type="submit" name="btnSearch"
				onclick="Action('/InternetBarManager/userquery')" value="快速搜索"
				class="user-button" style="margin-left: 30px; width: 80px;" /> <input
				type="submit" name="btnRefresh"
				onclick="Action('/InternetBarManager/refresh')" value="刷新"
				class="user-button" style="margin-left: 15px; width: 80px;" /> <input
				type="button" name="btnAdd" value="添加新会员"
				onclick="Action('/InternetBarManager/pages/UserAdd.jsp')"
				class="user-button" style="float: right; width: 100px;" />
		</form>
	</div>

	<div class="user-info">
		<table width="100%">
			<tr>
				<th width="8%">会员卡号</th>
				<th width="8%">会员姓名</th>
				<th width="6%">性别</th>
				<th width="6%">年龄</th>
				<th width="12%">注册日期</th>
				<th width="15%">身份证号</th>
				<th width="12%">手机号</th>
				<th width="12%">上一次来访日期</th>
				<th width="8%">账户余额</th>
				<th>操作</th>
			</tr>

			<c:if test="${empty user_page }">
				<td colspan="10" style="font-size: 12pt">没有查到数据</td>
			</c:if>

			<c:if test="${not empty user_page }">
				<c:forEach var="u" items="${user_page }">
					<tr>
						<td>${u.id+10000 }</td>
						<td>${u.name }</td>
						<td>${u.sex }</td>
						<td>${u.age }</td>
						<td>${u.registerdate }</td>
						<td>${u.idnumber }</td>
						<td>${u.phone }</td>
						<td><c:if test="${u.lastdate==null }">暂无上一次到访</c:if> <c:if
								test="${u.lastdate!=null }">${u.lastdate }</c:if></td>
						<td>${u.money }</td>
						<td><input type="button" value="修改" class="user-button"
							onclick="Action('/InternetBarManager/usermodifypre?userid=${u.id }')" />
							<input type="button" value="删除" class="user-button"
							onclick="Action('/InternetBarManager/userdelete?userid=${u.id }')" />
						</td>
					</tr>
				</c:forEach>
			</c:if>


		</table>
		<p class="paging" style="margin-bottom: 5px;">
			<a href="/InternetBarManager/pagedo?page=${paging.indexpage-1}">&lt;&lt;首页
			</a>&nbsp;&nbsp; <a
				href="/InternetBarManager/pagedo?page=${paging.page-1 }">&lt;上一页</a>&nbsp;&nbsp;
			<strong>&nbsp;&nbsp;第${paging.page+1}页
				&nbsp;&nbsp;/&nbsp;&nbsp;共${paging.pagenumber}页 &nbsp;&nbsp;</strong> <a
				href="/InternetBarManager/pagedo?page=${paging.page+1}">下一页 &gt;</a>&nbsp;&nbsp;
			<a href="/InternetBarManager/pagedo?page=${paging.pagenumber-1}">末页
				&gt;&gt;</a>
		</p>
		<br>
	</div>
</body>
</html>