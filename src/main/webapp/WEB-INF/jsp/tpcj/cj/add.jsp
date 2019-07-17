<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.whfp.oa.commons.util.ServletUtil"%>
<%@page import="com.whfp.oa.commons.model.Member"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp" %>
<%--
	模块：企业宣传--公告管理 --系统公告添加
--%>
 

 
<div style="width: 98%;margin: 0 auto ;" >
			
<form method="post" action="tpcj/save.do"  onsubmit="return validateSubmitForm(this)">
	<table class="table table-bordered ">
			<tr>
				<th style="width:80px">标题：</th>
				<td  colspan="3">
					<input type="text" name="cjtitle" class="easyui-validatebox" required="true" />
				</td>
			
			</tr>
			<tr>
				<th>发布范围 (人员):</th>
					<td>
						<a href="user/lookUpPage.do?type=2" lookupGroup="user" title="用户查询">
							<textarea  readonly="readonly"  toName="user.trueName"  rows="2" style="width: 400px"></textarea>
						</a>
						<input type="hidden"  name="fbry" toName="user.id" />
						<a class="easyui-linkbutton clearLookup"  icon="icon-cancel"	plain="true"  href="javascript:;"  clearLookup="user"  title="清空"></a>
					</td>
			</tr>
			<tr>
				<th>描述：</th>
				<td colspan="3">
					<textarea  name="ms" rows="5" class="editor"  style="width: 98%;"></textarea>
				</td>
			</tr>
			
			<tr>
				<th>是否生效：</th>
				<td colspan="3">
					<label class="checkbox inline" ><input type="checkbox" name="sfsx" value="是" /></label>
				</td>
			</tr>
			<tr>
				<th>一等奖人数：</th>
				<td >
					<input type="text" name="ydjrs" class="easyui-validatebox" required="true" />
				</td>
				<th>二等奖人数：</th>
				<td >
					<input type="text" name="edjrs" class="easyui-validatebox" required="true" />
				</td>
			</tr>
			<tr>
				<th>三等奖人数：</th>
				<td >
					<input type="text" name="sdjrs" class="easyui-validatebox" required="true" />
				</td>
				<th>其他奖人数：</th>
				<td >
					<input type="text" name="qtjrs" class="easyui-validatebox" required="true" />
				</td>
			</tr>
			<tr>
				<th>一等奖奖品：</th>
				<td >
					<input type="text" name="ydjjp" class="easyui-validatebox" required="true" />
				</td>
				<th>二等奖奖品：</th>
				<td >
					<input type="text" name="edjjp" class="easyui-validatebox" required="true" />
				</td>
			</tr>
			<tr>
				<th>三等奖奖品：</th>
				<td >
					<input type="text" name="sdjjp" class="easyui-validatebox" required="true" />
				</td>
				<th>其他奖奖品：</th>
				<td >
					<input type="text" name="qtjjp" class="easyui-validatebox" required="true" />
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
										
						
					
		

	

