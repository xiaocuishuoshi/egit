<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%> 
<%--
	模块：康复检查管理-定期检查
--%>

<div id="${param.rel}_toolbar" class="search-div">
	<form onsubmit="return datagridSearch(this,'${param.rel }_datagrid');">
		<div class="search-content ">
			<span>
				<label>
					戒毒人员：
				</label> 
				 <input type="text" name="name" style="width: 150px" op="like" />
			</span>
			<span>
				<label>
					尿检类型：
				</label> 
				 <select style="width: 150px" op="like" >
				 	<option>(请选择)</option>	
				 	<option>本地尿检</option>
				 	<option>异地尿检</option>
				 </select>
			</span>
			<span>
				<label>
					尿检结果：
				</label> 
				 <select style="width: 150px" op="like" >
				 	<option>(请选择)</option>	
				 	<option>正常</option>
				 	<option>不正常</option>
				 </select>
			</span>
		</div>

		<div class="search-toolbar">
		<span style="float: left;"> 
	 	<a class="easyui-linkbutton clearDgChecked" icon="icon-redo"
				plain="true" title="清空所有勾选项">清空勾选</a> 
				
			 	<shiro:hasPermission name="jbxx:add">
					<a class="easyui-linkbutton" icon="icon-add" plain="true"
						href="kfjc/add.do?rel=${param.rel }" title="添加"
						target="dialog" width="520" height="520" rel="${param.rel}_add"><span>登记检查</span>
					</a>
				 </shiro:hasPermission>  
				
				 <shiro:hasPermission name="jbxx:delete"> 
					<a class="easyui-linkbutton" icon="icon-remove" plain="true"
						href="kfjc/del.do" target="selectedTodo"
						rel="ids" title="确定要删除吗?" warn="至少选择一条信息"><span>批量删除</span> </a>			
				</shiro:hasPermission>
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
							url : "kfjc/query.do?sfzc=2&dh=2",
							 rowStyler:function(value,row,index){
				      			if (row.sfzc == "未检查"){
									//当单元格的值等于1的时候，颜色变成红色
				      				return 'background-color:#FF0000;';
				     			}else if(row.sfzc == "阴性"){
				     				return 'background-color:#FFFF00;';
				     			}
			     			}, 
							columns : [ [
								  	{
										field : "ck",
										title : "勾选",
										checkbox : true
									},{
										field : "name",
										title : "戒毒人员",			
										width : 80,						
										align : "center",
									},
									{
										field : "dh",
										title : "戒毒人员电话",			
										width : 80,						
										align : "center",
									},
									{
										field : "jcsj",
										title : "检查时间",			
										width : 80,						
										align : "center",
									},
									{
										field : "jcsm",
										title : "检查说明",			
										width : 180,						
										align : "center",
									},
									{
										field : "sfzc",
										title : "是否正常",			
										width : 80,						
										align : "center",
									},
									{
										field : "filePath",
										title : "附件",			
										width : 80,						
										align : "center",
										formatter:function(value,row,index){

											return "<a>图片</a>"
										}
									},
									{
										field : "fzr",
										title : "负责人",			
										width : 80,						
										align : "center",
									}
							] ],
		});
	});
						
</script>