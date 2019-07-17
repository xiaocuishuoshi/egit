<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.whfp.oa.commons.model.Member"%>
<%@include file="/WEB-INF/jsp/commons/jstl_message_tld.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
 	 <script> 
		function hello(){ 
			alert("11");
			var ss = document.getElementById("hb1").src;
			alert(ss);
			if(ss.eval("resource/images/hlkj/hbgydx/001.jpg")){
				alert("1");
				document.getElementById("hb1").src="resource/images/hlkj/hbgydx/1f.jpg";
			}else if(ss.eval("resource/images/hlkj/hbgydx/1f.jpg")){
				alert("2");
				document.getElementById("hb1").src="resource/images/hlkj/hbgydx/4f.jpg";
			}else if(ss.eval("resource/images/hlkj/hbgydx/4f.jpg")){
				alert("3");
				document.getElementById("hb1").src="resource/images/hlkj/hbgydx/5f.jpg";
			}else if(ss.eval("resource/images/hlkj/hbgydx/5f.jpg")){
				alert("4");
				document.getElementById("hb1").src="resource/images/hlkj/hbgydx/6f.jpg";
			}else if(ss.eval("resource/images/hlkj/hbgydx/6f.jpg")){
				alert("5");
				document.getElementById("hb1").src="resource/images/hlkj/hbgydx/001.jpg";
			}else{
				alert("6");
				document.getElementById("hb1").src="resource/images/hlkj/hbgydx/001.jpg";
			}
		} 
		//重复执行某个方法 
		var t1 = window.setInterval(hello,1000); 
		var t2 = window.setInterval("hello()",3000); 
		//去掉定时器的方法 
		window.clearInterval(t1); 
	</script> 
		
		
  <script type="text/javascript">
  	function changeGydx(String id){
  		document.getElementById(id).src = "resource/images/hlkj/hbgydx/1f.jpg";
  							
  	}
  </script>
  </head>
 			 <%
					Member mb = 	(Member)session.getAttribute("minfo");
					String dw = mb.getOrgId();
					// out.print(dw);
				%>
 	 <body>
					<%if(dw.equals("402881f73e1c5181013e1c56da3c0002")){ %>
							<div>
							
								 <div align="center"><img id="hb1" src="resource/images/hlkj/hbgydx/001.jpg" style="height:560px;width:1300px;"/></div>
	               			<!-- 	 <div align="center"><img id="hb2" src="resource/images/hlkj/hbgydx/1f.jpg" style="height:560px;width:1300px;"/></div>
	               				 <div align="center"><img id="hb3" src="resource/images/hlkj/hbgydx/4f.jpg" style="height:560px;width:1300px;"/></div>
	               				 <div align="center"><img id="hb4" src="resource/images/hlkj/hbgydx/5f.jpg" style="height:560px;width:1300px;"/></div>
	               				 <div align="center"><img id="hb5" src="resource/images/hlkj/hbgydx/6f.jpg" style="height:560px;width:1300px;"/></div>
               				 	 -->	
               				 	<!-- 	<div align="center"><img id="001" src="resource/images/hlkj/fshr/001.jpg" style="height:560px;width:1300px;"/></div>   -->
               				 </div>
							
						<%}else if(dw.equals("402881f73e1c5181013e1c56da3c0003")) {%>
							<div>
               				 		<div align="center"><img src="resource/images/hlkj/ld2046/001.jpg" style="height:560px;width:1300px;"/></div>
               				 </div>
						<%}else if(dw.equals("402881f73e1c5181013e1c56da3c0004")){ %>
							<div>
               				 		<div align="center"><img src="resource/images/hlkj/jtyh/001.jpg" style="height:560px;width:1300px;"/></div>
               				 </div>
						<%}else if(dw.equals("402881f73e1c5181013e1c56da3c0005")) {%>
							<div>
	               				 <div align="center" id="1" >
	               				 <img id="hbdx1" src="resource/images/hlkj/hbgydx/001.jpg" style="height:560px;width:1300px;"/>
	               				 <img id="hbdx2" src="resource/images/hlkj/hbgydx/1f.jpg" style="height:560px;width:1300px;"/>
	               				 <img id="hbdx3" src="resource/images/hlkj/hbgydx/4f.jpg" style="height:560px;width:1300px;"/>
	               				 <img id="hbdx4" src="resource/images/hlkj/hbgydx/5f.jpg" style="height:560px;width:1300px;"/>
	               				 <img id="hbdx5" src="resource/images/hlkj/hbgydx/6f.jpg" style="height:560px;width:1300px;"/></div>
               				 </div>
							
						<% }else{%>
							<div>
               				 		<div align="center"><img src="resource/images/hlkj/fshr/001.jpg" style="height:560px;width:1300px;"/></div>
               				</div>
						<% } %>

  </body>
</html>
