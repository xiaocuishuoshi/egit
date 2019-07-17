<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>


<div class="easyui-layout" fit="true" >
	<div  region="center" border="false">
		<div id="${param.rel}_toolbar" class="search-div">
	<form  onsubmit="return datagridSearch(this,'${param.rel }_datagrid');"  >
		<input id="${param.rel}_id" name="id" type="hidden" value="0"/>
		<div  class="search-content " >
			
			<span>
				<label>接收人：</label>
				<input type="text"  name="tzsjsrxm" class="span2" >
			</span>
		</div>
	

		<div class="search-toolbar" >
			<span style="float:left;">
				<a class="easyui-linkbutton clearDgChecked"  icon="icon-redo"	plain="true"  title="清空所有勾选项" >清空勾选</a>
				
				<shiro:hasPermission name="tzs:add">  
					<a class="easyui-linkbutton"  icon="icon-add"	plain="true"
					  title="添加"   href="tzs/addPage.do?rel=${param.rel}"  target="dialog" width="900" height="450" rel="${param.rel}_add" >添加</a>
					
				</shiro:hasPermission>
				<shiro:hasPermission name="tzs:update">  
					<a class="easyui-linkbutton"  icon="icon-edit"	plain="true"
					  title="修改"	href="tzs/updatePage.do?id={id}&rel=${param.rel}" target="dialog" width="900" height="450" rel="${param.rel}_update" warn="请先选择一个用户" >修改</a>
					
				</shiro:hasPermission>
				<shiro:hasPermission name="tzs:delete">  
					<a class="easyui-linkbutton"  icon="icon-remove"	plain="true"
					   	 href="tzs/del.do" target="selectedTodo"  title="确定要删除吗?" warn="至少选择一个用户">批量删除</a>
				</shiro:hasPermission>
			
			</span>
			
		
			<span style="margin-left:500px;">
				<button class="btn btn-primary btn-small" type="submit">查询</button>&nbsp;
				<button class="btn btn-small clear" type="button" >清空</button>&nbsp;	
			</span>
		
		</div>
	</form>
	
</div>

<table id="${param.rel }_datagrid"  class="tzstable" toolbar="#${param.rel}_toolbar"  title="信息交互--通知书下发管理"></table>

<script type="text/javascript">

	
	$(function() {
		$('#<%=request.getParameter("rel")%>_datagrid').datagrid({
			
			border:true,
			nowrap : false,
			url : "tzs/queryUsers.do",
			  rowStyler:function(index,row){    
	     		  if (row.ydzt=="0"){    
	     	       return 'color:red';    
     		   		}  
  			  } ,
			columns : [ [ 
				{
					field:"ck",
					title : "勾选",
					checkbox:true
				},
				{
					field : "tzsmc",
					title : "标题",
					align:"center",
					width : 50
				},
				{
					field : "tzsjsrxm",
					title : "接收人",
					align:"center",
					width : 50,
					formatter: function(value,row,index){
						
						return '<a href="tzs/show.do?id='+row.id+'" target="dialog" width="950" height="400" rel="<%=request.getParameter("rel")%>_show" title="查看用户详情">'+value+'</a>';
					}
				},
			 	 {
					field : "tzsxfsj",
					title : "下发时间",
					align:"center",
					width : 50
				},
			 	 {
					field : "tzshfsj",
					title : "回复时间",
					align:"center",
					width : 50
				} ,
				{
					field : "tzshfnr",
					title : "回复内容",
					align:"center",
					width :50
				},{
					field : "处理结果",
					title : "操作",
					align:"center",
					width : 60,
					formatter:function(value,row,index){
						if(row.flag=='0'){
						return '<a  datagrid="${param.rel }_datagrid" href="tzs/qrtz.do?id='
											+row.id 
											+ '&rel=${param.rel}" rel="${param.rel}_update"  width="1000" height="500" plain="true" target="dialog" title="处理结果">处理结果</a>';
						
						
						}
						
					}
				} 
			] ]
		});
	});
	
</script>
	</div>
</div>

