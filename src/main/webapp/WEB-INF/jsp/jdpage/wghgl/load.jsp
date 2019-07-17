<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>
<%--
	模块：网格化管理---当前网格吸毒人员
--%>


<table id="${param.rel }_datagrid"   toolbar="#${param.rel}_toolbar" ></table>

<script type="text/javascript">


	$(function() {
	
		$('#<%=request.getParameter("rel")%>_datagrid').datagrid({
			nowrap : true,
			url : "wgh/query.do?jdWghxh=${xh}&jdWgsssq=${sssq}",
			columns : [ [ 
				{
					field:"ck",
					title : "勾选",
					checkbox:true
				},
				 {
					field : "jdRyxm",
					title : "姓名",
					align:"center",
					width:70,
					formatter: function(value,row,index){
						
						return '<a href="wgh/show.do?id='+row.id+'" target="dialog" width="900" height="500" rel="<%=request.getParameter("rel")%>_show" title="查看吸毒人员详情">'+value+'</a>';
					}
				},
				{
					field : "jdZy",
					title : "职业",
					align:"center",
					width:90,
				},
				{
					field : "jdMz",
					title : "民族",
					align:"center",
					width:50,
				},
			 	 {
					field : "jdDwdh",
					title : "电话号码",
					align:"center",
					width:80,
					
				} ,
			 	 {
					field : "jdRyjg",
					title : "籍贯",
					align:"center",
					width:100,
				},
				
				{
					field : "jdRylb",
					title : "类型",
					align:"center",
					width:70,
					formatter: function(value,row,index){
						if(value==1){
							return "吸毒人员";
						}else if(value==2){
							return "社区戒毒人员";
						}else if(value==3){
							return "社区康复人员";
						}else if(value==4){
							return "强制戒毒人员";
						}else if(value==5){
							return "强制隔离戒毒人员";
						}else if(value==6){
							return "戒毒期满出所人员";
						}else{
							return;
						}
					}
				},
				
					 {
					field : "jdJb",
					title : "级别",
					align:"center",
					width:50,
					 formatter: function(value,row,index){
						if(value==1){
							return "一级";
						}else if(value==2){  
							return "二级";
						}else if(value==3){
							return "三级";
						}else if(value==0){
							return "正常";
						}else{
							return;
						}
					} 
				},
				
			] ]
		});
		
	});
	
</script>
