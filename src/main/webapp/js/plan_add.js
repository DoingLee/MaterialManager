

//加载完成后插入原料、混料罐选项
$(document).ready(function(){

    //加载混料罐选项
    $.getJSON( "/QRname/blender/", function( data ) {
        console.log(data);
        if (data.success == true){
            $.each( data.data, function( i, item ) {
                $("#blenderName").append(
                    "<option>" + item + "</option>"
                );
            });
        }
    });

    //加载原料选项
    $.getJSON( "/QRname/material/", function( data ) {
        console.log(data);
        if (data.success == true){
            $.each( data.data, function( i, item ) {
                $("#materialName").append(
                    "<option>" + item + "</option>"
                );
            });
        }
    });

    //监听提交表单按钮
    $('form').on('submit',function(e){
        console.info("表单post提交内容:" + $("#form").serialize());

        e.preventDefault();
        $.ajax({
            type:"post",
            url:"/plan/",
            data: $("#form").serialize(),
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


})
