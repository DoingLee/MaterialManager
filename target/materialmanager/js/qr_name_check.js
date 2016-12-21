

//加载完成就自动执行
$(document).ready(function(){

    //加载混料罐名
    $.getJSON( "/QRname/blender/", function( data ) {
        console.log(data);
        if (data.success == true){
            $.each( data.data, function( i, item ) {
                $("#blender-table-body").append(
                    "<tr> " +
                    "<td>" + item + "</td> " +
                    "<td> " +
                    "<img src=\" http:\/\/qr.liantu.com/api.php?text=" + item + "\" " +
                    "class=\"img-responsive\" alt=\"Responsive image\">" +
                    "</td >" +
                    "</tr> "
                );
            });
        }else{
            alert("加载混料罐名失败！")
        }
    });

    //加载原料名
    $.getJSON( "/QRname/material/", function( data ) {
        console.log(data);
        if (data.success == true){
            $.each( data.data, function( i, item ) {
                $("#material-table-body").append(
                    "<tr> " +
                    "<td>" + item + "</td> " +
                    "<td> " +
                    "<img src=\" http:\/\/qr.liantu.com/api.php?text=" + item + "\" " +
                    "class=\"img-responsive\" alt=\"Responsive image\">" +
                    "</td >" +
                    "</tr> "
                );
            });
        }else{
            alert("加载原料名失败！")
        }
    });

});



