<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%--
	模块：企业宣传，企业新闻列表
--%>
<div id="${param.rel}_toolbar" class="search-div">
	<form onsubmit="return datagridSearch(this,'${param.rel }_datagrid');" >
		<input id="${param.rel}_id" name="puGrouping" type="hidden" value="0" />
		<div class="search-content ">
		</div>


	</form>

</div>
<div id="addressStatusWin" class="easyui-window" title="MSG" data-options="fit:false,closed:true,width:800,height:400">
	<iframe src="" id="addressStatusFrame" width="100%" height="100%" frameborder="no"></iframe>
</div>
<table id="${param.rel }_datagrid" toolbar="#${param.rel}_toolbar" border="true"
	title="设备列表"></table>

<script type="text/javascript">	
<!--//
	function getAddressStatusWin(taskId){
		try{
			if(taskId){
				$("#addressStatusFrame").attr("src","hlkj/address/findSb.do?rel=hlkj_addressTree&taskId="+taskId);
				$("#addressStatusWin").window("open");
			}
		}catch(e){
		}
	}

	function closeWin(){
		$("#addressStatusWin").window("close");		
		$("#${param.rel}_datagrid").datagrid("reload");
	}
	$(function() {
		
		$('#<%=request.getParameter("rel")%>_datagrid')
				.datagrid(
						{
							nowrap : false,//true:只在一行显示数据,false:内容多时自动换行，效率低
							url : "hlkj/sbgl/toquerySbin.do",
							columns : [ [
									{
										field : "ck",
										title : "勾选",
										checkbox : true,
										halign:"center",
										width:30
									},
									{
										field : "desc",
										title : "序号",
										width : 120,
										halign:"center",
										align : "center"
									}, {
										field : "addressName",
										title : "地址",
										width :260,
										halign:"center",
										align : "center",
										sortable : true

									}, {
										field : "type",
										title : "类型",
										halign:"center",
										width : 120,
										align : "center"

									},{
											field : "op",
											title : "操作",
											align:"center",
											width : 50,
											formatter: function(value,row,index){
												return "<a onclick=\"getAddressStatusWin('"+row.desc+"');\">地址绑定</a>";
												//return '<a  href="hlkj/address/findSb.do?rel=hlkj_addressTree&taskId='+row.desc+'" target="blank" datagrid="<%=request.getParameter("rel")%>_datagrid"  >绑定地址</a>';
												
											}
									}
							] ],
							
						});
						
					});
	
//-->
</script>





