<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cache.amap.com/lbs/static/main.css" />
<script type="text/javascript"
	src="https://webapi.amap.com/maps?v=1.4.1&key=eede59ff2baca809214528113da0adc9"></script>
	<script type="text/javascript" src="js/marker.js"></script>
</head>
<style type="text/css">
body {
	font-size: 12px;
}

.amap-info-close {
	top: 10px;
}
</style>
<body>
	<div id="mapContainer"></div>
	<script type="text/javascript">
		//初始化地图对象，加载地图
		var map = new AMap.Map("mapContainer", {
			resizeEnable : true,
			zoom : 13
		});
		var lnglats = [ [ 116.37, 39.92 ], [ 116.38, 39.92 ],
				[ 116.39, 39.92 ], [ 116.40, 39.91 ] ];
		var infoWindow = new AMap.InfoWindow({
			offset : new AMap.Pixel(0, -30)
		});
		for (var i = 0, marker; i < provinces.length; i++) {
			var marker = new AMap.Marker({
				position : provinces[i].center.split(','),
				map : map
			});
			marker.content = ""+provinces[i].address+"<div><a href='http://www.baidu.com'>aa</a></div>";
			marker.on('click', markerClick);
			marker.emit('click', {
				target : marker
			});
		}
		function markerClick(e) {
			infoWindow.setContent(e.target.content);
			infoWindow.open(map, e.target.getPosition());
		}
		map.setFitView();
	</script>
	<script type="text/javascript"
		src="https://webapi.amap.com/demos/js/liteToolbar.js"></script>
</body>
</html>