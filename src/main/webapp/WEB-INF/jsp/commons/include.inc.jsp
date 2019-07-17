<%@ page pageEncoding="UTF-8"%>
<%@page import="com.whfp.oa.commons.util.ServletUtil"%>
<%@page import="com.whfp.oa.commons.model.Member"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 

<%@ taglib uri="/WEB-INF/tag/myTag.tld" prefix="my" %>
<%
	boolean sa=(Boolean) ServletUtil.getSession().getAttribute("sa");
	boolean dev=(Boolean) ServletUtil.getSession().getAttribute("dev");
	Member member=(Member) ServletUtil.getSession().getAttribute("minfo");
	
	request.setAttribute("ctx",request.getContextPath());
 %>