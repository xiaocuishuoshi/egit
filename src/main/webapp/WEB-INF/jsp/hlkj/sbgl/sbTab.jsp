<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<script type="text/javascript">
<!--
	function gotoque(){
	alert(1);
	}
//-->
</script>
<div  class="easyui-tabs"  fit="true" border="false" >
	<div class="easyui-tab"  title="列表视图" 	style="padding:2px; " >
	<input type="hidden" name="addres" id="addres">
	
	
		<%@ include file="/WEB-INF/jsp/hlkj/sbgl/query_sb.jsp" %>
	</div>
	<div  title="3D视图"   href="hlkj/sbgl/queryDetile.do?rel=${param.rel }_detile&lm=${lm}&addressid=${addres}" style="padding:2px; " >
	</div>
	<div  title="流水记录"   href="hlkj/sbgl/querySbList.do?rel=${param.rel }_detile&lm=${lm}&addressid=${addres}" style="padding:2px; " >
	</div>

</div>
