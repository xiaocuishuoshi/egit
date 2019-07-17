<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>
<%--
	模块：报能效分析-历史记录
--%>
<div id="${param.rel}_toolbar" class="search-div">
	<form onsubmit="return datagridSearch(this,'${param.rel }_datagrid');"
	formatFilterData="true">

		<div class="search-content">
			<span> <label>
					设备类型：
				</label>
				 <input type="text" name="lsDevicetype" style="width: 90px" />
			</span>
			<span> <label>
					虚拟号：
				</label>
				 <input type="text" name="lsVirtual" style="width: 90px" />
			</span>
			
				<span> <label>
					属性名：
				</label>
				 <input type="text" name="lsAttributename" style="width: 90px" />
			</span>
			
				<span>
				<label>开始时间：</label>
					<input type="text"  onFocus="WdatePicker()" name="startDate" class="span2"/>
					结束时间
					<input type="text"  onFocus="WdatePicker()" name="endDate" class="span2"/>
			</span>
		</div>

		<div class="search-toolbar">

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
							url : "ht/query.do",
							columns : [ [
								
									{
										field : "lsVirtual",
										title : "虚拟号",
										width : 120,
										align : "center",
									},
									{
										field : "lsAttributename",
										title : "属性名",
										width : 120,
										align : "center",
									},
									{
										field : "lsDatatype",
										title : "数据类型",
										width : 120,
										align : "center",
									},
									{
										field : "lsAbility",
										title : "属性值",
										width : 120,
										align : "center"
									},
									{
										field : "lsDate",
										title : "更新时间",
										width : 120,
										align : "center",
										sortable : true,
										formatter: function(value,row,index){
											return new Date(value).format("yyyy-MM-dd HH:mm:ss");
										}

									},
									
									{
										field : "lsDevicetype",
										title : "设备类型",
										width : 120,
										align : "center"
									}
							] ],
						
						});
						
					});
</script>