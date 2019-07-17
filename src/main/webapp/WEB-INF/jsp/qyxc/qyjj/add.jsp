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
					<input type="text" name="name" class="easyui-validatebox" required="true"  />
				</td>
				<th>企业地址：</th>
				<td>
					<input type="text"  name="addres" class="easyui-validatebox" ></textarea>
				</td>
			</tr>
			<tr>
				<th>联系电话：</th>
				<td>
					<input type="text"  name="telphone" class="easyui-validatebox" ></textarea>
				</td>
				<th>企业传真：</th>
				<td>
					<input type="text"  name="cz" class="easyui-validatebox" ></textarea>
				</td>
			</tr>
			<tr>
				<th>企业法人：</th>
				<td>
					<input type="text"  name="qyfr" class="easyui-validatebox" ></textarea>
				</td>
				<th>注册资金：</th>
				<td colspan="3">
					<input type="text"  name="zczj" class="easyui-validatebox" ></textarea>
				</td>
			</tr>
			<tr>
				<th>企业简介：</th>
				<td colspan="3">
					<textarea  name="qyjj" rows="5" class="editor"  style="width: 98%;"></textarea>
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
										
						
					
		

	

