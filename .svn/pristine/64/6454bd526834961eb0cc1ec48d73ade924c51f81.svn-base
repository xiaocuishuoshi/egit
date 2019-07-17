<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%--
	模块：企业宣传，企业新闻列表
--%>
<div id="${param.rel}_toolbar" class="search-div">
	<form onsubmit="return datagridSearch(this,'${param.rel }_datagrid');" >
		<input id="${param.rel}_id" name="puGrouping" type="hidden" value="0" />
		<div class="search-content ">
			<span> <label>
					新闻标题：
				</label>
				<input type="text" name="title" style="width: 90px" /> </span>
				<span> <label>
					新闻摘要：
				</label>
				<input type="text" name="zy" style="width: 90px"/> </span>
				<span> <label>
					新闻作者：
				</label>
				<input type="text" name="zz" style="width: 90px"/> </span>
				<span> <label>
					新闻内容：
				</label>
				<input type="text" name="content" style="width: 90px"/> </span>
		</div>


		<div class="search-toolbar">
			<span style="float: left;"> 
				<a class="easyui-linkbutton clearDgChecked"  icon="icon-redo"	plain="true"  title="清空所有勾选项" >清空勾选</a>


				 <shiro:hasPermission name="public:add">
					<a class="easyui-linkbutton" icon="icon-add" plain="true" href="qyxw/load.do?rel=${param.rel }"
						target="dialog" width="1000" height="500" rel="${param.rel}_add" title="添加" ><span>新增</span>
					</a>
				</shiro:hasPermission>
				  <shiro:hasPermission name="public:update">
					<a class="easyui-linkbutton" icon="icon-edit" plain="true" title="修改"
						href="qyxw/updateQQ.do?id={id}&rel=${param.rel}"
						target="dialog" width="1000" height="500"
						rel="ids"  warn="请先选择一条信息"><span>修改</span>
					</a>
				</shiro:hasPermission>
				 <shiro:hasPermission name="public:delete">
				 
				 	<a class="easyui-linkbutton" icon="icon-remove" plain="true"
							href="qyxw/delete.do" target="selectedTodo" rel="ids"
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
	title="企业新闻"></table>

<script type="text/javascript">	
	
	$(function() {
		
		$('#<%=request.getParameter("rel")%>_datagrid')
				.datagrid(
						{
							nowrap : false,//true:只在一行显示数据,false:内容多时自动换行，效率低
							url : "qyxw/query.do",
							columns : [ [
									{
										field : "ck",
										title : "勾选",
										checkbox : true
									},
									{
										field : "title",
										title : "新闻标题",
										width : 140,
										align : "center",
										formatter : function(value, row, index) {

											return '<a  datagrid="${param.rel }_datagrid" href="qyxw/show.do?id='
													+ row.id
													+ '" target="navTab"    rel="${param.rel}_find" title="企业新闻详情">'
													+ value + '</a>';
										}

									}, {
										field : "zy",
										title : "新闻摘要",
										width : 46,
										align : "center",
										sortable : true

									}, {
										field : "zz",
										title : "新闻作者",
										width : 100,
										align : "center"

									}, {
										field : "content",
										title : "新闻内容",
										width : 120,
										align : "center",
										sortable : true

									}, {
										field : "fbsj",
										title : "发布时间",
										width : 80,
										align : "center",
										sortable : true,
										formatter: function(value,row,index){
									return new Date(value).format("yyyy-MM-dd HH:mm:ss");
										}
	
									}

							] ],
							onDblClickRow:function(rowIndex, rowData){
								MUI.openDialog('修改新闻','qyxw/updateQQ.do?id='+rowData.id+'&rel=<%=request.getParameter("rel")%>','<%=request.getParameter("rel")%>_update',{width:1000,height:500});
							}
						});
						
					});
//-->
</script>





