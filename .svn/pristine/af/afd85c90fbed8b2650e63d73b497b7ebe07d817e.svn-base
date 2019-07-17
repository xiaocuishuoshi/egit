<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp" %>
<%
request.setAttribute("ctx",request.getContextPath());
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
	<style>


input{
	width:100px;
}

td{
border:1px solid #E9F1FF;
	white-space: nowrap;
}
input{
	readonly:readonly;
}
table{
	border:1px solid #E9F1FF;
}
td:hover{
	cursor:pointer;
	color:#3399FF;
	font-size:17px;
	font-weight:bold;
}
</style>				
<div style="width: 95%;margin: 0 auto ;" >				
		
		<table class="table table-bordered" >			
	
				<h3 style="text-align:center;">基本信息</h3>
		<hr/>
			戒毒(康复)人员编号:&nbsp;&nbsp;
		${requestScope.jd.jdRybh}
				<td style="width:80px;">
					姓名
				</td>
				<td>
					${requestScope.jd.jdRyxm}
				</td>
				<td style="width:80px;">
					绰号/别名
				</td>
				<td>
					${requestScope.jd.jdCym}
				</td>
				<td style="width:80px;">
					性别
				</td>
				<td style="width:80px;">
					${requestScope.jd.jdRyxb }
				</td>
				<td rowspan="3" id="tp" style="width:130px; margin-right:5px;">
				
				<c:if test="${requestScope.jd.jdRyxp!=null }">
				<img id="upview" src="<%= path %>/${requestScope.jd.jdRyxp}" style="float:left; width:130px; height:150px;">
				</c:if>
				</td>
			</tr>

			<tr>
				<td>
					民族
				</td>
				<td>
					${requestScope.jd.jdMz}
				</td>
				<td>
					出生日期
				</td>
				<td>
					${requestScope.jd.jdCsrq}
				</td>
				<td>
					身高(CM)
				</td>
				<td>
				${requestScope.jd.jdRysg}
				</td>
			</tr>
			<tr>
				<td>
					宗教信仰
				</td>
				<td>
					${requestScope.jd.jdZjxy}
				</td>
				<td>
					证件种类
				</td>
				<td>
				${requestScope.jd.jdZjzl}
				</td>
				<td>
					证件号码
				</td>
				<td>
				${requestScope.jd.jdSfzh}
				</td>
			</tr>
			<tr>
				<td>
					婚姻状况
				</td>
				<td>
					${requestScope.jd.jdHyzk}
					
				</td>
				<td>
					文化程度
				</td>
				<td>
					${requestScope.jd.jdWhcd}
				</td>
				<td>
						职业
					</td>
					<td>
						${requestScope.jd.jdZy}
				</td>
			</tr>

			
			<tr>
				<td>户籍地</td>
				<td>
						${requestScope.jd.jdHjd}
				</td>
				
				<td>户籍地详址</td>
				<td>
						${requestScope.jd.jdHjxxdz}
				</td>
				
				<td>户籍地派出所</td>
				<td>
						${requestScope.jd.jdHjdpcs}
				</td>
			</tr>
			<tr>
				<td>居住地</td>
				<td>
						${requestScope.jd.jdJzd}
				</td>
			<td>居住地详址</td>
				<td>
					${requestScope.jd.jdJzdz}
				</td>
				<td>居住地派出所</td>
				<td>
						${requestScope.jd.jdJzdpcs}
				</td>
				
				
			</tr>
			
			
			<tr>
				<td>
					监管人员
				</td>
				
				<td>${requestScope.jd.jdJgry}
				</td>
			
			<td>
					定位电话
				</td>
				<td>
					${requestScope.jd.jdDwdh}
				</td>
			
			<td>
					籍贯
				</td>
				<td>
					${requestScope.jd.jdRyjg}
				</td>
				
			</tr>
			
			<tr>
				<td>
					联系方式
				</td>
				<td>
					${requestScope.jd.jdLxfs}
				</td>
				<td>
					政治面貌
				</td>
				<td>
					${requestScope.jd.jdZzmm}
				</td>
				
				<td>
					查获日期
				</td>
				<td>
					${requestScope.jd.jdChrq}
				</td>
				
		<tr>
			<td>
					脱失次数
				</td>
				<td>
					${requestScope.jd.jdTscs}
				</td>
				
				<td>
					滥用毒品种类
				</td>
				<td>
					${requestScope.jd.jdLydpzl}
				</td>
				<td>
					查获单位
				</td>
				<td>
					${requestScope.jd.jdChdw}
				</td>
				
				
		</tr>
		<tr>
			
			<td>
					当前管控状况
				</td>
				<td>
					${requestScope.jd.jdDqgkxz}
				</td>
				
				<td>
					当前管控地区
				</td>
				<td>
				${requestScope.jd.jdDqgkdq}
				</td>
			</tr>
			
		
		
		</table>
	
	

</div>	
					
		

	

