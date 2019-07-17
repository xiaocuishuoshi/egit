<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%--
	模块：慧联科技-系统管理-地址管理
--%>
<div id="${param.rel}_toolbar" class="search-div">
	<form onsubmit="return datagridSearch(this,'${param.rel }_datagrid');" >
		<input id="${param.rel}_id" name="puGrouping" type="hidden" value="0" />
		<div class="search-content ">
			<span> <label>
					资产名称：
				</label>
				<input type="text" name="zcmc" style="width: 90px" /> </span>
				<span> <label>
					资产资产编号：
				</label>
				<input type="text" name="zcbh" style="width: 90px" /> </span>
		</div>


		<div class="search-toolbar">
			<span style="float: left;"> 
				<a class="easyui-linkbutton clearDgChecked"  icon="icon-redo"	plain="true"  title="清空所有勾选项" >清空勾选</a>


				 <shiro:hasPermission name="public:add">
					<a class="easyui-linkbutton" icon="icon-add" plain="true" href="hlkj/zcgl/toadd.do?rel=${param.rel }"
						target="dialog" width="1000" height="500" rel="${param.rel}_add" title="添加" ><span>新增</span>
					</a>
				</shiro:hasPermission>
				  <shiro:hasPermission name="public:update">
					<a class="easyui-linkbutton" icon="icon-edit" plain="true" title="修改"
						href="hlkj/zcgl/toupdate.do?id={id}&rel=${param.rel}"
						target="dialog" width="1000" height="500"
						rel="ids"  warn="请先选择一条信息"><span>修改</span>
					</a>
				</shiro:hasPermission>
				 <shiro:hasPermission name="public:delete">
				 
				 	<a class="easyui-linkbutton" icon="icon-remove" plain="true"
							href="hlkj/zcgl/delete.do" target="selectedTodo" rel="ids"
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
	title="资产管理"></table>

<script type="text/javascript">	
	
	$(function() {
		
		$('#<%=request.getParameter("rel")%>_datagrid')
				.datagrid(
						{
							nowrap : false,//true:只在一行显示数据,false:内容多时自动换行，效率低
							url : "hlkj/zcgl/query.do",
							columns : [ [
									{
										field : "ck",
										title : "勾选",
										checkbox : true
									},
									{
										field : "addressName",
										title : "资产名称",
										width : 100,
										align : "center",
										formatter : function(value, row, index) {

											return '<a  datagrid="${param.rel }_datagrid" href="hlkj/zcgl/show.do?id='
													+ row.id
													+ '" target="navTab"    rel="${param.rel}_find" title="资产详情">'
													+ value + '</a>';
										}

									}, {
										field : "zcbh",
										title : "资产编号",
										width :100,
										align : "center",
										sortable : true

									}, {
										field : "ccbh",
										title : "出厂编号",
										width : 100,
										align : "center"

									},{
										field : "dept",
										title : "单位",
										width : 100,
										align : "center"

									},{
										field : "gys",
										title : "供应商",
										width : 100,
										align : "center"

									},{
										field : "azdd",
										title : "安装地点",
										width : 100,
										align : "center"

									},{
										field : "cgsj",
										title : "采购时间",
										width : 100,
										align : "center",
										sortable : true,
										formatter: function(value,row,index){
									return new Date(value).format("yyyy-MM-dd HH:mm:ss");
										}
	

									},{
										field : "sysm",
										title : "使用寿命",
										width : 100,
										align : "center"

									},{
										field : "cgjg",
										title : "采购价格",
										width : 100,
										align : "center"

									},{
										field : "sbcs",
										title : "设备参数",
										width : 100,
										align : "center"

									},{
										field : "zrr",
										title : "责任人",
										width : 100,
										align : "center"

									},{
										field : "sbzt",
										title : "设备状态",
										width : 100,
										align : "center"

									}
									,{
										field : "sblx",
										title : "设备类型",
										width : 100,
										align : "center"

									},{
										field : "desc",
										title : "描述",
										width : 100,
										align : "center"

									}
									
							] ],
							onDblClickRow:function(rowIndex, rowData){
								MUI.openDialog('修改地址信息','hlkj/zcgl/toupdate.do?id='+rowData.id+'&rel=<%=request.getParameter("rel")%>','<%=request.getParameter("rel")%>_update',{width:1000,height:500});
							}
						});
						
					});
//-->
</script>





