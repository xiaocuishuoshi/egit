<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.whfp.oa.commons.util.ServletUtil"%>
<%@page import="com.whfp.oa.commons.model.Member"%>
<%@page import="com.whfp.oa.manager.hlkj.dict.bean.HlkjDict"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp" %>
<%--
	模块：企业宣传--公告管理 --系统公告添加
--%>
 

 
<div style="width: 98%;margin: 0 auto ;" >
			
<form method="post" action="hlkj/zcgl/save.do"  onsubmit="return validateSubmitForm(this)">
	<table class="table table-bordered ">
			<tr>
				<th>资产名称：</th>
				<td  colspan="3">
				<input type="text" name="zcmc" class="easyui-validatebox" required="true" />
				</td>
			</tr>
			<tr>
				<th>资产编号：</th>
				<td colspan="3">
					<input type="text" name="zcbh" class="easyui-validatebox" value="0" required="true" />
				</td>
			</tr>
			<tr>
				<th style="width:80px">出厂编号：</th>
				<td  colspan="3">
					<input type="text" name="ccbh" class="easyui-validatebox" required="false" />
				</td>
			</tr>
			<tr>
				<th style="width:80px">单位：</th>
				<td  colspan="3">
					<input type="text" name="dept" class="easyui-validatebox" required="false" />
				</td>
			</tr>
			<tr>
				<th style="width:80px">供应商：</th>
				<td  colspan="3">
					<input type="text" name="gys" class="easyui-validatebox" required="false" />
				</td>
			</tr>
			<tr>
				<th style="width:80px">安装地点：</th>
				<td  colspan="3">
					<input type="text" name="azdd" class="easyui-validatebox" required="false" />
				</td>
			</tr>
			<tr>
				<th style="width:80px">采购时间：</th>
				<td  colspan="3">
					<input type="text" name="cgsj" class="easyui-validatebox" required="false" />
				</td>
			</tr>
			<tr>
				<th style="width:80px">使用寿命：</th>
				<td  colspan="3">
					<input type="text" name="sysm" class="easyui-validatebox" required="false" />
				</td>
			</tr>
			<tr>
				<th style="width:80px">采购价格：</th>
				<td  colspan="3">
					<input type="text" name="cgjg" class="easyui-validatebox" required="false" />
				</td>
			</tr>
			<tr>
				<th style="width:80px">折旧年限：</th>
				<td  colspan="3">
					<input type="text" name="zjnx" class="easyui-validatebox" required="false" />
				</td>
			</tr>
			<tr>
				<th style="width:80px">保养频率：</th>
				<td  colspan="3">
					<input type="text" name="bypl" class="easyui-validatebox" required="false" />
				</td>
			</tr>
			<tr>
				<th style="width:80px">残值率：</th>
				<td  colspan="3">
					<input type="text" name="czl" class="easyui-validatebox" required="false" />
				</td>
			</tr>
			<tr>
				<th style="width:80px">功率：</th>
				<td  colspan="3">
					<input type="text" name="gl" class="easyui-validatebox" required="false" />
				</td>
			</tr>
			
			<tr>
				<th style="width:80px">设备参数：</th>
				<td  colspan="3">
					<input type="text" name="sbcs" class="easyui-validatebox" required="false" />
				</td>
			</tr>
			<tr>
				<th style="width:80px">责任人：</th>
				<td  colspan="3">
					<input type="text" name="zrr" class="easyui-validatebox" required="false" />
				</td>
			</tr>
			<tr>
				<th style="width:80px">设备状态：</th>
				<td  colspan="3">
					<input type="text" name="sbzt" class="easyui-validatebox" required="false" />
				</td>
			</tr>
			<tr>
				<th style="width:80px">设备类型：</th>
				<td  colspan="3">
					<select name="sblx" id="sblx">
						<option value="空调">空调</option>
						<option value="暖风机">暖风机</option>
					</select>
				</td>
			</tr>
			<tr>
				<th style="width:80px">描述：</th>
				<td  colspan="3">
					<textarea rows="2" name="desc"></textarea>
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
										
						
					
		

	

