<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%> 
<%--
	模块：宣传教育管理
--%>
<div id="${param.rel}_toolbar" class="search-div">
	<form onsubmit="return datagridSearch(this,'${param.rel }_datagrid');">
		<div class="search-content ">
		<span>
			<label>
				宣传六进：
			</label> 
				<select name="jdXcbt" submitForm="xcjy" style="width: 120px;"> 
					<option value="">全部</option>
					<option value="进学校">进学校</option>
					<option value="进社区">进社区</option>
					<option value="进农村">进农村</option>
					<option value="进单位">进单位</option>
					<option value="进家庭">进家庭</option>
					<option value="进场所">进场所</option>
				</select>
			</span>
		</div>

		<div class="search-toolbar">
		<span style="float: left;"> 
	 	<a class="easyui-linkbutton clearDgChecked" icon="icon-redo"
				plain="true" title="清空所有勾选项">清空勾选</a> 
				
					<a class="easyui-linkbutton" icon="icon-add" plain="true"
						href="xcjy/add.do?rel=${param.rel }" title="添加"
						target="dialog" width="680" height="520" rel="${param.rel}_add"><span>宣传教育</span>
					</a>
				
					<a class="easyui-linkbutton" icon="icon-remove" plain="true"
						href="xcjy/del.do" target="selectedTodo"
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
							url : "xcjy/query.do",
							columns : [ [
								  	{
										field : "ck",
										title : "勾选",
										checkbox : true
									}, 
								
										{
										field : "jdXcbt",
										title : "宣传六进",			
										width : 100,						
										align : "center",
									},
									{
										field : "jdXcnr",
										title : "宣传内容",			
										width : 200,						
										align : "center",
									},
									{
										field : "jdSj",
										title : "宣传时间",			
										width : 100,						
										align : "center",
										sortable : true,
										formatter: function(value,row,index){
											return new Date(value).format("yyyy-MM-dd");
										}
									},
								{
										field : "jdTp",
										title : "宣传图片",
										width : 80,
										align : "center",
										sortable : true,
										formatter:
										   function(value,row,index){
										   		if(value==null || value==""){
										   			 return;
										   		}else{
										   	 		return '<img src="'+value+'" style="width:120px;height:150px;margin-top:-3px;"/>';
												
										   	  }
										  }  
									},	
							] ],
		});
	});
						
</script>