<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.whfp.oa.commons.util.ServletUtil"%>
<%@page import="com.whfp.oa.commons.model.Member"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp" %>
<%--
	模块：企业宣传--公告管理 --系统公告添加
--%>
 

 
<div style="width: 98%;margin: 0 auto ;" >
			
<form method="post" action="qyxw/save.do"  onsubmit="return validateSubmitForm(this)">
	<table class="table table-bordered ">
			<tr>
				<th style="width: 80px">新闻标题：</th>
				<td>
					<input type="text" name="title" class="easyui-validatebox" required="true" />
				</td>
			
			</tr>
			<tr>
				<th>新闻摘要：</th>
				<td  colspan="3">
				<textarea row="3" name="zy"  style="width:80%;"></textarea>
				</td>
			</tr>
			<tr>
				<th>新闻作者：</th>
				<td>
					<input type="text"  name="zz" class="easyui-validatebox" ></textarea>
				</td>
				<th style="width: 80px">是否生效：</th>
				<td>
					<select name="sfgq" class="easyui-validatebox" required="true">
						<option value="是">是</option>
						<option value="否">否</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>新闻内容：</th>
				<td colspan="3">
					<textarea  name="content" rows="5" class="editor"  style="width: 98%;"></textarea>
				</td>
			</tr>
			
			<tr>
				<th></th>
				<td colspan="3">
					<div  style="margin-top: 10px;margin-bottom: 10px;">
						  <button type="submit" class="btn btn-primary" >发布</button>&nbsp;&nbsp;&nbsp;&nbsp;
						  <button type="button" class="btn clear" >清空</button>
					</div>
				</td>
			 </tr>
			
	</table>
</form>
</div>
										
						
					
		

	

