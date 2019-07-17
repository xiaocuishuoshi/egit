<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%> 
<%--
	模块：康复检查管理-检查分析详情
--%>

<div id="${param.rel}_toolbar" class="search-div">
	<form onsubmit="return datagridSearch(this,'${param.rel }_datagrid');">
		<div class="search-content ">
		<span>
			<label>
				戒毒人员：
			</label> 
				 <input type="text" name="jdRyxm" style="width: 150px" op="like" />
			</span>
			
		</div>
		
		<div class="search-toolbar">
			<span style="float: left;"> 
	
			</span>	
			<span style="float: right">
				<button class="btn btn-primary btn-small" type="submit">
					查询
				</button>&nbsp;
				<button class="btn btn-small clear" type="button">
					清空
			</button>&nbsp; </span>
		</div>
	</form>
</div>


<table id="${param.rel }_datagrid" toolbar="#${param.rel}_toolbar"
	border="true"></table>
	
<script type="text/JavaScript" >
	$(function() {
		$('#<%=request.getParameter("rel")%>_datagrid')
				.datagrid(
						{
							nowrap : false,//true:只在一行显示数据,false:内容多时自动换行，效率低
							url : "kfjc/querySum.do?sfzc=2&dh=${dh}",
							columns : [ [
								{
									field : "jdRyxm",
									title : "姓名",
									align:"center",
									width:30,
									formatter: function(value,row,index){

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
										field : "id",
										title : "次数(阴性/阳性)",			
										width : 80,						
										align : "center",
										formatter:function(value,row,index){

											return row.num1+"/"+row.num2
										}
									},
									{
										field : "jdJgry",
										title : "监管人员",			
										width : 80,						
										align : "center",
									},
									{
										field : "操作",
										title : "检查分析",
										width : 80,
										align : "center",
										formatter: function(value,row,index){
											return '<a href="kfjc/fxload.do?ryid='
												+row.id
												+'&rel=${param.rel}_fx" rel="${param.rel}_jcfx" target="dialog" style="text-decoration:none;font-size:12px;font-weight:bold;"  width="950" height="500" title="检查分析">检查分析</a>';
										}
									}
							] ],
		});
	});
						
</script>