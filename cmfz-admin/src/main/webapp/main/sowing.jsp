<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" isELIgnored="false" %>


	<script>
        $(function(){
            var rows = [];
            for(var i=1; i<=10; i++){
                var amount = Math.floor(Math.random()*1000);
                var price = Math.floor(Math.random()*1000);
                rows.push({
                    inv: 'Inv No '+i,
                    date: $.fn.datebox.defaults.formatter(new Date()),
                    name: 'Name '+i,
                    amount: amount,
                    price: price,
                    cost: amount*price,
                    note: 'Note '+i
                });
            }
            $('#tt').datagrid({
                fitColumns:true,
				fit:true,
                detailFormatter: function(rowIndex, rowData){
                    return '<table><tr>' +
                        '<td style="border:0;padding-right:10px">' +
                        '<p>Name: ' + rowData.name + '</p>' +
                        '<p>Amount: ' + rowData.amount + '</p>' +
                        '</td>' +
                        '<td style="border:0">' +
                        '<p>Price: ' + rowData.price + '</p>' +
                        '<p>Cost: ' + rowData.cost + '</p>' +
                        '</td>' +
                        '</tr></table>';
                }
            }).datagrid('loadData', rows);
        });
	</script>

<table id="tt" style="width:700px;height:250px"
	   title="DataGrid - VirtualScrollView with Detail Rows"
	   data-options="view:scrollview,rownumbers:true,singleSelect:true,autoRowHeight:false,pageSize:50">
	<thead>
	<tr>
		<th field="inv" width="80">Inv No</th>
		<th field="date" width="90">Date</th>
		<th field="name" width="80">Name</th>
		<th field="amount" width="80" align="right">Amount</th>
		<th field="price" width="80" align="right">Price</th>
		<th field="cost" width="90" align="right">Cost</th>
		<th field="note" width="100">Note</th>
	</tr>
	</thead>
</table>

