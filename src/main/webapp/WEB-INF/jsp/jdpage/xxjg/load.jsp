<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>

<div class="easyui-layout" fit="true" >
  	
	<div  region="center" border="false">
		<div id="${param.rel}_toolbar" class="search-div">
	<form  onsubmit="return datagridSearch(this,'${param.rel }_datagrid');"  >
		<input id="${param.rel}_id" name="id" type="hidden" value="0"/>
		<div  class="search-content " >
			<span>
				<label style="width:150px;">接受人姓名：</label>
				
							<input type="text" name="jsrxm"  >
							
				</a>
			</span>
			
		</div>
	

		<div class="search-toolbar" >
			<span style="float:left;">
				<a class="easyui-linkbutton clearDgChecked"  icon="icon-redo"	plain="true"  title="清空所有勾选项" >清空勾选</a>
			
			
				<shiro:hasPermission name="xxjg:add">  
						<a class="easyui-linkbutton" icon="icon-add" plain="true"
						title="添加" href="xxjg/addPage.do?rel=${param.rel}"  target="dialog" width="1000" height="400" rel="${param.rel}_add" >添加</a>
				</shiro:hasPermission>
				
				<shiro:hasPermission name="xxjg:delete">
					<a class="easyui-linkbutton" icon="icon-remove" plain="true" target="selectedTodo"
					title="删除" href="xxjg/del.do?rel=${param.rel }"  warn="请先选择一个用户" >批量删除</a>
				</shiro:hasPermission>
			</span>
			<span style="margin-left:600px;">
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
			url : "xxjg/queryUsers.do",
			columns : [ [ 
				{
					field:"ck",
					title : "勾选",
					checkbox:true
				},
				 {
					field : "jsrxm",
					title : "接受人姓名",
					align:"center",
					width : 30,
					formatter: function(value,row,index){
						
						return '<a href="xxjg/show.do?id='+row.id+'" target="dialog" width="950" height="400" rel="<%=request.getParameter("rel")%>_show" title="查看用户详情">'+value+'</a>';
					}
				},
				{
					field : "fssj",
					title : "发送时间",
					align:"center",
					width : 30
				},
				{
					field : "fsnr",
					title : "发送内容",
					align:"center",
					width : 30
				} 
			] ]
		});
		
	});
	
</script>
	</div>
</div>
