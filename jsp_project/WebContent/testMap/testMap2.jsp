<!doctype html>
<html lang="zh-CN">

<head>
    <!-- 原始地址：//webapi.amap.com/ui/1.0/ui/misc/PoiPicker/examples/search.html -->
    <base href="//webapi.amap.com/ui/1.0/ui/misc/PoiPicker/examples/" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>POI搜索</title>
    <style>
    html,
    body {
        width: 100%;
        height: 100%;
        margin: 0px;
        padding: 0;
        font-size: 13px;
    }
    
    #outer-box {
        height: 100%;
        padding-right: 300px;
    }
    
    #container {
        height: 100%;
        width: 100%;
    }
    
    #panel {
        position: absolute;
        top: 0;
        bottom: 0;
        right: 0;
        height: 100%;
        overflow: auto;
        width: 300px;
        z-index: 999;
        border-left: 1px solid #eaeaea;
        background: #fff;
    }
    
    #searchBar {
        height: 30px;
        background: #ccc;
    }
    
    #searchInput {
        width: 100%;
        height: 30px;
        line-height: 30%;
        -webkit-box-sizing: border-box;
        box-sizing: border-box;
        border: none;
        border-bottom: 1px solid #ccc;
        padding: 0 5px;
    }
    
    #searchResults {
        overflow: auto;
        height: calc(100% - 30px);
    }
    
    .amap_lib_placeSearch,
    .amap-ui-poi-picker-sugg-container {
        border: none!important;
    }
    
    .amap_lib_placeSearch .poibox.highlight {
        background-color: #CAE1FF;
    }
    
    .poi-more {
        display: none!important;
    }
    </style>
</head>

<body>
    <div id="outer-box">
        <div id="container" class="map" tabindex="0"></div>
        <div id="panel" class="scrollbar1">
            <div id="searchBar">
                <input id="searchInput" placeholder="输入关键字搜素POI" />
            </div>
            <div id="searchResults"></div>
        </div>
    </div>
    <script type="text/javascript" src='//webapi.amap.com/maps?v=1.4.0&key=f037938c4321cc6d99a6bd05e09d986c'></script>
    <!-- UI组件库 1.0 -->
    <script src="//webapi.amap.com/ui/1.0/main.js?v=1.0.11"></script>
    <script type="text/javascript">
    var map = new AMap.Map('container', {
        zoom: 10
    });

    AMapUI.loadUI(['misc/PoiPicker'], function(PoiPicker) {

        var poiPicker = new PoiPicker({
            input: 'searchInput',
            placeSearchOptions: {
                map: map,
                pageSize: 10
            },
            searchResultsContainer: 'searchResults'
        });

        poiPicker.on('poiPicked', function(poiResult) {

            poiPicker.hideSearchResults();

            var source = poiResult.source,
                poi = poiResult.item;

            if (source !== 'search') {

                //suggest来源的，同样调用搜索
                poiPicker.searchByKeyword(poi.name);

            } else {

                //console.log(poi);
            }
        });

        poiPicker.onCityReady(function() {
            poiPicker.searchByKeyword('湖南工业大学');
        });
    });
    </script>
</body>

</html>