<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String id=request.getParameter("id");
String datagridId=request.getParameter("datagridId");
String jdJzdz=request.getParameter("jdJzdz");
String jdRyxm=request.getParameter("jdRyxm");
String area="";
if(session.getAttribute("deptName")!=null)
area=(String)session.getAttribute("deptName");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>获取地区轮廓线</title>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=BydHZOdwnMhgKCnkXXrq4Eef6bs5V9Yn">
</script>
		<script type="text/javascript" src="../js/baidu/jquery-1.11.js">
</script>
		<script type="text/javascript" src="../js/baidu/jquery.json-2.2.js">
</script>
<style type="text/css">
body{font-size:13px;margin:10px}
#container{width:800px;height:500px;border:1px solid gray;margin:auto auto;}
#controler {text-align:center;margin-top:30px;}
</style>
</head>
<body>
<div id="container"></div>
<div id="controler">
<form id="form" name="form" method="post" action="<%=path%>/dwgl/updateFence.do">
 
		<input type="hidden"  name="id" value="<%=id%>"/> 
	    <input type="hidden" name="datagridId" value="<%=datagridId%>" />	
	    <input type="hidden" name="currentCallback" value="close" />  
	    <input type="hidden" id="jdHdqy"  name="jdHdqy"  />
	    输入省、直辖市或县名称：<input type="text" id="districtName" style="width:80px" value="<%=area%>">
<input type="button" onclick="getBoundary()" value="获取轮廓线"><input type="button" onclick="getData()" value="保存轮廓线">
<br/><br/>
<%out.println(jdRyxm+"现居住："+jdJzdz); %>  
</form>

</div>

<div id="ooo"></div>
<script type="text/javascript">
var map = new BMap.Map("container");
map.centerAndZoom(new BMap.Point(114.906618,30.486109), 5);
map.addControl(new BMap.NavigationControl({type: BMAP_NAVIGATION_CONTROL_SMALL}));
map.enableScrollWheelZoom();

var area=new Array();
function getBoundary(){       
    var bdary = new BMap.Boundary();
    var name = document.getElementById("districtName").value;
    bdary.get(name, function(rs){       //获取行政区域 
     
        map.clearOverlays();        //清除地图覆盖物
        var count = rs.boundaries.length; //行政区域的点有多少个  
        for(var i = 0; i < count; i++){  
        	area.push(rs.boundaries[i]);
	
            var ply = new BMap.Polygon(rs.boundaries[i], {strokeWeight: 2, strokeColor: "#ff0000"}); //建立多边形覆盖物
            map.addOverlay(ply);  //添加覆盖物
            map.setViewport(ply.getPath());    //调整视野         
        } ooo.innerHTML=area;               
    });   
}

getBoundary();


function getData(){
 // var m=$.toJSON(baiduArea.getConfigInfo()); 
	//document.getElementById("jdHdqy").value=m;
	//alert(document.getElementById("jdHdqy").value);
	// form.submit();
	 var data={'id':'<%=id%>','jdHdqy':area.join("#"),'jdDqgkdq':document.getElementById("districtName").value}; 
	   $.ajax({
            url: '<%=path%>/dwgl/updateFence.do',
            type: 'post',//提交的方式
            dataType:'json',data:data,
           // data: $('#form').serializeArray(),
            success: function(msg) {
                //这是成功返回的数据，写自己的逻辑
               alert('保存成功！');
          		//$.msg.alert('保存成功！');
            }
        });
    
} 
</script>
</body>
</html>
