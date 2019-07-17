<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<iframe id="bd" style="width:100%;height:100%" src="<%=path%>/baidu/index.jsp?id=${requestScope.jd.id }&datagridId=${param.rel }_datagrid"></iframe>