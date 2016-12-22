
//加载完成就自动执行
$(document).ready(function(){

    //加载订单
    $.getJSON( "/order/all/", function( data ) {
        console.log(data);
        if (data.success == true){
            $.each( data.data, function( i, item ) {
                $("#table-body").append(
                    " <tr> " +
                    "<td>" + item.orderId + "</td> " +
                    "<td>" + item.productName + "</td> " +
                    "<td>" + item.count + "</td> " +
                    "<td>" + item.status + "</td> " +
                    "<td>" + item.clientName + "</td> " +
                    "<td>" + item.clientTel + "</td>" +
                    " </tr>"
                );
            });
        }
    });

});



