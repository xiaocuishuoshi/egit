<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>

<div style="width: 100%; margin: 0 auto;">
	<form method="post" action="jiedu/man/contact/submit.do" 	onsubmit="return validateSubmitForm(this)">
		<input type="hidden" name="userId" value="${man.id}"/>
	
		<table class="table table-bordered ">
			<tr>
				<td style="width:100px;">职务</td>
				<td>姓名</td>
				<td>单位</td>
				<td>联系方式</td>
				<td>职责</td>
			</tr>
			<c:forEach var ="item" items="${list}">
			
				<c:if test="${item.postion eq '主任' }">
				<tr>
				<td style="width:100px;">主任
					<input type="hidden" name="postion" value="主任"/>
					<input type="hidden" name="id" value="${item.id}"/>
				</td>
				<td><input type="text" name="name"  value="${item.name }"/></td>
				<td><input type="text" name="company"   value="${item.company }"/></td>
				<td><input type="text" name="phone"   value="${item.phone }" /></td>
				<td><input type="text" name="duty"   value="${item.duty }"/></td>
				</tr>
			
				</c:if>
				<c:if test="${item.postion eq '(村/社区)责任人' }">
				<tr>
				<td style="width:100px;">(村/社区)责任人
					<input type="hidden" name="postion" value="(村/社区)责任人"/> 
					<input type="hidden" name="id"  value="${item.id}"/>
				</td>
				<td><input type="text" name="name"  value="${item.name }"/></td>
				<td><input type="text" name="company"   value="${item.company }"/></td>
				<td><input type="text" name="phone"   value="${item.phone }" /></td>
				<td><input type="text" name="duty"   value="${item.duty }"/></td>
				</tr>
			
				</c:if>
				<c:if test="${item.postion eq '家庭成员及其监护人（担保人）' }">
				<tr>
				<td style="width:100px;">家庭成员及其监护人（担保人）
					<input type="hidden" name="postion" value="家庭成员及其监护人（担保人）"/>
					<input type="hidden" name="id"  value="${item.id}"/>
				 </td>
				<td><input type="text" name="name"  value="${item.name }"/></td>
				<td><input type="text" name="company"   value="${item.company }"/></td>
				<td><input type="text" name="phone"   value="${item.phone }" /></td>
				<td><input type="text" name="duty"   value="${item.duty }"/></td>
				</tr>
			
				</c:if>
				<c:if test="${item.postion eq '专（兼）职社工' }">
				<tr>
				<td style="width:100px;">专（兼）职社工
					<input type="hidden" name="postion" value="专（兼）职社工"/> 
					<input type="hidden" name="id"  value="${item.id}"/>
				</td>
				<td><input type="text" name="name"  value="${item.name }"/></td>
				<td><input type="text" name="company"   value="${item.company }"/></td>
				<td><input type="text" name="phone"   value="${item.phone }" /></td>
				<td><input type="text" name="duty"   value="${item.duty }"/></td>
				</tr>
				</c:if>
				<c:if test="${item.postion eq '社区网格员' }">
				<tr>
				<td style="width:100px;">社区网格员
					<input type="hidden" name="postion" value="社区网格员"/> 
					<input type="hidden" name="id"  value="${item.id}"/>
				</td>
				<td><input type="text" name="name"  value="${item.name }"/></td>
				<td><input type="text" name="company"   value="${item.company }"/></td>
				<td><input type="text" name="phone"   value="${item.phone }" /></td>
				<td><input type="text" name="duty"   value="${item.duty }"/></td>
				</tr>
				</c:if>
				<c:if test="${item.postion eq '社区民警' }">
				<tr>
				<td style="width:100px;">社区民警
					<input type="hidden" name="postion" value="社区民警"/> 
					<input type="hidden" name="id"  value="${item.id}"/>
				</td>
				<td><input type="text" name="name"  value="${item.name }"/></td>
				<td><input type="text" name="company"   value="${item.company }"/></td>
				<td><input type="text" name="phone"   value="${item.phone }" /></td>
				<td><input type="text" name="duty"   value="${item.duty }"/></td>
				</tr>
				</c:if>
				<c:if test="${item.postion eq '社区医护人员' }">
				<tr>
				<td style="width:100px;">社区医护人员
					<input type="hidden" name="postion" value="社区医护人员"/> 
					<input type="hidden" name="id"  value="${item.id}"/>
				</td>
				<td><input type="text" name="name"  value="${item.name }"/></td>
				<td><input type="text" name="company"   value="${item.company }"/></td>
				<td><input type="text" name="phone"   value="${item.phone }" /></td>
				<td><input type="text" name="duty"   value="${item.duty }"/></td>
				</tr>
				</c:if>
				<c:if test="${item.postion eq '禁毒志愿者' }">
				<tr>
				<td style="width:100px;">禁毒志愿者
					<input type="hidden" name="postion" value="禁毒志愿者"/> 
					<input type="hidden" name="id"  value="${item.id}"/>
				</td>
				<td><input type="text" name="name"  value="${item.name }"/></td>
				<td><input type="text" name="company"   value="${item.company }"/></td>
				<td><input type="text" name="phone"   value="${item.phone }" /></td>
				<td><input type="text" name="duty"   value="${item.duty }"/></td>
				</tr>
				</c:if>
			
			</c:forEach>
			
		
			<c:if test="${fn:length(list)==0 }">
				<tr>
				<td style="width:100px;">主任
					<input type="hidden" name="postion" value="主任"/>
					<input type="hidden" name="id" />
				</td>
				<td><input type="text" name="name" /></td>
				<td><input type="text" name="company"  /></td>
				<td><input type="text" name="phone"  /></td>
				<td><input type="text" name="duty"  /></td>
				</tr>
				<tr>
				<td style="width:100px;">(村/社区)责任人
					<input type="hidden" name="postion" value="(村/社区)责任人"/> 
					<input type="hidden" name="id"  />
				</td>
				<td><input type="text" name="name"  /></td>
				<td><input type="text" name="company" /></td>
				<td><input type="text" name="phone" /></td>
				<td><input type="text" name="duty"  /></td>
				</tr>
		
				<tr>
				<td style="width:100px;">家庭成员及其监护人（担保人）
					<input type="hidden" name="postion" value="家庭成员及其监护人（担保人）"/>
					<input type="hidden" name="id" />
				 </td>
				<td><input type="text" name="name" /></td>
				<td><input type="text" name="company" /></td>
				<td><input type="text" name="phone"   /></td>
				<td><input type="text" name="duty"  /></td>
				</tr>
				<tr>
				<td style="width:100px;">专（兼）职社工
					<input type="hidden" name="postion" value="专（兼）职社工"/> 
					<input type="hidden" name="id"  />
				</td>
				<td><input type="text" name="name"  /></td>
				<td><input type="text" name="company" /></td>
				<td><input type="text" name="phone"  /></td>
				<td><input type="text" name="duty"  /></td>
				</tr>
				
				<tr>
				<td style="width:100px;">社区网格员
					<input type="hidden" name="postion" value="社区网格员"/> 
					<input type="hidden" name="id"  />
				</td>
				<td><input type="text" name="name"  /></td>
				<td><input type="text" name="company"/></td>
				<td><input type="text" name="phone"  /></td>
				<td><input type="text" name="duty"   /></td>
				</tr>
				<tr>
				<td style="width:100px;">社区医护人员
					<input type="hidden" name="postion" value="社区医护人员"/> 
					<input type="hidden" name="id"  />
				</td>
				<td><input type="text" name="name"  /></td>
				<td><input type="text" name="company" /></td>
				<td><input type="text" name="phone"  /></td>
				<td><input type="text" name="duty"   /></td>
				</tr>
				<tr>
				<td style="width:100px;">禁毒志愿者
					<input type="hidden" name="postion" value="禁毒志愿者"/> 
					<input type="hidden" name="id"  />
				</td>
				<td><input type="text" name="name"  /></td>
				<td><input type="text" name="company"  /></td>
				<td><input type="text" name="phone"   /></td>
				<td><input type="text" name="duty"  /></td>
				</tr>
			</c:if>
			
			<tr>
				<td colSpan="5" style="text-align:center">
					<button class="btn btn-primary">保存</button>
				</td>
			</tr>

		</table>
		
		<input type="hidden" name="datagridId" value="${param.rel }_datagrid" />
		<input type="hidden" name="currentCallback" value="close" />
	</form>
</div>