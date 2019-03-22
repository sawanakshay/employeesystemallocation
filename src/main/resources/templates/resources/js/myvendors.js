var data = {};
var dataTable;
// var endPoint = "http://localhost:8082/";
var endPoint = "http://3.17.73.55:8080/inv/";
var baseUrl = endPoint+"api/v1/employeesystem";
var employeeSystemAllocation = {

    init : function() {
        employeeSystemAllocation.loademployeeSystemAllocationData();
    },

    loademployeeSystemAllocationData : function(data) {

        $(".outer-loader").show();
        common.ajaxGet(baseUrl, function(response) {

            if(response.status == "200") {
                console.log(response);
                data = response.responseJSON;
            }else{

            }
            $(".outer-loader").hide();

            $('#employeeSystemAllocationListTableBody').empty();
            if(dataTable!=null && dataTable !=undefined) {
                dataTable.clear();
                // dataTable.destroy();
            }

            var employeeSystemAllocationlistbody = "";
            $.each(data,function(index, obj){
                employeeSystemAllocationlistbody = employeeSystemAllocationlistbody.concat("<tr><td>"
                    +(index+1)   +"</td><td>"
                    +obj.employee+"</td><td>"
                    +obj.system+"</td><td>"
                    +"</tr>");
            });

            $("#employeeSystemAllocationListTableBody").append(employeeSystemAllocationlistbody);

            dataTable = $('#employeeSystemAllocationListTable').DataTable({
                'aoColumnDefs': [{
                    'bSortable': false,
                    'aTargets': [3] /* 1st one, start by the left */
                },
                {
                    "targets": [ 3 ],
                    "visible": false,
                    "searchable": false
                }],
                "dom": 'lBfrtip',
                "buttons": [
                    {
                        extend : 'pdfHtml5',
                        title : common.dateFormat('employeeSystemAllocation'),
                        exportOptions: {
                                columns: ':visible'
                            },
                        orientation : 'landscape',
                        pageSize : 'A2',
                        text : '<i class="fa fa-file-pdf-o"> PDF</i>',
                        titleAttr : 'PDF'
                    } ,
                    {
                        extend : 'excel',
                        title :  common.dateFormat('employeeSystemAllocation'),
                        text : '<i class="fa fa-file-excel-o" aria-hidden="true"> Excel</i>',
                        titleAttr : 'Excel'
                    },
                    {
                        extend: 'print',
                        autoPrint: true,
                        title : common.dateFormat('employeeSystemAllocation'),
                        pageSize : 'A2',
                        text : '<i class="fa fa-print" aria-hidden="true"> Print</i>',
                        exportOptions: {
                            columns: ':visible',
                        },
                        customize: function (win) {
                            $(win.document.body).find('table').addClass('display').css('font-size', '9px');
                            $(win.document.body).find('table').addClass('display').css('width', '100%');
                            $(win.document.body).find('tr:nth-child(odd) td').each(function(index){
                                $(this).css('background-color','#D0D0D0');
                            });
                            $(win.document.body).find('h1').css('text-align','center');
                        }
                    }
                ],
                "pagingType":"numbers",
                "pageLength":10,
                "lengthMenu": [ [ 5, 10, 15, 25, 50, -1 ], [5, 10, 15, 25, 50, "All" ] ]
            });
        });
    },
}

$(document).ready(function() {
    employeeSystemAllocation.init();
});
