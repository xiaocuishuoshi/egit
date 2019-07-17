<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>
<%--
	模块：人员管理--基本信息管理--用户管理
--%>

<div class="easyui-layout" fit="true" >
   <!-- 左侧-->
	<div region="west" title="员工列表" split="true" 	style="width:250px;" >
	
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
				
			</span>
			<span>
				<label>身份证：</label>
				<input	type="text" name="jdSfzh" class="span2"  />
				&nbsp;<i class="boot_icon-question-sign" selectLike="tooltip"></i>
			</span>
			<span>
				<label>电话号码：</label>
				<input	type="text" name="jdDwdh" class="span2"  />
				&nbsp;<i class="boot_icon-question-sign" selectLike="tooltip"></i>
			</span>
			<span>
				<label>职业：</label>
				<input	type="text" name="jdZy" class="span2"  />
				
			</span>
			
				<span>
				<label>性别：</label>
				<select  name="JdRyxb" style="width: 70px;" submitForm="ryda" >
					<option value="">全部</option>
					<option value="男" >男</option>
					<option value="女">女</option>
				</select>
				
			</span>
			
		</div>
	

		<div class="search-toolbar" >
			<span style="float:left;">
				<a class="easyui-linkbutton clearDgChecked"  icon="icon-redo"	plain="true"  title="清空所有勾选项" >清空勾选</a>
				<shiro:hasPermission name="ryda:update">  
					<a class="easyui-linkbutton"  icon="icon-edit"	plain="true"
					  title="修改用户信息"	href="ryda/updatePage.do?id={id}&rel=${param.rel}" target="dialog" width="1000" height="500" rel="${param.rel}_update" warn="请先选择一个用户" >修改</a>
					
				</shiro:hasPermission>
				
				
			</span>
			
			
			<span style="margin-left:500px;">
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
			
			border:true,
			nowrap : false,
			url : "ryda/queryUsers.do",
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
					width : 50,
					formatter: function(value,row,index){
						
						return '<a href="ryda/show.do?id='+row.id+'" target="dialog" width="1000" height="500" rel="<%=request.getParameter("rel")%>_show" title="查看用户详情">'+value+'</a>';
					},sortable : true
				},
			 	 {
					field : "jdSfzh",
					title : "身份证号",
					align:"center",
					width:100,sortable : true
					
				} ,
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
				}    ,
				
				{
					field : "操作",
					title : "操作",
					width : 100,
					align : "left",
					formatter: function(value,row,index){
					return  '<a href="jbxx/sz.do?id='
								+row.id
								+'&rel=${param.rel}" rel="${param.rel}_sz" style="text-decoration:none;font-size:12px;font-weight:bold;" target="dialog"  width="350" height="310" title="分类级别">分类级别设置</a>';
							}
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
