<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
 <script type="text/javascript" src="<%=path%>/js/echarts-all.js"></script>
<title>毒品类型统计分析</title>

     <div id="container" style="height:100%;width:35%;float: left;"></div>
    
    <div style="position:absolute;margin-top: 0.5%;margin-left: 27%;"> 
        <select id="sj" name="sj" style="width: 70px;"  onchange="window.location.href='<%=path%>/tjfx/zltj.do?time='+this.value">
				<option value="">全部</option>
			<c:forEach items="${requestScope.date}" var="d">
					<option value="${pageScope.d}">${pageScope.d}年</option>
			</c:forEach>
		</select>
		 <script type="text/javascript">
			document.getElementById("sj").value="${sj}";
		</script>
   </div>
   
  <div id="container1" style="height:100%;width:65%;float: right;"></div>  
    <script type="text/javascript">
 
    var zs = ${zs};//总数
	var mc = ${mc};//毒品名称
	//var desc=${desc};

    option = {
   /*  title : {
        text: '${desc}吸毒人员统计分析',
        //subtext: '实时数据',
        x:'200'
    }, */
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient : 'vertical',
        x : 'left',
        data:mc
    },
   /*  toolbox: {
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
    }, */
    calculable : true,
    series : [
        {
            name:'毒品名称',
            type:'pie',
            radius : '55%',
            center: ['50%', '60%'],
            data:[
            <%
            	List<Object[]> list=(List<Object[]>)request.getAttribute("list");
            	for (int i = 0; i < list.size(); i++) {
            		if(list.get(i)[1]==null || list.get(i)[1].equals("")){
            			list.get(i)[1]="其他";
            		}
            	%>
            		{value:<%=list.get(i)[0]%>, name:'<%=list.get(i)[1]%>'},
            <%}%>
            ]
        }
    ]
};

var nf=${nf};
var sl=${sl};
 option1 = {

    title : {
        text: ' ${desc}吸毒人员统计分析',
       // subtext: '实时数据'
    },
    tooltip : {
        trigger: 'axis'
    },

    toolbox: {
        show : true,
        feature : {
            dataView : {show: true, readOnly: false},
            magicType : {show: true, type: ['line', 'bar']},
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    xAxis : [
        {
            type : 'category',
            data : nf
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    series : [
        {
            name:'吸毒人数',
            type:'bar',
            data:sl,
            stack: 'sum',
            barCategoryGap: '50%',
  		
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            },
            itemStyle: {
                normal: {
                   color: function(params) {
                   var colorList = [
                          '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',
                           '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',
                           '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'
                        ];
                        return colorList[params.dataIndex]
                      },
                      label: {
                        show: true,
                        position: 'top',
                    }
              }
               }
           }
         
    ]
};

          echarts.init(document.getElementById("container")).setOption(option);
          echarts.init(document.getElementById("container1")).setOption(option1);          
    </script>

