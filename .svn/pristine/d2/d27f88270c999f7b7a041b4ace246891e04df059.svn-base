<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%> 
<%--
	模块：帮扶列表管理-社区职务
--%>

<div id="${param.rel}_toolbar" class="search-div">
	<form onsubmit="return datagridSearch(this,'${param.rel }_datagrid');">
		<div class="search-content ">
		<span>
			<label>
				社区职务：
			</label> 
				 <input type="text" name="sqzw" style="width: 150px" op="like" />
			</span>
		</div>

		<div class="search-toolbar">
		<span style="float: left;"> 
	 	<a class="easyui-linkbutton clearDgChecked" icon="icon-redo"
				plain="true" title="清空所有勾选项">清空勾选</a> 
				
			 	<%--  <shiro:hasPermission name="dyhd:add"> --%>
					<a class="easyui-linkbutton" icon="icon-add" plain="true"
						href="sqzw/add.do?rel=${param.rel }" title="添加"
						target="dialog" width="320" height="450" rel="${param.rel}_add"><span>新增职务</span>
					</a>
				<%-- </shiro:hasPermission>  
				
				 <shiro:hasPermission name="dyhd:delete"> --%>
					<a class="easyui-linkbutton" icon="icon-remove" plain="true"
						href="sqzw/del.do" target="selectedTodo"
						rel="ids" title="确定要删除吗?" warn="至少选择一条信息"><span>批量删除</span> </a>			
				<%-- </shiro:hasPermission> 
				
				
				
				<shiro:hasPermission name="dyhd:update"> 
					<a class="easyui-linkbutton" icon="icon-edit" plain="true"
						title="修改" href="cpdj/update.do?id={id}&rel=${param.rel}"
						target="dialog" width="1000" height="550" 
						rel="${param.rel}_update" warn="请先选择一 条信息"><span>修改</span> </a>
					</shiro:hasPermission> --%>	
				
				
					<a class="easyui-linkbutton" icon="icon-add" plain="true"
						href="sqzw/addbf.do?rel=${param.rel }" title="添加"
						target="dialog" width="700" height="500" rel="${param.rel}_add"><span>新增帮扶情况</span>
					</a>
			</span>	
			<span style="float: right">
				<button class="btn btn-primary btn-small" type="submit">
					查询
				</button>&nbsp;
				<button class="btn btn-small clear" type="button">
					清空
			</button>&nbsp; </span>
		</div>
	</form>
</div>


<table id="${param.rel }_datagrid" toolbar="#${param.rel}_toolbar"
	border="true"></table>
	
<script type="text/JavaScript" >
	$(function() {
		$('#<%=request.getParameter("rel")%>_datagrid')
				.datagrid(
						{
							nowrap : false,//true:只在一行显示数据,false:内容多时自动换行，效率低
							url : "sqzw/query.do",
							columns : [ [
								  	{
										field : "ck",
										title : "勾选",
										checkbox : true
									}, 
								
									{
										field : "sqgb",
										title : "社区干部",			
										width : 100,						
										align : "center",
										sortable : true
									},
									{
										field : "sqmj",
										title : "社区民警",			
										width : 100,						
										align : "center",
										sortable : true
									},
									{
										field : "jdsg",
										title : "禁毒社工",			
										width : 100,						
										align : "center",
										sortable : true
									},
										{
										field : "wgy",
										title : "网格员",			
										width : 100,						
										align : "center",
										sortable : true
									},
									{
										field : "x",
										title : "X",			
										width : 100,						
										align : "center",
										sortable : true
									},
									{
										field : "addres",
										title : "所属地区",			
										width : 100,						
										align : "center",
										sortable : true
									},
									{
										field : "操作",
										title : "操作",
										width : 80,
										align : "center",
										formatter: function(value,row,index){
											return '<a href="sqzw/loadBf.do?sqzwid='
												+row.id
												+'&rel=${param.rel}_bf" rel="${param.rel}_bfqk" target="dialog" style="text-decoration:none;font-size:12px;font-weight:bold;"  width="950" height="500" title="帮扶列表">帮扶列表</a>';
										}
									}
							] ],
		});
	});
						
</script>