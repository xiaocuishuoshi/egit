<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%--
	模块：慧联科技-系统管理-地址管理
--%>
<div id="${param.rel}_toolbar" class="search-div">
	<form onsubmit="return datagridSearch(this,'${param.rel }_datagrid');" >
		<input id="${param.rel}_id" name="puGrouping" type="hidden" value="0" />
		<div class="search-content ">
			<span> <label>
					地址名称：
				</label>
				<input type="text" name="addressName" style="width:90px" /> </span>
		</div>

			<input type="hidden" id="${param.rel }_wdSuperId" name="wdSuperId" />
		<div class="search-toolbar">
			<span style="float: left;"> 
				<a class="easyui-linkbutton clearDgChecked"  icon="icon-redo"	plain="true"  title="清空所有勾选项" >清空勾选</a>


					<a class="easyui-linkbutton" icon="icon-add" plain="true" href="hlkj/address/toadd.do?rel=${param.rel }&wdSuperId={#${param.rel }_wdSuperId}"
						target="dialog" width="1000" height="500" rel="${param.rel}_add" title="添加" ><span>新增</span>
					</a>
					<a class="easyui-linkbutton" icon="icon-edit" plain="true" title="修改"
						href="hlkj/address/toupdate.do?id={id}&rel=${param.rel}"
						target="dialog" width="1000" height="500"
						rel="ids"  warn="请先选择一条信息"><span>修改</span>
					</a>
				 
				 	<a class="easyui-linkbutton" icon="icon-remove" plain="true"
							href="hlkj/address/delete.do" target="selectedTodo" rel="ids"
							title="确定要删除吗?" warn="至少选择一条信息"><span>批量删除</span>
						</a>
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
	title="地址管理"></table>

<script type="text/javascript">

	function getwal(){
		var s = document.getElementsByName("wdSuperId").value;
		alert(s);
		document.getElementById("fa").value=s;
		
	}
</script>

<script type="text/javascript">	

	$(function() {
		
		$('#<%=request.getParameter("rel")%>_datagrid')
				.datagrid(
						{
							nowrap : false,//true:只在一行显示数据,false:内容多时自动换行，效率低
							url : "hlkj/address/query.do",
							columns : [ [
									{
										field : "ck",
										title : "勾选",
										checkbox : true
									},
									{
										field : "addressName",
										title : "地址名称",
										width : 100,
										align : "center",
										formatter : function(value, row, index) {

											return '<a  datagrid="${param.rel }_datagrid" href="hlkj/address/show.do?id='
													+ row.id
													+ '" target="navTab"    rel="${param.rel}_find" title="地址详情">'
													+ value + '</a>';
										}

									}, {
										field : "father",
										title : "父节点",
										width :100,
										align : "center",
										sortable : true

									}, {
										field : "addressJb",
										title : "级别",
										width : 100,
										align : "center"

									},{
										field : "addressFlmc",
										title : "分类名称",
										width : 100,
										align : "center"

									},{
										field : "addressSb",
										title : "设备信息",
										width : 100,
										align : "center"

									},{
										field : "addressDesc",
										title : "顺序",
										width : 100,
										align : "center"

									},{
											field : "op",
											title : "操作",
											align:"center",
											width : 50,
											formatter: function(value,row,index){
											//	return "<a onclick=\"getAddressStatusWin('"+row.desc+"');\">编辑拓扑图</a>";
										return '<a  href="hlkj/address/findTp.do?rel=hlkj_addressTp&taskId='+row.id+'" target="_blank" datagrid="<%=request.getParameter("rel")%>_datagrid"  >编辑拓扑图</a>';
												
											}
									}
							] ],
							onDblClickRow:function(rowIndex, rowData){
								MUI.openDialog('修改地址信息','hlkj/address/toupdate.do?id='+rowData.id+'&rel=<%=request.getParameter("rel")%>','<%=request.getParameter("rel")%>_update',{width:1000,height:500});
							}
						});
						
					});
//-->
</script>





