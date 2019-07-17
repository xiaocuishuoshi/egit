<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>
<%--
	模块：报警管理-报警规则-添加报警记录
--%>

<div style="width: 800px; margin: 0 auto;">

	<form action="sr/addSirenRecord.do" method="post"
		onsubmit="return validateSubmitForm(this)">
		<table class="table table-bordered ">
			<tr>
				<th width="80px">
					规则名称：
				</th>
				<td>
					<input type="text" name="gzGzname" class="easyui-validatebox" 
						required="true" maxlength="50" size="50" style="width: 300PX"/>
				</td>
		</tr>
			<tr>
				<th width="80px">
					设备类型：
				</th>
				<td>
					<input type="text" name="gzSbtype" class="easyui-validatebox" 
						required="true" maxlength="50" size="50" style="width: 300PX"/>
					
				</td>
			</tr>
			<tr>
			
			<tr>
				<th width="80px">
					报警级别：
				</th>
				<td>
					<input type="text" name="gzSbjb" class="easyui-validatebox" 
						required="true" maxlength="50" size="50" style="width: 300PX"/>
				</td>
			</tr>
			<tr>
				<th width="80px">
					报警类型：
				</th>
				<td>
					<input type="text" name="gzBjtype" class="easyui-validatebox glkh" style="width: 300PX"
						required="true" maxlength="50" size="50" />
				</td>
			</tr>	
			</tr>
			<tr>
				<th>
					持续时间：
				</th>
				<td>
					<input type="text" name="gzTime" class="easyui-validatebox glkh" style="width: 300PX"
						required="true" maxlength="50" size="50" />
				</td>		
			</tr>
			<tr>
				<th>
					报警规则：
				</th>
				<td>
					<input type="text" name="gzGz" class="easyui-validatebox glkh" style="width: 300PX"
						required="true" maxlength="50" size="50" />
				</td>
		</tr>
		<tr>
				<th>
					开始时间：
				</th>
				<td>
			<input type="text" required="true" class="easyui-validatebox span3"  readonly="readonly"  onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" name="gzKdate"  />
			</td>
			</tr>
		<tr>
			<th>
					结束时间：
				</th>
				<td>
				<input type="text" required="true" class="easyui-validatebox span3"  readonly="readonly"  onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" name="gzJdate"  />
				</td>			
	
		</tr>
			
			<tr>
				<th>
					发送次数：
				</th>
				<td >
					<input type="text" name="gzCount" class="easyui-validatebox glkh" style="width: 300PX"
						required="true" maxlength="50" size="50" />
				</td>
			</tr>
			<tr>
				<th>
					报警开关：
				</th>
				<td>
					<input type="text" name="gzKg" class="easyui-validatebox glkh" style="width: 300PX"
						required="true" maxlength="50" size="50" />
				</td>
			</tr>

			<tr>
				<th>
					适用设备：
				</th>
				<td>
					<input type="text" name="gzFacility" class="easyui-validatebox glkh" style="width: 300PX"
						required="true" maxlength="50" size="50" />
				</td>
			</tr>
			
			<tr>
				<th>
					描述：
				</th>
				<td colspan="3">
					<input type="text" name="gzDescribe" class="easyui-validatebox glkh" style="width: 300PX"
						required="true" maxlength="50" size="50" />
				</td>
			</tr>
			
			<tr>
				<th>
					负责人手机：
				</th>
				<td colspan="3">
					<input type="text" name="gzPhone" class="easyui-validatebox glkh" style="width: 300PX"
						required="true" maxlength="50" size="50" />
				</td>
			</tr>
				<tr>
				<th>
					负责人邮件：
				</th>
				<td>
					<input type="text" name="gzEmail" class="easyui-validatebox glkh" style="width: 300PX"
						required="true" maxlength="50" size="50" />
				</td>
			</tr>

			<tr>
				<th>
				</th>
				<td>
					<div style="margin-top: 10px; margin-bottom: 10px;">
						<button type="submit" class="btn btn-primary">
							保存
						</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn clear">
							清空
						</button>
					</div>
				</td>
			</tr>


		</table>
	</form>
</div>






