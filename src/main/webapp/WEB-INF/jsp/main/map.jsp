<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
	首页 拖拽 模块效果 
--%>


				<%
					Member mb = 	(Member)session.getAttribute("minfo");
					String dw = mb.getOrgId();
					// out.print(dw);
					
					%>
　 
<iframe width="60%" frameborder="0" height="100%" src="./echarts-m-1.0.0/dt.jsp"></iframe>
<iframe width="30%" frameborder="0" height="100%" src="./echarts-m-1.0.0/lb.jsp"></iframe>



<div style="display: none;width:0px;> 
	<%@ include file="/WEB-INF/jsp/main/home_content.jsp"%>
</div>
