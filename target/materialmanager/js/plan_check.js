

//提交表单、返回原料流程信息
$('form').on('submit', function (e) {
    console.info("表单post提交内容:" + $("#inputProduct").val());
    $("#table-body").empty(); //清空原来展示的数据

    e.preventDefault();
    $.ajax({
        type: "get",
        url: "/plan/" + $("#inputProduct").val() + "/",
        success: function( data ) {
            console.log(data);
            if (data.success == true){
                $.each( data.data, function( i, item ) {
                    $("#table-body").append(
                        "<tr> " +
                        "<td id = \"process_id_" + i + "\">" + item.processOrder + "</td> " +
                        "<td id = \"product_id_" + i + "\">" + item.productName + "</td> " +
                        "<td>" +  item.materialName + "</td> " +
                        "<td>" + item.weight + "</td>" +
                        "<td>" + item.blenderName + "</td>" +
                        "<td> <button type=\"button\" class=\"btn btn-danger\" id=\"btn_danger_" + i + "\">" +
                        "删除</button> </td>" +
                        " </tr>");
                });
            }else{
                alert("产品不存在！");
            }
        }
    });
});

//删除某个步骤按钮监听
$(document).on("click", ".btn-danger", function(){
    console.log("点击成功！");
    var btn_danger = $(this).attr("id");
    var pos = btn_danger.charAt(btn_danger.length - 1);
    var process_order = $("#" + "process_id_" + pos).text();
    var product_name = $("#" + "product_id_" + pos).text();
    console.log("process_order：") + process_order;
    $.ajax({
        dataType: "json",
        type: "delete",
        url: "/plan/" + product_name + "/" + process_order + "/",
        success: function( data ) {
            console.log(data);
            if (data.success == true){
                $("#table-body").children("tr")[pos].remove();
                alert("删除成功！");
            }else{
                alert("删除失败！");
            }
        }
    });
} );

//删除整个产品按钮监听
$(document).on("click", "#btn_delete_product", function(){
    console.log("input内容：" +  $("#inputProduct").val());
    $.ajax({
        dataType: "json",
        type: "delete",
        url: "/plan/" + $("#inputProduct").val() + "/",
        success: function( data ) {
            console.log(data);
            if (data.success == true){
                $("#table-body").empty();
                alert("删除成功！");
            }else{
                alert("删除失败！");
            }
        }
    });
} );