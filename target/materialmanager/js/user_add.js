

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
})

