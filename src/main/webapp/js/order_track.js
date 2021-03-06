

//提交表单、返回原料流程信息
$('form').on('submit', function (e) {
    console.info("表单post提交内容:" + $("#orderId").val());
    $("#table-body").empty(); //清空原来展示的数据

    e.preventDefault();
    $.ajax({
        type: "get",
        url: "/order_track/" + $("#orderId").val() + "/",
        success: function( data ) {
            console.log(data);
            if (data.success == true){
                $.each( data.data, function( i, item ) {
                    $("#table-body").append(
                        " <tr> " +
                        "<td>" + item.orderId + "</td> " +
                        "<td>" + item.userName + "</td> " +
                        "<td>" + item.action + "</td> " +
                        "<td>" + item.actionTime + "</td> " +
                        " </tr>"
                    );
                });
            }else{
                alert("订单不存在！");
            }
        }
    });
});
