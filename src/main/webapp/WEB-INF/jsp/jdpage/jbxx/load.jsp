﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
			<span>
				<label>类别：</label>
				<select  name="jdRylb" style="width: 120px;" submitForm="jbxx">
						<option value="">全部</option>
						<option value="1">吸毒人员</option>
						<option value="2">社区戒毒人员</option>
						<option value="3">社区康复人员</option>
						<option value="4">强制戒毒人员</option>
						<option value="5">其他</option> 
				</select>
			</span>
			<span>
				<label>等级：</label>
				<select  name="jdJb" style="width: 100px;" submitForm="jbxx">
						<option value="">全部</option>
						<option value="0">正常</option>
						<option value="1">一级</option>
						<option value="2">二级</option>
						<option value="3">三级</option>
				</select>
			</span>
		</div>
	

		<div class="search-toolbar" >
			<span style="float:left;">
				<a class="easyui-linkbutton clearDgChecked"  icon="icon-redo"	plain="true"  title="清空所有勾选项" >清空勾选</a>
				
				<shiro:hasPermission name="jbxx:add">  
					<a class="easyui-linkbutton"  icon="icon-add"	plain="true"
					  title="添加用户"   href="jbxx/addPage.do?rel=${param.rel}"  target="dialog" width="1020" height="500" rel="${param.rel}_add" >添加</a>
					
				</shiro:hasPermission>
				<shiro:hasPermission name="jbxx:update">  
					<a class="easyui-linkbutton"  icon="icon-edit"	plain="true"
					  title="修改用户信息"	href="jbxx/updatePage.do?id={id}&rel=${param.rel}" target="dialog" width="1000" height="500" rel="${param.rel}_update" warn="请先选择一个用户" >修改</a>
					
				</shiro:hasPermission>
				<shiro:hasPermission name="jbxx:delete">  
					<a class="easyui-linkbutton"  icon="icon-remove"	plain="true"
					   	 href="jbxx/del.do" target="selectedTodo"  title="确定要删除吗?" warn="至少选择一个用户">批量删除</a>
				</shiro:hasPermission>
				 <shiro:hasPermission name="jbxx:update">  
					
				<a class="easyui-linkbutton"  icon="ui-icon-excel" plain="true"
					   href="jbxx/export.do" target="selectedTodo" targetType="export" >导出</a>	
				</shiro:hasPermission>
				
			</span>
			<span style="float: right">
				<button class="btn btn-primary btn-small" type="submit">查询</button>&nbsp;
				<button class="btn btn-small clear" type="button" >清空</button>&nbsp;	
			</span>
		
		</div>
	</form>
	
</div>

<table id="${param.rel }_datagrid"   style="width:100%" toolbar="#${param.rel}_toolbar"  title="用户查询--全部部门"></table>

<script type="text/javascript">


	$(function() {
	
		$('#<%=request.getParameter("rel")%>_datagrid').datagrid({
			nowrap : true,
			url : "jbxx/queryUsers.do?jdRylb=${lb}",
			rowStyler:function(value,row,index){
      			if (row.jdJb == 1){
					//当单元格的值等于1的时候，颜色变成红色
      				return 'background-color:#FF0000;';
     			}else if(row.jdJb == 2){
     				return 'background-color:#FFFF37;';
     			}else if(row.jdJb == 3){
     				return 'background-color:#00BB00;';
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
					width:30,
					formatter: function(value,row,index){

						//return '<a href="jbxx/show.do?id='+row.id+'" target="dialog" width="1000" height="500" rel="<%=request.getParameter("rel")%>_show" title="查看用户详情">'+value+'</a>';
						
						return '<a href="jiedu/man/view.do?id='+row.id+'" target="dialog" width="1000" height="600" rel="<%=request.getParameter("rel")%>_show" title="查看用户详情">'+value+'</a>';
					}
				},
				{
					field : "jdZy",
					title : "职业",
					align:"center",
					width:50,
				},
				{
					field : "jdMz",
					title : "民族",
					align:"center",
					width:50,
				},
			 	 {
					field : "jdSfzh",
					title : "身份证号",
					align:"center",
					width:50,
					
				} ,
			 	 {
					field : "jdDwdh",
					title : "电话号码",
					align:"center",
					width:50,
					
				} ,
			 	 {
					field : "jdRyjg",
					title : "籍贯",
					align:"center",
					width:50,
				},
			 	 {
					field : "relationshipNum",
					title : "亲属关系",
					align:"center",
					width:50,
					formatter: function(value,row,index){
	
						return '<a href="jiedu/man/relationship.do?uid='+row.id+'"  target="dialog" width="1000" height="600" rel="<%=request.getParameter("rel")%>_relationship" title="查看用户亲属关系">'+value+'</a>';
					}
				},
			 	 {
					field : "workNum",
					title : "工作经历",
					align:"center",
					width:50,
					formatter: function(value,row,index){
						
						return '<a href="jiedu/man/work.do?uid='+row.id+'" target="dialog" width="1000" height="600" rel="<%=request.getParameter("rel")%>_work" title="查看用户的工作经历">'+value+'</a>';
					}
				},
			 	 {
					field : "fileNum",
					title : "相关附件",
					align:"center",
					width:50,
					formatter: function(value,row,index){
						
						return '<a href="jiedu/man/files.do?uid='+row.id+'" target="dialog" width="1000" height="600" rel="<%=request.getParameter("rel")%>_files" title="查看用户相关附件">'+value+'</a>';
					}
				},
			 	 {
					field : "concactNum",
					title : "戒毒工作小组成员",
					align:"center",
					width:100,
					formatter: function(value,row,index){
						
						return '<a href="jiedu/man/contact.do?uid='+row.id+'" target="dialog" width="1200" height="600" rel="<%=request.getParameter("rel")%>_concat" title="查看用户戒毒工作小组成员">'+value+'</a>';
					}
				},
				{
					field : "jdRylb",
					title : "类型",sortable : true,
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
						}else if(value==5){
							return "其他";
						}else if(value==6){
							return "戒毒期满出所人员";
						}else{
							return;
						}
					}
				},
				
					 {
					field : "jdJb",
					title : "级别",
					align:"center",
					width:50,sortable : true,
					 formatter: function(value,row,index){
						if(value==1){
							return "一级";
						}else if(value==2){  
							return "二级";
						}else if(value==3){
							return "三级";
						}else if(value==0){
							return "正常";
						}else{
							return;
						}
					} 
				},
				
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
