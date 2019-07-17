<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>
<%--
	模块：系统管理--单位管理
--%>
<div class="easyui-layout" fit="true">
   <!-- 左侧-->
	<div region="west" title="单位列表" split="true"	style="width:250px;" >
	
	   	<ul id="${param.rel }_leftTree" class="ztree"></ul>
		
	</div>
  	
	<div  region="center" border="false">
		<div id="${param.rel }_box" title="单位操作" class="easyui-panel" fit="true" >
			<shiro:hasPermission name="org:add">
				<%@ include file="/WEB-INF/jsp/system/organize/org/add.jsp" %>
			</shiro:hasPermission>
			<shiro:lacksPermission name="org:add">
				 <img src="resource/images/big/arrow_left_48.png" style="vertical-align: middle;"/>
				 <span style="font-weight: bold;">请先点击左侧选择单位</span>	
			</shiro:lacksPermission>
		</div>
	</div>
   
</div>
<script type="text/javascript">

	$(function(){
		queryLeftDepts();
	});
	function queryLeftDepts(){
		$.ajax({
			url:"org/load/all.do",
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
							onClick: zTreeClick
						}
				};
				var rel='<%= request.getParameter("rel") %>';
				var zNodes = new Array();
				$.each(json, function(i, d){
					zNodes.push({id : d.id,name : d.orgName,
						pId : d.superId,href:"org/updatePage.do?id="+d.id+"&rel="+rel,dwzTarget:"ajax",
						rel:rel+"_box",open:false});
				});
				$.fn.zTree.init($('#<%= request.getParameter("rel") %>_leftTree'), setting, zNodes);
			}
		});
	}
	

</script>

	

	

