<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.whfp.oa.commons.util.ServletUtil"%>
<%@page import="com.whfp.oa.commons.model.Member"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp" %>
<%--
	模块：企业宣传--公告管理 --系统公告添加
--%>
 

 
<div style="width: 98%;margin: 0 auto ;" >
			
<form method="post" action="qycp/update.do"  onsubmit="return validateSubmitForm(this)">
	<table class="table table-bordered ">
			<input type="hidden" name="id" class="easyui-validatebox" required="true"  value="<c:out value='${qq.id }'/>"/>
			
			<tr>
				<th style="width:80px">产品名称：</th>
				<td  colspan="3">
					<input type="text" value="<c:out value='${qq.proName }'/>" name="proName" class="easyui-validatebox" required="true" />
				</td>
			
			</tr>
			<tr>
				<th>产品负责人：</th>
				<td  colspan="3">
				<input type="text" value="<c:out value='${qq.proCharge }'/>" name="proCharge" class="easyui-validatebox" required="true" />
				</td>
			</tr>
			<tr>
				<th>产品描述：</th>
				<td colspan="3">
					<textarea  name="proMs" rows="5" class="editor"  style="width: 98%;"><c:out value='${qq.proMs }'/></textarea>
				</td>
			</tr>
			
			<tr>
				<th>产品图片：</th>
				<td colspan="3">
					<textarea  name="proPho" rows="5" class="editor"  style="width: 98%;"><c:out value='${qq.proPho }'/></textarea>
				</td>
			</tr>
			
			
			<tr>
				<th></th>
				<td colspan="3">
					<div  style="margin-top: 10px;margin-bottom: 10px;">
						  <button type="submit" class="btn btn-primary" >修改</button>&nbsp;&nbsp;&nbsp;&nbsp;
					</div>
				</td>
			 </tr>
			
	</table>
</form>
</div>
										
						
					
		

	

