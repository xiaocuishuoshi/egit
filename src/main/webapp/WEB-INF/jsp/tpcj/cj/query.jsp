<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%--
	模块：投票抽奖-抽奖
--%>
<div id="${param.rel}_toolbar" class="search-div">
	<form onsubmit="return datagridSearch(this,'${param.rel }_datagrid');" >
		<input id="${param.rel}_id" name="puGrouping" type="hidden" value="0" />
		<div class="search-content ">
			<span> <label>
					标题：
				</label>
				<input type="text" name="cjtitle" style="width: 90px" /> </span>
		</div>


		<div class="search-toolbar">
			<span style="float: left;"> 
				<a class="easyui-linkbutton clearDgChecked"  icon="icon-redo"	plain="true"  title="清空所有勾选项" >清空勾选</a>


				 <shiro:hasPermission name="public:add">
					<a class="easyui-linkbutton" icon="icon-add" plain="true" href="tpcj/saveTo.do?rel=${param.rel }"
						target="dialog" width="1000" height="500" rel="${param.rel}_add" title="添加" ><span>新增</span>
					</a>
				</shiro:hasPermission>
				  <shiro:hasPermission name="public:update">
					<a class="easyui-linkbutton" icon="icon-edit" plain="true" title="修改"
						href="tpcj/updateQQ.do?id={id}&rel=${param.rel}"
						target="dialog" width="1000" height="500"
						rel="ids"  warn="请先选择一条信息"><span>修改</span>
					</a>
				</shiro:hasPermission>
				 <shiro:hasPermission name="public:delete">
				 
				 	<a class="easyui-linkbutton" icon="icon-remove" plain="true"
							href="tpcj/delete.do" target="selectedTodo" rel="ids"
							title="确定要删除吗?" warn="至少选择一条信息"><span>批量删除</span>
						</a>
				</shiro:hasPermission>
					<button class="btn btn-primary btn-small" type="submit">
						查询
					</button>&nbsp;
					<button class="btn btn-small clear" type="button">
						清空
					</button>&nbsp; </span>
		</div>
	</form>

</div>

<table id="${param.rel }_datagrid" toolbar="#${param.rel}_toolbar" border="true"
	title="抽奖管理"></table>

<script type="text/javascript">	
	
	$(function() {
		
		$('#<%=request.getParameter("rel")%>_datagrid')
				.datagrid(
						{
							nowrap : false,//true:只在一行显示数据,false:内容多时自动换行，效率低
							url : "tpcj/query.do",
							columns : [ [
									{
										field : "ck",
										title : "勾选",
										checkbox : true
									},
									{
										field : "cjtitle",
										title : "标题",
										width : 100,
										align : "center",
										formatter : function(value, row, index) {

											return '<a  datagrid="${param.rel }_datagrid" href="tpcj/show.do?id='
													+ row.id
													+ '" target="navTab"    rel="${param.rel}_find" title="抽奖详情">'
													+ value + '</a>';
										}

									}, {
										field : "ms",
										title : "描述",
										width :100,
										align : "center",
										sortable : true

									}, {
										field : "rbrq",
										title : "发布日期",
										width : 100,
										align : "center",
										sortable : true,
										formatter: function(value,row,index){
									return new Date(value).format("yyyy-MM-dd HH:mm:ss");
										}
	

									}, {
										field : "sfsx",
										title : "是否生效",
										width : 100,
										align : "center"

									}
							] ],
							onDblClickRow:function(rowIndex, rowData){
								MUI.openDialog('修改投票','tpcj/updateQQ.do?id='+rowData.id+'&rel=<%=request.getParameter("rel")%>','<%=request.getParameter("rel")%>_update',{width:1000,height:500});
							}
						});
						
					});
//-->
</script>





