<%@page import="com.whfp.oa.manager.jd.bean.JdRyb"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%

List<JdRyb> list=null;
String pos="";

if(session.getAttribute("fb")!=null)
	list=(List)session.getAttribute("fb");

/* if(session.getAttribute("pos")!=null){
	pos=(String)session.getAttribute("pos");
    pos=pos.replace("[", "").replace("]","");
 }else */
 pos="115.55,29.85";
 %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<style type="text/css">
		body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
		#l-map{height:100%;width:78%;float:left;border-right:2px solid #bcbcbc;}
		#r-result{height:100%;width:20%;float:left;}
	</style>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=Y9Yo0UsPgY38Ncy26Qmbz1B7"></script>
	<title>添加多个标注点</title>
</head>  
<body>
	<div id="allmap"></div>
</body>
</html>
<script type="text/javascript">
	// 百度地图API功能
	var map = new BMap.Map("allmap");
	var point = new BMap.Point(<%=pos%>);
	map.centerAndZoom(point, 11);
	map.enableScrollWheelZoom();
	// 编写自定义函数,创建标注
	var wind;
	function addMarker(point,name){
	  var marker = new BMap.Marker(point);
	  map.addOverlay(marker);
	  
	 
        var infoWindow = new BMap.InfoWindow("<p style='font-size:20px;'>" + name + "</p>");
        marker.addEventListener("mouseover", function () { this.openInfoWindow(infoWindow); wind=infoWindow; wind.setHeight(180); });
       
       
	} 
	var flag=0;
	function changeSize(wind){
		if(flag==0){
			wind.setHeight(400);
			flag=1;
			info.style.display="block";
		}else{
			wind.setHeight(180);
			flag=0;
			info.style.display="none";
		}
	}
	<%
	for(int i=0;i<list.size();i++){
		JdRyb jd=list.get(i);
		if(jd.getDqwz()!=null&&!jd.getDqwz().equals("")){
			String content="";
		    String wz[]=jd.getDqwz().split(",");
		    String cur_addr=wz[0];//联系
		    String bm=jd.getJdCym();//别名
		    String xb=jd.getJdRyxb();//性别
		    String sg=jd.getJdRysg();//身高
		    String jg=jd.getJdRyjg();//籍贯
		    String lxfs=jd.getJdLxfs();//联系方式 
		    String addr=cur_addr;//位置
		    String zy=jd.getJdZy();//职业
		    String csrq=jd.getJdCsrq();//出生日期 
		    String mz=jd.getJdMz();//民族 
		    String zjxy=jd.getJdZjxy();//宗教信仰
		    String zjhm=jd.getJdSfzh();//证件号码
		    if(zjhm!=null)
		    zjhm=zjhm.replace("'","");
		    String zjlx=jd.getJdZjzl();//证件种类
		    String jdHyzk=jd.getJdHyzk();//婚姻状况
		  	String jdWhcd=jd.getJdWhcd();//文化程度
		  	String hjd=jd.getJdHjd();//户籍地
		  	String hjdz=jd.getJdHjxxdz();//户籍地详址
		  	String hjdpcs=jd.getJdHjdpcs();//户籍地派出所
		  	String jzd=jd.getJdJzd();//居住地
		  	String jzdz=jd.getJdJzdz();//居住地详址
		  	String jzdpcs=jd.getJdJzdpcs();//居住地派出所
		  	String jgry=jd.getJdJgry();//监管人员
		  	String dwdh=jd.getJdDwdh();//定位电话
		  	String zzmm=jd.getJdZzmm();// 政治面貌
		  	String chrq=jd.getJdChrq();//查获日期
		  	String tscs=jd.getJdTscs();//脱失次数
		  	String lydp=jd.getJdLydpzl();//滥用毒品种类
		  	String chdw=jd.getJdChdw();//查获单位
		  	String dqgkzk=jd.getJdDqgkxz();//当前管控状况
		  	String dqgkdq=jd.getJdDqgkdq();//当前管控地区    
		    content="<table border=1 cellspacing=0><tr><td colspan=6>位置:"+addr+"["+jd.getDqwzsj()+"]</td></tr><tr><td>姓名:</td><td>"+jd.getJdRyxm()+"</td><td>别名:</td><td>"+bm+"</td><td>性别：</td><td>"+jd.getJdRyxb()+"</td></tr><tr><td>职业</td><td>"+zy+"</td><td>出生日期</td><td>"+csrq+"</td><td>民族</td><td>"+jd.getJdMz()+"</td></tr><tr><td>联系方式</td><td>"+jd.getJdLxfs()+"</td><td>证件种类</td><td>"+zjlx+"</td><td>证件号码</td><td>"+zjhm+"</td></tr><div id=info style=display:none><tr><td>婚姻状况</td><td>"+jdHyzk+"</td><td>文化程度</td><td>"+jdWhcd+"</td><td>政治面貌</td><td>"+zzmm+"</td></tr><tr><td>居住地</td><td>"+jzd+"</td><td>居住地详址</td><td>"+jzdz+"</td><td>居住地派出所</td><td>"+jzdpcs+"</td></tr><tr><td>监管人员</td><td>"+jgry+"</td><td>定位电话</td><td>"+dwdh+"</td><td>查获日期</td><td>"+chrq+"</td></tr><tr><td>监管人员</td><td>"+jgry+"</td><td>定位电话</td><td>"+dwdh+"</td><td>查获日期</td><td>"+chrq+"</td></tr> <tr><td>脱失次数</td><td>"+tscs+"</td><td>滥用毒品种类</td><td>"+lydp+"</td><td>查获单位</td><td>"+chdw+"</td></tr><tr><td>当前管控状况</td><td>"+dqgkzk+"</td><td colspan=3>当前管控地区</td><td>"+dqgkdq+" </td></tr></div><a href=javascript:changeSize(wind);>更多</a><br>";
		    if(wz.length>=3){
			out.println("var point"+i+" = new BMap.Point("+wz[1]+", "+wz[2]+");");
			out.println("addMarker(point"+i+",'"+content+"');"); 
			  
			}
		}
	}
	%> 
	
</script>
