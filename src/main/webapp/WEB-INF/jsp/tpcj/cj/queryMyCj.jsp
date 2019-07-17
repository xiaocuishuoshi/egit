<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
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
					<button class="btn btn-primary btn-small" type="submit">
						查询
					</button>&nbsp;
					<button class="btn btn-small clear" type="button">
						清空
					</button>&nbsp; </span>
		</div>
	</form>

</div>

<table id="${param.rel }_toolbar" toolbar="#${param.rel}_toolbar" border="true"
	title="抽奖记录"></table>

<script type="text/javascript">	
	
	$(function() {
		
		$('#<%=request.getParameter("rel")%>_datagrid')
				.datagrid(
						{
							nowrap : false,//true:只在一行显示数据,false:内容多时自动换行，效率低
							url : "tpcj/queryJl.do",
							columns : [ [
									{
										field : "ck",
										title : "勾选",
										checkbox : true
									},
									{
										field : "cjId",
										title : "标题",
										width : 100,
										align : "center"

									}, {
										field : "cjrq",
										title : "抽奖日期",
										width :100,
										align : "center",
										sortable : true,
										formatter: function(value,row,index){
									return new Date(value).format("yyyy-MM-dd HH:mm:ss");
										}
										
									}, {
										field : "cjJx",
										title : "奖项",
										width : 100,
										align : "center",
										sortable : true,
										

									}, {
										field : "cjJp",
										title : "奖品",
										width : 100,
										align : "center"
									}
							] ],
								
						});
						
					});
//-->
</script>





