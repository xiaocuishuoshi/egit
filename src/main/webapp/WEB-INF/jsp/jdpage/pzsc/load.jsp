<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>

<% String path=request.getContextPath(); %>
<div class="easyui-layout" fit="true" >
	<div  region="center" border="false">
		<div id="${param.rel}_toolbar" class="search-div">
	<form  onsubmit="return datagridSearch(this,'${param.rel }_datagrid');"  >
		<input id="${param.rel}_id" name="id" type="hidden" value="0"/>
		<div  class="search-content " >
		 
			<span>
				<label>拍照人姓名:</label>
				<input	type="text" name="pzryxm" class="span2"  />
				<i class="boot_icon-question-sign" selectLike="tooltip"></i>
			</span>
		</div>
		<div class="search-toolbar" >
			<span style="float:left;">
				<a class="easyui-linkbutton clearDgChecked"  icon="icon-redo"	plain="true"  title="清空所有勾选项" >清空勾选</a>
				
				<shiro:hasPermission name="pzsc:delete">  
					<a class="easyui-linkbutton"  icon="icon-remove"	plain="true"
					   	 href="pzsc/del.do" target="selectedTodo"  title="请谨慎操作！删除用户的同时也会删除跟用户相关的一些数据，如果想保留数据，可以设置禁止用户登录系统代替删除。确定要删除吗?" warn="至少选择一个用户">批量删除</a>
				</shiro:hasPermission>
				
			</span>
			
			<span style="margin-left:850px;">
				<button class="btn btn-primary btn-small" type="submit">查询</button>&nbsp;
				<button class="btn btn-small clear" type="button" >清空</button>&nbsp;	
			</span>
		</div>
	</form>
	
</div>

		<table id="${param.rel }_datagrid" toolbar="#${param.rel}_toolbar"
			title="人机状态--拍照上传管理"></table>

<script type="text/javascript">
		
	$(function() {
		$('#<%=request.getParameter("rel")%>_datagrid').datagrid({
			
			border:true,
			nowrap : false,
			url : "pzsc/query.do",
			columns : [ [ 
				{
					field:"ck",
					title : "勾选",
					checkbox:true
				},
				{
					field : "pzryxm",
					title : "拍照人姓名",
					align:"center",
					width : 50,
					formatter: function(value,row,index){
						
						return '<a href="pzsc/show.do?id='+row.id+'" target="dialog" width="950" height="450" rel="<%=request.getParameter("rel")%>_show" title="查看用户详情">'+value+'</a>';
					}
				},
				{
					field : "zpdz",
					title : "照片",
					align:"center",
					width : 50,
					formatter:function(value,rec){  
	                var btn = '<image src=<%=path%>/'+value+'/>';  
	                return btn;  
           		 }  
				},
			 	 {
					field : "pzsj",
					title : "拍照时间",
					align:"center",
					width : 50
				},{
					field : "操作",
					title : "操作",
					align:"center",
					width : 30,
					formatter:function(value,row,index){
						return '<a  datagrid="${param.rel }_datagrid" href="pzsc/CkWz.do?id='+row.id+'&rel=${param.rel}&lat='+row.lan+'&lng='+row.lng+'" width="1000"  plain="true" target="dialog"  title="查看位置">查看位置</a>';
					}
				} 
			] ] 
		});
		
	});
</script>
	</div>
</div>

