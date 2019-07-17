<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>无标题页</title>
    <script language="javascript" type="text/javascript">
        //用javascript进行声音播放控制
       function ManageSoundControl(action)
       {
            var soundControl = document.getElementById("soundControl");
            if(action == "play")
          {
                soundControl.play();
            }
            if(action == "stop")
            {
                soundControl.stop();
            }
        }
    </script>
</head>
<body>
    <form id="form1" runat="server">
        <table width="100%">
            <tr>
                <td>
                     <embed id="soundControl" src="06.wav" mastersound hidden="true" loop="false" autostart="false"></embed>
                     <input id="btPlay" type="button" value="播放" onclick="ManageSoundControl('play')" />
                     <input id="btStop" type="button" value="播放" onclick="ManageSoundControl('stop')" />
                </td>
            </tr>          
        </table>
    </form>
</body>
</html>