<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp" %>
	
<div style="width: 800px; margin:30px auto;">				
		
		<table class="table table-bordered"  style="width:700px;">			
		<caption>思想汇报</caption>
			<tr>	
				<td style="white-space: nowrap; text-align:right; width:40%;">汇报人姓名：</td>
				<td style=" width:400px;text-align:center;"> 
					${requestScope.sxhb.hbryxm}
				</td>
			</tr>
			<tr>
				<td style="white-space: nowrap; text-align:right;width:40%;">汇报内容：</td>
				<td  style=" width:400px;text-align:center;">
					${requestScope.sxhb.hbnr}
				</td>
			</tr>
			
			<tr>
				<td style="white-space: nowrap; text-align:right;width:40%;">汇报时间：</td>
				<td  style=" width:400px;text-align:center;">
					${requestScope.sxhb.hbsj}
				</td>
			</tr>
			
			
		</table>
	
	

</div>	
					
		

	

