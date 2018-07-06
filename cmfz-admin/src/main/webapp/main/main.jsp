<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持明法州主页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/IconExtension.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>
	<script type="text/javascript">
        $(function(){


            $.ajax({
				type:"POST",
				url:"${pageContext.request.contextPath}/showAllMenu.do",
				dataType:"json",
				success:function(datas){
				    $.each(datas,function(i,firstMenu){
							var secondlist = "";
							$.each(firstMenu.menulist,function(j,secondMenu){
							    //console.log("<a id='btn' data-link='"+secondMenu.menuUrl+"'>"+secondMenu.menuName+"</a>")
                                secondlist+="<p style=\"text-align: center\">" +
									"<a style=\"width:100%\" class=\"easyui-linkbutton\" data-options=\"iconCls:'"+secondMenu.menuIcon+
									"',plain:true\" data-link=\""+ secondMenu.menuUrl+"\">"+
									secondMenu.menuName+"</a></p>";


							});
                        	$.parser.parse($("btn").parent());
                        	$('#left_accordion').accordion('add', {
							   title:firstMenu.menuName,
							   content:secondlist,
							});

					});
                }
			});


            //左侧菜单栏
            // $("#left_accordion").accordion({
            //     fit:true,
            // });
            //选项卡渲染
            $("#center_tab").tabs({
                fit:true,
            });


            //添加选项卡
            $("#left_accordion").on("click","a",function(){
                console.log($(this));
                var $text = $(this).text();
                var $href = $(this).attr("data-link");

                var isExist = $("#center_tab").tabs("exists",$text);
                /*
                判断选项卡是否已经存在
                不存在,则添加新的选项卡
                存在,则选中此选项卡
                */
                if(!isExist){
                    $("#center_tab").tabs("add",{
                        title:$text,
                        href:$href,
                        closable:true,

                    });
                }else{
                    $("#center_tab").tabs("select",$text);
                }
            });



            //添加选项卡
            $("a[id='btn']").each(function(){
                $(this).linkbutton({
                    iconCls:"icon-edit",
                    plain:true,
                    width:210,
                    onClick:function(){
                        var $text = $(this).text();
                        var $href = $(this).attr("data-link");
                        var isExist = $("#center_tab").tabs("exists",$text);
                        /*
                        判断选项卡是否已经存在
                        不存在,则添加新的选项卡
                        存在,则选中此选项卡
                        */
                        if(!isExist){
                            $("#center_tab").tabs("add",{
                                title:$text,
                                href:$href,
                                closable:true,
                                iconCls:"icon-ok",
                            });
                        }else{
                            $("#center_tab").tabs("select",$text);
                        }
                    }
                });
            });
            //退出登录确认信息
            $("#LoginOut").linkbutton({
                onClick:function(){
                    $.messager.confirm("退出登录","确认退出登录？",function(r){
                        if(r){
                            //点击确认后执行的方法
                            alert("已退出登录！");
                        }
                    });
                }
            });


        });

	</script>

</head>

<body class="easyui-layout">
<div id="dialog"></div>
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持明法洲后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:xxxxx &nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;
			<a id="LoginOut" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 gaozhy@zparkhr.com.cn</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="left_accordion" class="easyui-accordion" data-options="fit:true">


		</div>  
    </div>   
    <div data-options="region:'center'">
    	<div id="center_tab" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>  
    </div>   
</body>

</html>