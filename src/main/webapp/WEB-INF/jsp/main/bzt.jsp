<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
	首页 拖拽 模块效果 
--%>


				<%
					Member mb = 	(Member)session.getAttribute("minfo");
					String dw = mb.getOrgId();
					// out.print(dw);
					
					%>
　 
<iframe width="100%" frameborder="0" height="100%" src="./echarts-m-1.0.0/zzt.jsp"></iframe>


<div style="display: none;width:0px;> 
	<%@ include file="/WEB-INF/jsp/main/home_content.jsp"%>
</div>
