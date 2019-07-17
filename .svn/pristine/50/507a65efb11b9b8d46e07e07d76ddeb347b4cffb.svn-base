<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp" %>
<%--
	模块：协同办公--日志管理--详情
--%>

<div class="div_titlebold"><c:out value="${requestScope.j.journalTitle}" /></div>
<div class="div_sendUser"><my:outSelectValue id="${j.journalType }"/> &nbsp;&nbsp;<fmt:formatDate value="${requestScope.j.journalTime }" pattern="yyyy-MM-dd HH:mm:ss" />	</div>	
<div class="divider"></div>
	
	
	<table>
<tr>
							<th>附件：</th>
							<td>
								<c:forEach  var="f"  items="${requestScope.files }" >
						
									<c:url var="url_download" value="workPlan/download.do" >
										<c:param name="name" value="${f.name }" />
										<c:param name="uuid" value="${f.uuid}" />
										<c:param name="ext" value="${f.ext}" />
									</c:url>
									<a href="${url_download }" target="_blank">
											<img src="resource/images/icons/${f.ext }.gif" 
											onerror="javascript:this.src='resource/images/icons/page.gif'" align="top" />&nbsp;<c:out value="${f.name }"/></a>
											 (<my:fileSizeFormat value="${f.size }"/>)&nbsp;&nbsp;&nbsp;&nbsp;
											
									
									
								</c:forEach>
								
									
							</td>
							
						</tr>
						</table>
	
<div style="margin:10px;" >
	<my:scriptEscape value="${requestScope.j.journalContent}"/>
</div>

					
				


	
										
						
	