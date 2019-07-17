<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>


<div class="easyui-layout" fit="true" >
	<div  region="center" border="false">
		<div id="${param.rel}_toolbar" class="search-div">
	<form  onsubmit="return datagridSearch(this,'${param.rel }_datagrid');"  >
		<input id="${param.rel}_id" name="id" type="hidden" value="0"/>
		<div  class="search-content " >
		<span >
				<label>请假人：</label>
				<input	type="text" name="qjryxm" class="span2"  />
				<i class="boot_icon-question-sign" selectLike="tooltip"></i>
			</span>
		<span >
				<label>审批状态：</label>
					<select name="spzt" submitForm="qjgl" >
						<option value="">全部</option>
						<option value="0">未审批</option>
						<option value="1">已审批</option>
					</select>
			</span>
		
		
		</div>
		<div class="search-toolbar" >
			<span style="float:left;">
				<a class="easyui-linkbutton clearDgChecked"  icon="icon-redo"	plain="true"  title="清空所有勾选项" >清空勾选</a>
					
				
				
			</span>
			
			<span style="margin-left:600px;">
				<button class="btn btn-primary btn-small" type="submit">查询</button>&nbsp;
				<button class="btn btn-small clear" type="button" >清空</button>&nbsp;	
			</span>
			
		</div>
	</form>
</div>

		<table id="${param.rel }_datagrid" toolbar="#${param.rel}_toolbar"
			title="请假管理--请假信息"></table>

<script type="text/javascript">
		
	$(function() {
		$('#<%=request.getParameter("rel")%>_datagrid').datagrid({
			
			border:true,
			nowrap : false,
			url : "qjgl/query.do",
			 rowStyler:function(index,row){    
	     		  if (row.spzt=="0"){    
	     	       return 'color:red';    
     		   		}    
  			  },  
			columns : [ [ 
				{
					field:"ck",
					title : "勾选",
					checkbox:true
				},
				{
					field : "qjryxm",
					title : "请假人姓名",
					align:"center",
					width : 50,
					formatter: function(value,row,index){
						
						return '<a href="qjgl/show.do?id='+row.id+'" target="dialog" width="950" height="400" rel="<%=request.getParameter("rel")%>_show" title="查看用户详情">'+value+'</a>';
					}
				},
				{
					field : "qjnr",
					title : "请假内容",
					align:"center",
					width : 50
				},
			 	 {
					field : "qjkssj",
					title : "请假开始时间",
					align:"center",
					width :50,
					sortable : true,
					formatter: function(value,row,index){
						if(value!=null)
						return new Date(value).format("yyyy-MM-dd HH:mm:ss");
					}
				},{
					field : "qjjssj",
					title : "请假结束时间",
					align:"center",
					width : 50,
					sortable : true,
					formatter: function(value,row,index){
						if(value!=null)
						return new Date(value).format("yyyy-MM-dd HH:mm:ss");
					}
				},
				{
					field : "操作",
					title : "操作",
					align:"center",
					width : 40,
					formatter:function(value,row,index){
						if(row.spzt==0){
						return '<a  datagrid="${param.rel }_datagrid" href="qjgl/updatePage.do?id='
											+row.id 
											+ '&rel=${param.rel}" rel="${param.rel}_update"  width="1000" height="500" plain="true" target="dialog" title="审批">审批</a>';
						
						
						}
						if(row.spzt==1 && row.xjbz==0){
						return '<a  datagrid="${param.rel }_datagrid" href="qjgl/updatePageXj.do?id='
											+row.id 
											+ '&rel=${param.rel}" rel="${param.rel}_update"  width="1000" height="500" plain="true" target="dialog" title="销假">销假</a>';
						
						
						}if(row.spzt==1 && row.xjbz==1){
							return "";
						}
						
					}
				}
				
				
				 
			]] 
		});
		
	});
</script>
	</div>
</div>

