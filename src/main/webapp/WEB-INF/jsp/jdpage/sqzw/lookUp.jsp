<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>
<%--
	模块：人员管理--基本信息管理--用户管理
--%>

<div class="easyui-layout" fit="true" >
   <!-- 左侧-->
	<div region="west" title="员工列表" split="true" 	style="width:200px;" >
	
	   	<ul id="${param.rel }_leftTree" class="ztree"></ul>
		
	</div>
  	
	<div  region="center" >
		<div id="${param.rel}_toolbar" class="search-div">
	<form  onsubmit="return datagridSearch(this,'${param.rel }_datagrid');"  >
		<input id="${param.rel}_id" name="id" type="hidden" value="0"/>
		<div  class="search-content " >
			<span>
				<label>姓名：</label>
				<input	type="text" name="jdRyxm" class="span2"  />
				&nbsp;<i class="boot_icon-question-sign" selectLike="tooltip"></i>
			</span>
			
			<span>
				<label>职业：</label>
				<input	type="text" name="jdZy" class="span2"  />
				&nbsp;<i class="boot_icon-question-sign" selectLike="tooltip"></i>
			</span>
			
			<span>
				<label>性别：</label>
				<select  name="JdRyxb" style="width: 70px;" submitForm="jbxx">
					<option value="">全部</option>
					<option value="男" >男</option>
					<option value="女">女</option>
				</select>
				
			</span>
		</div>
	

		<div class="search-toolbar" >
						<span style="float:left;">
							<a class="easyui-linkbutton clearDgChecked"  icon="icon-redo"	plain="true"  title="清空所有勾选项" >清空勾选</a>
							
							<a class="easyui-linkbutton"  icon="icon-add"	plain="true" warn="请先选择用户" 
							 href="javascript:;"  onclick="$.multLookup(this,true,'${param.rel }_datagrid')" >带回并覆盖</a>
							 
							 <a class="easyui-linkbutton"  icon="icon-add"	plain="true" warn="请先选择用户" 
							 href="javascript:;"  onclick="$.multLookup(this,false,'${param.rel }_datagrid')" >带回并追加</a>
							
						</span>
						<span style="float:right">
							<button class="btn btn-primary btn-small" type="submit">查询</button>&nbsp;
							<button class="btn btn-small clear" type="button" >清空</button>&nbsp;
						</span>
					
					</div>
	</form>
	
</div>

<table id="${param.rel }_datagrid"   toolbar="#${param.rel}_toolbar"  title="用户查询--全部部门"></table>

<script type="text/javascript">


	$(function() {
	
		$('#<%=request.getParameter("rel")%>_datagrid').datagrid({
			nowrap : true,
			url : "jbxx/queryUsers.do",
			rowStyler:function(value,row,index){
      			if (row.jdJb == 1){
					//当单元格的值等于1的时候，颜色变成红色
      				return 'background-color:red;';
     				}
     			},
			columns : [ [ 
				{
					field:"ck",
					title : "勾选",
					checkbox:true
				},
				 {
					field : "jdRyxm",
					title : "姓名",
					align:"center",
					width:70,
					formatter: function(value,row,index){
							return  "<a href='javascript:;' onclick=$.bringBack({id:'"+row.id+"',jdRyxm:'"+row.jdRyxm+"',jdDwdh:'"+row.jdDwdh+"'})>"+value+"</a>";
						}
				},
				{
					field : "jdZy",
					title : "职业",
					align:"center",
					width:90,
				},
				{
					field : "jdMz",
					title : "民族",
					align:"center",
					width:50,
				},
			 	 {
					field : "jdDwdh",
					title : "电话号码",
					align:"center",
					width:80,
					
				} ,
			 	 {
					field : "jdRyjg",
					title : "籍贯",
					align:"center",
					width:100,
				},
				
				{
					field : "jdRylb",
					title : "类型",
					align:"center",
					width:70,
					formatter: function(value,row,index){
						if(value==1){
							return "吸毒人员";
						}else if(value==2){
							return "社区戒毒人员";
						}else if(value==3){
							return "社区康复人员";
						}else if(value==4){
							return "强制戒毒人员";
						}else{
							return;
						}
					}
				},
				
					 {
					field : "jdJb",
					title : "级别",
					align:"center",
					width:50,
					 formatter: function(value,row,index){
						if(value==1){
							return "一级";
						}else if(value==2){  
							return "二级";
						}else if(value==3){
							return "三级";
						}else{
							return;
						}
					} 
				},
				
			] ]
		});
		
	});
	
</script>
	</div>
</div>

<script type="text/javascript">
<!--
	$(function(){
		$.ajax({
			url:"dept/load/all.do",
			cache: false,
			dataType:"json",
			success:function(json){
				var setting = {
						view: {
							showIcon: false
						},
						data: {
							simpleData: {
								enable: true
							}
						},
						callback: {
							onClick: updateUserDeptId
						}
				};
				var rel='<%= request.getParameter("rel") %>_datagrid';
				var zNodes = new Array();
				zNodes.push({id : 0,name : "全部部门",open:true,datagrid : rel,param : {"deptId":""},updateTitle:"用户查询--全部部门"});
				$.each(json, function(i, d) {
					
					zNodes.push({id : d.id,name : d.deptName,pId : d.superId,open:false,
					datagrid : rel,param : {"deptId":d.id},updateTitle:"用户查询--"+d.deptName});
					
				});
				$.fn.zTree.init($('#<%= request.getParameter("rel") %>_leftTree'), setting, zNodes);
				
			}
		});
	});
	function updateUserDeptId(event,treeId, treeNodeJSON){
		$('#<%= request.getParameter("rel") %>_deptId').val(treeNodeJSON.id);
		refreshDatagrid(event,treeId, treeNodeJSON);
	}
//-->
</script>
