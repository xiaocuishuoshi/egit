<%@page import="java.sql.*"%> 
<%@page import="com.fp.tool.*"%>
<%@page import="com.fp.database.DataConn"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String fromJson="";
String fromNumJson="";
String namenumJson=""; 
String year = request.getParameter("year");
String month = request.getParameter("month");
String day = request.getParameter("day");
if(year==null)year="";
if(month==null)month="";
if(day==null)day="";
String hh="";
 String cond=" createtime>=concat(replace(curdate(),'-',''),'0000')  ";
 if(!year.equals("")&&!month.equals("")&&day.equals("")){
  cond="  createtime>='"+year+month+"010000' and createtime<='"+year+month+"312359'";
  hh="_hour";
 }
 if(!year.equals("")&&!month.equals("")&&!day.equals("")){
  cond=" createtime>=concat('"+year+month+day+"','0000') and  createtime<=concat('"+year+month+day+"','2359') ";
  hh="_hour"; 
 }
DataConn dataConn=new DataConn();
StringBuffer buffer1=new StringBuffer();
StringBuffer buffer2=new StringBuffer();
StringBuffer buffer3=new StringBuffer();
int max=1000; 
try{
dataConn.OpenConnection();
Connection conn=dataConn.Conn;
 Statement stmt=conn.createStatement();
 
  System.out.println("select city,sum(num) as num1 from(select city,num from "+City.tb+"_area_info_sw"+hh+" where   "+cond+" )a  group by city order by num1 desc limit 10 ");
  ResultSet rs=stmt.executeQuery("select city,sum(num) as num1 from(select city,num from "+City.tb+"_area_info_sw"+hh+" where   "+cond+" )a  group by city order by num1 desc limit 10 ");
 //'武汉': [112.20,32.08],
 
 while(rs.next()){
    Statement stmt1=conn.createStatement(); 
    System.out.println("select pos from city a where  a.city='"+rs.getString(1)+"'");
 	 ResultSet rs1=stmt1.executeQuery("select pos from city a where  a.city='"+rs.getString(1)+"'");
 	 if(rs1.next()){
 	  /*   fromJson+="'"+rs.getString(1)+"':"+rs1.getString(1)+",";
 		fromNumJson+="[{name:'"+rs.getString(1)+"',value:"+rs.getString(2)+"},{name:'武汉'}],";
 		namenumJson+= "{name:'"+rs.getString(1)+"',value:"+rs.getString(2)+"},";
 		 */
 		buffer1.append("'"+rs.getString(1)+"':"+rs1.getString(1)+",");
 		buffer2.append("[{name:'"+rs.getString(1)+"',value:"+rs.getString(2)+"},{name:'"+City.name+"'}],");
 		buffer3.append("{name:'"+rs.getString(1)+"',value:"+rs.getString(2)+"},");
 	 }
 	 rs1.close();
 	 stmt1.close();
 	
  }
  System.out.println("select  max(num) from (select city,sum(num) as num  from (select city,num from "+City.tb+"_area_info_sw"+hh+" where  "+cond+" and not city='"+City.name+"' )a group by city) b");
   rs=stmt.executeQuery("select  max(num) from (select city,sum(num) as num  from (select city,num from "+City.tb+"_area_info_sw"+hh+" where  "+cond+" and not city='"+City.name+"' )a group by city) b ");
  if(rs.next()){
  	 max=rs.getInt(1);
  }
  rs.close();
  stmt.close();
  conn.close(); 
 /*  if(fromJson.equals("")) 
 fromJson=" "+                   
					"	'黄石': [115.09,30.20],"+
					"	'黄冈': [114.87,30.44],"+
					"	'武汉': [114.31,30.52],"+
				"		'咸宁': [114.28,29.87],"+
			"			'孝感': [113.91,31.92],"+
			"		'随州': [113.22,31.42],"+
			"			'荆门': [112.19,31.02],"+
             "           '宜昌': [111.30,30.70],"+
			"			'通城': [113.80,29.23],"+
			"			'十堰': [110.79,32.65]  ";
 if(fromNumJson.equals("")) 
 fromNumJson="  [{name:'黄石',value:260},{name:'武汉'}],"+
                          "  [{name:'黄冈',value:245},{name:'武汉'}],"+
                           " [{name:'武汉',value:222},{name:'武汉'}],"+
                           " [{name:'咸宁',value:197},{name:'武汉'}],"+
                           " [{name:'孝感',value:170},{name:'武汉'}],"+
                           " [{name:'随州',value:120},{name:'武汉'}],"+
                           " [{name:'荆门',value:112},{name:'武汉'}],"+
                           " [{name:'宜昌',value:108},{name:'武汉'}],"+
                           " [{name:'通城',value:98},{name:'武汉'}],"+
                           " [{name:'十堰',value:95},{name:'武汉'}]";
  if(namenumJson.equals(""))                          
  namenumJson=""+
               "  {name:'黄石',value:95},"+
                        "     {name:'黄冈',value:90},"+
                          "   {name:'武汉',value:80},"+
                            " {name:'咸宁',value:70},"+
                            " {name:'孝感',value:60},"+
                            " {name:'随州',value:50},"+
                            " {name:'荆门',value:40},"+
                            " {name:'宜昌',value:30},"+
                            " {name:'通城',value:20},"+
                            " {name:'十堰',value:10}"; */
 }catch(Exception e){
 	e.printStackTrace();
 }
%>

<html>
    <head>
        <meta charset="utf-8">
        <style type="text/css">
            body {
                margin: 0;
            }
        </style>
    </head>
    <body style="overflow-x:hidden">
        <div id="main" style="height:370px; width:100%;"></div>
        <script src="../../../doc/example/www/js/echarts.js"></script>
        <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=ZUONbpqGBsYGXNIYHicvbAbM"></script>
        <script src="../../../doc/asset/js/jquery.min.js"></script>
		<script src="../../../doc/asset/js/china.js"></script>
        <script>
		(function () {
    require.config({
        paths: {
            echarts: '../../../doc/example/www/js'
        },
        packages: [
            {
                name: 'BMap',
                location: '../src',
                main: 'main'
            }
        ]
    });

    require(
    [
        'echarts',
        'BMap',
		'echarts/chart/heatmap',
        'echarts/chart/map'
    ],
    function (echarts, BMapExtension) {
        $('#main').css({
            height:$('body').height(),
            width: $('body').width()
        });

        // 初始化地图
        var BMapExt = new BMapExtension($('#main')[0], BMap, echarts,{
            enableMapClick: false
        });
        var map = BMapExt.getMap();
        var container = BMapExt.getEchartsContainer();

        var startPoint = { 
 		x:<%=City.jwd.split(",")[0]%>,y:<%=City.jwd.split(",")[1]%>    
        };

        var point = new BMap.Point(startPoint.x, startPoint.y);
        map.centerAndZoom(point,4);
        map.enableScrollWheelZoom(true);
         // 地图自定义样式
        map.setMapStyle({
            styleJson: [
                  {
                       "featureType": "water",
                       "elementType": "all",
                       "stylers": {
                            "color": "#044161"
                       }
                  },
                  {
                       "featureType": "land",
                       "elementType": "all",
                       "stylers": {
                            "color": "#004981"
                       }
                  },
                  {
                       "featureType": "boundary",
                       "elementType": "geometry",
                       "stylers": {
                            "color": "#064f85"
                       }
                  },
                  {
                       "featureType": "railway",
                       "elementType": "all",
                       "stylers": {
                            "visibility": "off"
                       }
                  },
                  {
                       "featureType": "highway",
                       "elementType": "geometry",
                       "stylers": {
                            "color": "#004981"
                       }
                  },
                  {
                       "featureType": "highway",
                       "elementType": "geometry.fill",
                       "stylers": {
                            "color": "#005b96",
                            "lightness": 1
                       }
                  },
                  {
                       "featureType": "highway",
                       "elementType": "labels",
                       "stylers": {
                            "visibility": "off"
                       }
                  },
                  {
                       "featureType": "arterial",
                       "elementType": "geometry",
                       "stylers": {
                            "color": "#004981"
                       }
                  },
                  {
                       "featureType": "arterial",
                       "elementType": "geometry.fill",
                       "stylers": {
                            "color": "#00508b"
                       }
                  },
                  {
                       "featureType": "poi",
                       "elementType": "all",
                       "stylers": {
                            "visibility": "off"
                       }
                  },
                  {
                       "featureType": "green",
                       "elementType": "all",
                       "stylers": {
                            "color": "#056197",
                            "visibility": "off"
                       }
                  },
                  {
                       "featureType": "subway",
                       "elementType": "all",
                       "stylers": {
                            "visibility": "off"
                       }
                  },
                  {
                       "featureType": "manmade",
                       "elementType": "all",
                       "stylers": {
                            "visibility": "off"
                       }
                  },
                  {
                       "featureType": "local",
                       "elementType": "all",
                       "stylers": {
                            "visibility": "off"
                       }
                  },
                  {
                       "featureType": "arterial",
                       "elementType": "labels",
                       "stylers": {
                            "visibility": "off"
                       }
                  },
                  {
                       "featureType": "boundary",
                       "elementType": "geometry.fill",
                       "stylers": {
                            "color": "#029fd4"
                       }
                  },
                  {
                       "featureType": "building",
                       "elementType": "all",
                       "stylers": {
                            "color": "#1a5787"
                       }
                  },
                  {
                       "featureType": "label",
                       "elementType": "all",
                       "stylers": {
                            "visibility": "off"
                       }
                  }
            ]
        });

        option = {
            color: ['gold','aqua','lime'],
            title : {
                text: '<%=City.name%>省外人口迁徙流向图',
                x:'center',
                textStyle : {
                    color: '#fff'
                }
            },
            tooltip : {
                trigger: 'item',
                formatter: function (v) {
                    return v[1].replace(':', ' > ');
                }
            },
            legend: {
                orient: 'vertical',
                x:'left',
                data:['<%=City.name%>'],
                selectedMode: 'single',
                textStyle : {
                    color: '#eee'
                }
            },
            
            dataRange: {
                min : 0,
                max : <%=max%>,
                range: {
                    start: 0,
                    end: <%=max%>,
                },
                x: 'left',
                calculable : true,
                color: ['#ff3333', 'orange', 'yellow','lime','aqua'],
                textStyle:{
                    color:'#eee'
                }
            },
            series : [
                {
                    name:'<%=City.name%>',
                    type:'map',
                    mapType: 'none',
                    data:[],
                    geoCoord: {'<%=City.name%>': [<%=City.jwd%>],
					      <%=buffer1.toString()%>                     						
                    },

                    markLine : {
                        smooth:true,
                        effect : {
                            show: true,
                            scaleSize: 1,
                            period: 30,
                            color: '#fff',
                            shadowBlur: 10
                        },
                        itemStyle : {
                            normal: {
                                borderWidth:1,
                                lineStyle: {
                                    type: 'solid',
                                    shadowBlur: 10
                                }
                            }
                        },
                        data : [
                              <%=buffer2.toString()%>
                        ]
                    },
                    markPoint : {
                        symbol:'emptyCircle',
                        /* symbolSize : function (v){
                            return 10 + v/10
                        }, */
                        effect : {
                            show: true,
                            shadowBlur : 0
                        },
                        itemStyle:{
                            normal:{
                                label:{show:true}
                            }
                        },
                        data : [
                           <%=buffer3.toString()%>
                        ]
                    }

                }
               
            ]
        };

        var myChart = BMapExt.initECharts(container);
        window.onresize = myChart.onresize;
        BMapExt.setOption(option);
    }
);
})();
		</script>

    </body>
</html>