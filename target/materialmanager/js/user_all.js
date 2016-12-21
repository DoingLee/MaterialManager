
//加载完成就自动执行
$(document).ready(function(){

    //加载用户
    $.getJSON( "/user/", function( data ) {
        console.log(data);
        if (data.success == true){
            $.each( data.data, function( i, item ) {
                $("#table-body").append(
                "<tr> " +
                "<td id = \"user_id_" + i + "\">" + item.accountId + "</td> " +
                "<td>" +  item.userName + "</td> " +
                "<td>" + item.userType + "</td>" +
                "<td> <button type=\"button\" class=\"btn btn-danger\" id=\"btn_danger_" + i + "\">" +
                "删除</button> </td>" +
                " </tr>");
            });
        }
    });

    //删除按钮监听
    $(document).on("click", ".btn-danger", function(){
        console.log("点击成功！");
        var btn_danger = $(this).attr("id");
        var pos = btn_danger.charAt(btn_danger.length - 1);
        var user_id = $("#" + "user_id_" + pos).text();
        console.log("user_id：") + user_id;
        $.ajax({
            dataType: "json",
            type: "delete",
            url: "/user/" + user_id + "/",
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

});



