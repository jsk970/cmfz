<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">



	$(function(){
        var E = window.wangEditor
        var editor = new E('#editor')
        // 或者 var editor = new E( document.getElementById('#editor') )
        editor.customConfig.uploadImgServer = '/upload';
        editor.customConfig.uploadFileName = 'files';
        editor.create();


        $("#article_add_combobox").combobox({
            panelHeight:50,
            onLoadSuccess:function(value){
                if(value=='1'){
                    $('#sowing_update_combobox').combobox('selectIndex',0);
                }else if(value=='0'){
                    $('#sowing_update_combobox').combobox('selectIndex',1);
                }
            }

        });


        $("#article_submit").linkbutton({
            iconCls:"icon-edit",
            onClick:function(){
                $("#article_form").form("submit",{
                    url:"${pageContext.request.contextPath}/.do",
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

        $("#article_reset").linkbutton({
            iconCls:"icon-cancel",
            onClick:function(){
                $("#article_form").form("reset");
            }
        });
	});


</script>
<div class="easyui-panel" style="width:100%;padding:30px 60px;" data-options="border:false">
	<form id="article_form" class="easyui-form" method="post">
		<div style="margin-bottom:20px;width: 400px">
			<label >文章标题：</label>
			<input class="easyui-textbox" name="id" style="width:80%" data-options="required:true">
		</div>
		<div style="margin-bottom:20px;;width: 400px">
			<label >文章作者：</label>
			<input class="easyui-textbox" name="name" style="width:80%" data-options="required:true">
		</div>
		<div style="margin-bottom:20px;;width: 400px">
			<label >文章状态：</label>
			<select id="article_add_combobox" class="easyui-combobox" name="state" style="width:200px;">
				<option value="1">展示</option>
				<option value="0">不展示</option>
			</select>
		</div>

		<div style="margin-bottom:20px">
			<label >文章内容：</label>
			<div id="editor"></div>
		</div>


	</form>
	<div style="text-align:center;padding:5px 0;margin-top:50px">
		<a id="article_submit" style="width:80px">创建文章</a>
		<a id="article_reset" style="width:80px">清除内容</a>
	</div>
</div>
