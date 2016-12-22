

$('form').on('submit',function(e){
    e.preventDefault();

    var p = hex_md5($("#login-password").val());
    $.ajax({
        type:"post",
        url:"/login/",
        data: "accountId=" + $("#login-username").val() +
        "&password=" + p +
        "&userType=" + $("#userType").val(),
            //$("#loginform").serialize(),
        success:function (data) {
            console.info("返回值:",data);
            if (data.success == true){
                //alert("登录成功！");
                window.location.href = data.data;
            }else{
                alert(data.data);
            }
        }
    });
})

