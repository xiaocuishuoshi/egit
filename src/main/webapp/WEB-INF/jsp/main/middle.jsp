<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>
<%
	String path = request.getContextPath();
%>
<%--
	中间区域
--%>
<%--
	菜单  
	<ul class="ul-menu">
	  <li><a href="javascript:alert('xxx');"></a></li>
	  <li><a href="javascript:;">菜单二</a></li>		
	  <li>
	  		<a href="javascript:;">二级菜单</a>
	  		<ul class="ul-submenu">
	  			<li >
	  				<a href="javascript:;">子菜单</a>
	  			</li>
	  			<li >
	  				<a href="javascript:;">三级菜单</a> 
	  				<ul class="ul-submenu">
	  					<li ><a>xx</a></li>
	  				</ul>
	  			</li>
	  		</ul>
	  </li>
	  
</ul>
 --%>
<div class="easyui-layout" fit="true" border="false" id="mainTabInfo">
	<!-- 左侧-->
	<div region="west" split="true" title="${requestScope.name }"
		style="width:220px; padding: 1px; ">

		<ul class="ul-menu">${requestScope.menus }
		</ul>

	</div>
	<!-- 中间-->
	<div region="center" style="overflow: hidden;border-top: none"
		data-options="fit:false">
		<div class="maintabs" fit="true" border="false"></div>
	</div>

</div>


<script type="text/javascript">

			
	$(function(){
			
	//!!setInterval(show_xx,3000);
	
	});
	
	function show_xx(){
		$.ajax({
			url:"qjgl/countQj.do",
			cache: false,
			dataType:"json",
			success:function(msg){
			 
				
			 	var t = $("a[rel='xxjh_qjgl']");
			 	var em1 =t.find("em");
			 	if(em1.length==0){
			 		em1 = $("<em></em>");
			 		em1.css({"color":"#ff0000","font-size":"16px","width":"50px","overflow":"hidden","text-overflow":"ellipse","float":"right"});
						if(msg.qj!="0"){
							var em1value=msg.qj;
							em1.html("( "+em1value+" )");
							em1.appendTo(t);
					}else{
							em1.remove();
						}
			 	}else{
			 			em1.css({"color":"#ff0000","font-size":"16px","width":"50px","overflow":"hidden","text-overflow":"ellipse","float":"right"});
						if(msg.qj!="0"){
							var em1value=msg.qj;
							em1.html("( "+em1value+" )");
							em1.appendTo(t);
						}else{
							em1.remove();
						}
			 	}
					
				
					
					var s = $("a[rel='xxjh_sxhb']");
					var em2=s.find("em");
					if(em2.length==0){
						em2=$("<em></em>");
						if(msg.hb!="0"){
							var em1value2=msg.hb;
							em2.html("( "+em1value2+" )");
							em2.css({"color":"#ff0000","font-size":"14px","width":"50px","overflow":"hidden","text-overflow":"ellipse","float":"right"});
							em2.appendTo(s);
						}else{
							em2.remove();
						}		
					}else{
						if(msg.hb!="0"){
							var em1value2=msg.hb;
							em2.html("( "+em1value2+" )");
							em2.css({"color":"#ff0000","font-size":"14px","width":"50px","overflow":"hidden","text-overflow":"ellipse","float":"right"});
							em2.appendTo(s);
						}else{
							em2.remove();
						}
						
					}
				var d = $("a[rel='xxjh_shqz']");
				var em3=d.find("em");
				if(em3.length==0){
					em3=$("<em></em>");
						if(msg.qz!="0"){
							var em1value3=msg.qz;
							em3.html("( "+em1value3+" )");
							em3.css({"color":"#ff0000","font-size":"14px","width":"50px","overflow":"hidden","text-overflow":"ellipse","float":"right"});
							em3.appendTo(d); 
						}else{
							em3.remove();
						}
					}else{
					
						if(msg.qz!="0"){
							var em1value3=msg.qz;
							em3.html("( "+em1value3+" )");
							em3.css({"color":"#ff0000","font-size":"14px","width":"50px","overflow":"hidden","text-overflow":"ellipse","float":"right"});
							em3.appendTo(d); 
						}else{
							em3.remove();
						}
					
					}
					
			
			}}); 		
	}
</script>
