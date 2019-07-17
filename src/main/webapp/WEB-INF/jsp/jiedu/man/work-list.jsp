<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div id="${param.rel}_toolbar" class="search-div">
	<form  onsubmit="return datagridSearch(this,'${param.rel }_datagrid');"  >
		<input id="${param.rel}_id" name="id" type="hidden" value="0"/>
	
		<div class="search-toolbar" >
			<span style="float:left;">
				<a class="easyui-linkbutton clearDgChecked"  icon="icon-redo"	plain="true"  title="清空所有勾选项" >清空勾选</a>
				
				<shiro:hasPermission name="jbxx:add">  
					<a class="easyui-linkbutton"  icon="icon-add"	plain="true"
					  title="添加"   href="jiedu/man/work/edit.do?id=0&userId=${man.id}&rel=${param.rel}"  target="dialog" width="600" height="500" rel="${param.rel}_add" >添加</a>
					
				</shiro:hasPermission>
				<shiro:hasPermission name="jbxx:update">  
					<a class="easyui-linkbutton"  icon="icon-edit"	plain="true"
					  title="修改"	href="jiedu/man/work/edit.do?id={id}&userId=${man.id}&rel=${param.rel}" target="dialog" width="600" height="500" rel="${param.rel}_update" warn="请先选择一条记录" >修改</a>
					
				</shiro:hasPermission>
				<shiro:hasPermission name="jbxx:delete">  
					<a class="easyui-linkbutton"  icon="icon-remove"	plain="true"
					   	 href="jiedu/man/work/delete.do" target="selectedTodo"  title="确定要删除吗?" warn="至少选择一个用户">删除</a>
				</shiro:hasPermission>
				
			</span>
		
		</div>
	</form>
	
</div>

<table id="man_work_datagrid"   style="width:100%" toolbar="#${param.rel}_toolbar">
</table>

<script type="text/javascript">

$(function(){
	initGrid();
})

function initGrid(){

	$('#man_work_datagrid').datagrid({
		nowrap : true,
		url : "jiedu/man/work/query.do?userId=${man.id}",
		columns : [ [ 
			{
				field:"ck",
				title : "勾选",
				checkbox:true
			},
			 {
				field : "startDate",
				title : "起止",
				align:"center",
				width:30,
			},
			{
				field : "endDate",
				title : "止时",
				align:"center",
				width:50
			},
			{
				field : "job",
				title : "职业",
				align:"center",
				width:50
			},
		 	 {
				field : "company",
				title : "所在单位",
				align:"center",
				width:50
			},
		 	 {
				field : "postion",
				title : "职位",
				align:"center",
				width:50
			}
		  
		] ]
	});
}

</script>