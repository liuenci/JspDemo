<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <style type="text/css">
      body,html,#container{
        height: 100%;
        margin: 0px;
      }
    </style>
    <title>快速入门</title>
  </head>
  <body>
    <div id="container" tabindex="0"></div>
    <script type="text/javascript" src="http://webapi.amap.com/maps?v=1.4.0&key=eede59ff2baca809214528113da0adc9"></script>
    <script type="text/javascript">
        var map = new AMap.Map('container',{
            resizeEnable: true,
            zoom: 10,
            center: [116.480983, 40.0958]
        });
    </script>
  </body>
</html>