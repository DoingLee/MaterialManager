

$('#btn-login-out').on('click',function(e){

    //删除cookie
    console.info("cookie：  " + getCookie("key") );
    delete_cookie("key");
    console.info("cookie：  " + getCookie("key") );

    window.location.href = "http://" + window.location.host + "/login/page/"; //页面跳转

})

function getCookie(name) {
    var value = "; " + document.cookie;
    var parts = value.split("; " + name + "=");
    if (parts.length == 2) return parts.pop().split(";").shift();
}


function delete_cookie(name) {
    document.cookie = name +'=; Path=/; Expires=Thu, 01 Jan 1970 00:00:01 GMT;'; //删除cookie，必须显示声明path
}

