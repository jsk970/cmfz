<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" isELIgnored="false" %>


	<script>
        $(function(){
            $('#datagrid').datagrid({
                title:'轮播图列表',
                width:500,
                height:250,
                remoteSort:false,
                singleSelect:true,
                nowrap:false,
                fitColumns:true,
                url:'${pageContext.request.contextPath}/showPicForPage.do',
				toolbar:"#tools",
                pagination:true,
                pageList:[2,4,6,8,10],
                pageSize:4,
				fit:true,
                columns:[[
                    {field:'id',title:'图片编号',width:80},
                    {field:'description',title:'描述',width:100,sortable:true},
                    {field:'publishedDate',title:'上传时间',width:80,align:'right',sortable:true,fitColumns:true,formatter:function(value,row,index){ // 格式化展示数据到对应的列
                            var date = new Date(value);
                            //console.log("value:"+date);
                            // 年  月  日
                            var year = date.getFullYear();
                            var month = date.getMonth()+1;
                            var day = date.getDay();
                            var hh = date.getHours();
                            var mm = date.getMinutes();
                            var ss = date.getSeconds();
                            return year+"年"+month+"月"+day+"日"+" "+hh+":"+mm+":"+ss;
                        }},
                    {field:'state',title:'状态',width:80,align:'right',sortable:true},
                    {field:'123',title:'123',width:80,align:'right',sortable:true},

                ]],
                view: detailview,
                detailFormatter: function(rowIndex, rowData){
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/' + rowData.path +'" style="height:50px;"></td>' +
                        '<td style="border:0">' +
                        '<p>Attribute: ' + rowData.description + '</p>' +
                        '<p>Status: ' + rowData.state + '</p>' +
                        '</td>' +
                        '</tr></table>';
                }

            });

		//add、edit、delete工具渲染

        $("#edit").linkbutton({
            iconCls:"icon-edit",
            onClick:function(){
                var $rowData = $("#datagrid").datagrid("getSelected");
                if($rowData==null){
                    $.messager.alert("警告","未选中数据行","warning");
                }else{
                    //console.log($rowData);
                    //console.log($rowData.borndate);

                    $("#dialog").dialog({
                        title:"修改信息",
                        width:420,
                        height:305,
                        href:"login.jsp",
                        modal:true,
                    });
                }
            }
        });

        $("#addUser").linkbutton({
            iconCls:"icon-add",
            onClick:function(){
                $("#dialog").dialog({
                    title:"添加图片",
                    width:310,
                    height:281,
                    href:"add.jsp",
                    modal:true,
                });
            }
        });


        $("#delete").linkbutton({
            iconCls:"icon-delete",
            onClick:function(){
                var $rowData = $("#datagrid").datagrid("getSelected");
                if($rowData==null){
                    $.messager.alert("警告","未选中数据行","warning");
                }else{
                    $.messager.confirm('确认框', '您确认删除吗？', function(r){
                        if (r){
                            $.ajax({
                                type:"POST",
                                url:"${pageContext.request.contextPath}/user/remove.do",
                                data:"cardno="+$rowData.cardno,
                                success:function(message){
                                    if(message){
                                        $.messager.alert("提示","删除成功！","info");
                                        $("#datagrid").datagrid("load");
                                    }else{
                                        $.messager.alert("提示","删除失败！","info");
                                    }
                                }
                            });
                        }
                    });

                }
            }

        });

        });

	</script>

<table id="datagrid"></table>
<div id="tools">
	<a id="edit">编辑/修改</a>
	<a id="delete">删除</a>
	<a id="addUser">添加</a>
</div>
