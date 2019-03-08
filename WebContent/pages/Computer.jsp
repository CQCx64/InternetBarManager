<%@page import="com.ibm.entity.Com"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="css/notifications.css">
<script type="text/javascript" src="../jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/call.js"></script> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>机器管理</title>
<link rel="stylesheet" type="text/css"
	href="/InternetBarManager/css/navi.css">
<link rel="stylesheet" type="text/css"
	href="/InternetBarManager/css/cominfo.css">
<script type="text/javascript">
		function Action(url){
			document.com.action= url;
			document.com.submit();
		}
		function ActionFast(url){
			document.comfast.action= url;
			document.comfast.submit();
		}
</script>
</head>
<body style="background: url('/InternetBarManager/Pic/bc.jpg');">

	<ul class="nav">
		<li><a href="/InternetBarManager/index">主页</a></li>
		<li><a href="/InternetBarManager/userquery">会员管理</a></li>
		<li><a class="active" href="/InternetBarManager/comquery">机器管理</a></li>
		<li style="float: right"><a href="">关于</a></li>
		<li style="float: right" class="drop-down"><a href="">管理员：${adminInfo.name }</a>
			<ul class="drop-down-content">
				<li><a href="/InternetBarManager/pages/AdPwdModify.jsp">更改密码</a></li>
				<li><a href="/InternetBarManager/logout">注销</a></li>
			</ul></li>
		<li><a href="/InternetBarManager/pos">区域管理</a></li>
		<li><a href="/InternetBarManager/bar">连锁门店信息</a></li>
	</ul>

	<div class="com-power">
		<form style="width: 94%" method="post" name="comfast">
			<label style="font-size: 18px; color: white;">会员卡号：</label> <input
				type="text" name="txtUserId" /> <input type="submit" name="powerOn"
				value="快速上机" class="com-button" style="float: right; width: 100px;"
				onclick="ActionFast('/InternetBarManager/fastpower?info=1')" /> <span
				style="float: right;">&nbsp;&nbsp;&nbsp;&nbsp;</span> <input
				type="submit" name="powerOFF" value="快速下机" class="com-button"
				style="float: right; width: 100px;"
				onclick="ActionFast('/InternetBarManager/fastpower?info=2')" />
		</form>
	</div>
	<div id="content">
		<form method="post" name="com">
			<table class="com-table">
				<tr class="com-table-title" style="height: 80px">
					<td colspan="10">&nbsp;&nbsp;&nbsp;&nbsp;大厅对战区 ——— 4元每小时</td>
				</tr>
				<tr>
					<c:forEach var="c" items="${coms1 }">
						<td>
							<div class="dropdown">
								${c.id }号机 <br /> <img
									<c:if test="${c.status=='1'}">src="/InternetBarManager/Pic/comOn.png" alt="已开机" style="width:100%;"</c:if>
									<c:if test="${c.status=='0'}">src="/InternetBarManager/Pic/comOff.png" alt="已关机" style="width:100%;"</c:if> />
								<br />
								<c:if test="${c.status=='1'}">
									<input class="com-button" type="submit" value="强制下机"
										onclick="Action('/InternetBarManager/power?cid='+${c.id }+'&&info=1')" />
								</c:if>
								<c:if test="${c.status=='0'}">
									<input class="com-button" type="submit" value="无人使用" />
								</c:if>

								<div class="dropdown-content">
									<c:if test="${c.status=='0' }">
										<p>
											<input type="text" name="userid_${c.id }"
												placeholder="请输入会员卡号" class="dropdown-text" />
										</p>
										<p>
											<input class="com-button" type="submit" value="上机"
												onclick="Action('/InternetBarManager/power?cid='+${c.id }+'&&info=2')">
										</p>

									</c:if>
									<c:if test="${c.status=='1' }">
										<p>${c.user.getId()+10000 }号会员</p>
										<p>
											于
											<fmt:formatDate value="${c.starttime }"
												pattern="yyyy-MM-dd HH:mm:ss" />
											上机
										</p>
									</c:if>

								</div>

							</div>
						</td>

					</c:forEach>
				</tr>

				<tr class="com-table-title" style="height: 80px">
					<td colspan="10">&nbsp;&nbsp;&nbsp;&nbsp;豪华电竞区 ——— 6元每小时</td>
				</tr>

				<tr>
					<c:forEach var="c" items="${coms2 }">
						<td colspan="2">
							<div class="dropdown">
								${c.id }号机 <br /> <img
									<c:if test="${c.status=='1'}">src="/InternetBarManager/Pic/comOn.png" alt="已开机"</c:if>
									<c:if test="${c.status=='0'}">src="/InternetBarManager/Pic/comOff.png" alt="已关机"</c:if> />
								<br />
								<c:if test="${c.status=='1'}">
									<input class="com-button" type="submit" value="强制下机"
										onclick="Action('/InternetBarManager/power?cid='+${c.id }+'&&info=1')" />
								</c:if>
								<c:if test="${c.status=='0'}">
									<input class="com-button" type="submit" value="无人使用" />
								</c:if>

								<div class="dropdown-content">
									<c:if test="${c.status=='0' }">
										<p>
											<input type="text" name="userid_${c.id }"
												placeholder="请输入会员卡号" class="dropdown-text" />
										</p>
										<p>
											<input class="com-button" type="submit" value="上机"
												onclick="Action('/InternetBarManager/power?cid='+${c.id }+'&&info=2')">
										</p>

									</c:if>
									<c:if test="${c.status=='1' }">
										<p>${c.user.getId()+10000 }号会员</p>
										<p>
											于
											<fmt:formatDate value="${c.starttime }"
												pattern="yyyy-MM-dd HH:mm:ss" />
											上机
										</p>
									</c:if>
								</div>

							</div>
						</td>

					</c:forEach>
				</tr>

				<tr class="com-table-title" style="height: 80px">
					<td colspan="10"><input type="button" value="下 一 页"
						class="com-button"
						onclick="javascrtpt:window.location.href='/InternetBarManager/pages/Computer1.jsp'"
						style="font-size: 16px; width: 10%; font-weight: bold" /></td>
				</tr>
			</table>

		</form>
	</div>
</body>
</html>