<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>

	<div id="panel" class="easyui-panel" style="width:100%;max-width:400px;padding:40px 40px;" >
		<form id="add_guru_form" class="easyui-form" method="post" enctype="multipart/form-data">

			<div style="margin-bottom:15px;margin-left: 50px">
				<label for="file">请选择文件：</label>
				<input id="file" name="file">
			</div>

		</form>
		<div style="text-align:center;margin-top:30px">
			<a id="submit_form"  style="width:80px">添加</a>
			<a id="cancel_form"  style="width:80px;margin-left: 20px">取消</a>
		</div>
	</div>




	<script type="text/javascript">
		$(function(){
		    $("#panel").panel({
				width:380,
				height:240,
                border:false,

			});

            $("#file").filebox({
                required:true,
            });




			$("#submit_form").linkbutton({
				iconCls:"icon-add",
				onClick:function(){
					$("#add_guru_form").form("submit",{
						url:"${pageContext.request.contextPath}/GuruMoreAdd.do",
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
                                    msg:"批量导入成功,<br/>消息将在5秒后关闭。",
                                    timeout:5000,
                                    showType:'slide',

                                });

                                $("#datagrid").datagrid("reload");
							}else{
                                $.messager.show({
									width:200,
									height:120,
                                    title:'我的消息',
                                    msg:"批量导入失败,<br/>消息将在5秒后关闭。",
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

    