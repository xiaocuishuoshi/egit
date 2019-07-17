<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%--
	模块：慧联科技-系统管理-地址管理
--%>
<script type="text/javascript">
<!--//
	function updateDevice(){
		var chks = $("#${param.rel}_datagrid").datagrid("getChecked");
		if(chks &&　chks.length==1){
			var chk = chks[0];
			var url = "toupdateSb.do?id="+(chk.id||"")+"&addre="+(chk.addressName||"")+"&rel=${param.rel}&sbid=${sbid}";
			location.href=url;
			//window.open(url);
		}else{
			$.messager.alert("操作提示","请选择需要绑定的设备!");			
		}
	}
//-->
</script>
<div id="${param.rel}_toolbar" class="search-div">
	<form onsubmit="return datagridSearch(this,'${param.rel }_datagrid');" >
		<input id="${param.rel}_id" name="puGrouping" type="hidden" value="0" />
		<div class="search-content ">
		</div>

			<input type="hidden" id="${param.rel }_wdSuperId" name="wdSuperId" />
		<div class="search-toolbar">
			<span style="float: left;"> 
					<a class="easyui-linkbutton" icon="icon-edit" plain="true" title="修改"
						onclick="updateDevice();"
						target="dialog" width="1000" height="500"
						rel="ids"  warn="请先选择一条设备信息"><span>绑定地址</span>
					</a>
		</div>
	</form>

</div>

<table id="${param.rel }_datagrid" toolbar="#${param.rel}_toolbar" border="true"
	title="地址管理"></table>



<script type="text/javascript">	
	
	$(function() {
		
		$('#<%=request.getParameter("rel")%>_datagrid')
				.datagrid(
						{
							nowrap : false,//true:只在一行显示数据,false:内容多时自动换行，效率低
							singleSelect:true,
							url : "query.do",
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
										align : "center"

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

									}
							] ],
						});
					});
</script>





