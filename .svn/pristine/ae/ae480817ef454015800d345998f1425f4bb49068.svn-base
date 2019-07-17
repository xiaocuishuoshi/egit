<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>
<%--
	模块：个人办公--即时消息
--%>
<div class="easyui-layout" data-options="fit:true">
	<div class="easyui-panel"
		data-options="region:'west',width:'120',collapsible:false"
		title="地址列表">
		<ul id="${param.rel }_leftTree" class="ztree"></ul>
	</div>
	<script type="text/javascript">
<!--

	$(function(){
		$.ajax({
			url:"hlkj/sbgl/query.do",
			cache: false,
			dataType:"json",
			type:"get",
			data:{
				
				lm:"${lm}"
			},
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
							onClick: refreshDatagrid
						}
				};
				var rel='<%=request.getParameter("rel")%>_datagrid';
				var zNodes = new Array();
				$.each(json, function(i, d) {
					zNodes.push({id : d.id,name : d.addressName,open:true,
					datagrid : rel,param : {"addressid":d.id},updateTitle:"用户查询--"+d.addressName});
					
				});
				$.fn.zTree.init($('#<%=request.getParameter("rel")%>_leftTree'), setting, zNodes);
				
			}
		});
		
		
	});

	var adres = "";
	function refreshDatagrid(e,tid,tnode){
		if(tnode){
			var id = tnode.id||"";
			if(id && id.length>0){
				$('#${param.rel}_datagrid')
				.datagrid("load",{addressid:id,pageNumber:1,sblm:'${lm}'});
				document.getElementById("addres").value=id;
				adres = id;
			}
		}
		return false;
	}
//-->
</script>
	<div class="easyui-panel" data-options="region:'center',fit:true" style="">
		<%@include file="/WEB-INF/jsp/hlkj/sbgl/sbTab.jsp"%>
	</div>
	

</div>