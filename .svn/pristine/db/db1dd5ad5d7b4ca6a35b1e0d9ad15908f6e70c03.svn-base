<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>
<%@include file="/WEB-INF/jsp/commons/jstl_message_tld.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"	+ request.getServerName() + ":" + request.getServerPort()	+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
	<link href="<%=basePath%>/resource/js/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen">

<link rel="stylesheet" href="<%=basePath%>/resource/css/main.css" type="text/css"/>

<link rel="stylesheet" href="<%=basePath%>/resource/js/ui/css/ui.css" type="text/css"/>
<link rel="stylesheet" href="<%=basePath%>/resource/js/ui/css/icon.css" type="text/css"/>
<link rel="stylesheet" href="<%=basePath%>/resource/js/zTree/zTreeStyle/zTreeStyle.css" type="text/css"/>

<%-- jquery --%>
<script type="text/javascript" src="<%=basePath%>/resource/js/jquery/jquery-1.10.2.js"></script>
<script type="text/javascript" src="<%=basePath%>/resource/js/jquery/jquery.cookie.js"></script>
<script type="text/javascript" src="<%=basePath%>/resource/js/jquery/jquery.json-2.3.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/resource/js/jquery/jquery-expand.js"></script>
<script type="text/javascript" src="<%=basePath%>/resource/js/zTree/jquery.ztree.all-3.5.min.js"></script>
<%-- easyui  --%>
<link href="<%=basePath%>/resource/js/easyui-1.3.5/themes/icon.css"  rel="stylesheet" type="text/css" media="screen" />
<link id="easyuiTheme" href="<%=basePath%>/resource/js/easyui/themes/<c:out value="${cookie.easyuiThemeName.value}" default="default"/>/easyui.css"  rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="<%=basePath%>/resource/js/easyui-1.3.5/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/resource/js/easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>


<%-- easyui portal插件 --%>
<link rel="stylesheet" href="<%=basePath%>/resource/js/easyui-portal/portal.css" type="text/css"/>
<script type="text/javascript" src="<%=basePath%>/resource/js/easyui-portal/jquery.portal.js"></script>


<!-- js 对象拓展  -->
<script src="<%=basePath%>/resource/js/jsObject.Expand.js" type="text/javascript"></script>




</head>
<body>
<%--
	模块：公司文档管理
--%>
<div class="easyui-layout" fit="true" >
   <!-- 左侧-->
	<div region="west" title="地址管理列表" split="true"	style="width:250px;" >
	
	   	<ul id="${param.rel }_leftTree" class="ztree"></ul>
		
	</div>
  	
	<div  region="center" border="false" data-options="fit:true">
		<%@ include file="/WEB-INF/jsp/hlkj/address/treeAddress/listTosb.jsp"%>
	</div>
   
</div>

<script type="text/javascript">
<!--
	$(function(){
		loadLeftWdTypes();
	});
	function loadLeftWdTypes(){
		$.ajax({
			url:"queryTree.do",
			cache: false,
			dataType:"json",
			success:function(json){
				var setting = {
						data: {
							simpleData: {
								enable: true
							}
						},
						callback: {
							onClick: updateWdTypeSuperId
						}
				};
				var rel='<%= request.getParameter("rel") %>_datagrid';
				var zNodes = new Array();
				$.each(json, function(i, m) {
					
					zNodes.push({id : m.id,name : m.name,pId : m.superId,open:false,
					datagrid : rel,param : {"id":m.id},updateTitle:m.name,iconSkin:"folder"});
					
				});
				$.fn.zTree.init($('#<%= request.getParameter("rel") %>_leftTree'), setting, zNodes);
				
			}
		});
	}
	function updateWdTypeSuperId(event,treeId, treeNodeJSON){
			$('#<%= request.getParameter("rel") %>_wdSuperId').val(treeNodeJSON.id);
		refreshDatagrid(event,treeId, treeNodeJSON);
	}
	
	function refreshDatagrid(e,tid,tnode){
		if(tnode){
			var id = tnode.id||"";
			if(id && id.length>0){
				$('#${param.rel}_datagrid')
				.datagrid("load",{superId:id,pageNumber:1,sblm:'${lm}'});
			}
		}
		return false;
	}
	
//-->
</script>
</body>
</html>
