<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>
<%--
	模块：报警管理-报警规则
--%>
<div id="${param.rel}_toolbar" class="search-div">
	<form onsubmit="return datagridSearch(this,'${param.rel }_datagrid');"
	formatFilterData="true">

		<div class="search-content ">
			<span> <label>
					规则名称：
				</label> <input type="text" name="gzGzname" style="width: 90px" />
				 </span>
		</div>

		<div class="search-toolbar">
			<span style="float: left;"> <a
				class="easyui-linkbutton clearDgChecked" icon="icon-redo"
				plain="true" title="清空所有勾选项">清空勾选</a>
				  <shiro:hasPermission name="sr:add">
					<a class="easyui-linkbutton" icon="icon-add" plain="true"
						href="sr/add.do?rel=${param.rel}" title="添加报警规则"
						target="navTab" width="1000" height="500" rel="${param.rel}_add"><span>添加报警规则</span>
					</a>
				</shiro:hasPermission> 
				<shiro:hasPermission name="sr:update">
					<a class="easyui-linkbutton" icon="icon-edit" plain="true"
						title="修改报警规则" href="sr/update.do?id={gzId}&rel=${param.rel}"
						target="navTab" width="1000" height="500"
						rel="${param.rel}_update" warn="请先选择一 条信息"><span>修改报警规则</span> </a>
				</shiro:hasPermission>
				 <shiro:hasPermission name="sr:delete">
					<a class="easyui-linkbutton" icon="icon-remove" plain="true"
						href="sr/del.do?rel=${param.rel}" target="selectedTodo"
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

<script type="text/javascript">	
	
	$(function() {
		
		$('#<%=request.getParameter("rel")%>_datagrid')
				.datagrid(
						{
							nowrap : false,//true:只在一行显示数据,false:内容多时自动换行，效率低
<%--							multiSort : true,//是否进行多字段排序--%>
							url : "sr/query.do",
							columns : [ [
									{
										field : "ck",
										title : "勾选",
										checkbox : true
									},
									{
										field : "gzGzname",
										title : "规则名称",
										width : 120,
										align : "center",
									},
									{
										field : "gzSbtype",
										title : "设备类型",
										width : 120,
										align : "center",
									},
									{
										field : "gzSbjb",
										title : "报警级别",
										width : 120,
										align : "center",
									},
									{
										field : "gzBjtype",
										title : "报警类型",
										width : 120,
										align : "center"
									},
									{
										field : "gzTime",
										title : "持续时间",
										width : 120,
										align : "center"

									},
									
									{
										field : "gzGz",
										title : "报警规则",
										width : 120,
										align : "center"
									},
									
									{
										field : "gzKdate",
										title : "开始时间",
										width : 190,
										align : "center",
										sortable : true,
										formatter: function(value,row,index){
											return new Date(value).format("yyyy-MM-dd HH:mm");
										}
									},
									{
										field : "gzJdate",
										title : "结束时间",
										width : 190,
										align : "center",
										sortable : true,
										formatter: function(value,row,index){
											return new Date(value).format("yyyy-MM-dd HH:mm");
										}
									},
									{
										field : "gzCount",
										title : "发送次数",
										width : 120,
										align : "center"
									},
									{
										field : "gzKg",
										title : "报警开关",
										width : 120,
										align : "center"
									},
									{
										field : "gzFacility",
										title : "适应设备",
										width : 120,
										align : "center"
									},
									{
										field : "gzDescribe",
										title : "描述",
										width : 120,
										align : "center"
									},
									{
										field : "gzPhone",
										title : "负责人手机",
										width : 120,
										align : "center"
									},
									{
										field : "gzEmail",
										title : "负责人邮件",
										width : 120,
										align : "center"
									} 
							] ],
							onDblClickRow:function(rowIndex, rowData){
								MUI.openCenterTab('修改报警规则','sr/update.do?id='+rowData.gzId+'&rel=<%=request.getParameter("rel")%>','<%=request.getParameter("rel")%>_update',false,false);
							}
						});
						
					});
</script>







