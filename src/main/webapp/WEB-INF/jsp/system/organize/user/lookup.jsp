<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp" %>
<%--
	模块：系统管理--组织机构 -- 用户管理--查找带回
--%>

<div class="easyui-layout"  fit="true">
   <!-- 左侧-->
	<div region="west" title="部门列表" split="true"	style="width:250px;" >
	
	   	<ul id="${param.rel }_leftTree" class="ztree"></ul>
		
	</div>
  	
	<div  region="center" border="false">
		<div id="${param.rel }_box" class="easyui-panel" fit="true"  title="用户查询">
			
			<c:choose>
				<c:when test="${param.type==1 }">
					<%--单选--%>
					 
 
<%--
	模块：系统管理--组织机构 -- 用户管理--查找带回(单选)
--%>

<div id="${param.rel}_toolbar" class="search-div">
	<form  onsubmit="return datagridSearch(this,'${param.rel }_datagrid');"  >
		
		<div  class="search-content " >
			
			<span>
				<label>姓名：</label>
				<input	type="text" name="trueName" class="span2"  />
				&nbsp;<i class="boot_icon-question-sign" selectLike="tooltip"></i>
			</span>
			
			<span>
				<label>性别：</label>
				<select  name="userSex" style="width: 70px;" >
					<option value="">全部</option>
					<option value="1">男</option>
					<option value="0">女</option>
				</select>
				
			</span>
			
			
		</div>
	

		<div class="search-toolbar" >

			<span style="float:right">
				
				<button class="btn btn-primary btn-small" type="submit">查询</button>&nbsp;
				<button class="btn btn-small" type="reset">重置</button>&nbsp;
			</span>
		
		</div>
		
	</form>
	
</div>

<table id="${param.rel }_datagrid"   toolbar="#${param.rel}_toolbar"  ></table>


<script type="text/javascript" >
<!--	

	$(function() {
		
		$('#<%=request.getParameter("rel")%>_datagrid').datagrid({
			url : "user/lookUp.do",
			queryParams: {
				type: '<%=request.getParameter("type")%>'
				
			},
			mustParamNames:"deptId,type",
			frozenColumns:[[
					
					 {
						field : "trueName",
						title : "姓名",
						align:"center",
						width : 180,
						formatter: function(value,row,index){
							
							return  "<a href='javascript:;' onclick=$.bringBack({id:'"+row.id+"',userName:'"+row.userName+"',trueName:'"+row.trueName+"',cid:'"+row.cid+"'})>"+value+"</a>";
							
						}
					}
			]],
			columns : [ [ 
			    
				{
					field : "deptName",
					title : "部门",
					align:"center",
					width : 250
				},
			 	 
			 	 {
					field : "userSex",
					title : "性别",
					align:"center",
					width : 40,
					formatter: function(value,row,index){
							if("1"==value){
								return "男";
							}else{
								return "女";
							}
							
					}
				}
			 	  
			
			] ]
		});
		
	});

//-->		
</script>
				</c:when>
				<c:when test="${param.type==2 }">
					<%--多选--%> 
<%--
	模块：系统管理--组织机构 -- 用户管理--查找带回(多选)
--%>
<div id="${param.rel}_toolbar" class="search-div">
	<form  onsubmit="return datagridSearch(this,'${param.rel }_datagrid');" >
		
		<div  class="search-content " >
			
			<span>
				<label>姓名：</label>
				<input	type="text" name="trueName" class="span2"  />
				&nbsp;<i class="boot_icon-question-sign" selectLike="tooltip"></i>
			</span>
			
			<span>
				<label>性别：</label>
				<select  name="userSex" style="width: 70px;" >
					<option value="">全部</option>
					<option value="1">男</option>
					<option value="0">女</option>
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

<table id="${param.rel }_datagrid"   toolbar="#${param.rel}_toolbar"  ></table>


<script type="text/javascript" >
<!--	

	$(function() {
		
		$('#<%=request.getParameter("rel")%>_datagrid').datagrid({

			url : "user/lookUp.do",
			queryParams: {
				type: '<%=request.getParameter("type")%>'
				
			},
			mustParamNames:"deptId,type",
			frozenColumns:[[
					{
						field:"ck",
						title : "勾选",
						checkbox:true
					},
					 {
						field : "trueName",
						title : "姓名",
						align:"center",
						width : 180,
						formatter: function(value,row,index){
							
							return  "<a href='javascript:;' onclick=$.bringBack({id:'"+row.id+"',userName:'"+row.userName+"',trueName:'"+row.trueName+"',cid:'"+row.cid+"'})>"+value+"</a>";
							
						}
					}
			]],
			columns : [ [ 
			    
				{
					field : "deptName",
					title : "部门",
					align:"center",
					width : 250
				},
			 	 
			 	 {
					field : "userSex",
					title : "性别",
					align:"center",
					width : 40,
					formatter: function(value,row,index){
							if("1"==value){
								return "男";
							}else{
								return "女";
							}
							
					}
				}
			 	  ,	{
					field : "cid",
					title : "手机id",
					align:"center",
					width : 140
				}
			
			] ]
		});
		
	});

//-->		
</script>
	


				</c:when>
				<c:when test="${param.type==3 }">
					<%--手机号--%>
					
					 
 
<%--
	模块：系统管理--组织机构 -- 用户管理--查找带回(多选)手机号
--%>
<div id="${param.rel}_toolbar" class="search-div">
	<form  onsubmit="return datagridSearch(this,'${param.rel }_datagrid');"  >
		
		<div  class="search-content " >
			
			<span>
				<label>姓名：</label>
				<input	type="text" name="trueName" class="span2"  />
				&nbsp;<i class="boot_icon-question-sign" selectLike="tooltip"></i>
			</span>
			
			<span>
				<label>性别：</label>
				<select  name="userSex" style="width: 70px;" >
					<option value="">全部</option>
					<option value="1">男</option>
					<option value="0">女</option>
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

<table id="${param.rel }_datagrid"   toolbar="#${param.rel}_toolbar"  ></table>


<script type="text/javascript" >
<!--	

	$(function() {
		
		$('#<%=request.getParameter("rel")%>_datagrid').datagrid({

			url : "user/lookUp.do",
			queryParams: {
				type: '<%=request.getParameter("type")%>'
				
			},
			mustParamNames:"deptId,type",
			frozenColumns:[[
					{
						field:"ck",
						title : "勾选",
						checkbox:true
					},
					 {
						field : "trueName",
						title : "姓名",
						align:"center",
						width : 180,
						formatter: function(value,row,index){
							
							return  "<a href='javascript:;' onclick=$.bringBack({id:'"+row.id+"',userName:'"+row.userName+"',trueName:'"+row.trueName+"',cid:'"+row.cid+"'})>"+value+"</a>";
							
						}
					}
			]],
			columns : [ [ 
			    
				{
					field : "deptName",
					title : "部门",
					align:"center",
					width : 250
				},
			 	 
			 	 {
					field : "mobilePhoneNumber",
					title : "手机号",
					align:"center",
					width : 100
				}
			 	  
			
			] ]
		});
		
	});

//-->						
</script>	

	

					 
					 		</c:when>
				
			</c:choose>
		
		
		</div>
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
							dblClickExpand: false,
							showIcon: false
						},
						data: {
							simpleData: {
								enable: true
							}
						},
						callback: {
							onClick: refreshDatagrid
						}
				};
				var rel='<%= request.getParameter("rel") %>_datagrid';
				var zNodes = new Array();
				zNodes.push({id : 0,name : "全部部门",open:true,datagrid : rel,param : {"deptId":""}});
				$.each(json, function(i, d) {
					
					zNodes.push({id : d.id,name : d.deptName,pId : d.superId,open:true,
					datagrid : rel,param : {"deptId":d.id}});
					
				});
				$.fn.zTree.init($('#<%= request.getParameter("rel") %>_leftTree'), setting, zNodes);
				
			}
		});
		
	});
//-->
</script>