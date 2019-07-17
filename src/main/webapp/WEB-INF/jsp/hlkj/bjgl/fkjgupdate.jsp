<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>
<%--
	模块：报警管理-报警记录-反馈结果
--%>

<div style="width: 800px; margin: 0 auto;">

	<form action="reco/updateSirenRecord.do" method="post"
		onsubmit="return validateSubmitForm(this)">
		<table class="table table-bordered ">
			<tr>
				<th width="80px">
					状态：
				</th>
				<td>
				<input type="hidden" name="jlId" class="easyui-validatebox" required="true"  value="<c:out value='${sr.jlId }'/>"/>
				<input type="hidden" name="jlSbid" class="easyui-validatebox" required="true"  value="<c:out value='${sr.jlSbid}'/>"/>
				
				<input type="hidden" name="jlSbtype" class="easyui-validatebox" required="true"  value="<c:out value='${sr.jlSbtype }'/>"/>
				<input type="hidden" name="jlBjjb" class="easyui-validatebox" required="true" value="<c:out value='${sr.jlBjjb}'/>"/>
				
				<input type="hidden" name="jlBjtype" class="easyui-validatebox" required="true"  value="<c:out value='${sr.jlBjtype }'/>"/>
				<input type="hidden" name="jlBjgz" class="easyui-validatebox" required="true"  value="<c:out value='${sr.jlBjgz}'/>"/>
				<input type="hidden" name="jlBjdz" class="easyui-validatebox" required="true"  value="<c:out value='${sr.jlBjdz}'/>"/>
				<% 
					java.util.Date now=new java.util.Date(); 
				%>	 
				<input type="hidden" name="jlStime" class="easyui-validatebox" required="true"  value="${now}"/>
			
				<input type="hidden" name="jlMs" class="easyui-validatebox" required="true"  value="<c:out value='${sr.jlMs}'/>"/>
				<input type="hidden" name="jlPhone"  value="<c:out value='${sr.jlPhone}'/>"/>
				
				
					<input type="text" name="jlZt" value="<c:out value='${sr.jlZt}'/>" class="easyui-validatebox" 
						required="true" maxlength="50" size="50" style="width: 300PX"/>							
				</td>
		</tr>
			<tr>
				<th width="80px">
					结果：
				</th>
				<td>
					<input type="text" value="<c:out value='${sr.jlReslet}'/>" name="jlReslet" class="easyui-validatebox" 
					required="true" maxlength="50" size="50" style="width: 300PX"/>
					
				</td>
			</tr>
			<tr>
		
			<tr>
				<th>
				</th>
				<td>
					<div style="margin-top: 10px; margin-bottom: 10px;">
						<button type="submit" class="btn btn-primary">
							保存
						</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn clear">
							清空
						</button>
					</div>
				</td>
			</tr>


		</table>
	</form>
</div>






