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
				<th style="width:80px">产品名称：</th>
				<td  colspan="3">
					<c:out value='${qq.proName }'/>
				</td>
			
			</tr>
			<tr>
				<th>产品负责人：</th>
				<td  colspan="3">
				<c:out value='${qq.proCharge }'/>
				</td>
			</tr>
			<tr>
				<th>产品描述：</th>
				<td colspan="3">
					<textarea  name="pro_ms" readonly="readonly" rows="5" class="editor"  style="width: 98%;"><c:out value='${qq.proMs }'/></textarea>
				</td>
			</tr>
			
			<tr>
				<th>产品图片：</th>
				<td colspan="3">
					<textarea  name="pro_pho" readonly="readonly" rows="5" class="editor"  style="width: 98%;"><c:out value='${qq.proPho }'/></textarea>
				</td>
			</tr>
			
			
	</table>
</form>
</div>
										
						
					
		

	

