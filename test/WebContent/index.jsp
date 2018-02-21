<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">

    <title>高德地图展示</title>

    <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>

    <script src="http://cache.amap.com/lbs/static/es5.min.js"></script>
    <!-- 这里要配置参数key,将其值设置为高德官网开发者获取的key -->
    <script src="http://webapi.amap.com/maps?v=1.3&key=eede59ff2baca809214528113da0adc9"></script> 
    <script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>

    <style type="text/css">
       #container{
          margin-left:500px;
          margin-top:50px;
          width:800px;
          height:500px;
       }
    </style>
</head>
<body>
<div><h2>欢迎进入高德地图</h2></div>
<div id="container"></div>

<script>
    //创建地图,设定地图的中心点和级别
    var map = new AMap.Map('container', {
        resizeEnable: true,
        zoom:11,
        center: [120.2, 30.3]

    });

   /*  AMap.plugin(['AMap.ToolBar','AMap.Scale'],function(){
        //TODO  创建控件并添加
        alert("dddd");
    }) */
    //信息窗体的创建与设定
    var infowindow = new AMap.InfoWindow({
        content: '<h3>高德地图</h1><div>高德是中国领先的数字地图内容、导航和位置服务解决方案提供商。</div>',
        offset: new AMap.Pixel(0, -30),
        size:new AMap.Size(230,0)
   });
   //点标记的创建与添加
    var marker = new AMap.Marker({
        position: [120.2, 30.3],
        map:map
    });

</script>
</body>
</html>