

//加载完成后插入原料、混料罐选项
$(document).ready(function(){

    //监听添加原料名提交表单按钮
    $('#material-name-form').on('submit',function(e){
        console.info("表单post提交内容:" + $("#material-name-form").serialize());

        e.preventDefault();
        $.ajax({
            dataType: "json",
            type:"post",
            url:"/QRname/material/",
            data: $("#material-name-form").serialize(),
            success:function (data) {
                console.info("返回值:",data);
                if (data.success == true){
                    alert("添加成功！");
                    var name = $("#material_name").val();
                    $("#material-qrCode").attr("src","http://qr.liantu.com/api.php?text=" + name);
                }else{
                    alert("添加失败！");
                }
            }
        });
    })

    //监听添加混料罐名提交表单按钮
    $('#blender-name-form').on('submit',function(e){
        console.info("表单post提交内容:" + $("#blender-name-form").serialize());

        e.preventDefault();
        $.ajax({
            type:"post",
            url:"/QRname/blender/",
            data: $("#blender-name-form").serialize(),
            success:function (data) {
                console.info("返回值:",data);
                if (data.success == true){
                    alert("添加成功！");
                    var name = $("#blender_name").val();
                    $("#blender-qrCode").attr("src","http://qr.liantu.com/api.php?text=" + name);
                }else{
                    alert("添加失败！");
                }
            }
        });
    })

})
