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
                url:'datagrid_data.json',
				toolbar:"#tools",
                pagination:true,
				fit:true,
                columns:[[
                    {field:'itemid',title:'Item ID',width:80},
                    {field:'productid',title:'Product ID',width:100,sortable:true},
                    {field:'listprice',title:'List Price',width:80,align:'right',sortable:true},
                    {field:'unitcost',title:'Unit Cost',width:80,align:'right',sortable:true},
                    {field:'attr1',title:'Attribute',width:150,sortable:true},
                    {field:'status',title:'Status',width:60,align:'center'}
                ]],
                view: detailview,
                detailFormatter: function(rowIndex, rowData){
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="images/' + rowData.itemid + '.png" style="height:50px;"></td>' +
                        '<td style="border:0">' +
                        '<p>Attribute: ' + rowData.attr1 + '</p>' +
                        '<p>Status: ' + rowData.status + '</p>' +
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
                        href:"",
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
