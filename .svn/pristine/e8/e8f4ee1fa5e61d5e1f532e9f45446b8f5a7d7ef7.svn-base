<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%--
	模块：企业宣传，企业简介列表
--%>
<div id="${param.rel}_toolbar" class="search-div">
	<form onsubmit="return datagridSearch(this,'${param.rel }_datagrid');" >
		<input id="${param.rel}_id" name="puGrouping" type="hidden" value="0" />
		<div class="search-content ">
			<span> <label>
					企业名称：
				</label>
				<input type="text" name="name" style="width: 90px" /> </span>
				<span> <label>
					联系电话：
				</label>
				<input type="text" name="telphone" style="width: 90px"/> </span>
		</div>


		<div class="search-toolbar">
			<span style="float: left;"> 
				<a class="easyui-linkbutton clearDgChecked"  icon="icon-redo"	plain="true"  title="清空所有勾选项" >清空勾选</a>


				 <shiro:hasPermission name="public:add">
					<a class="easyui-linkbutton" icon="icon-add" plain="true" href="qyxc/load.do?rel=${param.rel }"
						target="dialog" width="1000" height="500" rel="${param.rel}_add" title="添加" ><span>新增</span>
					</a>
				</shiro:hasPermission>
				  <shiro:hasPermission name="public:update">
					<a class="easyui-linkbutton" icon="icon-edit" plain="true" title="修改"
						href="qyxc/updateQQ.do?id={id}&rel=${param.rel}"
						target="dialog" width="1000" height="500"
						rel="${param.rel}_update" warn="请先选择一条信息"><span>修改</span>
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
	title="企业简介维护"></table>

<script type="text/javascript">	
	
	$(function() {
		
		$('#<%=request.getParameter("rel")%>_datagrid')
				.datagrid(
						{
							nowrap : false,//true:只在一行显示数据,false:内容多时自动换行，效率低
							url : "qyxc/query.do",
							columns : [ [
									{
										field : "ck",
										title : "勾选",
										checkbox : true
									},
									{
										field : "name",
										title : "企业名称",
										width : 140,
										align : "center",
										formatter : function(value, row, index) {

											return '<a  datagrid="${param.rel }_datagrid" href="qyxc/show.do?id='
													+ row.id
													+ '" target="navTab"    rel="${param.rel}_find" title="企业简介详情">'
													+ value + '</a>';
										}

									}, {
										field : "addres",
										title : "企业地址",
										width : 46,
										align : "center",
										sortable : true

									}, {
										field : "telphone",
										title : "联系电话",
										width : 100,
										align : "center"

									}, {
										field : "cz",
										title : "传真",
										align : "center",
										sortable : true

									}, {
										field : "qyfr",
										title : "企业法人",
										width : 80,
										align : "center",
										sortable : true

									}, {
										field : "zczj",
										title : "注册资金",
										width : 120,
										align : "center",
										sortable : true

									}, {
										field : "qyjj",
										title : "企业简介",
										width : 120,
										align : "center",
										sortable : true

									}

							] ],
							onDblClickRow:function(rowIndex, rowData){
								MUI.openDialog('修改人员','qyxc/updateQQ.do?id='+rowData.id+'&rel=<%=request.getParameter("rel")%>','<%=request.getParameter("rel")%>_update',{width:1000,height:500});
							}
						});
						
					});
//-->
</script>





