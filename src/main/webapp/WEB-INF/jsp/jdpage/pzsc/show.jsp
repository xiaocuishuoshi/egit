<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp" %>
<%--
	模块：系统管理--用户管理 --单个用户详情
--%>
	<style>


input{
	width:100px;
}
</style>				
<div style="width: 95%;margin: 0 auto ;" >			
		
		<table class="table table-bordered" >			
				<caption>拍照信息</caption>
				<tr>
					<td>拍照人姓名:</td>
					<td>${requestScope.pz.pzryxm}</td>
				</tr>
				
				<tr>
					<td>相片:</td>
					<td><img src="${requestScope.pz.zpdz}" style="width:250px; height:170px;"/></td>
				</tr>
				
				<tr>
					<td>拍照时间:</td>
					<td>${requestScope.pz.pzsj}</td>
				</tr>
				
				<tr>
					<td>所属单位:</td>
					<td>${requestScope.deptName}</td>
				</tr>
				
		</table>
	
	

</div>	
					
		

	

