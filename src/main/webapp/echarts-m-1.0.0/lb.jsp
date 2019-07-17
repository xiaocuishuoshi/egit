<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%

List<Object[]> list=null;
if(session.getAttribute("map")!=null)
	list=(List)session.getAttribute("map");

 %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<style type="text/css">
		body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
	</style>

 	<title></title>
</head>
<body>
<br>
	 <table border="1px" style="border-spacing: 0px;font-size:25px;">
	 <tr><td>区域</td><td>人口总数</td><td>吸毒人数</td><td>吸毒比例</td></tr>
	 <%   for(int i=0;list!=null&&i<list.size();i++){
    Object[] obj=list.get(i);
    String v=obj[5].toString();
    v=Double.parseDouble(v)*100+""; 
    if(v.length()>4)
    v=v.substring(0,5); 
   
    	out.println("<tr><td>"+obj[0]+"</td><td>"+obj[1]+"</td><td>"+obj[4]+"</td><td>"+v+"%</td></tr>");
    } %>
	 </table>
</body>
</html>
 