<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>

<div class="easyui-layout" fit="true" >
  	
	<div  region="center" border="false">
		<div id="${param.rel}_toolbar" class="search-div">
	<form  onsubmit="return datagridSearch(this,'${param.rel }_datagrid');"  >
		<input id="${param.rel}_id" name="id" type="hidden" value="0"/>
		<div  class="search-content " >
			<span>
				<label style="width:150px;">可疑人姓名：</label>
				<input type="text" name="username"  >
							
			</span>
			
		</div>
	

		<div class="search-toolbar" >
			<span style="float:left;">
				<a class="easyui-linkbutton clearDgChecked"  icon="icon-redo"	plain="true"  title="清空所有勾选项" >清空勾选</a>
			
			
				
			</span>
			
			<span style="float: right">
				<button class="btn btn-primary btn-small" type="submit">查询</button>&nbsp;
				<button class="btn btn-small clear" type="button" >清空</button>&nbsp;	
			</span>
		
		</div>
	</form>
	
</div>

<table id="${param.rel }_datagrid"   toolbar="#${param.rel}_toolbar"  ></table>

<script type="text/javascript">

	
	$(function() {
		$('#<%=request.getParameter("rel")%>_datagrid').datagrid({
			
			border:true,
			nowrap : false,
			url : "knxx/queryUsers.do",
			rowStyler: function(ivalue,row,index){
			    if (row.ydzt==0){
			        return 'background-color:#E2FF77;';
			    }
			 },
			columns : [ [ 
				{
					field:"ck",
					title : "勾选",
					checkbox:true
				},
				 {
					field : "username",
					title : "可疑人人姓名",
					align:"center",
					width : 30,
					formatter: function(value,row,index){
						
						return '<a href="knxx/show.do?id='+row.id+'" target="dialog" width="950" height="400" rel="<%=request.getParameter("rel")%>_show" title="查看用户详情">'+value+'</a>';
					}
				},
				{
					field : "kssj",
					title : "开始时间",
					align:"center",
					width : 30,
					sortable:true,
					formatter:function(value,row,index){
						if(value!=null)
					return 	new Date(value).format(" yyyy-MM-dd HH:mm:ss");
					}
				}
				,
				{
					field : "address",
					title : "地址",
					align:"center",
					width : 30
				},
				{
					field : "bj",
					title : "备注",
					align:"center",
					width : 30
				},{
					field : "操作",
					title : "操作",
					align:"center",
					width : 30,
					formatter:function(value,row,index){
						return '<a  datagrid="${param.rel }_datagrid" href="knxx/CkWz.do?id='
											+row.id 
											+ '&rel=${param.rel}&lat='+row.lat+'&lng='+row.lng+'" width="1000"  plain="true" target="dialog"  title="查看位置">查看位置</a>';
					}
				} 
			] ]
		});
		
	});
	
</script>
	</div>
</div>
