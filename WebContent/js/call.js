var cidold = 0;
var cidnew = 0;
$(document).ready(function() {
	$('.close').click(function() {
		var box = $(this).parent();
		box.addClass('inactive');
		window.setTimeout(function() {
			box.remove()
		}, 700);
	})
});

var fireNotification = function(config) {
	$('body').append(
			'<aside class="notification-' + config.type + ' ' + config.position
					+ ' animation-' + config.animation + '"><img alt="" src="'
					+ config.img + '"/><h1>' + config.heading + '</h1><p>'
					+ config.text
					+ '</p><button class="close">Close</button></aside>');

	$('.close').click(function() {
		var box = $(this).parent();
		box.addClass('inactive');
		window.setTimeout(function() {
			box.remove()
		}, 700)
	})
}


function refresh() {
	if (cidnew==0&&cidold==0) {
		showBox("暂无");
		cidold=-1;
		cidnew=-1;
		return;
	}
	$.ajax({
		url : "/InternetBarManager/call",
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		async : true, // 是否为异步请求
		cache : false, // 是否缓存结果
		type : "get",
		data : "",
		success : function(data, textStatus) {
			// Result为后端post函数传递来的数据，这里写结果操作代码
			if (data.cid!=null) {
				cidnew = data.cid;
			}
			if (cidold != cidnew) {
				cidold = cidnew;
				showBox(cidnew+"号");
				return;
			}
			

		},
		error : function(xhr, status, errMsg) {
			alert("初始化失败!");
		}
	});
}
setInterval("refresh()", 3000);

function showBox(cid) {
	fireNotification({
		position : "bottomright",
		animation : "fadedown",
		type : "info",
		img : "",
		heading : "呼叫服务",
		text : cid + "机器呼叫网管"
	});
}