<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" session="false"%>
<%@include file="/WEB-INF/jsp/commons/jstl_message_tld.jsp"%>
<!doctype html>
<html>
<head>
	<meta http-equiv="contentType" content="text/html; charset=UTF-8"/>
</head>
<body>
<script type="text/javascript" src="./resource/js/jquery/jquery-1.10.2.js"></script>
<script type="text/javascript" src="./resource/js/jquery/jquery.json-2.3.min.js"></script>


<script type="text/javascript">

function testSend(){
    var json = {};
    json.device_id = 'FV00456';
    json.last_update_time = '20150908122607';//(new Date()).format("yyyyMMddhhmmss");
    json.device_type = '5';
    json.data_type = '0';
    json.reverse = '测试002';
    json.data = {};
    json.data.temperatureValue='status';
    json.data.humidity='23';


    var data = $.toJSON(json);
    alert(data);
    var url = './HlkjSbgl/upload.do';
    $.ajax({
       url: url,
       type:"POST",
       dataType:"json",
      contentType:'application/json;charset=UTF-8',
       data:data,
       success: function (text) {
        if(text){
            alert("模拟数据发送成功！");
        }else{
            alert("模拟数据发送失败");
        }


       },
       error: function (jqXHR, textStatus, errorThrown) {
            alert(jqXHR+textStatus+errorThrown+"服务器繁忙，请稍后重试");
       }
    });
}
$(function(){
	testSend();
});
</script>
</body>
</html>