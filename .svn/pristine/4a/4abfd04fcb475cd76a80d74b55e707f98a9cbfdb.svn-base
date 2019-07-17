<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>


<div class="easyui-layout" fit="true" >
	<div  region="center" border="false">
		<div id="${param.rel}_toolbar" class="search-div">
	<form  onsubmit="return datagridSearch(this,'${param.rel }_datagrid');"  >
		<input id="${param.rel}_id" name="id" type="hidden" value="0"/>
		<div  class="search-content " >
			<span>
				<label>被举报人：</label>
				<input	type="text" name="jbryxm" class="span2"  />
				&nbsp;<i class="boot_icon-question-sign" selectLike="tooltip"></i>
			</span>
			
		</div>
	

		<div class="search-toolbar" >
			<span style="float:left;">
				<a class="easyui-linkbutton clearDgChecked"  icon="icon-redo"	plain="true"  title="清空所有勾选项" >清空勾选</a>
				
				<shiro:hasPermission name="yjsb:delete">  
					<a class="easyui-linkbutton"  icon="icon-remove"	plain="true"
					   	 href="yjsb/del.do" target="selectedTodo"  title="确定要删除吗?" warn="至少选择一个用户">批量删除</a>
				</shiro:hasPermission>
				
			</span>
			
		
			<span style="float:right">
				<button class="btn btn-primary btn-small" type="submit">查询</button>&nbsp;
				<button class="btn btn-small clear" type="button" >清空</button>&nbsp;	
			</span>
		
		</div>
	</form>
	
</div>

<table id="${param.rel }_datagrid"   toolbar="#${param.rel}_toolbar"  title="信息交互--越级上报"></table>

<script type="text/javascript">

	
	$(function() {
		$('#<%=request.getParameter("rel")%>_datagrid').datagrid({
			
			border:true,
			nowrap : false,
			url : "yjsb/queryUsers.do",
			columns : [ [ 
				{
					field:"ck",
					title : "勾选",
					checkbox:true
				},
				{
					field : "jbryxm",
					title : "被举报人",
					align:"center",
					width : 50,
					formatter: function(value,row,index){
						
						return '<a href="yjsb/show.do?id='+row.id+'" target="dialog" width="950" height="450" rel="<%=request.getParameter("rel")%>_show" title="查看用户详情">'+value+'</a>';
					}
				},
			 	 {
					field : "jbsj",
					title : "举报时间",
					align:"center",
					width : 50
				},
				{
					field : "jbnr",
					title : "举报内容",
					align:"center",
					width : 50
				}
			] ]
		});
		
	});
	
</script>
	</div>
</div>

