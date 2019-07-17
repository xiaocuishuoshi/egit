<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%--
	模块：系统管理--用户管理  用户更新
--%>
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
<div style="width: 96%;margin: 0 auto ;" >	
				
<form method="post" action="jbxx/update.do" enctype="multipart/form-data"  onsubmit="return validateSubmitForm(this)">
<input type="hidden" name="jdHdqy" class="easyui-validatebox"
					 	value="${requestScope.jd.jdHdqy}"/>
<input type="hidden" name="dqwz" class="easyui-validatebox"
					 value="${requestScope.jd.dqwz}"/>
<input type="hidden" name="dqwzsj" class="easyui-validatebox"
					 value="${requestScope.jd.dqwzsj}"/>
<input type="hidden" name="jdXxly" class="easyui-validatebox"
					 value="${requestScope.jd.jdXxly}"/>
<input type="hidden" name="jdSfyj" class="easyui-validatebox"
					 value="${requestScope.jd.jdSfyj}"/>
					 
<input type="hidden"  name="jdCjsj"
					value="<fmt:formatDate value="${requestScope.jd.jdCjsj}" pattern="yyyy-MM-dd" />"
					class="easyui-validatebox"
					onfocus="WdatePicker({dateFmt:'yyyy-MM-dd '})"
					 style="width: 150PX" />					 
					 
<input type="hidden" name="jdScbz" class="easyui-validatebox"
					 value="${requestScope.jd.jdScbz}"/>
<input type="hidden" name="jdSjid" class="easyui-validatebox"
					 value="${requestScope.jd.jdSjid}"/>
<input type="hidden" name=jdRylb class="easyui-validatebox"
					 value="${requestScope.jd.jdRylb}"/>	
<input type="hidden" name=jdJb class="easyui-validatebox"
					 value="${requestScope.jd.jdJb}"/>					 				 
					 
		<table class="table table-bordered">				
	
			<h3 style="text-align:center;">基本信息</h3>
		<hr/>
			戒毒(康复)人员编号
		<input type="text" name="jdRybh" class="easyui-validatebox"
		value="${requestScope.jd.jdRybh}"	 />
				<td >
					姓名
				</td>
				<td>
					<input type="text" name="jdRyxm" class="easyui-validatebox"
					required="true" 	value="${requestScope.jd.jdRyxm}"/>
				</td>
				<td>
					绰号/别名
				</td>
				<td>
					<input type="text" name="jdCym" class="easyui-validatebox"
					value="${requestScope.jd.jdCym}"	/>
				</td>
				<td>
					性别
				</td>
				<td>
					<select name="jdRyxb" sValue="${requestScope.jd.jdRyxb }">
						
						<option value="男">
							男
						</option>
						<option value="女">
							女
						</option>
						<option value="">无</option>
					</select>
				</td>
				<td rowspan="4" id="tp">
					<div><img id="upview" src="<%= path %>/${requestScope.jd.jdRyxp}" style="float:left; width:130px; height:150px;"></div>
				<div><input id="upload" type="file" name="jdRyxpFile"
					class="easyui-validatebox" style="float:left;width: 130px;'"></div>
				</td>
			</tr>

			<tr>
				<td>
					民族
				</td>
				<td>
					<input type="text" name="jdMz" class="easyui-validatebox"
					value="${requestScope.jd.jdMz}"	 />
				</td>
				<td>
					出生日期
				</td>
				<td>
					<input type="text" readonly="readonly" class="easyui-validatebox"
					value="${requestScope.jd.jdCsrq}"	onFocus="WdatePicker()" name="jdCsrq" />
				</td>
				<td>
					身高(CM)
				</td>
				<td>
					<input type="text" name="jdRysg" class="easyui-validatebox"
					value="${requestScope.jd.jdRysg}"	 />
				</td>
			</tr>
			<tr>
				<td>
					部门:
				</td>
					<td>
					<a  href="dept/lookUpPage.do?type=1"  lookupGroup="dept" title="部门查询">
					<input type="text" readonly="readonly"  toName="dept.deptName"   value='<my:outDeptName id="${requestScope.jd.fkDeptId }"/>'  class="easyui-validatebox" required="true"/>
					</a>
					<input type="hidden" name="fkDeptId" toName="dept.id" value="${requestScope.jd.fkDeptId }"/>
					</td>
				<td>
					证件种类
				</td>
				<td>
					<input type="text" name="jdZjzl" class="easyui-validatebox"
					value="${requestScope.jd.jdZjzl}" 	/>
				</td>
				<td>
					证件号码
				</td>
				<td>
					<input type="text" name="jdSfzh" class="easyui-validatebox"
						value="${requestScope.jd.jdSfzh}" />
				</td>
			</tr>
			<tr>
				<td>
					婚姻状况
				</td>
				<td>
					<select name="jdHyzk" sValue="${requestScope.jd.jdHyzk}">
						<option value="已婚">
							已婚
						</option>
						<option value="未婚">
							未婚
						</option>
						<option value="离婚">
							离婚
						</option>
						<option value="丧偶">
							丧偶
						</option>
					</select>
				</td>
				<td>
					文化程度
				</td>
				<td>
					<select name="jdWhcd" sValue="${requestScope.jd.jdWhcd}">
						<option value="硕士及以上">
							硕士及以上
						</option>
						<option value="本科">
							本科
						</option>
						<option value="大专">
							大专
						</option>
						<option value="中专">
							中专
						</option>
						<option value="高中">
							高中
						</option>
						<option value="初中">
							初中
						</option>
						<option value="小学">
							小学
						</option>
						<option value="文盲">
							文盲
						</option>
					</select>
				</td>
				<td>
						职业
					</td>
					<td>
						<input type="text" name="jdZy" class="easyui-validatebox"
						Value="${requestScope.jd.jdZy}"/>
				</td>
			</tr>

			
			<tr>
				<td>户籍地</td>
				<td>
						<input type="text" name="jdHjd" class="easyui-validatebox"
						Value="${requestScope.jd.jdHjd}"	 />
				</td>
				
				<td>户籍地详址</td>
				<td>
						<input type="text" name="jdHjxxdz" class="easyui-validatebox"
							Value="${requestScope.jd.jdHjxxdz}"/>
				</td>
				
				<td>户籍地派出所</td>
				<td>
						<input type="text" name="jdHjdpcs" class="easyui-validatebox"
							Value="${requestScope.jd.jdHjdpcs}" />
				</td>
			</tr>
			<tr>
				<td>居住地</td>
				<td>
						<input type="text" name="jdJzd" class="easyui-validatebox"
							Value="${requestScope.jd.jdJzd}"  />
				</td>
			<td>居住地详址</td>
				<td>
						<input type="text" name="jdJzdz" class="easyui-validatebox"
							Value="${requestScope.jd.jdJzdz}" />
				</td>
				<td>居住地派出所</td>
				<td>
						<input type="text" name="jdJzdpcs" class="easyui-validatebox"
							Value="${requestScope.jd.jdJzdpcs}"/>
				</td>
				
				
			</tr>
			
			
			<tr>
				<td>
					监管人员
				</td>
				
				<td><input type="text" name="jdJgry" class="easyui-validatebox"
						Value="${requestScope.jd.jdJgry}"	/>
				</td>
			
			<td>
					定位电话
				</td>
				<td>
					<input type="text" name="jdDwdh" class="easyui-validatebox"
						Value="${requestScope.jd.jdDwdh}" />
				</td>
			
			<td>
					籍贯
				</td>
				<td>
					<input type="text" name="jdRyjg" class="easyui-validatebox"
						Value="${requestScope.jd.jdRyjg}" />
				</td>
				
			</tr>
			
			<tr>
				<td>
					联系方式
				</td>
				<td>
					<input type="text" name="jdLxfs" class="easyui-validatebox"
						Value="${requestScope.jd.jdLxfs}"/>
				</td>
				<td>
					政治面貌
				</td>
				<td>
					<input type="text" name="jdZzmm" class="easyui-validatebox"
						Value="${requestScope.jd.jdZzmm}" />
				</td>
				
				
				<td>
					宗教信仰
				</td>
				<td>
					<input type="text" name="jdZjxy" class="easyui-validatebox"
						Value="${requestScope.jd.jdZjxy}"  />
				</td>
		<tr>
			<td>
					脱失次数
				</td>
				<td>
					<input type="text" name="jdTscs" class="easyui-validatebox"
						Value="${requestScope.jd.jdTscs}"  />
				</td>
				
				<td>
					滥用毒品种类
				</td>
				<td>
					<input type="text" name="jdLydpzl" class="easyui-validatebox"
						Value="${requestScope.jd.jdLydpzl}"  />
				</td>
				<td>
					查获单位
				</td>
				<td>
					<input type="text" name="jdChdw" class="easyui-validatebox"
						Value="${requestScope.jd.jdChdw}" />
				</td>
				
				
		</tr>
		<tr>
			<td>
					查获日期
				</td>
				<td>
					<input type="text" readonly="readonly" class="easyui-validatebox"
					Value="${requestScope.jd.jdChrq}"	onFocus="WdatePicker()" name="jdChrq" />
				</td>
			<td>
					当前管控状况
				</td>
				<td>
					<input type="text" name="jdDqgkxz" class="easyui-validatebox"
					Value="${requestScope.jd.jdDqgkxz}"	/>
				</td>
				
				<td>
					当前管控地区
				</td>
				<td>
					<input type="text" name="jdDqgkdq" class="easyui-validatebox"
							Value="${requestScope.jd.jdDqgkdq}"	 />
				</td>
			</tr>
		
		<tr>
			<td>
					网格化序号
				</td>
				<td>
					<input type="text" name="jdWghxh" class="easyui-numberbox"
							Value="${requestScope.jd.jdWghxh }"	 />
				</td>
				<td>
					网格员
				</td>
				<td>
					<input type="text" name="jdWgy" class="easyui-validatebox"
							Value="${requestScope.jd.jdWgy}"	 />
				</td>
				
				<td>
					网格所属社区
				</td>
				<td>
				 	<input type="text" name="jdWgsssq" toName="dis.name" style="width:80%" readonly maxlength="30" class="easyui-validatebox" required="true" Value="${requestScope.jd.jdWgsssq}" />
					<a href="district/lookUpPage.do?type=1&superId=402881ec3f74d2d5013f74dc383e16d8" lookupGroup="dis" title="用户查询"><img src="resource/images/menu/24507_s.gif"  style="margin-top:-3px;"/></a>
				
				</td>
		</tr>
		
			
		</table>
			<center>
						  <button type="submit" class="btn btn-primary" >保存</button>&nbsp;&nbsp;&nbsp;&nbsp;
						  <button type="button" class="btn clear" >清空</button>
				</center>
				
		<input type="hidden"  name="id" value="${requestScope.jd.id }"/>
		<input type="hidden"  name="jdRyid" value="${requestScope.jd.jdRyid }"/>
	    <input type="hidden" name="datagridId" value="${param.rel }_datagrid" />	
	    <input type="hidden" name="currentCallback" value="close" />
		  <input type="hidden" name="jdRyxp" value="${requestScope.jd.jdRyxp}" />
		  
	
</form>
</div>	

<script>
function getObjectURL(file) {
 var url = null ;
 if (window.createObjectURL!=undefined) { // basic
  url = window.createObjectURL(file) ;
 } else if (window.URL!=undefined) { // mozilla(firefox)
  url = window.URL.createObjectURL(file) ;
 } else if (window.webkitURL!=undefined) { // webkit or chrome
  url = window.webkitURL.createObjectURL(file) ;
 }
 return url ;
}
 
$('#upload').change(function() {

	 eImg = $('#upview');
	 var src=getObjectURL($(this)[0].files[0]);
	 eImg.attr('src', src); // 或 this.files[0] this->input
});
</script>