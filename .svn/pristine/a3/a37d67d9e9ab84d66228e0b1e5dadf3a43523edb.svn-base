<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>

</head>
<script type="text/javascript" src="/oa/resource/js/jquery/jquery-1.10.2.js"></script>
<script type="text/javascript" src="/oa/resource/js/jquery/jquery.json-2.3.min.js"></script>
		 <script type="text/javascript">
		 
		 	function outmsg(){
		 		var ms = document.getElementById("msg").value;
		 		ms = encodeURI(encodeURI(ms));
		 		var cod = document.getElementById("cod").value;
		 		if(ms!=""&&ms!=null){
		 			alert(ms);
		 		}
		 		if(cod!=""&&cod!=null){
		 			if(cod==1){
		 				document.getElementById("nin").src="/oa/resource/images/hlkj/dd/off.jpg";
		 			}else{
		 				document.getElementById("nin").src="/oa/resource/images/hlkj/dd/on.jpg";
		 			}
		 		}
		 		
		 	}
		 
				function testSend(ss){
					var uk = "/oa/hlkj/sbgl/loaddd.do?lm=ddgl&rel=hlkj_ddgl&op="+ss;
					document.getElementById("frmd").action=uk;
					document.getElementById("frmd").submit();
				}
				
		</script>
		<body onload="outmsg()">
		
			<form method="post" id="frmd" action="">
			<input type="text" name="code" id="cod" value="${code}">
			<input type="text" name="msg" id="msg" value="${msg}">
				<div style="width:600px;" align="center">
		 			<div style="width:200px;" align="center">
		 				<img src="/oa/resource/images/hlkj/dd/off.jpg" id="nin" style=" width:200px; "/>
		 			</div>
					 <div style="width:200px; background-color:#52a4a8;; line-height:30px; height:30px; text-align:center;color:#fff;">
					<input type="button" value="开灯" onclick="testSend('on')"/>
					<input type="button" value="关灯" onclick="testSend('off')"/></div>
				 </div>
			</form>	 
		</body>
</html>
		 