<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎光临本网咖</title>
<!-- <link rel="stylesheet" type="text/css" href="css/zzsc.css"> -->
<link rel="stylesheet" href="src/jquery.skidder.css">
<link rel="stylesheet" type="text/css" href="css/navi.css">
<style>
.wrapper {
	background: #50a3a2;
	background: -webkit-linear-gradient(top left, #50a3a2 0%, #53e3a6 100%);
	background: linear-gradient(to bottom right, #50a3a2 0%, #53e3a6 100%);
	background-size: 100% 100%;
	height: 960px;
	left: 0;
	width: 100%;
}
</style>
<script type="text/javascript" src="jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$.ajax({
			url : "preUserLogin",
			async : true, //是否为异步请求
			cache : false, //是否缓存结果
			type : "post",
			data : "",
			success : function(Result) {
				//Result为后端post函数传递来的数据，这里写结果操作代码
			},
			error : function(xhr, status, errMsg) {
				alert("初始化失败!");
			}
		});
	});

	function showDetail() {
		var posno = 0;
		x = document.getElementById("detail");
		y = $("#comNotUse").val();
		if (y >= 1 && y <= 10) {
			posno = 1;
		} else if (y >= 11 && y <= 15) {
			posno = 2;
		} else if (y >= 16 && y <= 20) {
			posno = 3;
		} else if (y >= 21 && y <= 26) {
			posno = 4;
		}
		$.ajax({
			url : "/InternetBarManager/posmodify",
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			async : true, // 是否为异步请求
			cache : false, // 是否缓存结果
			type : "get",
			dataType : "json",
			data : {
				posno : posno
			},
			success : function(data, textStatus) {
				// Result为后端post函数传递来的数据，这里写结果操作代码
				x.innerHTML = y + "号机机器配置<br><hr>CPU：" + data.cpu + "<br>主板："
						+ data.board + "<br>" + "显卡：" + data.graphics
						+ "<br>内存：" + data.memory + "<br>硬盘：" + data.sata
						+ "<br>SSD：" + data.ssd + "<br>显示器：" + data.monitor
						+ "<hr>"
						+ "<div style='font-weight:bold;color:black'>"
						+ data.price + "￥/每小时</div>";

			},
			error : function(xhr, status, errMsg) {
				alert("请选择机器!");
			}
		});

	}
</script>
</head>
<body>
	<div class="wrapper">
		<c:if test="${param.info==1 }">
			<%
				out.print("<script>alert('密码错误！')</script>");
			%>
		</c:if>
		<c:if test="${param.info==2 }">
			<%
				out.print("<script>alert('查无此账户！')</script>");
			%>
		</c:if>
		<c:if test="${param.info==3 }">
			<%
				out.print("<script>alert('请去前台激活自主上网权限！')</script>");
			%>
		</c:if>
		<form action="userlogin" method="post">
			<ul>
				<li style="float: left; width: 20%;"><a href="">欢迎光临本网咖</a></li>
				<li style="float: right"><a href="">关于</a></li>
				<li style="float: right"><a href="">未登录</a></li>
			</ul>

			<div class="left"
				style="width: 20%; float: left; color: white; font-size: 20px">
				<div class="bar-info"
					style="height: 300px; background: rgba(119, 136, 153, 0.25); padding: 10px 25px">
					<div style="text-align: center; font-size: 25px; font-weight: bold">门店信息</div>
					<div style="margin-top: 20px">No.00${barInfo.bid}
						&nbsp;&nbsp;&nbsp;&nbsp; ${barInfo.bname }</div>
					<div style="margin-top: 10px">地址：${barInfo.baddress }</div>
					<div style="margin-top: 50px">现有会员${usernum }人,当前有${comnum }人上机</div>
					<div style="margin-top: 50px">请文明上网，爱护公共文明</div>
				</div>
				<div class="com-info"
					style="margin-top: 10px; height: 550px; background: rgba(119, 136, 153, 0.25); padding: 10px 10px">
					<div style="width: 45%; margin: 0 auto">
						<img src='Pic/comOff.png' style="width: 100%;"></img>
					</div>
					<div style="width: 80%; margin: 0 auto; text-align: center">
						<div style="float: left">请选择机器：</div>

						<div>
							<select name="comNotUse" id="comNotUse" onchange="showDetail()"
								style="width: 45%; height: 30px; border: none; background: #ccc; border-radius: 6px;">
								<option value=''>-请选择-</option>
								<c:forEach var="c" items="${comNotUse }">
									<option value='${c.id }'>${c.id }号机</option>
								</c:forEach>
							</select>
						</div>

						<div style="margin-top: 6%;">
							<label id="detail"></label>
						</div>
					</div>
				</div>
			</div>


			<div class="slideshow"
				style="height: 750px; overflow: hidden; background: black; width: 79%; margin: 0.5% auto;">
				<div class="slide">
					<img src="./Pic/zzh.jpg">
				</div>
				<div class="slide">
					<img src="./Pic/2.jpg">
				</div>
				<div class="slide">
					<img src="./Pic/3.jpg">
				</div>
				<div class="slide">
					<img src="./Pic/4.jpg">
				</div>
				<div class="slide">
					<img src="./Pic/5.jpg">
				</div>
			</div>
			<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
			<script src="js/imagesloaded.js"></script>
			<script src="js/smartresize.js"></script>
			<script src="src/jquery.skidder.js"></script>
			<script type="text/javascript">
				$('.slideshow').each(function() {
					var $slideshow = $(this);
					$slideshow.imagesLoaded(function() {
						$slideshow.skidder({
							slideClass : '.slide',
							animationType : 'css',
							scaleSlides : true,
							maxWidth : 1300,
							maxHeight : 750,
							paging : true,
							autoPaging : true,
							pagingWrapper : ".skidder-pager",
							pagingElement : ".skidder-pager-dot",
							swiping : true,
							leftaligned : false,
							cycle : true,
							jumpback : false,
							speed : 400,
							autoplay : false,
							autoplayResume : false,
							interval : 4000,
							transition : "slide",
							afterSliding : function() {
							},
							afterInit : function() {
							}
						});
					});
				});
			</script>

			<div class="warning"
				style="width: 35%; background: rgba(119, 136, 153, 0.25); padding: 10px 10px; margin-left: 0.5%; height: 290px; font-size: 21px; text-align: center; float: left">
				<p style="font-size: 23px; font-weight: bold; color: #EE7600">安全上网须知</p>
				<hr>
				<p>抵制不良游戏 拒绝盗版游戏</p>
				<p>注意自我保护 谨防受骗上当</p>
				<p>适度游戏益脑 沉迷游戏伤身</p>
				<p>合理安排时间 享受健康生活</p>
			</div>

			<div class="notice"
				style="width: 41.5%; background: rgba(119, 136, 153, 0.25); padding: 10px 10px; margin-left: 57%; height: 290px; font-size: 21px;">
				<p
					style="font-size: 23px; font-weight: bold; color: #EE7600; text-align: center">今日活动</p>
				<hr>
				<c:forEach var="n" items="${usernotes }">
				<p style="margin-left: 25%">${n.detail }</p>
				</c:forEach>
			</div>

			<div id="content"
				style="width: 78%; background: rgba(119, 136, 153, 0.25); padding: 10px 10px; margin-left: 20.5%; margin-top: 0.5%; height: 40px; font-size: 25px;">
				<div class="login-header" style="float: left">
					<span style="color: white">请使用身份证登录,并确保已激活上机权限</span>
				</div>

				<div class="login-button-box"
					style="float: right; width: 15%; height: 40px">
					<input type="submit" value="开始上机"
						style="color: white; width: 100%; height: 40px; font-size: 18px; border-radius: 5px; background: #EE7600; border: none; box-shadow: 0px 0px 5px black"></input>
				</div>

				<div class="login-input-box"
					style="float: right; width: 15%; height: 40px; margin-right: 1%;">
					<span class="icon icon-password"></span> <input type="password"
						name="password" placeholder="请输入密码 "
						style="width: 100%; height: 35px; font-size: 18px; background: #ccc; border: 1px solid #ddd; border-radius: 5px; box-shadow: 0px 0px 5px black" />
				</div>

				<div class="login-input-box"
					style="float: right; width: 15%; height: 40px; margin-right: 1%;">
					<span class="icon icon-user"></span> <input type="text"
						name="txtID" placeholder="请输入身份证号"
						style="width: 100%; height: 35px; font-size: 18px; background: #ccc; border: 1px solid #ddd; border-radius: 5px; box-shadow: 0px 0px 5px black" />
				</div>
				<div class="remember-box">
					<!-- <label>
		            <input type="checkbox">&nbsp;记住密码
		        </label> -->
				</div>


			</div>
		</form>
	</div>
</body>
</html>