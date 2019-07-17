<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>


<div class="easyui-layout" fit="true" >
	<div  region="center" border="false">
		<div id="${param.rel}_toolbar" class="search-div">
	<form  onsubmit="return datagridSearch(this,'${param.rel }_datagrid');"  >
		<input id="${param.rel}_id" name="id" type="hidden" value="0"/>
		<div  class="search-content " >
			<span>
				<label>标题：</label>
				<input	type="text" name="tzsmc" class="span2"  />
				&nbsp;<i class="boot_icon-question-sign" selectLike="tooltip"></i>
			</span>
			
			<span>
				<label>接收人：</label>
				<a href="user/lookUpPage.do?type=2"  lookupGroup="user" title="用户查询">
						<input type="text"  name="cjry" readonly="readonly"  toName="user.trueName" >
					</a>
					<input type="hidden"   toName="user.id" />
			</span>
		</div>
	

		<div class="search-toolbar" >
			<span style="float:left;">
				<a class="easyui-linkbutton clearDgChecked"  icon="icon-redo"	plain="true"  title="清空所有勾选项" >清空勾选</a>
				
				<shiro:hasPermission name="tzsgl:add">  
					<a class="easyui-linkbutton"  icon="icon-add"	plain="true"
					  title="添加用户"   href="tzsgl/addPage.do?rel=${param.rel}"  target="dialog" width="900" height="400" rel="${param.rel}_add" >添加</a>
					
				</shiro:hasPermission>
				<shiro:hasPermission name="tzsgl:update">  
					<a class="easyui-linkbutton"  icon="icon-edit"	plain="true"
					  title="修改用户信息"	href="tzsgl/updatePage.do?id={id}&rel=${param.rel}" target="dialog" width="800" height="400" rel="${param.rel}_update" warn="请先选择一个用户" >修改</a>
					
				</shiro:hasPermission>
				<shiro:hasPermission name="tzsgl:delete">  
					<a class="easyui-linkbutton"  icon="icon-remove"	plain="true"
					   	 href="tzsgl/del.do" target="selectedTodo"  title="确定要删除吗?" warn="至少选择一个用户">批量删除</a>
				</shiro:hasPermission>
				
			</span>
			
			
			<span style="margin-left:600px;">
				<button class="btn btn-primary btn-small" type="submit">查询</button>&nbsp;
				<button class="btn btn-small clear" type="button" >清空</button>&nbsp;	
			</span>
		
		</div>
	</form>
	
</div>

<table id="${param.rel }_datagrid"   toolbar="#${param.rel}_toolbar"  title="信息交互--通知书管理"></table>

<script type="text/javascript">

	
	$(function() {
		$('#<%=request.getParameter("rel")%>_datagrid').datagrid({
			
			border:true,
			nowrap : false,
			url : "tzsgl/queryUsers.do",
			columns : [ [ 
				{
					field:"ck",
					title : "勾选",
					checkbox:true
				},
				{
					field : "tzsmc",
					title : "标题",
					align:"center",
					width : 100,
					formatter: function(value,row,index){
						
						return '<a href="tzsgl/show.do?id='+row.id+'" target="dialog" width="1000" height="400" rel="<%=request.getParameter("rel")%>_show" title="查看用户详情">'+value+'</a>';
					}
				},
			 	 {
					field : "cjsj",
					title : "接收时间",
					align:"center",
					width : 80,
					sortable : true,
					formatter: function(value,row,index){
						if(value!=null)
						return new Date(value).format("yyyy-MM-dd HH:mm:ss");
					}
				}  
			] ]
		});
		
	});
	
</script>
	</div>
</div>

