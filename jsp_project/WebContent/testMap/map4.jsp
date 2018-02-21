<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body, html, #container {
	height: 100%;
	margin: 0px;
	font: 12px Helvetica, 'Hiragino Sans GB', 'Microsoft Yahei', '微软雅黑',
		Arial;
}

.info-title {
	color: white;
	font-size: 14px;
	background-color: rgba(0, 155, 255, 0.8);
	line-height: 26px;
	padding: 0px 0 0 6px;
	font-weight: lighter;
	letter-spacing: 1px
}

.info-content {
	padding: 4px;
	color: #666666;
	line-height: 23px;
}

.info-content img {
	float: left;
	margin: 3px;
}
</style>
<script type="text/javascript"
	src="https://webapi.amap.com/maps?v=1.4.1&key=f037938c4321cc6d99a6bd05e09d986c"></script>
</head>
<body>
	<div id="container" tabindex="0"></div>
	<div id='panel'></div>
	<script type="text/javascript"
		src="https://webapi.amap.com/maps?v=1.4.1&key=您申请的key值"></script>
	<script type="text/javascript">
		var map = new AMap.Map('container', {
			resizeEnable : true,
			zoom : 10,
			center : [ 116.48, 40.10 ]
		});
		for (var i = 0, marker; i < provinces.length; i++) {
			var marker = new AMap.Marker({
				position : provinces[i].center.split(','),
			});
			marker.setMap(map);
			marker.on('click', function(e) {
				infowindow.open(map, e.target.getPosition());
			})
			AMap
					.plugin(
							'AMap.AdvancedInfoWindow',
							function() {
								infowindow = new AMap.AdvancedInfoWindow(
										{
											content : '<div class="info-title">高德地图</div><div class="info-content">'
													+ '<img src="https://webapi.amap.com/images/amap.jpg">'
													+ '高德是中国领先的数字地图内容、导航和位置服务解决方案提供商。<br/>'
													+ '<a target="_blank" href = "https://mobile.amap.com/">点击下载高德地图</a></div>',
											offset : new AMap.Pixel(0, -30)
										});
								infowindow.open(map, [ 116.48, 39.99 ]);
							})
		}
	</script>
	<script type="text/javascript"
		src="https://webapi.amap.com/demos/js/liteToolbar.js"></script>

</body>
</html>