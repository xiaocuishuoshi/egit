<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>
<%--
	模块：人员管理--基本信息管理 -- 新增用户
--%>
<%
request.setAttribute("ctx",request.getContextPath());
 %>
<style>

input {
	width: 150px;
}

td {
	white-space: nowrap;
}
</style>
<div style="width: 96%;margin: 0 auto ;" >

	<form action="jbxx/addUser.do"
		onsubmit="return validateSubmitForm(this)"
		enctype="multipart/form-data" method="post">
		<h3 style="text-align:center;">基本信息</h3>
			<hr />
			戒毒(康复)人员编号
			<input type="text" name="jdRybh" class="easyui-validatebox"  required="true" />
		<table class="table table-bordered " border=1>
			
			<tr>
			<td>
				姓名
			</td>
			<td>
				<input type="text" name="jdRyxm" class="easyui-validatebox"
					required="true" />
			</td>
			<td>
				绰号/别名
			</td>
			<td>
				<input type="text" name="jdCym" class="easyui-validatebox"
					required="true" />
			</td>
			<td>
				性别
			</td>
			<td>
				<select name="jdRyxb">
					<option value="">
						无
					</option>
					<option value="男 ">
						男
					</option>
					<option value="女">
						女
					</option>
				</select>
			</td>
			<td rowspan="6" id="tp">
			<div><img id="upview" src="${ctx }${filePath}" style="float:left; width:130px; height:150px;"></div>
				<div><input id="upload" type="file" name="jdRyxpFile"
					class="easyui-validatebox" style="float:left;width:130px;"></div>
				
			</td>
			</tr>

			<tr>
				<td>
					民族
				</td>
				<td>
					<input type="text" name="jdMz" class="easyui-validatebox"
						required="true" />
				</td>
				<td>
					出生日期
				</td>
				<td>
					<input type="text" readonly="readonly" class="easyui-validatebox"
						required="true" onFocus="WdatePicker()" name="jdCsrq" />
				</td>
				<td>
					身高(CM)
				</td>
				<td>
					<input type="text" name="jdRysg" class="easyui-validatebox"
						required="true" />
				</td>
			</tr>
			<tr>
				<td>
					单位:
				</td>
				<td>
					<a href="dept/lookUpPage.do?type=1" lookupGroup="dept" title="部门查询">
						<input type="text" readonly="readonly" toName="dept.deptName"
							value='<my:outDeptName id="${requestScope.jd.fkDeptId }"/>'
							class="easyui-validatebox" required="true" /> </a>
					<input type="hidden" name="fkDeptId" toName="dept.id" />
				</td>
				<td>
					证件种类
				</td>
				<td>
					<input type="text" name="jdZjzl" class="easyui-validatebox"
						required="true" />
				</td>
				<td>
					证件号码
				</td>
				<td>
					<input type="text" name="jdSfzh" class="easyui-validatebox"
						required="true" />
				</td>
			</tr>
			<tr>
				<td>
					婚姻状况
				</td>
				<td>
					<select name="jdHyzk">
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
					<select name="jdWhcd">
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
						required="true" />
				</td>
			</tr>


			<tr>
				<td>
					户籍地
				</td>
				<td>
					<input type="text" name="jdHjd" class="easyui-validatebox"
						required="true" />
				</td>

				<td>
					户籍地详址
				</td>
				<td>
					<input type="text" name="jdHjxxdz" class="easyui-validatebox"
						required="true" />
				</td>

				<td>
					户籍地派出所
				</td>
				<td>
					<input type="text" name="jdHjdpcs" class="easyui-validatebox"
						required="true" />
				</td>
			</tr>
			<tr>
				<td>
					居住地
				</td>
				<td>
					<input type="text" name="jdJzd" class="easyui-validatebox"
						required="true" />
				</td>
				<td>
					居住地详址
				</td>
				<td>
					<input type="text" name="jdJzdz" class="easyui-validatebox"
						required="true" />
				</td>
				<td>
					居住地派出所
				</td>
				<td>
					<input type="text" name="jdJzdpcs" class="easyui-validatebox"
						required="true" />
				</td>


			</tr>


			<tr>
				<td>
					监管人员
				</td>

				<td>
					<input type="text" name="jdJgry" class="easyui-validatebox"
						required="true" />
				</td>

				<td>
					定位电话
				</td>
				<td>
					<input type="text" name="jdDwdh" class="easyui-validatebox"
						required="true" />
				</td>

				<td>
					籍贯
				</td>
				<td>
					<input type="text" name="jdRyjg" class="easyui-validatebox"
						required="true" />
				</td>

			</tr>

			<tr>
				<td>
					联系方式
				</td>
				<td>
					<input type="text" name="jdLxfs" class="easyui-validatebox"
						required="true" />
				</td>
				<td>
					政治面貌
				</td>
				<td>
					<input type="text" name="jdZzmm" class="easyui-validatebox"
						required="true" />
				</td>


				<td>
					宗教信仰
				</td>
				<td>
					<input type="text" name="jdZjxy" class="easyui-validatebox"
						required="true" />
				</td>
				<tr>
					<td>
						脱失次数
					</td>
					<td>
						<input type="text" name="jdTscs" class="easyui-validatebox"
							required="true" />
					</td>

					<td>
						滥用毒品种类
					</td>
					<td>
						<input type="text" name="jdLydpzl" class="easyui-validatebox"
							required="true" />
					</td>
					<td>
						查获单位
					</td>
					<td>
						<input type="text" name="jdChdw" class="easyui-validatebox"
							required="true" />
					</td>


				</tr>
				<tr>
					<td>
						查获日期
					</td>
					<td>
						<input type="text" readonly="readonly" class="easyui-validatebox"
							required="true" onFocus="WdatePicker()" name="jdChrq" />
					</td>
					<td>
						当前管控状况
					</td>
					<td>
						<input type="text" name="jdDqgkxz" class="easyui-validatebox"
							required="true" />
					</td>

					<td>
						当前管控地区
					</td>
					<td>
						<input type="text" name="jdDqgkdq" class="easyui-validatebox"
							required="true" />
					</td>
				</tr>
				<tr>
				<td>
					网格所属社区
				</td>
				<td>
					<input type="text" name="area" toName="dis.name" style="width:80%" readonly maxlength="30" class="easyui-validatebox" required="true" />
					<a href="district/lookUpPage.do?type=1&superId=402881ec3f74d2d5013f74dc383e16d8" lookupGroup="dis" title="用户查询"><img src="resource/images/menu/24507_s.gif"  style="margin-top:-3px;"/></a>
				
					<!-- <select name="jdWgsssq" style="width: 120px;">
						<option value="京广社区">京广社区</option>
						<option value="凉亭社区">凉亭社区</option>
						<option value="孝感乡社区">孝感乡社区</option>
						<option value="小河头社区">小河头社区</option>
						<option value="朝圣门社区">朝圣门社区</option>
						<option value="杜鹃社区">杜鹃社区</option>
						<option value="杨基塘社区">杨基塘社区</option>
						<option value="枫树村">枫树村</option>
						<option value="桃园社区">桃园社区</option>
						<option value="鼓楼社区">鼓楼社区</option>
						
						<option value="园林社区">园林社区</option>
						<option value="城西社区">城西社区</option>
						<option value="西畈社区">西畈社区</option>
						<option value="龙池桥社区">龙池桥社区</option>
						<option value="松鹤社区">松鹤社区</option>
						<option value="宋家河社区">宋家河社区</option>
						<option value="黄狮岗社区">黄狮岗社区</option>
						<option value="七里桥村">七里桥村</option>
						<option value="红石堰村">红石堰村</option>
						<option value="白塔河社区">白塔河社区</option>
						
						<option value="兴发村">兴发村</option>
						<option value="陡坡山">陡坡山</option>
						<option value="鼎长岗">鼎长岗</option>
						<option value="红叶村">红叶村</option>
						<option value="谌家园村">谌家园村</option>
						<option value="黄金桥">黄金桥</option>
					</select> -->
				</td>
				<td>
					网格化序号
				</td>
				<td>
					<input type="text" name="jdWghxh" toName="dis.disSort" class="easyui-numberbox"
						required="true" />
				</td>
				<td>
					网格员
				</td>
				<td>
					<input type="text" name="jdWgy" class="easyui-validatebox"
						required="true" />
				</td>
				
				
				</tr>
		</table>

		<center>
			<button type="submit" class="btn btn-primary">
				保存
			</button>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="button" class="btn clear">
				清空
			</button>
		</center>

		<input type="hidden" name="datagridId" value="${param.rel }_datagrid" />
		<input type="hidden" name="currentCallback" value="close" />
		<input type="hidden" id="modulus" value="${requestScope.modulus }" />
		<input type="hidden" id="exponent" value="${requestScope.exponent }" />

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