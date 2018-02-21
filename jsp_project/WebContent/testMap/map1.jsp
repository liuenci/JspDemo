<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="chrome">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="initial-scale=1.0, user-scalable=no, width=device-width">
<title>输入提示后查询</title>
<link rel="stylesheet"
	href="http://cache.amap.com/lbs/static/main1119.css" />
<script type="text/javascript"
	src="http://webapi.amap.com/maps?v=1.4.0&key=f037938c4321cc6d99a6bd05e09d986c&plugin=AMap.Autocomplete,AMap.PlaceSearch"></script>
<script type="text/javascript"
	src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
</head>
<body>
	<div id="container"></div>
	<div id="myPageTop">
		<table>
			<tr>
				<td><label>请输入关键字：</label></td>
			</tr>
			<tr>
				<td><input id="tipinput" /></td>
			</tr>
		</table>
	</div>
	<script type="text/javascript">
		//地图加载
		var map = new AMap.Map("container", {
			resizeEnable : true
		});
		//输入提示
		var autoOptions = {
			input : "tipinput"
		};
		var auto = new AMap.Autocomplete(autoOptions);
		var placeSearch = new AMap.PlaceSearch({
			map : map
		}); //构造地点查询类
		AMap.event.addListener(auto, "select", select);//注册监听，当选中某条记录时会触发
		function select(e) {
			placeSearch.setCity(e.poi.adcode);
			placeSearch.search(e.poi.name); //关键字查询查询
		}
	</script>
</body>
</html>