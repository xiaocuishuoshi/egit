<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>
<%-- 
--%>

<div class="easyui-layout" fit="true" >
  	
	<div  region="center" border="false">
		<div id="${param.rel}_toolbar" class="search-div">
	<form  onsubmit="return datagridSearch(this,'${param.rel }_datagrid');"  >
		<input id="${param.rel}_id" name="id" type="hidden" value="0"/>
		<div  class="search-content " >
			<span>
				<label style="white-space: nowrap;">汇报人姓名：</label>
				<input	type="text" name="hbryxm" class="span2"  />
				&nbsp;<i class="boot_icon-question-sign" selectLike="tooltip"></i>
			</span>
			
			
			
		</div>
	

		<div class="search-toolbar" >
			<span style="float:left;">
				<a class="easyui-linkbutton clearDgChecked"  icon="icon-redo"	plain="true"  title="清空所有勾选项" >清空勾选</a>
				
				
				
				
					<a class="easyui-linkbutton" icon="icon-remove" plain="true" target="selectedTodo"
					title="删除" href="sxhb/del.do?rel=${param.rel }"  warn="请先选择一个用户" >批量删除</a>
				
			</span>
			
			<span style="margin-left:500px;">
				<button class="btn btn-primary btn-small" type="submit">查询</button>&nbsp;
				<button class="btn btn-small clear" type="button" >清空</button>&nbsp;	
			</span>
		
		</div>
	</form>
	
</div>

<table id="${param.rel }_datagrid"   toolbar="#${param.rel}_toolbar"  title="信息交互--思想汇报"></table>

<script type="text/javascript">

	
	$(function() {
		$('#<%=request.getParameter("rel")%>_datagrid').datagrid({
			
			border:true,
			nowrap : false,
			url : "sxhb/queryUsers.do",
			 rowStyler:function(index,row){    
	     		  if (row.ydzt=="0"){    
	     	       return 'color:red';    
     		   		}  
  			  } ,
			columns : [ [ 
				{
					field:"ck",
					title : "勾选",
					checkbox:true
				},
				{
					field : "hbryxm",
					title : "汇报人",
					align:"center",
					width : 50,
					formatter: function(value,row,index){
						
						return '<a href="sxhb/show.do?id='+row.id+'" target="dialog" width="950" height="400" rel="<%=request.getParameter("rel")%>_show" title="查看用户详情">'+value+'</a>';
					}
				},
				{
					field : "hbsj",
					title : "汇报时间",
					align:"center",
					width : 50,
					sortable : true,
					formatter: function(value,row,index){
						if(value!=null)
						return new Date(value).format("yyyy-MM-dd HH:mm:ss");
					}
				},
			 	 {
					field : "hbnr",
					title : "汇报内容",
					align:"center",
					width : 80
					
				}   
			] ]
		});
		
	});
	
</script>
	</div>
</div>
