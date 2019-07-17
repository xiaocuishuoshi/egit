<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp" %>
<%--
	模块：个人办公--日程安排--添加日程
--%>

<div style="width: 98%;margin: 0 auto ;" >			
	
	<form method="post" action="gwsp/save.do"  onsubmit="return validateSubmitForm(this)">
						
	<table class="flowtable" >
	<caption>发文登记单</caption>
	
	<tr style="width: 60px;">
		<th>公文标题</th>
		
		<td colspan="3" >
			<input type="text" name="gwbt" taskId="task1376896066259"  required="true" />
		</td>
	</tr>
	<tr>
		<th>收文字号</th>
		<td colspan="3" >
			<input type="text" name="swzh" taskId="task1376896066259"  required="true" />
		</td>
	</tr>
	<tr>
		<th>发文字号</th>
		<td colspan="3" >
			<input type="text" name="fwzh" taskId="task1376896066259"  required="true" />
		</td>
	</tr>
	<tr>
		<th>主题词</th>
		<td colspan="3" >
			<input type="text" name="ztc" taskId="task1376896066259"  required="true" />
		</td>
	</tr>
	<tr>
		<th>主送机关</th>
		<td colspan="3" >
			<textarea  name="zsjg" taskId="task1376896066259" required="true" ></textarea>
		</td>
	</tr>
	<tr>
		<th>抄送机关</th>
		<td colspan="3" >
			<textarea  name="csjg" taskId="task1376896066259" required="true" ></textarea>
		</td>
	</tr>
	<tr>
		<th >起草单位</th>
		<td colspan="3" >
			<textarea  name="qcdw" taskId="task1376896066259" required="true" ></textarea>
		</td>
	</tr>
	<tr>
		<th>拟稿人</th>
		<td colspan="3">
			<input type="text"  taskId="task1376896066259" readonly="readonly" loginUserInfo="name"   />
		</td>
	</tr>
	<tr>
		<th>审稿人</th>
		<td colspan="3">
			<input type="text"  taskId="task1376896120327" readonly="readonly" loginUserInfo="name"   />
		</td>
		
	</tr>
	<tr>
		<th>核稿人</th>
		<td colspan="3">
			<input type="text"  taskId="task1376896139227" readonly="readonly" loginUserInfo="name"   />
		</td>
		
	</tr>
	

	<tr>
		<th>校对人</th>
		<td >
			<input type="text"  taskId="task1377244367031" readonly="readonly" loginUserInfo="name"   />
		</td>
		<th>印制份数</th>
		<td >
			<input type="text"  taskId="task1377244367031"  name="yzfs" required="true"/>
		</td>
	</tr>
	</table>
	<div  style="margin-top: 10px;margin-bottom: 10px;" align="center">
						  <button type="submit" class="btn btn-primary" >保存</button>&nbsp;&nbsp;&nbsp;&nbsp;
						  <button type="button" class="btn clear" >清空</button>
					</div>
		
    <input type="hidden" name="currentCallback" value="close" />
    <%--重新初始化日程提醒js--%>
    <input type="hidden" name="callback_fn" value="initScheduleWarn" />
    <c:choose>
    	<c:when test="${empty param.view }">
    		<input type="hidden" name="datagridId" value="${param.rel }_datagrid" />
    	</c:when>
    	<c:otherwise>
    		<input type="hidden" name="otherCallback" value="refresh" />
    		<input type="hidden" name="otherBoxId" value="${param.rel }" />
    	</c:otherwise>
    </c:choose>
    
</form>
</div>
										
						
					
		

	

