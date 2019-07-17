<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp" %>
<%--
	模块：工作计划--计划管理 --添加
--%>

<div style="width: 98%;margin: 0 auto ;" >
			
<form method="post" action="workPlan/add.do" enctype="multipart/form-data" onsubmit="return validateSubmitForm(this)">
						
	<table class="table table-bordered ">
			<tr>
				<th style="width: 80px">计划名称：</th>
				<td>
					<input type="text" name="name" class="easyui-validatebox" required="true" validType="minlength[1]"  maxlength="100"   />
					
				</td>
			</tr>
			<tr>
				<th>计划类型：</th>
				<td>
					<select class="easyui-validatebox" required="true"  name="type" >
						<option value="">--请选择类型--</option>
						<my:outOptions type="60"/>
					</select>
				</td>
			</tr>
			<tr>
				<th>计划时间：</th>
				<td>
					<input type="text"  name="startTime" id="workplan_add" class="easyui-validatebox" required="true"  style="width: 140px"  readonly="readonly" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
					--
					<input type="text"  name="endTime"  class="easyui-validatebox" required="true"   readonly="readonly"  style="width: 140px"  onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'workplan_add\');}'})" />
				</td>
			</tr>
			<tr>
				<th>工作状态：</th>
				<td>
					<select   name="status" >
						<option value="0">未开始</option>
						<option value="1">进行中</option>
						<option value="2">暂停</option>
						<option value="3">结束</option>
					</select>
					<span class="text-info">说明工作现在运行情况，状态为 结束 时不能对工作计划添加计划任务。</span>
				</td>
			</tr>
			<tr>
				<th>负责人：</th>
				<td>
					<a href="user/lookUpPage.do?type=2"  lookupGroup="fz" title="用户查询">
						<textarea  readonly="readonly"  toName="fz.trueName"  rows="2" style="width: 400px"></textarea>
					</a>
					<input type="hidden"  name="fzIds" toName="fz.id" />
					<a class="easyui-linkbutton clearLookup"  icon="icon-cancel"	plain="true"  href="javascript:;"  clearLookup="fz"  title="清空"></a>
					<br/><span class="text-info">负责人可以对工作计划进行修改，添加计划任务。</span>
				</td>
			</tr>
			<tr>
				<th>参与人：</th>
				<td>
					<a href="user/lookUpPage.do?type=2"  lookupGroup="cy" title="用户查询">
						<textarea  readonly="readonly"  toName="cy.trueName"  rows="2" style="width: 400px"></textarea>
					</a>
					<input type="hidden"  name="cyIds" toName="cy.id" />
					<a class="easyui-linkbutton clearLookup"  icon="icon-cancel"	plain="true"  href="javascript:;"  clearLookup="cy"  title="清空"></a>
					<br/><span class="text-info">参与人可以对工作计划添加计划任务。</span>

				</td>
			</tr>
			<tr>
				<th>批注领导：</th>
				<td>
					<a href="user/lookUpPage.do?type=2"  lookupGroup="head" title="用户查询">
						<textarea  readonly="readonly"  toName="head.trueName"  rows="2" style="width: 400px"></textarea>
					</a>
					<input type="hidden"  name="headIds" toName="head.id" />
					<a class="easyui-linkbutton clearLookup"  icon="icon-cancel"	plain="true"  href="javascript:;"  clearLookup="head"  title="清空"></a>
					
					<br/><span class="text-info">批注领导可以对工作计划添加批注。</span>

				</td>
			</tr>
			<tr>
				<th>授权部门：</th>
				<td>
					<a href="dept/lookUpPage.do?type=2" lookupGroup="dept" title="部门查询">
						<textarea  readonly="readonly"  toName="dept.deptName"  rows="2" style="width: 400px" ></textarea>
					</a>
					<input type="hidden" name="deptIds" toName="dept.id" />
					<a class="easyui-linkbutton clearLookup"  icon="icon-cancel"	plain="true"  href="javascript:;"  clearLookup="dept"  title="清空"></a>
					
					<br/><span class="text-info">只有查询功能。</span>
				</td>
			</tr>
			
			<tr>
				<th>授权人员：</th>
				<td>
					<a href="user/lookUpPage.do?type=2"  lookupGroup="user" title="用户查询">
						<textarea  readonly="readonly"  toName="user.trueName"  rows="2" style="width: 400px"></textarea>
					</a>
					<input type="hidden"  name="userIds" toName="user.id" />
					<a class="easyui-linkbutton clearLookup"  icon="icon-cancel"	plain="true"  href="javascript:;"  clearLookup="user"  title="清空"></a>
					<br/><span class="text-info">只有查询功能。</span>

				</td>
			</tr>
			<tr>
				<th>提醒：</th>
				<td>
					<label class="checkbox inline" ><input type="checkbox" name="isSendMsg" value="1" checked="checked"/>系统提醒</label>
				</td>
			</tr>
			<tr>
				<th>附件：</th>
				<td>
					
					<table class="table table-bordered itemDetail" addButton="添加"  style="width:100%;margin-top: 0;"
						template='
							<tr>
					 			<td style="text-align: center;"><div class="itemDetail-rownumber">1</div></td>
								<td ><input type="file" fileupload="no" class="easyui-validatebox"  required="true" name="file[#index#]"  /></td>
								<td style="text-align: center;"><a href="javascript:;" class="btnDel"  title="删除"></a></td>	
							</tr>
						'>
						<thead>
							<tr>
								 <th width="35" style="text-align: center;">序号</th>
								 <th style="text-align: center;">附件</th>
							 	 <th width="35" style="text-align: center;">删除</th>
							</tr>
						</thead>
						<tbody></tbody>
					</table>
						
				</td>
				
			</tr>
			<tr>
				<th>备注：</th>
				<td>
					<textarea  name="remark"  rows="2"   style="width: 98%;" ></textarea>
				</td>
			</tr>
			<tr>
				<th>计划内容：</th>
				<td>
					<textarea  name="content"  rows="5" class="editor"  style="width: 98%;" ></textarea>
				</td>
			</tr>
			<tr>
				<th></th>
				<td>
					<div  style="margin-top: 10px;margin-bottom: 10px;">
						  <button type="submit" class="btn btn-primary" >保存</button>&nbsp;&nbsp;&nbsp;&nbsp;
						  <button type="button" class="btn clear" >清空</button>
					</div>
				</td>
			 </tr>
			
			
			
		
	</table>
	
	
	
	<input type="hidden" name="datagridId" value="${param.rel }_datagrid" />	
    <input type="hidden" name="currentCallback" value="close" />
	
</form>
</div>
										
						
					
		

	

