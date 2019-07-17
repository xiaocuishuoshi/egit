<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>  
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String ids[]=null;
if(request.getAttribute("ids")!=null){
  ids=(String[])request.getAttribute("ids");
   
  }
%> 
<script> 
     function cx(){
     	  var kssj=kssj.value;
     	  var jssj=jssj.value;
     	  bd.src="<%=path%>/baidu/gj.jsp?id=${requestScope.jd.id }&kssj="+kssj+"&jssj="+jssj+"&area=${requestScope.area }&datagridId=${param.rel }_datagrid&time=<%=System.currentTimeMillis()%>";
     }
</script>

<iframe id="bd" style="width:100%;height:90%" src="<%=path%>/baidu/ydgj.jsp?id=${requestScope.jd.id }&area=${requestScope.area }&datagridId=${param.rel }_datagrid&time=<%=System.currentTimeMillis()%>"></iframe>
<form name="form" method="post">
<%
String idstr=""; 
for(int i=0;ids!=null&&i<ids.length;i++){
   idstr+="&ids="+ids[i];
%>
<input type="hidden" id="ids" name="ids" value="<%=ids[i]%>">

<%} 
if(request.getAttribute("a")==null){
%>
开始时间 <input type="text" id="kssj"  name="kssj" value="${requestScope.kssj}" readonly="readonly" class="easyui-validatebox"
						required="true" onFocus="WdatePicker()">
结束时间<input  type="text" id="jssj" name="jssj" readonly="readonly" class="easyui-validatebox"
						required="true" onFocus="WdatePicker()">
<select name="cx">
	<option value="0" selected="selected">全部</option>
	<option value="1">查询人员最后一次出现的位置</option>
</select><%-- 
 <input type="button" name="query" value="查询" onClick="form.action='<%=path%>/dwgl/running.do';form.submit();"> --%>
 <input type="button" name="query" value="查询" onClick="var bd=document.getElementById('bd');bd.src='<%=path%>/dwgl/running.do?a=1<%=idstr%>&kssj='+document.getElementById('kssj').value+'&jssj='+document.getElementById('jssj').value;">
 <%} %>
</form>