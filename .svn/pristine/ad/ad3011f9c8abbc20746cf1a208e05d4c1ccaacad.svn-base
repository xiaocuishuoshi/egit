<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<%--用户任务--%>

<script type="text/javascript">
<!--
	var task = workflow.getFigure(nodeid);//当前节点对象
	//获取执行监听器id
	function getOldListenerIds(){
		var listeners=task.listeners;
		  var listenersIds=new Array();
		  for(var i=0;i<listeners.getSize();i++){
			var listener = listeners.get(i);
			listenersIds.push(listener.getId());
		  }
		return listenersIds.join(",");
	}
	//添加执行监听器
	function addListener(row){
		
		var ls=task.getListener(row.id);
		if(!ls){
			var listener = new draw2d.Task.Listener();
			listener.id=row.id;
			listener.event = row.event;
			if(row.valueType==1){
				listener.serviceType="javaClass";
				listener.serviceClass = row.value;
			}else{
				listener.serviceType="expression";
				listener.serviceExpression = row.value;
			}
			
			task.addListener(listener);
		}
	}
	//删除执行监听器
	function removeListener(id){
		task.deleteListener(id);
	}	

//-->
</script>

<div id="task-properties-layout" class="easyui-layout" fit="true">
	<div id="task-properties-toolbar-panel" region="north" border="false"	style="height:30px; background: #E1F0F2;">
		<a href="javascript:;"  class="easyui-linkbutton" plain="true" 	iconCls="icon-save" onclick="saveTaskProperties()">保存</a>

	</div>
	<div id="task-properties-panel" region="center" border="true">
		<div id="task-properties-accordion" class="easyui-accordion" selected="true" fit="true" border="false">
			
			<div id="task" title="用户任务基本属性"  class="properties-menu">
	
					<table style="margin-top: 10px;">
						<tr>
							<td align="right">id:</td>
							<td>
								<span type="text" id="taskId" ></span>
							</td>
						</tr>
						<tr>
							<td align="right">名称:</td>
							<td>
								<input type="text" id="taskName" />
							</td>
						</tr>
						
						<tr >
							<td align="right">表单:</td>
							<td>
								<a href="form/lookUpPage.do?type=2" lookupGroup="flowform" title="表单查询" targetBox="table">
									<input id="formName"  toName="flowform.formName" readonly="readonly" />
								</a>
								<input type="hidden" id="formId"  toName="flowform.id" />
								<a  class="clearLookup" style="margin-left: 5px;" href="javascript:;"  clearLookup="flowform" targetBox="table"  title="清空">清空</a>
							</td>
						</tr>
						<tr>
							<td align="right">到期时间:</td>
							<td>
								<textarea id="dueDate" class="textdesc"></textarea>
							</td>
						</tr>
						<tr>
							<td align="right">优先级:</td>
							<td>
								<input type="text" id="priority" />
							</td>
						</tr>
						<tr>
							<td align="right">描述:</td>
							<td>
								<textarea id="taskDesc" class="textdesc"></textarea>
							</td>
						</tr>
						
					</table>
					<fieldset style="line-height: 21px;">
						<legend>说明</legend>
						<div>1.用户任务是系统和用户交互的任务，需要用户来完成任务流程才能继续往下执行。</div>
						<div>2.表单：用户完成任务时需要填写的表单。</div>
						<div>3.任务到期时间,可以为任务指定到期时间，使用表达式取值流程变量，用户可以自定义时间。</div>
				 		<div>4.任务优先级。数值越大，优先级越高。</div>
				 </fieldset>
				
			</div>
			
			<div id="main-config" title="用户任务配置"  class="properties-menu" >
				
					<table id="main-properties" style="margin-top: 10px;">
						<tr>
							<td align="right">分配模式:</td>
							<td>
								<select id="performerType" name="performerType">
									<option value="candidate" selected="selected">待选模式</option>
									<option value="assignee" >直接指派</option>
									<option value="expression">表达式</option>
								</select>
							</td>
						</tr>
						<!-- 待选模式 -->
						<tr class="task_candidate">
							<td align="right">待选人员:</td>
							<td>
								<a href="user/lookUpPage.do?type=2" lookupGroup="user" title="用户查询" targetBox="table">
									<textarea id="userNames"   toName="user.trueName"  readonly="readonly" ></textarea>
								</a>
								<input type="hidden" id="userIds" toName="user.id" />
								<a  class="clearLookup" style="margin-left: 5px;" href="javascript:;"  clearLookup="user" targetBox="table"  title="清空">清空</a>
							</td>
						
						</tr>
						<tr class="task_candidate">
							<td align="right">待选角色:</td>
							<td>
								<a href="role/lookUpPage.do?type=2" lookupGroup="role" title="角色查询" targetBox="table">
									<textarea  id="roleNames" toName="role.roleName"  readonly="readonly" ></textarea>
								</a>
								<input type="hidden"  id="roleIds" toName="role.id" />
								<a  class="clearLookup" style="margin-left: 5px;" href="javascript:;"  clearLookup="role" targetBox="table"  title="清空">清空</a>
							</td>
							
						</tr>
						<!-- 直接指派 -->
						<tr style="display: none;" class="task_assignee">
							<td align="right">人员:</td>
							<td>
								<a href="user/lookUpPage.do?type=1" lookupGroup="assignee" title="用户查询" targetBox="table">
									<input id="assigneeName"  toName="assignee.trueName" readonly="readonly" />
								</a>
								<input type="hidden" id="assigneeId"  toName="assignee.id" />
								<a  class="clearLookup" style="margin-left: 5px;" href="javascript:;"  clearLookup="assignee" targetBox="table"  title="清空">清空</a>
							</td>
						</tr>
						<!-- 表达式 -->
						<tr style="display: none;" class="task_expression">
							<td align="right">指派人员:</td>
							<td>
								<textarea id="expression_assignee" class="textdesc"></textarea>
							</td>
						</tr>
						<tr style="display: none;" class="task_expression">
							<td align="right">待选人员:</td>
							<td>
								<textarea id="expression_user" class="textdesc"></textarea>
							</td>
						</tr>
						<tr style="display: none;" class="task_expression">
							<td align="right">待选角色:</td>
							<td>
								<textarea id="expression_group" class="textdesc"></textarea>
							</td>
						</tr>
						
						
						
					</table>
					<fieldset style="line-height: 21px;">
							<legend>说明</legend>
							<div>1.待选模式：人员，角色可作为候选类型，可多选。任务会在未领任务里面出现，一旦有一个人领取任务，此任务将在其他候选人未领任务列表消失。</div>
							<div>2.直接指派：直接指定任务执行人。只能指定一个人员。</div>
							<div>3.表达式：从流程变量中取值。注意：待选人员和待选角色可以同时存在，如果有指派人员，那么待选人员和待选角色则无效，例:\${userId }，可用\${applyUserId}指定为流程发起人，可用\${flowUtil.getDeptHeadId(applyUserId)}指定发起人的部门经理</div>
							
							
					</fieldset>
			</div>


			<div id="multi-instance" title="多实例任务配置"  class="properties-menu" 	>
				
					<table id="main-properties" style="margin-top: 10px;">
						<tr>
							<td align="right">状态:</td>
							<td>
								
								<select id="isSequential" >
									<option value="" >不启用多实例</option>
									<option value="false" >并行</option>
									<option value="true">顺序</option>
								</select>
							</td>
						</tr>
						<tr>
							<td align="right">循环数量:</td>
							<td>
								<input type="text" id="loopCardinality" />
							</td>
						</tr>
						<tr>
							<td align="right">循环集合:</td>
							<td>
								<textarea id="collection" class="textdesc"></textarea>
							</td>
						</tr>
						<tr>
							<td align="right">元素名称:</td>
							<td>
								<input type="text" id="elementVariable" />
							</td>
						</tr>
						<tr>
							<td align="right">结束条件:</td>
							<td>
								<textarea id="completionCondition" class="textdesc"></textarea>
							</td>
						</tr>
						
					</table>
					<fieldset style="line-height: 21px;">
							<legend>说明</legend>
							<div>1.多实例任务Activiti默认会创建3个流程变量，nrOfInstances:实例总数，nrOfActiveInstances:当前活跃的，也就是当前还未完成的，对于顺序的多实例，此值总是1,nrOfCompletedInstances:已完成的实例个数。</div>
							<div>2.状态:不启动多实例,则只会创建一个任务，默认不启动，不启动多实例，一下配置都无效，true:顺序执行，fasle:并行,同时执行。</div>
							<div>3.循环数量:指定创建多任务的数量。可使用表达式从流程变量获取。</div>
							<div>4.循环集合:流程变量中一个集合类型变量的变量名称。根据集合元素多少创建任务数量。可使用表达式。例:流程变量：assigneeUserIdList=[user1,user2]，可用assigneeUserIdList。</div>
							<div>5.集合元素:集合中每个元素的变量名称，可在每个任务中获取,可使用表达式。例：集合为当定义集合元素名称为:assigneeUserId,可在任务直接指派人员用表达式\${assigneeUserId}获取，用于动态会签。</div>
							<div>6.结束条件:多实例活动结束的条件，默认为完成多全部实例，当表达式返回true时结束多实例活动。例：\${nrOfCompletedInstances/nrOfInstances>=0.6} 说明当有60%的任务完成时，会完成此多实例，删除其他未完成的，继续下面的流程。</div>
							<div>7.\${flowUtil.stringToList(assigneeUserIdList)}，将字符串转换成集合，暴露的SpringBean方法</div>
					</fieldset>
			</div>
			<%--任务监听器 --%>
			<div  style="padding: 1px;" title="用户任务监听器"	class="properties-menu">	
				<table id="oldTaskListenerDatagrid" ></table>
			</div>
			
			<%--执行监听器 --%>
			<%@ include file="/WEB-INF/jsp/workflow/flow/designer/include/executionListener.jsp" %>
			
		</div>
	</div>
</div>

<script type="text/javascript">

<!--
$(function(){
		
	//初始化节点基本数据
	$("#taskId").text(task.taskId);
	$("#taskName").val(task.taskName);
	$("#taskDesc").val(task.documentation);
	$("#dueDate").val(task.dueDate);
	$("#priority").val(task.priority);
	
	//多实例
	$("#isSequential").val(task.isSequential);
	$("#loopCardinality").val(task.loopCardinality);
	$("#collection").val(task.collection);
	$("#elementVariable").val(task.elementVariable);
	$("#completionCondition").val(task.completionCondition);
	
	if(task.formKey!=null&&task.formKey!=""){
			
			$.ajax({
				url:"form/getFormNameById.do?id="+task.formKey,
				type:"post",
				dataType:"json",
				success:function(data){
					
					if(data.name!=""){
						$("#formName").val(data.name);
						$("#formId").val(task.formKey);
					}else{
						Msg.alert('消息','<center>表单不存在！</center>','error');
					}
					
				}
			});
		}
	
	
	
	
	if(task.expression!=null&&task.expression!=""){
		
		if(task.expression.indexOf("\${")!=-1){
			//指派人员，表达式模式	
		
			$('#performerType').val('expression');
			hideAllTask();
			$(".task_expression").show();
			$("#expression_assignee").val(task.expression);
		}else{
			//指派人员，分配用户id
			hideAllTask();
			$(".task_assignee").show();
			$('#performerType').val('assignee');
			
			$("#assigneeId").val(task.expression);
			$.ajax({
				url:"user/getTrueNamesById.do?ids="+task.expression,
				type:"post",
				dataType:"json",
				success:function(data){
					
					if(data.names!=""){
						$(".task_assignee").show();
						$(".task_candidate").hide();
						$("#assigneeName").val(data.names);
					}else{
						Msg.alert('消息','<center >任务执行人不存在！</center>','error');
					}
					
				}
			});
		}
		
	}else{
		//候选人	,表达式模式
		if(task.users!=null&&task.users.indexOf("\${")!=-1){
			$('#performerType').val('expression');
			hideAllTask();
			$(".task_expression").show();
			$("#expression_user").val(task.users);
			
		}else if(task.users!=null&&task.users!=""){
			//候选人，分配id模式	
				$("#userIds").val(task.users);
				$.ajax({
					url:"user/getTrueNamesById.do?ids="+task.users,
					type:"post",
					dataType:"json",
					success:function(data){
						
						if(data.names!=""){
							$("#userNames").val(data.names);
						}else{
							Msg.alert('消息','<center >任务候选人不存在！</center>','error');
						}
						
					}
				});
		}
		//候选角色
		if(task.groups!=null&&task.groups.indexOf("\${")!=-1){
			//表达式模式
			$('#performerType').val('expression');
			hideAllTask();
			$(".task_expression").show();
			$("#expression_group").val(task.groups);
			
		}else if(task.groups!=null&&task.groups!=""){
			//分配角色id模式
			$("#roleIds").val(task.groups);
			$.ajax({
				url:"role/getRoleNamesById.do?ids="+task.groups,
				type:"post",
				dataType:"json",
				success:function(data){
					
					if(data.names!=""){
						$("#roleNames").val(data.names);
					}else{
						Msg.alert('消息','<center >任务候选角色不存在！</center>','error');
					}
					
				}
			});
				
			
		}
		
	}
	
	
	//更改任务分配模式，直接分配执行人或分配待选人，组
	
	
	$('#performerType').change(function(){
		
		var newValue=$(this).val();
		if(newValue=="candidate"){
			hideAllTask();
			$(".task_candidate").show();
		}
		else if(newValue=="assignee"){
			hideAllTask();
			$(".task_assignee").show();
		}else{
			hideAllTask();
			$(".task_expression").show();
		}
		
		
	});	
});	

	//隐藏所有输入框
	function hideAllTask(){
		$(".task_candidate").hide();
		$(".task_assignee").hide();
		$(".task_expression").hide();
	}

	//保存
	function saveTaskProperties() {
		
		//基本属性
		task.taskName = $("#taskName").val().trim();
		task.documentation = $("#taskDesc").val().trim();
		
		task.formKey = $("#formId").val().trim();
		task.setContent($("#taskName").val().trim());
		task.dueDate = $("#dueDate").val().trim();
		task.priority = $("#priority").val().trim();
		
		task.performerType = $('#performerType').val().trim();
		//
		if(task.performerType=="candidate"){
			task.users=$("#userIds").val().trim();
			task.groups=$("#roleIds").val().trim();
			if(task.users=="")task.users=null;
			if(task.groups=="")task.groups=null;
			task.expression=null;
		}else if(task.performerType=="assignee"){
			task.expression = $("#assigneeId").val().trim();
			if(task.expression=="")task.expression==null;
			task.users=null;task.groups=null;
		}else if(task.performerType=="deptHead"){
			//部门经理模式，添加部门经理分配监�?
			var listener = new draw2d.Task.Listener();
			listener.id="deptLd";
			listener.event = "create";
			listener.serviceType="javaClass";
			listener.serviceClass = "com.whfp.oa.manager.workFlow.listener.AssigneeDeptHeadListener";
			//task.listeners.removeAllElements();//清空任务全部监听�?
			
			var ls=task.getListener("deptLd");
			if(!ls){
				//如果没有此监听器则添�?
				task.listeners.add(listener);
			}
		}
		
		else{
			task.expression =$("#expression_assignee").val().trim();//指派人员表达式
			var euser=$("#expression_user").val().trim();//待选人员表达式
			var egroup=$("#expression_group").val().trim();//待选角色表达式
			
			if(task.expression!=null&&task.expression!=""){
				task.users=null;
				task.groups=null;
				$("#expression_user").val("");
				$("#expression_group").val("");
			}else{
				if(euser!="")task.users=euser;
				if(egroup!="")task.groups=egroup;
				task.expression=null;
			}
	
			
		}
		
		//多实例
		task.isSequential =$("#isSequential").val().trim();
		if(task.isSequential!=""){
			task.loopCardinality =$("#loopCardinality").val().trim();
			task.collection =$("#collection").val().trim();
			task.elementVariable =$("#elementVariable").val().trim();
			task.completionCondition =$("#completionCondition").val().trim();
		}else{
			task.isSequential=null;
		}
	}
	

//-->
</script>


<%--任务监听器 --%>
<script type="text/javascript">
<!--
	
	//根据监听器id，查询数据库监听器信息
	$('#oldTaskListenerDatagrid').datagrid({
			url : 'flowListener/getByIds.do',
			queryParams: {
				ids: getOldTaskListenerIds
			},
			toolbar : 
				[{
		    		text:'添加',
		               iconCls:'icon-add',
		               handler:function(){
		            	
		            	   $lookupWindow.window({  
								title:"任务监听器查询",
								width:850,  
							    height:450,  
							    modal:true,
							    minimizable:false
							 
							}).window("refresh", "flowListener/lookUpPage.do?type=2&rel=lookup_flowListener");  
		            	  
		            	  
		              }
		            },'-',{
		                text:'删除',
		               iconCls:'icon-remove',
		              handler:function(){
		            	  
		            	  var rows=$('#oldTaskListenerDatagrid').datagrid('getSelections');
		            	  for(var i=0;i<rows.length;i++){
		            		  var row=rows[i];
		            		  var index=$('#oldTaskListenerDatagrid').datagrid('getRowIndex',row);
			            	  $('#oldTaskListenerDatagrid').datagrid('deleteRow',index);
			            	  
			            	  task.deleteTaskListener(row.id);
		            	  }
		            	  
		            	  
		              }
		            }],
			title : '添加，删除操作会自动保存',
			fitColumns : false,
			nowrap : true,
			border : false,
			rownumbers:false,
			pagination:false,
			frozenColumns : [ [ {
				field : 'name',
				title : '名称',
				width:100,
				formatter : function(value, rec, index) {
					return "<span title='"+rec.desc+"'>"+rec.name+"</span>";
				}
				
			} ] ],
			columns : [ [ 
			{
				field : 'event',
				title : '事件',
				align:'center',
				width:60
			},
			{
				field : 'valueType',
				title : '执行类型',
				width:80,
				align:'center',
				formatter : function(value, rec, index) {
					
					if(rec.valueType==1){
						return "Java class";
					}else if(rec.valueType==2){
						return "expression";	
					}
					
					
				}
			},
			{
				field : 'value',
				title : '执行内容',
				width:'auto'
				
				
			}
		] ]
		 
	});
	//获取任务执行器 id
	function getOldTaskListenerIds(){
		var taskListeners=task.taskListeners;
		var taskListenersIds=new Array();
		for(var i=0;i<taskListeners.getSize();i++){
			var listener = taskListeners.get(i);
			taskListenersIds.push(listener.getId());
		}
		return taskListenersIds.join(",");
	}

	//添加任务监听器
	function addTaskListener(row){
		
		var ls=task.getTaskListener(row.id);
		if(!ls){
			var listener = new draw2d.UserTask.TaskListener();
			listener.id=row.id;
			listener.event = row.event;
			if(row.valueType==1){
				listener.serviceType="javaClass";
				listener.serviceClass = row.value;
			}else{
				listener.serviceType="expression";
				listener.serviceExpression = row.value;
			}
			
			task.addTaskListener(listener);
		}
	}



//-->
</script>











