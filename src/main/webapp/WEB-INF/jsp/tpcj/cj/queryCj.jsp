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
  					<shiro:hasPermission name="public:update">
					<a class="easyui-linkbutton" icon="icon-edit" plain="true" title="抽奖"
						href="tpcj/tocj.do?id={id}&rel=${param.rel}"
						target="dialog" width="1000" height="500"
						rel="ids"  warn="请先选择一条信息"><span>抽奖</span>
					</a>
				</shiro:hasPermission>

		<div class="search-toolbar">
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
							url : "tpcj/queryCj.do",
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
										align : "center"

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
										title : "是否有效",
										width : 100,
										align : "center"
									}
							] ],
								
						});
						
					});
//-->
</script>





