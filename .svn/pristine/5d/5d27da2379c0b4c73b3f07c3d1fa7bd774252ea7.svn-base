<%@page import="java.sql.*"%> 
<%@page import="com.whfp.oa.commons.db.DataConn"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String year = request.getParameter("year");
String month = request.getParameter("month");
String day = request.getParameter("day");

StringBuffer buffercitys=new StringBuffer(); 
StringBuffer buffernums=new StringBuffer();
 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String citys="";
String nums="";
int num=0;
String namenumJson="";
DataConn dataConn=new DataConn(); 
try{
dataConn.OpenConnection();
Connection conn=dataConn.Conn;
 Statement stmt=conn.createStatement();
 String cond2=""; 
 //System.out.println("select city,sum(num) as num1 from (select city,  num from "+City.tb+"_area_info_sn"+hh+" where "+cond+" and not city='"+City.name+"' "+cond2+") a group by city order by num1 desc limit 10");
  ResultSet rs=stmt.executeQuery("SELECT b.dept_desc ,count(*) as total  FROM   jd_ryb a ,`sy_dept` b where  a.fk_dept_id=b.id  and dept_desc is not null  and dept_desc<>'' and a.jd_ryid not in(select user_id from sy_user_role)  group by b.dept_desc order by dept_sort");
 //'襄阳': [112.20,32.08],
 while(rs.next()){
 	buffercitys.append("'"+rs.getString(1)+"',");
 	buffernums.append("{value:'"+rs.getString(2)+"',name:'"+rs.getString(1)+"'},");
 	
  } 
  //out.println(buffercitys.toString());
  //out.println(buffernums.toString());
  
  rs.close();
  stmt.close();
  conn.close();  
  }catch(Exception e ){
 	e.printStackTrace();
 }
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'zzt.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
     <!--Step:1 Prepare a dom for ECharts which (must) has size (width & hight)-->
    <!--Step:1 为ECharts准备一个具备大小（宽高）的Dom-->
    <div id="main" style="height:500px;border:1px solid #ccc;padding:10px;"></div>
    <div id="mainMap" style="height:500px;border:1px solid #ccc;padding:10px;"></div>
    
    <!--Step:2 Import echarts.js-->
    <!--Step:2 引入echarts.js-->
    <script src="./echarts-m-1.0.0/dist/echarts.js"></script>
    
    <script type="text/javascript">
    // Step:3 conifg ECharts's path, link to echarts.js from current page.
    // Step:3 为模块加载器配置echarts的路径，从当前页面链接到echarts.js，定义所需图表路径
    require.config({
        paths: {
            echarts: './echarts-m-1.0.0/dist'
        }
    });
    
    // Step:4 require echarts and use it in the callback.
    // Step:4 动态加载echarts然后在回调函数中开始使用，注意保持按需加载结构定义图表路径
    require(
        [
            'echarts',
            'echarts/chart/bar',
            'echarts/chart/line',
            'echarts/chart/pie',
            'echarts/chart/radar',
            'echarts/chart/force',
            'echarts/chart/chord'
        ],
        function (ec) {
            //--- 折柱 ---
            var myChart = ec.init(document.getElementById('main'));
            myChart.setOption({ 
                
                title : {
        text: '各地吸毒人员分布统计',
        //subtext: '纯属虚构',
         
                             
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient : 'vertical',
        x : 'left',
        data:[<%=buffercitys.toString()%>],
                        textStyle : {  
                                fontStyle : 'bolder',  
                                fontSize : 25  
                            }  
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType : {
                show: true, 
                type: ['pie', 'funnel'],
                option: {
                    funnel: {
                        x: '25%',
                        width: '50%',
                        funnelAlign: 'left',
                        max: 1548
                    }
                }
            },
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    series : [
        {
            name:'所在地',
            type:'pie',
            radius : '55%',
            center: ['50%', '60%'],
            itemStyle: {
                normal: {
                    color: function(params) {
                        // build a color map as your need.
                        var colorList = [
                          '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',
                           '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',
                           '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0',
                           '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',
                           '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD'
                        ];
                        return colorList[params.dataIndex]
                    },
                    label: {
                        show: true,
                        position: 'top' ,
                        textStyle : {  
                                fontStyle : 'bolder',  
                                fontSize : 20  
                            }  
                    },
                }
            },
            
            data:[
                <%=buffernums.toString()%>
            ]
        }
    ]
                
            });
            
            // --- 地图 ---
        /* var myChart2 = ec.init(document.getElementById('mainMap'));
            myChart2.setOption({
                tooltip : {
                    trigger: 'item',
                    formatter: '{b}'
                },
                series : [
                    {
                        name: '湖北',
                        type: 'map',
                        mapType: 'china',
                        selectedMode : 'multiple',
                        itemStyle:{
                            normal:{label:{show:true}},
                            emphasis:{label:{show:true}}
                        },
                        data:[
                            {name:'湖北',selected:true}
                        ]
                    }
                ]
            });
	*/
            window.onresize = function() {
                myChart.resize(); 
            }
        }
    );
    </script>
  </body>
</html>
