
//加载完成就自动执行
$(document).ready(function(){

    //从cookie中获取用户类型信息
    var userTypeString = getCookie("userType");


    //加载用户
    $.getJSON( "/user/", function( data ) {
        console.log(data);
        if (data.success == true){
            $.each( data.data, function( i, item ) {
                if ( userTypeString == "manager" && (item.userType == "超级管理员" || item.userType == "管理员" ) ){
                    //不显示该行
                }else{
                    $("#table-body").append(
                        "<tr> " +
                        "<td id = \"user_id_" + i + "\">" + item.accountId + "</td> " +
                        "<td>" +  item.userName + "</td> " +
                        "<td>" + item.userType + "</td>" +
                        "<td> <button type=\"button\" class=\"btn btn-danger\" id=\"btn_danger_" + i + "\">" +
                        "删除</button> </td>" +
                        " </tr>");
                }
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


function getCookie(name) {
    var value = "; " + document.cookie;
    var parts = value.split("; " + name + "=");
    if (parts.length == 2) return parts.pop().split(";").shift();
}


