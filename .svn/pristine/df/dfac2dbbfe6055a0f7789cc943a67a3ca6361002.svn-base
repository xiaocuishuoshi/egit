<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>
<%--
	模块：报警管理-报警记录
--%>
<div id="${param.rel}_toolbar" class="search-div">
	<form onsubmit="return datagridSearch(this,'${param.rel }_datagrid');"
	formatFilterData="true">

		<div class="search-content ">
			<span> <label>
					设备ID：
				</label> <input type="text" name="jlSbid" style="width: 90px" />
				 </span>
		</div>

		<div class="search-toolbar">
			<span style="float: left;"> <a
				class="easyui-linkbutton clearDgChecked" icon="icon-redo"
				plain="true" title="清空所有勾选项">清空勾选</a>
				  <shiro:hasPermission name="sr:add">
					<a class="easyui-linkbutton" icon="icon-add" plain="true"
						href="reco/add.do?rel=${param.rel}" title="添加报警规则"
						target="navTab" width="1000" height="500" rel="${param.rel}_add"><span>添加报警记录</span>
					</a>
				</shiro:hasPermission> 
				<shiro:hasPermission name="reco:update">
					<a class="easyui-linkbutton" icon="icon-edit" plain="true"
						title="修改报警规则" href="reco/update.do?id={jlId}&rel=${param.rel}"
						target="navTab" width="1000" height="500"
						rel="${param.rel}_update" warn="请先选择一 条信息"><span>修改报警规则</span> </a>
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
							url : "reco/query.do",
							columns : [ [
									{
										field : "ck",
										title : "勾选",
										checkbox : true
									},
									{
										field : "jlSbid",
										title : "设备ID",
										width : 120,
										align : "center",
									},
									{
										field : "jlSbtype",
										title : "设备类型",
										width : 120,
										align : "center",
									},
									{
										field : "jlBjjb",
										title : "报警级别",
										width : 120,
										align : "center",
									},
									{
										field : "jlBjtype",
										title : "报警类型",
										width : 120,
										align : "center"
									},
									{
										field : "jlBjgz",
										title : "报警规则",
										width : 120,
										align : "center"

									},
									
									{
										field : "jlBjdz",
										title : "报警地址",
										width : 120,
										align : "center"
									},
									
									{
										field : "jlStime",
										title : "当前时间",
										width : 190,
										align : "center",
										sortable : true,
										formatter: function(value,row,index){
											return new Date(value).format("yyyy-MM-dd HH:mm");
										}
									},
									{
										field : "jlMs",
										title : "描述",
										width : 190,
										align : "center",
									
									},
									{
										field : "jlPhone",
										title : "负责人手机",
										width : 120,
										align : "center"
									},
									{
										field : "jlReslet",
										title : "结果",
										width : 120,
										align : "center"
									},
									{
										field : "jlZt",
										title : "状态",
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







