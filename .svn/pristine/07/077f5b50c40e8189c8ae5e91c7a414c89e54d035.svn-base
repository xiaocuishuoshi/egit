<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>
<%--
	模块：报警管理-推送消息
--%>
<div id="${param.rel}_toolbar" class="search-div">
	<form onsubmit="return datagridSearch(this,'${param.rel }_datagrid');"
	formatFilterData="true">

		<div class="search-content ">
			<span> <label>
					发送类型：
				</label>
				 <select name="xxType"  style="width: 100px;" submitForm="push">
					<option value="">所有</option>
					<option value="短信">短信</option>
					<option value="邮件">邮件</option>
				</select>
			</span>
			
				<span>
				<label>发布时间：</label>
				
					<input type="text"  onFocus="WdatePicker()"  name="startDate" class="span2"/>
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
<%--							multiSort : true,//是否进行多字段排序--%>
							url : "push/query.do",
							columns : [ [
								
									{
										field : "xxType",
										title : "发送类型",
										width : 120,
										align : "center",
									},
									{
										field : "xxTypename",
										title : "名称",
										width : 120,
										align : "center",
									},
									{
										field : "xxNr",
										title : "发送内容",
										width : 120,
										align : "center",
									},
									{
										field : "xxZname",
										title : "接收者",
										width : 120,
										align : "center"
									},
									{
										field : "xxFname",
										title : "发送者",
										width : 120,
										align : "center"

									},
									
									{
										field : "xxReslet",
										title : "发送结果",
										width : 120,
										align : "center"
									},
									
									{
										field : "xxTdate",
										title : "发送时间",
										width : 190,
										align : "center",
										sortable : true,
										formatter: function(value,row,index){
											return new Date(value).format("yyyy-MM-dd HH:mm");
										}
									}
							] ],
						
						});
						
					});
</script>







