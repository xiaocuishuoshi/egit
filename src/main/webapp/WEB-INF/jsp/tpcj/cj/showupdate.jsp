<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.whfp.oa.commons.util.ServletUtil"%>
<%@page import="com.whfp.oa.commons.model.Member"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp" %>
<%--
	模块：企业宣传--公告管理 --系统公告添加
--%>
 

 
<div style="width: 98%;margin: 0 auto ;" >
			
<form method="post" action="tpcj/update.do"  onsubmit="return validateSubmitForm(this)">
	<table class="table table-bordered ">
			<input type="hidden" name="id" class="easyui-validatebox" required="true"  value="<c:out value='${qq.id }'/>"/>
			<input type="hidden" name="fbrs" class="easyui-validatebox" required="true"  value="<c:out value='${qq.fbrs }'/>"/>
			<tr>
				<th style="width:80px">标题：</th>
				<td  colspan="3">
					<input type="text" name="cjtitle" value="<c:out value='${qq.cjtitle }'/>" class="easyui-validatebox" required="true" />
				</td>
			
			</tr>
			<tr>
				<th>发布范围 (人员):</th>
					<td>
						<a href="user/lookUpPage.do?type=2" lookupGroup="user" title="用户查询">
							<textarea  readonly="readonly"  toName="user.trueName"  rows="2" style="width: 400px"><my:outTrueName id="${requestScope.qq.fbry }"  /></textarea>
						</a>
						<input type="hidden"  name="fbry" toName="user.id" value="<c:out value='${qq.fbry}'/>"/>
						<a class="easyui-linkbutton clearLookup"  icon="icon-cancel"	plain="true"  href="javascript:;"  clearLookup="user"  title="清空"></a>
					</td>
			</tr>
			<tr>
				<th>描述：</th>
				<td colspan="3">
					<textarea  name="ms"  rows="5" class="editor"  style="width: 98%;"><c:out value='${qq.ms }'/></textarea>
				</td>
			</tr>
			
			<tr>
				<th>是否生效：</th>
				<td colspan="3">
					<c:choose>
						<c:when test="${requestScope.qq.sfsx==是}">
							<label class="checkbox inline" ><input type="checkbox" checked="checked" name="sfsx" value="是" /></label>
						</c:when>
						<c:otherwise>
							<label class="checkbox inline" ><input type="checkbox" checked="checked" name="sfsx" value="是" /></label>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<th>一等奖人数：</th>
				<td >
					<input type="text" name="ydjrs" value="<c:out value='${qq.ydjrs }'/>"  class="easyui-validatebox" required="true" />
				</td>
				<th>二等奖人数：</th>
				<td >
					<input type="text" name="edjrs" value="<c:out value='${qq.edjrs }'/>" class="easyui-validatebox" required="true" />
				</td>
			</tr>
			<tr>
				<th>三等奖人数：</th>
				<td >
					<input type="text" name="sdjrs" value="<c:out value='${qq.sdjrs }'/>"  class="easyui-validatebox" required="true" />
				</td>
				<th>其他奖人数：</th>
				<td >
					<input type="text" name="qtjrs" value="<c:out value='${qq.qtjrs }'/>"  class="easyui-validatebox" required="true" />
				</td>
			</tr>
			<tr>
				<th>一等奖奖品：</th>
				<td >
					<input type="text" name="ydjjp" value="<c:out value='${qq.ydjjp }'/>"  class="easyui-validatebox" required="true" />
				</td>
				<th>二等奖奖品：</th>
				<td >
					<input type="text" name="edjjp" value="<c:out value='${qq.edjjp }'/>"  class="easyui-validatebox" required="true" />
				</td>
			</tr>
			<tr>
				<th>三等奖奖品：</th>
				<td >
					<input type="text" name="sdjjp" value="<c:out value='${qq.sdjjp }'/>"  class="easyui-validatebox" required="true" />
				</td>
				<th>其他奖奖品：</th>
				<td >
					<input type="text" name="qtjjp" value="<c:out value='${qq.qtjjp }'/>"  class="easyui-validatebox" required="true" />
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
										
						
					
		

	

