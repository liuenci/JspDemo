<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>demo测试</title>

<link rel="stylesheet"
	href="http://cache.amap.com/lbs/static/main1119.css" />
<script src="http://cache.amap.com/lbs/static/es5.min.js"></script>
<script src="http://webapi.amap.com/maps?v=1.4.0&key=您申请的key值"></script>
<script type="text/javascript"
	src="http://cache.amap.com/lbs/static/addToolbar.js"></script>


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