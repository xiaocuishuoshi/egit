<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%> 
<%--
	模块：在线评估-吸毒评估详情
--%>
<style>
	td {
	font-size: 18px;
}
</style>

	<div style="width: 800px; margin: 0 auto;">
		<table class="table table-bordered ">
		<div>
		<h3 style="margin-left: 80px;">戒毒人员:${requestScope.jd.jdRyxm},编号${requestScope.jd.jdRybh}
		类型为:&nbsp;&nbsp;
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
		</h3>
				<td rowspan="3" colspan="2" >
					<img id="upview" src="<%= path %>/${requestScope.jd.jdRyxp}" style="float:left; width:180px; height:150px;">
				</td>
			
				<td>
					绰号/别名：${requestScope.jd.jdCym}
				</td>
			
				<td>
					性别：${requestScope.jd.jdRyxb }
				</td>
				
			</tr>

			<tr>
				<td>
					民族：${requestScope.jd.jdMz}
				</td>
			
				<td>
					出生日期:${requestScope.jd.jdCsrq}
				</td>
				
				<td>
					身高(CM):${requestScope.jd.jdRysg}
				</td>
			
			</tr>
			<tr>
				<td>
					联系方式:${requestScope.jd.jdLxfs}
				</td>
				<td>
					证件种类:${requestScope.jd.jdZjzl}
				</td>
				
				<td>
					证件号码:${requestScope.jd.jdSfzh}
				</td>
			</tr>
			<tr>
				<td>
					婚姻状况：${requestScope.jd.jdHyzk}
				</td>
				<td>
					文化程度:${requestScope.jd.jdWhcd}
				</td>
			
				<td>
						职业:${requestScope.jd.jdZy}
					</td>
					
				<td>
					政治面貌:${requestScope.jd.jdZzmm}
				</td>
				
				<td>
					宗教信仰:${requestScope.jd.jdZjxy}
				</td>	
					
			</tr>

			
			<tr>
				<td>
					户籍地:${requestScope.jd.jdHjd}
				</td>
				
				<td>
					户籍地详址:${requestScope.jd.jdHjxxdz}
				</td>
				
				<td>
					户籍地派出所:${requestScope.jd.jdHjdpcs}
				</td>
				<td>
					定位电话:${requestScope.jd.jdDwdh}
				</td>
			
			<td>
					籍贯:${requestScope.jd.jdRyjg}
				</td>
			</tr>
			<tr>
				<td>
					居住地:${requestScope.jd.jdJzd}
				</td>
			<td>
				居住地详址:${requestScope.jd.jdJzdz}
			</td>
			
				<td>
					居住地派出所:${requestScope.jd.jdJzdpcs}
				</td>
				<td>
					监管人员:${requestScope.jd.jdJgry}
				</td>
			
					<td>
					查获日期:${requestScope.jd.jdChrq}
				</td>	
			</tr>
				
		
		<tr>
			<td>
					脱失次数:${requestScope.jd.jdTscs}
				</td>
				
				<td>
					滥用毒品种类:${requestScope.jd.jdLydpzl}
				</td>
				
				<td>
					查获单位:${requestScope.jd.jdChdw}
				</td>
			<td>
					当前管控状况:${requestScope.jd.jdDqgkxz}
				</td>
				
				<td>
					当前管控地区:${requestScope.jd.jdWghxh}
				</td>	
		</tr>

		<tr>
			<td>
					当前网格:${requestScope.jd.jdWghxh}
				</td>
				
				<td>
					网格员:${requestScope.jd.jdWgy}
				</td>
				
				<td colspan="3">
					所属社区:${requestScope.jd.jdWgsssq}
				</td>
		</tr>

		</div>
		
		<script type="text/javascript">
			$("#btn").click(function() {
				if ($("#div_id").css("display") == "none") {
					$("#div_id").show(500, null);
				} else {
					$("#div_id").hide(500, null);
				}
			});
		</script>
	</table>	
	</div>
	<a id="btn" href="javascript:;" style="text-decoration: none;font-size: 18px;margin-left: 20px;">
						更多</a>
	<hr/>					
		<!-- ============================吸毒人员在线评估=================================== -->
			<div id="div_id" style="display: none;width: 800px; margin: 0 auto;">
		<table class="table table-bordered ">
		<h3 style="margin-left: 180px;">戒毒人员:${requestScope.jd.jdRyxm},在线评估情况</h3>
			<tr>	
				<td>
					生理检测：${xdpg.sljc}
				</td>

				<td>
					拒绝尿检次数：${xdpg.jjljcs}
				</td>
			
		
				<td>
					主要生活来源：${xdpg.shly}
				</td>
				
				<td >
					心里矫治：${xdpg.slqz}
				</td>
		
				<td >
					告诫次数：${xdpg.gjcs}
				</td>
				</tr>
			
			
				<tr>	
				<td >
					见面次数：${xdpg.jmcs}
				</td>
			
				<td >
					当前戒断时限：${xdpg.jdsx}
				</td>
				
				<td >
					戒断情况：${xdpg.jdqk}
				</td>
					<td >
					情况汇报：${xdpg.qkhb}
				</td>
				
				<td >
					擅自离开：${xdpg.szlk}
				</td>
			</tr>

			
			<tr>
				
				<td >
					家属与邻里评论：${xdpg.jspl}
				</td>
				
				<td >
					综合得分：${xdpg.zhds}
				</td>
				
				<td>
					综合评估意见：${xdpg.zhpgyj}
				</td>
		
				<td >
					社区戒毒工作小组组长意见：${xdpg.gzxzyj}
				</td>
				
				<td >
					社区民警意见：${xdpg.mjyj}
				</td>
			</tr>
			
			
			<tr>
				<td >
					社区医生意见：${xdpg.ysyj}
				</td>
				
				<td >
					中心戒毒社区工作者意见：${xdpg.gzgyj}
				</td>
					<td >
					综合评分：${xdpg.zhds}
				</td>
				<td>
					评估时间：${xdpg.pgsj}
				</td>
			</tr>
		
		</table>
		
		<hr/>
		<!-- ============================健康检查情况=================================== -->
				<table class="table table-bordered ">
				<h3 style="margin-left: 180px;">戒毒人员:${requestScope.jd.jdRyxm},健康检查情况</h3>
					<tr>
						<td>负责人：${kfjc.fzr}</td>
						<td>检查说明：${kfjc.jcsm}</td>
						<td>是否正常：${kfjc.sfzc}</td>
						<td>检查时间：${kfjc.jcsj}</td>
					</tr>
				</table>

			
			<hr/>
				<!-- ============================帮扶情况情况=================================== -->
				<table class="table table-bordered ">
				<h3 style="margin-left: 180px;">戒毒人员:${requestScope.jd.jdRyxm},帮扶情况</h3>
					</tr>
						<td>社区干部：${bfqk.sqgb}</td>
						<td>社区民警：${bfqk.sqmj}</td>
						<td>禁毒社工：${bfqk.jdsg}</td>
						<td>网格员：${bfqk.wgy}</td>
						<td>X: ${bfqk.sqzwname}</td>
				</tr>
					<tr>
						<td width="240">帮扶内容：${bfqk.bfnr}</td>
						<td>帮扶时间：${bfqk.bfsj}</td>
						<td colspan="3">帮扶照片：<img src="${bfqk.bfzp}" style="width:180px; height:150px;"></td>
					</tr>
					<tr>
				</table>
			</div>