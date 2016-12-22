
//加载完成就自动执行
$(document).ready(function(){

    //加载订单原料缺货信息
    $.getJSON( "/inventory/all/lack/", function( data ) {
        console.log(data);
        if (data.success == true){
            $.each( data.data, function( i, item ) {
                $("#table-body").append(
                    " <tr> " +
                    "<td>" + item.materialName + "</td> " +
                    "<td>" + item.totalOrderNeedWeight + "</td> " +
                    "<td>" + item.totalInventoryWeight + "</td> " +
                    "<td>" + item.lack + "</td> " +
                    " </tr>"
                );
            });
        }
    });

});



