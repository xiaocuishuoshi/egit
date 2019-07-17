<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>
<%-- 
--%>

<div class="easyui-layout" fit="true" >
   <!-- 左侧-->
	<div region="west" title="人员列表" split="true" 	style="width:250px;" >
	
	   	<ul id="${param.rel }_leftTree" class="ztree"></ul>
		
	</div>
  	
	<div  region="center" border="false">
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
				<select  name="JdRyxb" style="width: 70px;" submitForm="jbxx" >
					<option value="">全部</option>
					<option value="男" >男</option>
					<option value="女">女</option>
				</select>
				
			</span>
		</div>
	

		<div class="search-toolbar" >
			<span style="float:left;">
				<a class="easyui-linkbutton clearDgChecked"  icon="icon-redo"	plain="true"  title="清空所有勾选项" >清空勾选</a>
			<shiro:hasPermission name="dwgl:fence">  
					<a class="easyui-linkbutton"  icon="icon-edit"	plain="true"
					  title="电子围栏"	href="dwgl/fencePage.do?id={id}&rel=${param.rel}" target="dialog" width="800" height="400" rel="${param.rel}_fence" warn="请先选择一个用户" >电子围栏</a>
					
				</shiro:hasPermission>
			</span> 
				<span>
				<shiro:hasPermission name="dwgl:running">  
					<a class="easyui-linkbutton"  icon="icon-edit"	plain="true"
					   	 href="dwgl/running.do" target="dialog2" width="1000" height="400" title="运行轨迹" rel="${param.rel}_running" warn="至少选择一个用户">运行轨迹</a>
				</shiro:hasPermission>
			</span>
			 
			<span style="margin-left:500px;">
				<button class="btn btn-primary btn-small" type="submit">查询</button>&nbsp;
				<button class="btn btn-small clear" type="button" >清空</button>&nbsp;	
			</span>
		
		</div>
	</form>
	
</div>
  
<table id="${param.rel }_datagrid"   toolbar="#${param.rel}_toolbar"  title="人员查询"></table>

<script type="text/javascript">

	
	$(function() {
		$('#<%=request.getParameter("rel")%>_datagrid').datagrid({
			
			border:true,
			nowrap : false,
			url : "ryda/queryUsers.do",
			rowStyler:function(value,row,index){
      			if (row.jdSfyj == 1){
					//当单元格的值等于1的时候，颜色变成红色
      				return 'background-color:red;';
     				}
     			},
			columns : [ [ 
				{
					field:"id",
					title : "勾选",
					checkbox:true,
					formatter: function(value,row,index){
						
						alert(row);
					}
				},
				 {
					field : "jdRyxm",
					title : "姓名",
					align:"center",
					sortable : true,
					width : 120,
					formatter: function(value,row,index){
						
						return '<a href="ryda/show.do?id='+row.id+'" target="dialog" width="800" height="400" rel="<%=request.getParameter("rel")%>_show" title="查看用户详情">'+value+'</a>';
					}
				},
				{
					field : "jdJgry",
					title : "监管人员",
					align:"center",
					width : 100,sortable : true
				},
				{
					field : "jdJzdz",
					title : "居住地址",
					align:"center",
					width : 100,sortable : true
				},
			 	 {
					field : "jdDwdh",
					title : "电话号码",
					align:"center",
					width : 80,sortable : true
					
				} ,
			 	 {
					field : "jdLydpzl",
					title : "滥用毒品种类",
					align:"center",
					width : 130,sortable : true
				}    
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
