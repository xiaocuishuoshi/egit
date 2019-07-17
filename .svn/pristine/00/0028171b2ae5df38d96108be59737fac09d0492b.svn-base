<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.whfp.oa.commons.util.ServletUtil"%>
<%@page import="com.whfp.oa.commons.model.Member"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp" %>
<%--
	模块：企业宣传--公告管理 --系统公告添加
--%>
 

 
<div style="width: 98%;margin: 0 auto ;" >
			
<form method="post" action="qyxc/save.do"  onsubmit="return validateSubmitForm(this)">
	<table class="table table-bordered ">
			<tr>
				<th style="width: 80px">企业名称：</th>
				<td>
					<c:out value="${qq.name }"/>
				</td>
				<th style="width: 80px">企业地址：</th>
				<td>
					<c:out value="${qq.addres }"/>
				</td>
			</tr>
			<tr>
				<th>联系电话：</th>
				<td>
					<c:out value="${qq.telphone }"/>
				</td>
				<th>企业传真：</th>
				<td>
					<c:out value="${qq.cz }"/>
				</td>
			</tr>
			<tr>
				<th>企业法人：</th>
				<td>
					<c:out value="${qq.qyfr }"/>
				</td>
				<th>注册资金：</th>
				<td colspan="3">
					<c:out value="${qq.zczj }"/>
				</td>
			</tr>
			<tr>
				<th>企业简介：</th>
				<td colspan="3">
					<textarea  name="qyjj" rows="5" class="editor"  style="width: 98%;" readonly="readonly">
						<c:out value="${qq.qyjj }"/>
					</textarea>
				</td>
			</tr>
			
			
	</table>
</form>
</div>
										
						
					
		

	

