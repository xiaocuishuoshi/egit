<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>
<%--
	模块：在线评估-吸毒评估
--%>

<form method="post" action="xdpg/addXdpg.do" enctype="multipart/form-data"
	onsubmit="return validateSubmitForm(this)">
	<div style="width: 800px; margin: 0 auto;">
		<table class="table table-bordered ">
			<h3 style="margin-left: 250px;">社区戒毒人员综合量化评估表（半年）</h3>
			
			<tr>	
				<th style="width:150px">评估者：</th>
				<td>
					<a href="sqzw/lookUp.do" lookupGroup="fw" title="人员查询">
						<input type="text" readonly="readonly" toName="fw.jdRyxm" style="width: 210px;"
						placeholder="检查人员列表" class="easyui-validatebox" name="name" required="true"/> </a> 
				<input type="hidden" name="xdrid" toName="fw.id">	
				</td>

				<th style="width:150px">评估时间：</th>
				<td>
				<input type="text" name="pgsj" class="easyui-validatebox"/>
				</td>
			</tr>
			
			
			<tr>	
				<th style="width:150px">生理检测：</th>
				<td>
					<input type="text" name="sljc" class="easyui-validatebox"/>
				</td>

				<th style="width:150px">拒绝尿检次数：</th>
				<td>
					<select name="jjljcs" style="width: 220px;">
						<option value="无">无 </option>
						<option value="六次">六次 </option>
						<option value="五次">五次 </option>
						<option value="四次">四次 </option>
						<option value="三次 ">三次 </option>
						<option value="二次">二次 </option>
						<option value="一次">一次 </option>
					</select>
				</td>
			
			</tr>
			
				<tr>
				<th style="width:150px">主要生活来源：</th>
				<td>
				<select name="shly" style="width: 220px;">
						<option value="家庭支助 ">家庭支助</option>
						<option value="享受低保 ">享受低保</option>
						<option value="自食其力">自食其力</option>
					</select>
				</td>
				
			<th >心里矫治：</th>
				<td >
				<select name="slqz" style="width: 220px;">
						<option value="优">优</option>
						<option value="良">良</option>
						<option value="差">差</option>
					</select>
				</td>
			</tr>
			
			
				<tr>
				<th style="width:150px">告诫次数：</th>
				<td >
				<select name="gjcs" style="width: 220px;">
						<option value="无">无</option>
						<option value="一次">一次</option>
						<option value="二次">二次</option>
					</select>
				</td>
				
			<th >见面次数：</th>
				<td >
				<input type="text" name="jmcs" class="easyui-validatebox" value="周/次"/>
				</td>
			</tr>
			
				<tr>
				<th >当前戒断时限：</th>
				<td >
				<input type="text" name="jdsx" class="easyui-validatebox"/>
				</td>
				
				<th style="width:150px">戒断情况：</th>
				<td >
				<select name="jdqk" style="width: 220px;">
						<option value="靠药物维持">靠药物维持</option>
						<option value="非药物维持">非药物维持</option>
					</select>
				</td>
			</tr>
			
				<tr>
				<th >情况汇报：</th>
				<td >
				<input type="text" name="qkhb" class="easyui-validatebox" value="月/次"/>
				</td>
				
				<th style="width:150px">擅自离开：</th>
				<td >
					<input type="text" name="szlk" class="easyui-validatebox" value="次/天"/>
				</td>
			</tr>
			
			<tr>
				
				<th style="width:150px">家属与邻里评论：</th>
				<td >
				<select name="jspl" style="width: 220px;">
						<option value="优">优</option>
						<option value="良">良</option>
						<option value="差">差</option>
					</select>
				</td>
				
				<th >综合得分：</th>
				<td >
				<input type="text" name="zhds" class="easyui-validatebox"/>
				</td>
			</tr>
			
			<tr>	
				<th style="width:150px">综合评估意见：</th>
				<td colspan="4">
					<textarea style="width:500px;height: 60px;" required="true" name="zhpgyj"></textarea>
				</td>
			</tr>
			
			
			<tr>
				<th >社区戒毒工作小组组长意见：</th>
				<td >
				<input type="text" name="gzxzyj" class="easyui-validatebox"/>
				</td>
				
				<th style="width:150px">社区民警意见：</th>
				<td >
					<input type="text" name="mjyj" class="easyui-validatebox"/>
				</td>
			</tr>
			
			
			<tr>
				<th >社区医生意见：</th>
				<td >
				<input type="text" name="ysyj" class="easyui-validatebox"/>
				</td>
				
				<th style="width:150px">中心戒毒社区工作者意见：</th>
				<td >
					<input type="text" name="gzgyj" class="easyui-validatebox"/>
				</td>
			</tr>
			
			
			<tr>
				<th></th>
				<td colspan="4">
					<div style="margin-top: 10px;margin-bottom: 10px;">
						<button type="submit" class="btn btn-primary">保存</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn clear">清空</button>
					</div>
				</td>
			</tr>
		</table>
		<input type="hidden" name="datagridId" value="${param.rel }_datagrid" />
		<input type="hidden" name="currentCallback" value="close" />
	</div>
</form>