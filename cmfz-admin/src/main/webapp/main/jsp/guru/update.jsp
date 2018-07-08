<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<div class="easyui-panel" style="width:100%;max-width:400px;padding:30px 60px;" data-options="border:false">
		<form id="guru_ff" class="easyui-form" method="post">
			<div style="margin-bottom:20px">
				<label >上师编号：</label>
				<input class="easyui-textbox" name="id" style="width:100%" data-options="required:true,readonly:true">
			</div>
			<div style="margin-bottom:20px">
				<label >上师法号：</label>
				<input class="easyui-textbox" name="name" style="width:100%" data-options="required:true">
			</div>
			<div style="margin-bottom:20px">
				<label >上师简介：</label>
				<input class="easyui-textbox" name="summar" style="width:100%" data-options="required:true">
			</div>

			<div style="margin-bottom:20px">
				<label >上师法照：</label>
				<img id="img" style="height:50px;">
			</div>


		</form>
		<div style="text-align:center;padding:5px 0;margin-top:50px">
			<a id="guru_submit" style="width:80px">修改</a>
			<a id="guru_cancel" style="width:80px">取消</a>
		</div>
	</div>
	<script type="text/javascript">

		$(function(){

			$("#guru_ff").form("load","${pageContext.request.contextPath}/queryGuruById.do?id="+${param.id});
			$("#guru_ff").form({
                onLoadSuccess:function(data){

                    console.log("data:"+data.picPath);
                    $("#img").attr("src","${pageContext.request.contextPath}/upload/"+data.picPath);
            }
			});


			$("#guru_submit").linkbutton({
				iconCls:"icon-edit",
				onClick:function(){
					$("#guru_ff").form("submit",{
						url:"${pageContext.request.contextPath}/modifyGuru.do",
						dateType:"json",
						onSubmit:function(){
							return $(this).form('enableValidation').form('validate');
						},
						success:function(message){
							console.log(message);
							if(message){
							    $("#dialog").dialog("close");
                                $.messager.show({
                                    width:200,
                                    height:120,
                                    title:'我的消息',
                                    msg:"修改成功,<br/>消息将在5秒后关闭。",
                                    timeout:5000,
                                    showType:'slide',

                                });
                                $("#guru_datagrid").datagrid("reload");
							}else{
                                $.messager.show({
                                    width:200,
                                    height:120,
                                    title:'我的消息',
                                    msg:"修改失败,<br/>消息将在5秒后关闭。",
                                    timeout:5000,
                                    showType:'slide',

                                });
							}
						}
					});
				}
			});
			
			$("#guru_cancel").linkbutton({
				iconCls:"icon-cancel",
				onClick:function(){
					$("#dialog").dialog("close");
				}
			});
		});

		
	</script>

