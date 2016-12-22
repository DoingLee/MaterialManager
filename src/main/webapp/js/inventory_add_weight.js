

//加载完成
$(document).ready(function(){

    //加载原料名称选项
    $.getJSON( "/QRname/material/", function( data ) {
        console.log(data);
        if (data.success == true){
            $.each( data.data, function( i, item ) {
                $("#materialName").append(
                    "<option>" + item + "</option>"
                );
                $("#materialName1").append(
                    "<option>" + item + "</option>"
                );
            });
        }
    });

    //监听添加质量提交表单按钮
    $('#add-weight-form').on('submit',function(e){
        console.info("表单post提交内容:" + $("#add-weight-form").serialize());

        e.preventDefault();
        $.ajax({
            type:"put",
            url:"/inventory/" + $("#materialName").val() + "/weight/",
            data: $("#add-weight-form").serialize(),
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

    //监听添加新材料提交表单按钮
    $('#add-material-form').on('submit',function(e){
        console.info("表单post提交内容:" + $("#add-material-form").serialize());

        e.preventDefault();
        $.ajax({
            type:"post",
            url:"/inventory/",
            data: $("#add-material-form").serialize(),
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
