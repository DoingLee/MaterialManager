

$(document).ready(function(){

    //从cookie中获取用户类型信息
    var userType = getCookie("userType");


    //可添加的用户类型
    if (userType == "manager"){

    }else if (userType == "super_manager"){
        $("#userType").append(
            "<option>管理员</option> " +
            "<option>超级管理员</option> "
        );
    }

    //监听添加按钮
    $('form').on('submit',function(e){
        console.info("表单post提交内容:" + $("#form").serialize());

        e.preventDefault();
        var p = hex_md5($("#password").val());
        $.ajax({
            type:"post",
            url:"/user/",
            data:
            "accountId=" + $("#accountId").val() +
            "&userName=" + $("#userName").val() +
            "&password=" + p +
            "&userType=" + $("#userType").val(),
            //$("#form").serialize(),
            success:function (data) {
                console.info("返回值:",data);
                if (data.success == true){
                    alert("添加成功！");
                }else{
                    alert("添加失败！");
                }
            }
        });
    });

})

function getCookie(name) {
    var value = "; " + document.cookie;
    var parts = value.split("; " + name + "=");
    if (parts.length == 2) return parts.pop().split(";").shift();
}


