var bars;

$(function() {
	$.ajax({
		url : "/InternetBarManager/map",
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		async : false, // 是否为异步请求
		cache : false, // 是否缓存结果
		type : "get",
		dataType : "json",
		data : "",
		success : function(data, textStatus) {
			// Result为后端post函数传递来的数据，这里写结果操作代码
			bars = data.bars;
			initMap(bars);// 创建和初始化地图
		},
		error : function(xhr, status, errMsg) {
			alert("修改失败!");
		}
	});

});



function initMap(bars) {
	for (var i = 0; i < bars.length; i++) {
		createMap(bars[i].id,bars[i].x,bars[i].y);// 创建地图
		setMapEvent();// 设置地图事件
		addMapControl();// 向地图添加控件
		var markerArr = [ {
			title : "11",
			content : "11",
			point : "11",
			isOpen : 0,
			icon : {
				w : 21,
				h : 21,
				l : 0,
				t : 0,
				x : 6,
				lb : 5
			}
		} ];
		markerArr[0].title = bars[i].name;
		markerArr[0].content = bars[i].address;
		markerArr[0].point = bars[i].x + "|" + bars[i].y ;
		addMarker(markerArr);// 向地图中添加marker
	}
	
}

// 创建地图函数：
function createMap(id,x,y) {
	var map = new BMap.Map("dituContent_"+id);// 在百度地图容器中创建一个地图
	var point = new BMap.Point(x, y);// 定义一个中心点坐标
	map.centerAndZoom(point, 15);// 设定地图的中心点和坐标并将地图显示在地图容器中
	window.map = map;// 将map变量存储在全局
}

// 地图事件设置函数：
function setMapEvent() {
	map.enableDragging();// 启用地图拖拽事件，默认启用(可不写)
	map.enableScrollWheelZoom();// 启用地图滚轮放大缩小
	map.enableDoubleClickZoom();// 启用鼠标双击放大，默认启用(可不写)
	map.enableKeyboard();// 启用键盘上下左右键移动地图
}

// 地图控件添加函数：
function addMapControl() {
	// 向地图中添加缩放控件
	var ctrl_nav = new BMap.NavigationControl({
		anchor : BMAP_ANCHOR_TOP_LEFT,
		type : BMAP_NAVIGATION_CONTROL_SMALL
	});
	map.addControl(ctrl_nav);
	// 向地图中添加缩略图控件
	var ctrl_ove = new BMap.OverviewMapControl({
		anchor : BMAP_ANCHOR_BOTTOM_RIGHT,
		isOpen : 0
	});
	map.addControl(ctrl_ove);
	// 向地图中添加比例尺控件
	var ctrl_sca = new BMap.ScaleControl({
		anchor : BMAP_ANCHOR_BOTTOM_LEFT
	});
	map.addControl(ctrl_sca);
}

// 标注点数组

// 创建marker
function addMarker(markerArr) {
	for (var i = 0; i < markerArr.length; i++) {
		var json = markerArr[i];
		var p0 = json.point.split("|")[0];
		var p1 = json.point.split("|")[1];
		var point = new BMap.Point(p0, p1);

		var iconImg = createIcon(json.icon);
		var marker = new BMap.Marker(point, {
			icon : iconImg
		});
		var ar = markerArr;
		var iw = createInfoWindow(i,ar);
		var label = new BMap.Label(json.title, {
			"offset" : new BMap.Size(json.icon.lb - json.icon.x + 10, -20)
		});
		marker.setLabel(label);
		map.addOverlay(marker);
		label.setStyle({
			borderColor : "#808080",
			color : "#333",
			cursor : "pointer"
		});

		(function() {
			var index = i;
			var _arr = markerArr;
			var _iw = createInfoWindow(i,_arr);
			var _marker = marker;
			_marker.addEventListener("click", function() {
				this.openInfoWindow(_iw);
			});
			_iw.addEventListener("open", function() {
				_marker.getLabel().hide();
			})
			_iw.addEventListener("close", function() {
				_marker.getLabel().show();
			})
			label.addEventListener("click", function() {
				_marker.openInfoWindow(_iw);
			})
			if (!!json.isOpen) {
				label.hide();
				_marker.openInfoWindow(_iw);
			}
		})()
	}
}
// 创建InfoWindow
function createInfoWindow(i,arr) {
	var json = arr[i];
	var iw = new BMap.InfoWindow("<b class='iw_poi_title' title='" + json.title
			+ "'>" + json.title + "</b><div class='iw_poi_content'>"
			+ json.content + "</div>");
	return iw;
}
// 创建一个Icon
function createIcon(json) {
	var icon = new BMap.Icon("http://localhost:8080/InternetBarManager/Pic/map.png",
			new BMap.Size(json.w, json.h), {
				imageOffset : new BMap.Size(-json.l, -json.t),
				infoWindowOffset : new BMap.Size(json.lb + 5, 1),
				offset : new BMap.Size(json.x, json.h)
			})
	return icon;
}


