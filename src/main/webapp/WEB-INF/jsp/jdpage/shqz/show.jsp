<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp" %>

	<style>


input{
	width:150px;
}
#tp{

	margin-top:180px;
}
td{
white-space: nowrap;
}
</style>				
<div style="width: 95%;margin: 0 auto ;" >				
			
		
		<table class="table table-bordered" >			
		
			<caption>戒毒求助</caption>
		<tr>
				<td style="width:26%;white-space: nowrap;">求助人：</td>
				<td>
					${requestScope.shqz.qzryxm}
				</td>
		</tr>
		
			
			<tr>
				<td >求助内容：</td>
				<td  colspan="3">
					${requestScope.shqz.qznr}
				</td>
			</tr>
			<tr>
				<td style="width:26%;white-space: nowrap;">求助时间：</td>
				<td>
					${requestScope.shqz.qzsj}
				</td>
			</tr>
			
			<tr>
				<td style="width:26%;white-space: nowrap;">回复时间：</td>
				<td>
					${requestScope.shqz.hfsj}
				</td>
			</tr>
			
			<tr>	
				<td style="width:26%;white-space: nowrap;">回复内容：</td>
				<td>
					${requestScope.shqz.hfnr}
				</td>
			</tr>
			
		</table>
	
	

</div>	
					
		

	

