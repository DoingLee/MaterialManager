

$('form').on('submit',function(e){

    e.preventDefault();
    $.ajax({
        type:"post",
        url:"/login/",
        data: $("#loginform").serialize(),
        success:function (data) {
            console.info("返回值:",data);
            if (data.success == true){
                alert("登录成功！");
            }else{
                alert("登录失败！");
            }
        }
    });
})

