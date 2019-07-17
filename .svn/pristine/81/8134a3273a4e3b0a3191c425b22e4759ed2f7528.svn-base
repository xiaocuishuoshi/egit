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
				<th style="width:80px">标题：</th>
				<td  colspan="3">
					<c:out value='${qq.cjtitle }'/>
				</td>
			
			</tr>
			<tr>
				<th>发布范围 (人员):</th>
					<td>
						<a href="user/lookUpPage.do?type=2" lookupGroup="user" title="用户查询">
							<textarea  readonly="readonly"  toName="user.trueName"  rows="2" style="width: 400px"><my:outTrueName id="${requestScope.qq.fbry }"  /></textarea>
						</a>
						<input type="hidden"  name="fbry" toName="user.id" />
						<a class="easyui-linkbutton clearLookup"  icon="icon-cancel"	plain="true"  href="javascript:;"  clearLookup="user"  title="清空"></a>
					</td>
			</tr>
			<tr>
				<th >描述：</th>
				<td colspan="3">
					<c:out value='${qq.ms }'/>
				</td>
			</tr>
			
			<tr>
				<th>是否生效：</th>
				<td colspan="3">
					<c:out value='${qq.sfsx }'/>
				</td>
			</tr>
			<tr>
			<table   class="table table-bordered ">
				<tr>
					<th style="text-align: center;">等级</th>
					<th style="text-align: center;">规定人数</th>
					<th style="text-align: center;">规定奖品</th>
				</tr>
				<tr>
					<th style="text-align: center;">一等奖：</th>
					<td >
						<c:out value='${qq.ydjrs }'/>
					</td>
					<td >
						<c:out value='${qq.ydjjp }'/>
					</td>
				</tr>
				<tr>
					<th style="text-align: center;">二等奖：</th>
					<td >
						<c:out value='${qq.edjrs }'/>
					</td>
					<td >
						<c:out value='${qq.edjjp }'/>
					</td>
				</tr>
				<tr>
					<th style="text-align: center;">三等奖：</th>
					<td >
						<c:out value='${qq.sdjrs }'/>
					</td>
					<td >
						<c:out value='${qq.sdjjp }'/>
					</td>
				</tr>
				<tr>
					<th style="text-align: center;">其他奖：</th>
					<td >
						<c:out value='${qq.qtjrs }'/>
					</td>
					<td >
						<c:out value='${qq.qtjjp }'/>
					</td>
				</tr>
			
			</table>
		</tr>			
	</table>
</form>
</div>
										
						
					
		

	

