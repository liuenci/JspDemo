<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style type="text/css">
#container {
	width: 100%;
	height: 1000px;
}
</style>
</head>
<body>
	<div id="container"></div>
	<script type="text/javascript" src="js/marker.js"></script>
	<script type="text/javascript"
		src="http://webapi.amap.com/maps?v=1.4.0&key=eede59ff2baca809214528113da0adc9"></script>
	<script type="text/javascript">
		//marker点击事件
		function markerClick(e) {
			infoWindow.setContent(e.target.content);
			infoWindow.open(map, e.target.getPosition());
		}
		var infoWindow = new AMap.InfoWindow();
		var map = new AMap.Map('container', {
			zoom : 10
		//new AMap.LngLat(116.39,39.9)
		});
		//设置地图中心级别
		//map.setZoom(100);

		//设置地图中心点
		//map.setCenter([116.39,39.9]);

		//设置地图标记
		/* var marker = new AMap.Marker({
			position : [ 113.16, 27.83 ],//marker所在的位置
			map : map
		//创建时直接赋予map属性
		});
		//也可以在创建完成后通过setMap方法执行地图对象
		marker.setMap(map); */

		//设置地图窗体
		/* var info = new AMap.InfoWindow({
		    content:"湖南工业大学<br>这里是湖南工业大学",
		    offset:new AMap.Pixel(0,-28)
		})
		info.open(map,marker.getPosition()) */

		var markers = []; //province见Demo引用的JS文件
		for (var i = 0; i < provinces.length; i += 1) {
			var marker;
			if (provinces[i].type === 0) {
				var icon = new AMap.Icon({
					image : 'https://vdata.amap.com/icons/b18/1/2.png',
					size : new AMap.Size(24, 24)
				});
				marker = new AMap.Marker({
					icon : icon,
					position : provinces[i].center.split(','),
					offset : new AMap.Pixel(-12, -12),
					zIndex : 101,
					title : provinces[i].name,
					map : map
				});
				marker.content = '我是第' + i + '个信息窗体的内容';
				//给Marker绑定单击事件
				marker.on('click', markerClick);
			} else {
				marker = new AMap.Marker({
					position : provinces[i].center.split(','),
					title : provinces[i].name,
					map : map
				});
				if (provinces[i].type === 2) {
					var content = "<div class = 'taiwan'>宝岛台湾<a href='www.baidu.com'>baidu</a></div>";
					baodao = new AMap.Marker({
						content : content,
						position : provinces[i].center.split(','),
						title : provinces[i].name,
						offset : new AMap.Pixel(0, 0),
						map : map
					});
				}
			}
			markers.push(marker);
			
		}
		map.setFitView();
	</script>
</body>
</html>