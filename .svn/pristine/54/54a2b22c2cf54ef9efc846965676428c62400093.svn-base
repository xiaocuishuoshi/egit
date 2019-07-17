<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.whfp.oa.commons.util.ServletUtil"%>
<%@page import="com.whfp.oa.commons.model.Member"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp" %>
<%--
	模块：企业宣传--公告管理 --系统公告添加
--%>
 

 
<div style="width: 98%;margin: 0 auto ;" >
			
<form method="post" action="qyxw/update.do"  onsubmit="return validateSubmitForm(this)">
	<table class="table table-bordered ">
			<input type="hidden" name="id" class="easyui-validatebox" required="true"  value="<c:out value='${qq.id }'/>"/>
			<input type="hidden" name="fbsj"   value="<c:out value='${qq.fbsj }'/>" class="span2"/>
			
			<tr>
				<th style="width: 80px">新闻标题：</th>
				<td>
					<input type="text" name="title"  value="<c:out value='${qq.title }'/>" class="easyui-validatebox" required="true" />
				</td>
			<th>
				发件时间：
			</th>
			<td>
				<fmt:formatDate  value="${qq.fbsj}"
					pattern="yyyy-MM-dd HH:mm:ss" />
			</td>
			</tr>
			<tr>
				<th>新闻摘要：</th>
				<td  colspan="3">
				<textarea row="3" name="zy"  style="width:80%;"> <c:out value='${qq.zy }'/></textarea>
				</td>
			</tr>
			<tr>
				<th>新闻作者：</th>
				<td>
					<input type="text"  name="zz" class="easyui-validatebox" value="<c:out value='${qq.zz }'/>"></textarea>
				</td>
				<th style="width: 80px">是否生效：</th>
				<td>
				
					<select name="sfgq" id="sfgq">
							<option value="<c:out value='${qq.sfgq }'/>"><c:out value='${qq.sfgq }'/></option>
							<option value="是" selected="selected">是</option>
							<option value="否" selected="selected">否</option>
						
						
					</select>
				</td>
			</tr>
			<tr>
				<th>新闻内容：</th>
				<td colspan="3">
					<textarea  name="content" rows="5" class="editor"  style="width: 98%;"><c:out value='${qq.content }'/></textarea>
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
										
						
					
		

	

