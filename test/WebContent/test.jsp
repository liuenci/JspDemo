<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<title>测试地图</title>
<script type="text/javascript"
	src="http://webapi.amap.com/maps?v=1.4.0&key=eede59ff2baca809214528113da0adc9"></script>
<script type="text/javascript"
	src="https://webapi.amap.com/maps?v=1.4.0&key=eede59ff2baca809214528113da0adc9"></script>
<script type="text/javascript">
	//创建地图
	var map = new AMap.Map('container');
	//创建地图的中心点和级别
	var map = new AMap.Map('container', {
		zoom : 11,
		center : [ 116.39, 39.9 ]
	//new AMap.LngLat(116.39,39.9)
	});
	//添加marker点标记
	var marker = new AMap.Marker({
		position : [ 116.480983, 39.989628 ],//marker所在的位置
		map : map
	//创建时直接赋予map属性
	});
	//也可以在创建完成后通过setMap方法执行地图对象
	marker.setMap(map);

	AMap
			.plugin(
					[ 'AMap.ToolBar', 'AMap.AdvancedInfoWindow' ],
					function() {
						//创建并添加工具条控件
						var toolBar = new AMap.ToolBar();
						map.addControl(toolBar);
						//创建高级信息窗体并在指定位置打开
						var infowindow = new AMap.AdvancedInfoWindow(
								{
									content : '<div class="info-title">高德地图</div><div class="info-content">'
											+ '<img src="http://webapi.amap.com/images/amap.jpg">'
											+ '高德是中国领先的数字地图内容、导航和位置服务解决方案提供商。<br>'
											+ '<a target="_blank" href="http://mobile.amap.com/">点击下载高德地图</a></div>',
									offset : new AMap.Pixel(0, -30)
								});
						infowindow.open(map, [ 116.480983, 39.989628 ]);
					})
</script>
<style type="text/css">
#container {
	width: 300px;
	height: 180px;
}
</style>
</head>
<body>
	<div id="container"></div>


	<script>
		var map = new AMap.Map('container', {
			resizeEnable : true,
			zoom : 11,
			center : [ 116.397428, 39.90923 ]
		});
	</script>
</body>
</html>