// 首页 幻灯片轮播
var lbnum = 1;
function imgTran(){
	//获取图片标签
	var imgid = document.getElementById("imglb");
	imglb.src = "./images/lb"+lbnum+".jpg";
	lbnum++;
	if(lbnum==9){
		lbnum = 1;
	}
}
//启动计时器
var lbtime = setInterval("imgTran()","2000");