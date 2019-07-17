<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.whfp.oa.commons.util.ServletUtil"%>
<%@page import="com.whfp.oa.commons.model.Member"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp" %>
<%--
	模块：企业宣传--公告管理 --系统公告添加
--%>
 

 
<div style="width: 98%;margin: 0 auto ;" >
			
<form method="post" action="qyxc/save.do"  onsubmit="return validateSubmitForm(this)">
	<table class="table table-bordered ">
				<tr>
				<th style="width: 80px">新闻标题：</th>
				<td>
					<c:out value='${qq.title }'/>
				</td>
			<th>
				发件时间：
			</th>
			<td>
				<fmt:formatDate  value="${qq.fbsj}"
					pattern="yyyy-MM-dd HH:mm:ss" />
			</td>
			</tr>
			<tr>
				<th>新闻摘要：</th>
				<td  colspan="3">
				<c:out value='${qq.zy }'/>
				</td>
			</tr>
			<tr>
				<th>新闻作者：</th>
				<td>
					<c:out value='${qq.zz }'/>
				</td>
				<th style="width: 80px">是否生效：</th>
				<td>
				
							<c:out value='${qq.sfgq }'/>
				</td>
			</tr>
			<tr>
				<th>新闻内容：</th>
				<td colspan="3">
					<textarea  name="content" rows="5" class="editor"  style="width: 98%;"><c:out value='${qq.content }'/></textarea>
				</td>
			</tr>
			
	</table>
</form>
</div>
										
						
					
		

	

