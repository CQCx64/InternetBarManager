<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎使用网咖管理系统</title>

<link rel="stylesheet" type="text/css" href="/InternetBarManager/css/navi.css">
<link rel="stylesheet" type="text/css" href="/InternetBarManager/css/index.css">
<link rel="stylesheet" href="css/notifications.css">
<script type="text/javascript" src="../jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/call.js"></script> 
<script type="text/javascript">
	
	
	function display(clock){
	    var now=new Date();   //创建Date对象
	    var year=now.getFullYear(); //获取年份
	    var month=now.getMonth(); //获取月份
	    var date=now.getDate();  //获取日期
	    var day=now.getDay();  //获取星期
	    var hour=now.getHours(); //获取小时
	    var minu=now.getMinutes(); //获取分钟
	    var sec=now.getSeconds(); //获取秒钟
	    month=month+1;
	    var arr_week=new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六");
	    var week=arr_week[day];  //获取中文的星期
	    var time=year+"年"+month+"月"+date+"日 "+week+" "+hour+":"+minu+":"+sec; //组合系统时间
	    clock.innerHTML="现在是："+time; //显示系统时间
	}
	window.onload=function(){
	    window.setInterval("display(clock)", 1000);
	    
	}
</script>
</head>
<body style="background:url('/InternetBarManager/Pic/bc.jpg');">

	<ul class="nav">
		<li><a class="active" href="/InternetBarManager/index">主页</a></li>
		<li><a href="/InternetBarManager/userquery">会员管理</a></li>
		<li><a href="/InternetBarManager/comquery">机器管理</a></li>
		<li style="float: right"><a href="">关于</a></li> 
		<li style="float: right" class="drop-down"><a href="">管理员：${adminInfo.name }</a>
			<ul class="drop-down-content">
				<li><a href="/InternetBarManager/pages/AdPwdModify.jsp">更改密码</a></li>
				<li><a href="/InternetBarManager/logout">注销</a></li>
			</ul>
		</li>
		<li><a href="/InternetBarManager/pos">区域管理</a></li>
		<li><a href="/InternetBarManager/bar">连锁门店信息</a></li>
	</ul>
	
	<div>
		<div align=center style="text-shadow:1px 1px 1px #000;margin-top:5%;margin-bottom:2%;font-size: 50px;color :#363636;font-weight: bold;">欢迎使用网咖管理系统</div>
	</div>
	
	<hr width = 800px style="height: 5px;border:none;border-top:5px solid black"/> 
	
	<div id="content">
	
		<label class="index-welcome">
			<span style="display:block;float: left;margin-left: 12px;">你好，admin</span>
			<span id="clock"style="display:block;float: right;margin-right: 12px;"></span>
		</label>
		
		<hr class="index-hr"/>
		
		<div class="index-title">
			<label>
				<span>今日公告</span>
			</label>
		</div>
		
		<div class="index-notice">
			<c:forEach var="n" items="${adminnnotes }">
			<p>
				<span>● ${n.detail }</span>
			</p>
			</c:forEach>
		</div>
		
			<hr class="index-hr" style="margin-left:0px;"/>
			<span class="index-info">已有${unum }名用户成为会员，当前有${cnum }人上机</span>
	</div>
	
</body>
</html>