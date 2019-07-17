<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp" %>
<style>
table{
	font-size:16px;
}
   
</style>				
<div style="width: 95%;margin: 0 auto ;" >				
			
		
		<table class="table table-bordered" >
			<caption>通知书下发管理</caption>			
		<tr>
				<td >标题：</td>
				<td>${requestScope.tzs.tzsmc}
				</td>
				
				<td >接收人员：</td>
				
					<td>
						${requestScope.tzs.tzsjsrxm}
					</td>
				
			</tr>
			<tr>
				<td >通知书内容：</td>
				<td colspan="3">
					${requestScope.tzs.tzsnr}
				</td>
				
			</tr>
			
			<tr>
				<td style="white-space: nowrap;">回复内容：</td>
				<td >
					${requestScope.tzs.tzshfnr}
				</td>
				
				<td style="white-space: nowrap;">回复时间：</td>
				<td  colspan="3" >
					${requestScope.tzs.tzshfsj}
				</td>
			</tr>
			<tr>
				<td style="white-space: nowrap;">确认时间：</td>
				<td >
					${requestScope.tzs.qrsj}
				</td>
				
				<td style="white-space: nowrap;">备注：</td>
				<td >
					${requestScope.tzs.bz}
				</td>
			</tr>
			<tr>
				<c:choose>
					<c:when test="${not empty requestScope.tzs.zpdz}">
						<td>相片:</td>
						<td>
						<img src="${requestScope.tzs.zpdz}" style="width:250px; height:170px;">
						</td>	
					</c:when>
					<c:otherwise>
						<td>相片:</td>
						<td>暂无相片</td>
					</c:otherwise>
				</c:choose>
			</tr>
		</table>
	
	

</div>	
					
		

	

