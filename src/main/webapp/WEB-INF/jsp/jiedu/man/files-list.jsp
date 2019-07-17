<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp" %>
<style>
<!--   
.qq-upload-button{
	height:95px!important ;
}

-->
</style>
<div style="width: 100%; margin: 0 auto;">
	
		<table class="table table-bordered ">
			<tr>
				<td style="width:50px;">类型</td>
				<td>附件</td>
			</tr>
			<tr>
				<td>社区戒毒协议书</td>
				<td>

				 <div  id="holder_0">
    				
    				<c:forEach var ="f0" items="${files0}">
	 					<div id="file_${f0.id }" class="qq-upload-button" style="float:left;margin-top:8px;margin-left:10px;">	
    						<img alt="" src="${ctx }/upfiles/${f0.file_url }" style="width:77px;height:77px;">		
    						<a href="javascript:rmFile(${f0.id })">删除</a>	
    					</div>	
	 				</c:forEach>
    					   
	    		 </div>
    			 <div class="qq-upload-button-selector qq-upload-button"  style="float:left;margin-top:8px;margin-left:10px;">
	      				<input type="file" id="upload_file" name="upload_file" actType="0" class="file-no-visual" style="width:77px;height:77px;"/>
	    		 </div>
	    		 				
				</td>
			</tr>
			<tr>
				<td>担保书</td>
				<td>
				 <div  id="holder_1">
    					
    				<c:forEach var ="f0" items="${files1}">
	 					<div id="file_${f0.id }" class="qq-upload-button" style="float:left;margin-top:8px;margin-left:10px;">	
    						<img alt="" src="${ctx }/upfiles/${f0.file_url }" style="width:77px;height:77px;">		
    						<a href="javascript:rmFile(${f0.id })">删除</a>	
    					</div>	
	 				</c:forEach>
    					   
	    		 </div>
    			 <div class="qq-upload-button-selector qq-upload-button"  style="float:left;margin-top:8px;margin-left:10px;">
	      				<input type="file" id="upload_file2" name="upload_file2"  actType="1"  class="file-no-visual" style="width:77px;height:77px;"/>
	    		 </div>
	    						
				</td>
			</tr>

		</table>
		
		<input type="hidden" name="datagridId" value="${param.rel }_datagrid" />
		<input type="hidden" name="currentCallback" value="close" />
</div>

<script type="text/javascript">

var basePath='${ctx}';

$(function(){
	
	initUpload();
});

function initUpload(){

	$('input[type="file"]').change(function(){

		var me=$(this);
		var formData = new FormData();
		//获取文件
		var file_data = $(this).prop("files")[0];

		var actType=$(this).attr('actType');
		
		//把所以表单信息
		formData.append("actType", actType);
		formData.append("manId", '${man.id}');
		formData.append("file", file_data);

        $.ajax({
            type: 'post',
            url: basePath+"/jiedu/man/files/upload.do",
            data: formData,
            cache: false,
            processData: false,
            contentType: false,
        }).success(function (resp) {

        	 console.log(resp);

        	 var data=JSON.parse(resp);

        	 if(data==null){
        		 $.messager.alert('信息',"附件上传失败");

        		 return;
             }
        	 
        	 me.val('');

        	 addHolder('holder_'+actType,data);
        	 
        }).error(function () {
            alert("上传失败");
        });

		});
}

function addHolder(holderId,fileInfo){

	$('#'+holderId).append(
		'<div id="file_'+fileInfo.id+'" class="qq-upload-button" style="float:left;margin-top:8px;margin-left:10px;">	'+
    '					<img alt="" src="'+basePath+'/upfiles/'+fileInfo.file_url+'" style="width:77px;height:77px;">	'+	
    '					<a href="javascript:rmFile('+fileInfo.id+')">删除</a>	'+
 	'	</div>'
	);
}

function rmFile(id){

	alert(id);
	
}

</script>
