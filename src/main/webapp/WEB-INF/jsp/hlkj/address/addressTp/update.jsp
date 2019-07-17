<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.whfp.oa.commons.util.ServletUtil"%>
<%@page import="com.whfp.oa.commons.model.Member"%>
<%@page import="com.whfp.oa.manager.hlkj.dict.bean.HlkjDict"%>
<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp" %>
<%--
	模块：企业宣传--公告管理 --系统公告添加
--%>
 
<script type="text/javascript">
<!--

	function changepic(path){
		var pa = path.toString().indexOf("-");
		var pathImg = path.toString().substring(pa+1);
		document.getElementById("showpic").src="/oa/"+pathImg;
	}

	
//-->
</script>
 
<div style="width: 98%;margin: 0 auto ;"  align="center">
			
<form method="post" action="hlkj/address/updatetp.do"  onsubmit="return validateSubmitForm(this)">
	<table class="table table-bordered ">
	<input type="hidden" name="id" value="${qq.id}"/>
	<input type="hidden" name="tpAddressId" value="${qq.tpAddressId}"/>
	<input type="hidden" name="tpAddress" value="${qq.tpAddress}"/>
	<input type="hidden" name="tpCreatetime" value="${qq.tpCreatetime}"/>
	<input type="hidden" name="tpBackId" value="${qq.tpBackId}"/>
			<tr>
				<th>拓扑图名称：</th>
				<td  colspan="3">
				<input type="text" name="tpName" value="${qq.tpName}" class="easyui-validatebox" required="true" />
				</td>
			</tr>
			<tr>
				<th style="width:80px">背景图：</th>
				<td  colspan="3">
					<select id="pathii" name="tpBack" value="${qq.tpBack}" onchange="changepic(this.value)" value="">
							<c:forEach  var="v"  items="${listimg}" varStatus="status">
         				 			<option value="${v.id}*${v.name}-${v.savePath}">${v.name}</option >
      						</c:forEach>
					</select>
				</td>
			
			</tr>
			<tr>
				<td colspan="4">
					<img id="showpic" src="/oa/${savepath }">					
				</td>
			</tr>
			
			<tr>
				<th>是否置顶：</th>
				<td colspan="3">
					<select name="tpSfzd" value="${qq.tpSfzd}">
						<option value="置顶">置顶</option>
						<option value="不置顶">不置顶</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>虚拟号：</th>
				<td colspan="3">
					<input type="text" name="tpXnh" value="${qq.tpXnh}" class="easyui-validatebox"  required="false" />
				</td>
			</tr>
			
			
			<tr>
				<th></th>
				<td colspan="3">
					<div  style="margin-top: 10px;margin-bottom: 10px;">
						  <button type="submit" class="btn btn-primary" >保存</button>&nbsp;&nbsp;&nbsp;&nbsp;
						  <button type="button" class="btn clear" >清空</button>
					</div>
				</td>
			 </tr>
	</table>
</form>
</div>
										
						
					
		

	

