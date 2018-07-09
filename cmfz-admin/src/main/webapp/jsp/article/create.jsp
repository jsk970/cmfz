<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">



	$(function(){
        var E = window.wangEditor
        var editor = new E('#editor')
        // 或者 var editor = new E( document.getElementById('#editor') )
        editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/contextUpload.do';
        editor.customConfig.uploadFileName = 'files';
        editor.create();

        // console.log($("#w-e-img2961763663109622"));
        // console.log($("#w-e-text"));
        // $("#w-e-img2961763663109622").click(function(){
         //    alert("123");
         //    $("#w-e-text").focus();
		// })


        $("#article_add_combobox").combobox({
            panelHeight:50,
            editable:false
        });


        $("#article_submit").linkbutton({
            iconCls:"icon-edit",
            onClick:function(){
                $("#article_form").form("submit",{
                    url:"${pageContext.request.contextPath}/addArticle.do",
                    queryParams:{"context":editor.txt.html()},
                    //dateType:"json",
                    onSubmit:function(){
                        return $(this).form('enableValidation').form('validate');
                    },
                    success:function(message){
                        console.log(message);
						var result = JSON.parse(message);
                        if(result){
                            $.messager.show({
                                width:200,
                                height:120,
                                title:'我的消息',
                                msg:"添加文章成功,<br/>消息将在5秒后关闭。",
                                timeout:5000,
                                showType:'slide',
                            });
                            $("#article_form").form("reset");
                            editor.txt.html("");
                        }else{
                            $.messager.show({
                                width:200,
                                height:120,
                                title:'我的消息',
                                msg:"添加文章失败,<br/>消息将在5秒后关闭。",
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
                editor.txt.html("");
            }
        });

        $('#article_author').combobox({
            url:'${pageContext.request.contextPath}/queryAllGuru.do',
            valueField:'id',
            textField:'name',
            editable:false
        });
	});


</script>
<%--<div class="easyui-panel" style="width:100%;padding:30px 60px;" data-options="border:false">--%>
	<form id="article_form" class="easyui-form" method="post">
		<div style="margin:20px;width: 400px">
			<label >文章标题：</label>
			<input class="easyui-textbox" name="name" style="width:80%" data-options="required:true">
		</div>
		<div style="margin:20px;;width: 400px">
			<label >文章作者：</label>
			<input id="article_author" name="author"  style="width:80%" data-options="required:true">
		</div>
		<div style="margin:20px;width: 400px">
			<label >文章状态：</label>
			<select id="article_add_combobox" class="easyui-combobox" name="state" style="width:200px;">
				<option value="1">展示</option>
				<option value="0">不展示</option>
			</select>
		</div>

		<div style="margin:20px">
			<label>文章内容：</label>
			<div id="editor" name="context"></div>
		</div>


	</form>
	<div style="text-align:center;padding:5px 0;margin-top:50px">
		<a id="article_submit" style="width:80px">创建文章</a>
		<a id="article_reset" style="width:80px">清除内容</a>
	</div>
<%--</div>--%>
