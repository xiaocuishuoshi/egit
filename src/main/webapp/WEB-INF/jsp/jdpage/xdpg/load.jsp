<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%> 
<%--
	模块：在线评估_吸毒评估
--%>

<div id="${param.rel}_toolbar" class="search-div">
	<form onsubmit="return datagridSearch(this,'${param.rel }_datagrid');">
		<div class="search-content ">
		<span>
			<label style="width: 100px">
				评估人姓名：
			</label> 
			<input type="text" name="name" style="width: 150px" op="like" >
			</span>
		</div>

		<div class="search-toolbar">
		<span style="float: left;"> 
	 	<a class="easyui-linkbutton clearDgChecked" icon="icon-redo"
				plain="true" title="清空所有勾选项">清空勾选</a> 
				
					<a class="easyui-linkbutton" icon="icon-add" plain="true"
						href="xdpg/add.do?rel=${param.rel }" title="添加"
						target="dialog" width="900" height="520" rel="${param.rel}_add"><span>吸毒人员评估</span>
					</a>
				
					<a class="easyui-linkbutton" icon="icon-remove" plain="true"
						href="xdpg/del.do" target="selectedTodo"
						rel="ids" title="确定要删除吗?" warn="至少选择一条信息"><span>批量删除</span>
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
							url : "xdpg/query.do",
							columns : [ [
								  	{
										field : "ck",
										title : "勾选",
										checkbox : true
									}, 
								
										{
										field : "name",
										title : "吸毒人姓名",			
										width : 100,						
										align : "center",
										formatter: function(value,row,index){
											return '<a href="xdpg/show.do?id='+row.id+'" target="dialog" width="900" height="520" rel="<%=request.getParameter("rel")%>_show" title="吸毒人员评估详情">'+value+'</a>';
										}
									},
									{
										field : "sljc",
										title : "生理检测",			
										width : 80,						
										align : "center",
									},
									
									
								{
										field : "jjljcs",
										title : "拒绝尿检次数",			
										width : 100,						
										align : "center",
									},
									
									
								{
										field : "zhpgyj",
										title : "综合评估意见",			
										width : 100,						
										align : "center",
									},
							
									
									{
										field : "pgsj",
										title : "评估时间",			
										width : 100,						
										align : "center",
									},
									
									
									{
										field : "mjyj",
										title : "社区民警意见",			
										width : 100,						
										align : "center",
									},
									
									
										
									{
										field : "zhds",
										title : "综合得分",			
										width : 100,						
										align : "center",
									},
							
							] ],
		});
	});
						
</script>