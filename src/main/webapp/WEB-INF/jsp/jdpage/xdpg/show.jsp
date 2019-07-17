<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>
<%--
	模块：在线评估-吸毒评估详情
--%>

	<div style="width: 800px; margin: 0 auto;">
		<table class="table table-bordered ">
			<h3 style="margin-left: 180px;">戒毒人员${xdpg.name}综合量化评估（${xdpg.pgsj}）</h3>
			
			<tr>	
				<th style="width:150px">生理检测：</th>
				<td>
					${xdpg.sljc}
				</td>

				<th style="width:150px">拒绝尿检次数：</th>
				<td>
					${xdpg.jjljcs}
				</td>
			
			</tr>
			
				<tr>
				<th style="width:150px">主要生活来源：</th>
				<td>
					${xdpg.shly}
				</td>
				
			<th >心里矫治：</th>
				<td >
					${xdpg.slqz}
				</td>
			</tr>
			
			
				<tr>
				<th style="width:150px">告诫次数：</th>
				<td >
					${xdpg.gjcs}
				</td>
				
			<th >见面次数：</th>
				<td >
					${xdpg.jmcs}
				</td>
			</tr>
			
				<tr>
				<th >当前戒断时限：</th>
				<td >
					${xdpg.jdsx}
				</td>
				
				<th style="width:150px">戒断情况：</th>
				<td >
					${xdpg.jdqk}
				</td>
			</tr>
			
				<tr>
				<th >情况汇报：</th>
				<td >
					${xdpg.qkhb}
				</td>
				
				<th style="width:150px">擅自离开：</th>
				<td >
					${xdpg.szlk}
				</td>
			</tr>
			
			<tr>
				
				<th style="width:150px">家属与邻里评论：</th>
				<td >
					${xdpg.jspl}
				</td>
				
				<th >综合得分：</th>
				<td >
					${xdpg.zhds}
				</td>
				
			</tr>
			
			<tr>	
				<th style="width:150px">综合评估意见：</th>
				<td colspan="4">
					${xdpg.zhpgyj}
				</td>
			</tr>
			
		
			
			<tr>
				<th >社区戒毒工作小组组长意见：</th>
				<td >
					${xdpg.gzxzyj}
				</td>
				
				<th style="width:150px">社区民警意见：</th>
				<td >
					${xdpg.mjyj}
				</td>
			</tr>
			
			
			<tr>
				<th >社区医生意见：</th>
				<td >
					${xdpg.ysyj}
				</td>
				
				<th style="width:150px">中心戒毒社区工作者意见：</th>
				<td >
					${xdpg.gzgyj}
				</td>
			</tr>
		</table>
	</div>
