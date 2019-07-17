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
		
			<body onLoad="outmsg()" >
				<form method="post" id="frmd" action="">
					<div style="width:350px;height:400px;background:rgb(239,239,239);margin-left:250px;margin-top:15px;" align="center">
						<table  style="padding-top: 10px;">
							<tr style="height: 80px;">
								<th style="width:300px; color:#FFF;" colspan="3">
								<p style="font-size:18px;color:green;">空调温度：XX ℃&nbsp;&nbsp;&nbsp;
								空调状态：关</p>
								</th>
								
							</tr>
							<tr style="height: 80px;text-align: center;">
								<td><button style="width:80px;height:40px;background:rgb(151,119,119);color:#FFF;border:1px #fff solid;border-radius:5px;font-size:14px;">自动模式</button></td>
								<td><input type="text" name="" id="" style="width:60px">℃</td>
								<td><button style="width:80px;height:40px;background:rgb(54,180,223);color:#FFF;border:1px #fff solid;border-radius:5px;font-size:14px;">确&nbsp;&nbsp;定</button></td>
							</tr>
							<tr style="height: 80px;text-align: center;">
								<td><button style="width:80px;height:40px;background:rgb(151,119,119);color:#FFF;border:1px #fff solid;border-radius:5px;font-size:14px;">手动模式</button></td>
								<td><button style="width:80px;height:40px;background:rgb(54,180,223);color:#FFF;border:1px #fff solid;border-radius:5px;font-size:14px;">制冷</button></td>
								<td><button style="width:80px;height:40px;background:rgb(54,180,223);color:#FFF;border:1px #fff solid;border-radius:5px;font-size:14px;">制热</button></td>
							</tr>
							<tr style="height: 80px;text-align: center;">
								<td colspan="3"><button style="width:200px;height:40px;background:rgb(54,180,223);color:#FFF;border:1px #fff solid;border-radius:5px;font-size:14px;">关机</button></td>
							</tr>
						</table>
					</div>
				</form>	 
		</body>
</html>
		 