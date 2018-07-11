<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" isELIgnored="false" %>


	<script>
        $(function(){
            $('#guru_datagrid').datagrid({
                title:'上师列表',
                width:500,
                height:250,
                remoteSort:false,
                singleSelect:true,
                nowrap:false,
                fitColumns:true,
                url:'${pageContext.request.contextPath}/showAllGuruForPage.do',
				toolbar:"#guru_tools",
                pagination:true,
                pageList:[2,4,6,8,10],
                pageSize:4,
				fit:true,
                columns:[[
                    {field:'id',title:'上师编号',width:80},
                    {field:'name',title:'上师法号',width:100,sortable:true},
                    {field:'summar',title:'简介',width:80,align:'right',sortable:true},
                    {field:'options',title:'操作',width:80,align:'right'},
                ]],
                view: detailview,
                detailFormatter: function(rowIndex, rowData){
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/' + rowData.picPath +'" style="height:50px;"></td>' +
                        '<td style="border:0">' +
                        '<p>法号: ' + rowData.name + '</p>' +
                        '<p>简介: ' + rowData.summar + '</p>' +
                        '</td>' +
                        '</tr></table>';
                }

            });

		//add、edit、delete工具渲染

			$("#guru_edit").linkbutton({
				iconCls:"icon-edit",
				onClick:function(){
					var $rowData = $("#guru_datagrid").datagrid("getSelected");
					if($rowData==null){
						$.messager.alert("警告","未选中数据行","warning");
					}else{
						//console.log($rowData);
						//console.log($rowData.borndate);

						$("#dialog").dialog({
							title:"修改上师信息",
							width:435,
							height:410,
							href:"jsp/guru/update.jsp?id="+$rowData.id,
							modal:true,
						});
					}
				}
			});

			$("#guru_addUser").linkbutton({
				iconCls:"icon-add",
				onClick:function(){
					$("#dialog").dialog({
						title:"添加上师信息",
						width:410,
						height:300,
						href:"jsp/guru/guruAdd.jsp",
						modal:true,
					});
				}
			});


			$("#guru_delete").linkbutton({
				iconCls:"icon-delete",
				onClick:function(){
					var $rowData = $("#guru_datagrid").datagrid("getSelected");
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
											//$.messager.alert("提示","删除成功！","info");
                                            $.messager.show({
                                                width:200,
                                                height:120,
                                                title:'我的消息',
                                                msg:"删除成功,<br/>消息将在5秒后关闭。",
                                                timeout:5000,
                                                showType:'slide',

                                            });
											$("#datagrid").datagrid("load");
										}else{
											//$.messager.alert("提示","删除失败！","info");
                                            $.messager.show({
                                                width:200,
                                                height:120,
                                                title:'我的消息',
                                                msg:"删除失败,<br/>消息将在5秒后关闭。",
                                                timeout:5000,
                                                showType:'slide',

                                            });
										}
									}
								});
							}
						});

					}
				}

			});
			//搜索框
			$('#ss').searchbox({
				width:300,
				searcher:function(value,name){
					$("#guru_datagrid").datagrid({
						url:"${pageContext.request.contextPath}/showByKeywords.do",
						queryParams:{"keywords":value},
						columns:[[
                            {field:'id',title:'上师编号',width:80},
                            {field:'name',title:'上师法号',width:100,sortable:true},
                            {field:'summar',title:'简介',width:80,align:'right',sortable:true},
                            {field:'options',title:'操作',width:80,align:'right'},

						]],
						toolbar:"#guru_tools",
						pagination:true,
						pageList:[2,4,6,8],
						pageSize:2,
						singleSelect:true,
                        view: detailview,
                        detailFormatter: function(rowIndex, rowData){
                            return '<table><tr>' +
                                '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/' + rowData.path +'" style="height:50px;"></td>' +
                                '<td style="border:0">' +
                                '<p>法号: ' + rowData.name + '</p>' +
                                '<p>简介: ' + rowData.summar + '</p>' +
                                '</td>' +
                                '</tr></table>';
                        }

					});

				},
				menu:'#mm',
				prompt:'请输入...',

			});

			$("#guru_BatchAddUser").linkbutton({
				iconCls:"icon-add",
				onClick:function(){
                    $("#dialog").dialog({
                        title:"批量添加上师信息",
                        width:410,
                        height:300,
                        href:"jsp/guru/guruMoreAdd.jsp",
                        modal:true,
                    });
				}
			})

		});

	</script>

<table id="guru_datagrid"></table>
<div id="guru_tools">
	<a id="guru_edit">编辑/修改</a>
	<a id="guru_delete">删除</a>
	<a id="guru_addUser">添加</a>
	<a id="guru_BatchAddUser">批量添加</a>
	<a class="easyui-linkbutton" href="${pageContext.request.contextPath}/exportExcel.do">导出</a>

	<input id="ss"/>
	<div id="mm" style="width:50px">
		<div data-options="name:'keywords',iconCls:'icon-search'">keywords</div>
	</div>
</div>
