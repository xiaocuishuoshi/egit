<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp" %>
<%

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
	<style>
input{
	width:50px;
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
	text-align:center;
}
td:hover{
	cursor:pointer;
	color:#3399FF;
	font-size:17px;
	font-weight:bold;
}
img.file_image{
 width:120px;height:120px; 
}
</style>				
<div style="width: 95%;margin: 0 auto ;" >			
		<h5>基本信息</h5>
		<table class="table table-bordered">
		<br>		
			<span style="size: 14px;color: red;">戒毒(康复)人员编号:&nbsp;&nbsp;
		${requestScope.jd.jdRybh}
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;类型为:&nbsp;&nbsp;
		<c:if test="${requestScope.jd.jdRylb==1}">
		吸毒人员
		</c:if>
		<c:if test="${requestScope.jd.jdRylb==2}">
		社区戒毒人员
		</c:if>
		<c:if test="${requestScope.jd.jdRylb==3}">
		社区康复人员
		</c:if>
		<c:if test="${requestScope.jd.jdRylb==4}">
		强制戒毒人员
		</c:if>
		 <c:if test="${requestScope.jd.jdRylb==5}">
		其他
		</c:if>
		<c:if test="${requestScope.jd.jdRylb==6}">
		戒毒期满出所人员
		</c:if>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级别为:&nbsp;&nbsp;
		<c:if test="${requestScope.jd.jdJb==1}">
		一级
		</c:if>
		<c:if test="${requestScope.jd.jdJb==2}">
		二级
		</c:if>
		<c:if test="${requestScope.jd.jdJb==3}">
		三级
		</c:if>
		<c:if test="${requestScope.jd.jdJb==0}">
		正常
		</c:if>
		</span>
				<td rowspan="3" colspan="2" >
					<img id="upview" src="<%= path %>/${requestScope.jd.jdRyxp}" style="float:left; width:180px; height:150px;text-align: center;">
				</td>
				<td style="width:50px;">
					姓名
				</td>
				<td>
					${requestScope.jd.jdRyxm}
				</td>
				<td style="width:50px;">
					绰号/别名
				</td>
				<td>
					${requestScope.jd.jdCym}
				</td>
				<td style="width:50px;">
					性别
				</td>
				<td style="width:50px;">
					${requestScope.jd.jdRyxb }
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
					联系方式
				</td>
				<td>
					${requestScope.jd.jdLxfs}
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
					政治面貌
				</td>
				<td>
					${requestScope.jd.jdZzmm}
				</td>
				
				
				<td>
					宗教信仰
				</td>
				<td>
					${requestScope.jd.jdZjxy}
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
				
				<td>
					网格员
				</td>
				<td>
				${requestScope.jd.jdWgy}
				</td>
			</tr>
			
		
		
	</table>
	<h5>个人简历</h5>
	<table class="table table-bordered">
		<tr>
			<td  style="width:15%;">起时</td>
			<td  style="width:15%;">止时</td>
			<td  style="width:20%;">职业</td>
			<td  style="width:30%;">所在单位</td>
			<td  style="width:20%;">职位</td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	
	</table>
	<h5>家庭社会关系</h5>
	<table class="table table-bordered">
		<tr>
			<td  style="width:20%;">姓名</td>
			<td  style="width:10%;">性别</td>
			<td  style="width:10%;">年龄</td>
			<td  style="width:10%;">关系</td>
			<td  style="width:30%;">家庭住址</td>
			<td  style="width:20%;">联系电话</td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	
	</table>
	
	<h5>相关附件</h5>
	<table class="table table-bordered">
		<tr>
			<td  style="width:20%;">类型</td>
			<td  style="width:80%;">附件</td>
		</tr>
		<tr>
			<td>社区戒毒协议书</td>
			<td>
				<ul class="inline">
					<li><img alt="" class="file_image" src="${ctx }/asset/img/about/HelloWorld2.png"></li>
					<li><img alt="" class="file_image"  src="${ctx }/asset/img/about/HelloWorld2.png"></li>
					<li><img alt="" class="file_image" src="${ctx }/asset/img/about/HelloWorld2.png"></li>
					<li><img alt="" class="file_image" src="${ctx }/asset/img/about/HelloWorld2.png"></li>
					<li><img alt="" class="file_image" src="${ctx }/asset/img/about/HelloWorld2.png"></li>
				</ul>
			</td>
		</tr>
		<tr>
			<td>
				担保书
			</td>
			<td>
				<ul  class="inline">
					<li><img alt="" class="file_image" src="${ctx }/asset/img/about/HelloWorld2.png"></li>
					<li><img alt="" class="file_image" src="${ctx }/asset/img/about/HelloWorld2.png"></li>
					<li><img alt="" class="file_image" src="${ctx }/asset/img/about/HelloWorld2.png"></li>
			
				</ul>			
			</td>

		</tr>
	
	</table>
	<h5>社区戒毒工作小组成员</h5>
	<table class="table table-bordered">
		<tr>
			<td  style="width:20%;">职务</td>
			<td  style="width:20%;">姓名</td>
			<td  style="width:30%;">单位</td>
			<td  style="width:30%;">联系方式</td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	
	</table>
</div>	
