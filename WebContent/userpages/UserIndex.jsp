<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎光临本网咖</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/navi.css">
<script type="text/javascript">
	var moneyAll = 0;
	function Action(url){
		document.call.action= url;
		document.call.submit();
	}
	
	function recharge(url){
		document.re.action= url;
		document.re.submit();
	}
	function wifi(){
		alert('WIFI账号：abc---WIFI密码：123456');
	}
	
	
	
	function display(clock) {
		var now = new Date(); //创建Date对象
		var year = now.getFullYear(); //获取年份
		var month = now.getMonth(); //获取月份
		var date = now.getDate(); //获取日期
		var day = now.getDay(); //获取星期
		var hour = now.getHours(); //获取小时
		var minu = now.getMinutes(); //获取分钟
		var sec = now.getSeconds(); //获取秒钟
		month = month + 1;
		if (hour >= 0 && hour <= 9) {
			hour = "0" + hour;
		}
		if (month >= 0 && month <= 9) {
			month = "0" + month;
		}
		if (date >= 0 && date <= 9) {
			date = "0" + date;
		}
		if (minu >= 0 && minu <= 9) {
			minu = "0" + minu;
		}
		if (sec >= 0 && sec <= 9) {
			sec = "0" + sec;
		}
		var time = year + "-" + month + "-" + date + " " + hour + ":" + minu
				+ ":" + sec; //组合系统时间
		clock.innerHTML = time; //显示系统时间
	}

	function getTime(timeGap) {
		var stime = Date.parse(new Date('${userCom.starttime }'));
		var etime = (new Date()).valueOf();
		var usedTime = etime - stime; //两个时间戳相差的毫秒数  
		var days = Math.floor(usedTime / (24 * 3600 * 1000));
		//计算出小时数  
		var leave1 = usedTime % (24 * 3600 * 1000); //计算天数后剩余的毫秒数  
		var hours = Math.floor(leave1 / (3600 * 1000));
		//计算相差分钟数  
		var leave2 = leave1 % (3600 * 1000); //计算小时数后剩余的毫秒数  
		var minutes = Math.floor(leave2 / (60 * 1000));
		var minutes1 = minutes / 60;
		/* minutes1 =minutes1.toFixed(2) */
		minutes1 = Math.round(minutes1 * 100) / 100;
		var time1 = days + "天" + hours + "小时" + minutes + "分 ";
		var time2 = days * 24 + hours + minutes1;
		var price = "${userPos.price }" ;
		moneyAll = price*time2;
		timeGap.innerHTML = time1 + "( 共 " + time2 + " 小时 )" + "<br><br>本次消费：" + moneyAll + "￥";
	}

	function checkOut(){
		var uid='${userInfo.id}';
		var cid='${userCom.id}';
		var allMoney = Math.round(moneyAll);
		window.location.href='/InternetBarManager/checkout?moneyall=' + allMoney + '&&uid=' + uid + '&&cid=' +cid;
	}
	
	window.onload = function() {
		window.setInterval("display(clock)", 1000);
		window.setInterval("getTime(timeGap)", 1000);
	}
</script>
</head>
<body>
	<%-- <c:if test="${userInfo.canuse=='0' }">
		<%
			out.print(
						"<script>alert('您没有上机权限！');window.location.href='/InternetBarManager/UserLogin.jsp'</script>");
		%>
	</c:if> --%>
	<div class="content">
		<div class="nav">
			<ul>
				<li style="float: left; width: 20%;"><a href="">欢迎光临本网咖</a></li>
				<li style="float: right"><a href="">关于</a></li>
				<li style="float: right"><a href="">欢迎光临，${userInfo.name }</a></li>
			</ul>
		</div>
		<div class="left"
			style="width: 20%; float: left; color: white; font-size: 20px">
			<div class="user-info">
				<div style="text-align: center; font-size: 25px; font-weight: bold">用户信息</div>
				<div style="margin-top: 20px">您正在使用No.00${userCom.id }号机器</div>
				<div style="margin-top: 10px">使用会员：${userInfo.name }</div>
				<div style="margin-top: 10px">会员卡号：${userInfo.id+10000 }</div>
				<div style="margin-top: 10px">
					开始使用时间：
					<fmt:formatDate value="${userCom.starttime }"
						pattern="yyyy-MM-dd HH:mm:ss" />
				</div>
				<div style="margin-top: 10px">
					当前时间：<label id="clock" style=""></label>
				</div>
				<div style="margin-top: 10px">
					已使用：<label id="timeGap" style=""></label>
				</div>

				<div style="margin-top: 50px">现有会员${usernum }人,当前有${comnum }人上机</div>
				<div style="margin-top: 50px">请文明上网，爱护公共文明</div>
			</div>
			<div class="recharge">
				<div style="text-align: center; font-size: 25px; font-weight: bold">快速充值</div>
				<div style="margin-top: 25px">当前余额：${userInfo.money }￥</div>
				<form method="post" name="re">
					<input type="button" class="btn-recharge" value="10￥"
						onclick="recharge('/InternetBarManager/recharge?money=10&&uid='+${userInfo.id})" />
					<input type="button" class="btn-recharge" value="20￥"
						onclick="recharge('/InternetBarManager/recharge?money=20&&uid='+${userInfo.id})" />
					<input type="button" class="btn-recharge" value="50￥"
						onclick="recharge('/InternetBarManager/recharge?money=50&&uid='+${userInfo.id})" />
					<input type="button" class="btn-recharge" value="100￥"
						onclick="recharge('/InternetBarManager/recharge?money=100&&uid='+${userInfo.id})" />
					<input type="text" name="moneyany" class="btn-text"
						placeholder="任意金额" /> <input type="button" class="btn-recharge"
						style="width: 25%; margin-left: 7.6%" value="确定"
						onclick="recharge('/InternetBarManager/recharge?money=any&&uid='+${userInfo.id})" />
				</form>
			</div>

		</div>

		<div class="apps">
			<ul class="tabs">
				<li><input type="radio" name="tabs" id="tab1" checked /> <label
					for="tab1">热门游戏</label>
					<div id="tab-content1" class="tab-content">
						<table class="apps-detail" cellspacing="25">

							<tr>
								<c:forEach var="app" items="${apps2 }" varStatus="status">

									<td><a href="${app.url }"> <img src="${app.icon }"></img>
									</a> <span>${app.appname }</span></td>
									<c:if test="${status.count%7==0}">
							</tr>
							<tr>
								</c:if>
								</c:forEach>
							</tr>

						</table>
					</div></li>

				<li><input type="radio" name="tabs" id="tab2" /> <label
					for="tab2">实用软件</label>
					<div id="tab-content2" class="tab-content">
						<table class="apps-detail" cellspacing="25">

							<tr>
								<c:forEach var="app" items="${apps1 }" varStatus="status">

									<td><a href="${app.url }"> <img src="${app.icon }"></img>
									</a> <span>${app.appname }</span></td>
									<c:if test="${status.count%7==0}">
							</tr>
							<tr>
								</c:if>
								</c:forEach>
							</tr>
						</table>
					</div></li>
			</ul>
		</div>

		<div class="bottom">

			<form name="call" method="post">
				<div class="call-div"
					onclick="Action('/InternetBarManager/call?cid='+${userCom.id })">
					<img src="../Pic/call.png"> <span>&nbsp;&nbsp;呼叫服务</span>
				</div>
				<div class="call-div"
					onclick="wifi()">
					<img src="../Pic/wifi.png"> <span>&nbsp;&nbsp;免费WIFI</span>
				</div>
				<div class="call-div"
					onclick="checkOut()">
					<img src="../Pic/poweroff.png"> <span>&nbsp;&nbsp;自主下机</span>
				</div>
			</form>

		</div>
	</div>

</body>
</html>