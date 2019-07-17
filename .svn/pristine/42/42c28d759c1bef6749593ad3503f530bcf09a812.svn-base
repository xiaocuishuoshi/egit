<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>

<style>

td {
	padding-left: 40px;
}
td{
	white-space: nowrap;
}
</style>
<div style="width: 95%;margin: 0 auto ;" >				

		<table class="table table-bordered">
			<caption>请假信息</caption>
			<tr>
				<td style="padding-left: 50px;">
					请假人姓名
				</td>
				<td>
					${requestScope.qj.qjryxm}
				</td>
			</tr>
			
			<tr>
				<td style="padding-left: 50px;">
					请假内容
				</td>
				<td>
					${requestScope.qj.qjnr}
				</td>
			</tr>
			<tr>
				<td style="padding-left: 50px;">
					请假开始时间
				</td>
				<td>
					${requestScope.qj.qjkssj}
				</td>
			</tr>
			<tr>
				<td style="padding-left: 50px;">
					请假结束时间
				</td>
				<td>
					${requestScope.qj.qjjssj}
				</td>
			</tr>
			<tr>
				<td style="padding-left: 50px;">
					审批:
				</td>
				<td>
						<c:if test="${requestScope.qj.spzt eq '1'}">
							<input type="text" name="spzt" class="easyui-validatebox"
						value="1" />&nbsp;&nbsp;<span style="color:#808080;">0代表未审批 ,1代表已审批</span>
						</c:if>
						
						<c:if test="${requestScope.qj.spzt eq '0'}">
							<input type="text" name="spzt" class="easyui-validatebox"
						value="0" />&nbsp;&nbsp;<span style="color:#808080;">0代表未审批 ,1代表已审批</span>
					
						</c:if>
				
				</td>
			</tr>
		
			
				<tr>
				<td style="padding-left: 50px;">
					销假时间:
				</td>
				<td>
					${requestScope.qj.xjsj}
				</td>
				
				<tr>
				<td style="padding-left: 50px;">
					销假标志:
				</td>
				<td>
				<c:if test="${requestScope.qj.xjbz eq '0'}">
					<input type="text" name="xjbz" class="easyui-validatebox"
						value="0" />&nbsp;&nbsp;<span style="color:#808080;">0代表未销假 ,1代表已销假</span>
				</c:if>	
					<c:if test="${requestScope.qj.xjbz eq '1'}">
					<input type="text" name="xjbz" class="easyui-validatebox"
						value="1" />&nbsp;&nbsp;<span style="color:#808080;">0代表未销假 ,1代表已销假</span>
				</c:if>	
				</td>
			</tr>
			
			
		</table>
</div>





