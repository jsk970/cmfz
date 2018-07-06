<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>

	<div id="panel" class="easyui-panel" style="width:100%;max-width:300px;padding:40px 40px;" >
		<form id="ff_add" class="easyui-form" method="post" enctype="multipart/form-data">
			<div style="margin-bottom:15px;margin-left: 20px">
				<input id="file" name="file">
			</div>
			<div style="margin-bottom:15px;margin-left: 20px">
				<input id="description" name="description">
			</div>

		</form>
		<div style="text-align:center;margin-top:60px">
			<a id="submit_form"  style="width:80px">添加</a>
			<a id="cancel_form"  style="width:80px">取消</a>
		</div>
	</div>




	<script type="text/javascript">
		$(function(){
		    $("#panel").panel({
				width:285,
				height:240,
                border:false,

			});

            $("#file").filebox({
                required:true,
                prompt:"请选择图片",
            });
            $("#description").textbox({

                required:true,
                prompt:"添加图片描述",
            });



			$("#submit_form").linkbutton({
				iconCls:"icon-add",
				onClick:function(){
					$("#ff_add").form("submit",{
						url:"${pageContext.request.contextPath}/upload.do",
						onSubmit:function(){
							return $(this).form('validate');
						},
						success:function(message){
							var result = JSON.parse(message);
							console.log(result);
							
							if(result){
                                $("#dialog").dialog("close");
								$.messager.alert("提示","添加成功！","info");
								$("#datagrid").datagrid("load");
							}else{
								$.messager.alert("提示","添加失败！","info");
							}
						}
						
					});
				}
			});
			
			$("#cancel_form").linkbutton({
				iconCls:"icon-delete",
				onClick:function(){
					$("#dialog").dialog("close");
				},
			});
		});
	
		
	</script>

    