<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%> 

<div id="${param.rel}_toolbar" class="search-div">
	<form  onsubmit="return datagridSearch(this,'${param.rel }_datagrid');"  >
		<input id="${param.rel}_id" name="id" type="hidden" value="0"/>
	
		<div class="search-toolbar" >
			<span style="float:left;">
				<a class="easyui-linkbutton clearDgChecked"  icon="icon-redo"	plain="true"  title="清空所有勾选项" >清空勾选</a>
				
				<shiro:hasPermission name="jbxx:add">  
					<a class="easyui-linkbutton"  icon="icon-add"	plain="true"
					  title="添加"   href="jiedu/man/relationship/edit.do?id=0&userId=${man.id}&rel=${param.rel}"  target="dialog" width="600" height="500" rel="${param.rel}_add" >添加</a>
					
				</shiro:hasPermission>
				<shiro:hasPermission name="jbxx:update">  
					<a class="easyui-linkbutton"  icon="icon-edit"	plain="true"
					  title="修改"	href="jiedu/man/relationship/edit.do?id={id}&userId=${man.id}&rel=${param.rel}" target="dialog" width="600" height="500" rel="${param.rel}_update" warn="请先选择一条记录" >修改</a>
					
				</shiro:hasPermission>
				<shiro:hasPermission name="jbxx:delete">  
					<a class="easyui-linkbutton"  icon="icon-remove"	plain="true"
					   	 href="jiedu/man/relationship/delete.do" target="selectedTodo"  title="确定要删除吗?" warn="至少选择一个用户">删除</a>
				</shiro:hasPermission>
				
			</span>
		
		</div>
	</form>
	
</div>

<table id="man_relationship_datagrid"   style="width:100%" toolbar="#${param.rel}_toolbar">
</table>

<script type="text/javascript">

$(function(){
	initGrid();
})

function initGrid(){

	$('#man_relationship_datagrid').datagrid({
		nowrap : true,
		url : "jiedu/man/relationship/query.do?userId=${man.id}",
		columns : [ [ 
			{
				field:"ck",
				title : "勾选",
				checkbox:true
			},
			 {
				field : "name",
				title : "姓名",
				align:"center",
				width:30,
			},
			{
				field : "sex",
				title : "性别",
				align:"center",
				width:50,
				formatter: function(value,row,index){
					
					return value==1?"男":"女";
				}
			},
			{
				field : "birthday",
				title : "年龄",
				align:"center",
				width:50
			},
		 	 {
				field : "relationship",
				title : "关系",
				align:"center",
				width:50
			} ,
		 	 {
				field : "address",
				title : "家庭住址",
				align:"center",
				width:50
			} ,
		 	 {
				field : "phone",
				title : "联系电话",
				align:"center",
				width:50
			}
		  
		] ]
	});
}

</script>