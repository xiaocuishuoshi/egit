<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.whfp.oa.commons.util.ServletUtil"%>
<%@page import="com.whfp.oa.commons.model.Member"%>
<%@page import="com.whfp.oa.manager.hlkj.dict.bean.HlkjDict"%>
<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp" %>
<%--
	模块：企业宣传--公告管理 --系统公告添加
--%>
 

 
<div style="width: 98%;margin: 0 auto ;" >
			
<form method="post" action="hlkj/address/save.do"  onsubmit="return validateSubmitForm(this)">
	<input type="hidden" name="father" value="${param.wdSuperId }"/>
	<table class="table table-bordered ">
			<tr>
				<th style="width:80px">分类名称：</th>
				<td  colspan="3">
					<select name="addressFlmc" >
							<c:forEach  var="v"  items="${qq}" varStatus="status">
         				 			<option value="${v.flmc}">${v.flmc}</option >
      						</c:forEach>
					</select>
				</td>
			
			</tr>
			<tr>
				<th>地址名称：</th>
				<td  colspan="3">
				<input type="text" name="addressName" class="easyui-validatebox" required="true" />
				</td>
			</tr>
			<tr>
				<th>顺序：</th>
				<td colspan="3">
					<input type="text" name="addressDesc" class="easyui-validatebox" value="0" required="false" />
				</td>
			</tr>
			
			
			<tr>
				<th></th>
				<td colspan="3">
					<div  style="margin-top: 10px;margin-bottom: 10px;">
						  <button type="submit" class="btn btn-primary" >保存</button>&nbsp;&nbsp;&nbsp;&nbsp;
						  <button type="button" class="btn clear" >清空</button>
					</div>
				</td>
			 </tr>
			
	</table>
</form>
</div>
										
						
					
		

	

