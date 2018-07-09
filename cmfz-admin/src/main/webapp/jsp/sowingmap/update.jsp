<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<div class="easyui-panel" style="width:100%;max-width:400px;padding:30px 60px;" data-options="border:false">
		<form id="sowing_ff" class="easyui-form" method="post">
			<div style="margin-bottom:20px">
				<label >图片编号：</label>
				<input class="easyui-textbox" name="id" style="width:100%" data-options="required:true,readonly:true">
			</div>
			<div style="margin-bottom:20px">
				<label >图片描述：</label>
				<input class="easyui-textbox" name="description" style="width:100%" data-options="required:true">
			</div>

			<%--<div style="margin-bottom:20px">--%>
				<%--<label >上传时间：</label>--%>
				<%--<input id="sowing_mydate" class="easyui-textbox" name="publishedDate" style="width:100%" data-options="required:true">--%>
			<%--</div>--%>
			<div style="margin-bottom:20px">
				<label >图片状态：</label>
				<select id="sowing_update_combobox" class="easyui-combobox" name="state" style="width:150px;">
					<option value="1">展示</option>
					<option value="0">不展示</option>
				</select>
			</div>

		</form>
		<div style="text-align:center;padding:5px 0;margin-top:50px">
			<a id="sowing_submit" style="width:80px">修改</a>
			<a id="sowing_cancel" style="width:80px">取消</a>
		</div>
	</div>
	<script type="text/javascript">

		$(function(){
            $("#sowing_update_combobox").combobox({
                panelHeight:50,
                onLoadSuccess:function(value){
                    if(value=='1'){
                        $('#sowing_update_combobox').combobox('selectIndex',0);
                    }else if(value=='0'){
                        $('#sowing_update_combobox').combobox('selectIndex',1);
                    }
				}

            });

			$("#sowing_ff").form("load","${pageContext.request.contextPath}/skiptoModify.do?id="+${param.id});
			$("#sowing_ff").form({
                onLoadSuccess:function(){
                    $("#sowing_mydate").datebox({
                        formatter:function(value){
                            console.log("value:"+value);
                            var date = new Date(value);
                            console.log("date:"+date);

                            var y = date.getFullYear();
                            var m = date.getMonth()+1;
                            var d = date.getDate();
                            var hh = date.getHours();
                            var mm = date.getMinutes();
                            var ss = date.getSeconds();
                            return y+"年"+m+"月"+d+"日"+" "+hh+":"+mm+":"+ss;
						}
					})
            }
			});


			$("#sowing_submit").linkbutton({
				iconCls:"icon-edit",
				onClick:function(){
					$("#sowing_ff").form("submit",{
						url:"${pageContext.request.contextPath}/modifyPic.do",
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
                                $("#sowing_datagrid").datagrid("reload");
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
			
			$("#sowing_cancel").linkbutton({
				iconCls:"icon-cancel",
				onClick:function(){
					$("#dialog").dialog("close");
				}
			});
		});

		
	</script>

