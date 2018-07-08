<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>

	<div id="panel" class="easyui-panel" style="width:100%;max-width:300px;padding:40px 40px;" >
		<form id="ff_add" class="easyui-form" method="post" enctype="multipart/form-data">

			<div style="margin-bottom:15px;margin-left: 20px">
				<input id="description" name="description">
			</div>
			<div style="margin-bottom:15px;margin-left: 20px">
				<select id="combobox" class="easyui-combobox" name="state" style="width:150px;">
					<option value="1">展示</option>
					<option value="0">不展示</option>
				</select>
			</div>
			<div style="margin-bottom:15px;margin-left: 20px">
				<input id="file" name="file">
			</div>

		</form>
		<div style="text-align:center;margin-top:30px">
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
				label:"请选择文件:",
                required:true,
                prompt:"请选择图片",
            });
            $("#description").textbox({
                label:"请添加图片描述",
                required:true,
                prompt:"添加图片描述",
            });
            $("#combobox").combobox({
				panelHeight:50,

			})



			$("#submit_form").linkbutton({
				iconCls:"icon-add",
				onClick:function(){
					$("#ff_add").form("submit",{
						url:"${pageContext.request.contextPath}/picUpload.do",
						onSubmit:function(){
							return $(this).form('validate');
						},
						success:function(message){
							var result = JSON.parse(message);
							console.log(result);
							
							if(result){
                                $("#dialog").dialog("close");
								//$.messager.alert("提示","添加成功！","info");
                                $.messager.show({
                                    width:200,
                                    height:120,
                                    title:'我的消息',
                                    msg:"图片添加成功,<br/>消息将在5秒后关闭。",
                                    timeout:5000,
                                    showType:'slide',

                                });

                                $("#datagrid").datagrid("load");
							}else{
                                $.messager.show({
									width:200,
									height:120,
                                    title:'我的消息',
                                    msg:"图片添加失败,<br/>消息将在5秒后关闭。",
                                    timeout:5000,
                                    showType:'slide',

                                });
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

    