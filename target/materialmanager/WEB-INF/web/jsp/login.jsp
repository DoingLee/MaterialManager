<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>物料管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <link href="/css/login.css" rel="stylesheet" type="text/css"/>

    <!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
    <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<%--<jsp:include page="header.jsp"/>--%>

<%--主体内容--%>
<div class="container">
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-primary">

            <div class="panel-heading">
                <div class="panel-title">物料防错管理系统</div>
            </div>

            <div style="padding-top:30px" class="panel-body">

                <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>

                <form id="loginform" class="form-horizontal" role="form">

                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input id="login-username" type="text" class="form-control" name="accountId" value=""
                               placeholder="用户账号">
                    </div>

                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input id="login-password" type="password" class="form-control" name="password"
                               placeholder="密码">
                    </div>

                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-leaf"></i></span>
                        <select class="form-control" id="userType" name="userType">
                            <option>管理员</option>
                            <option>超级管理员</option>
                            <option>用户管理员</option>
                            <option>产品设计员</option>
                            <option>仓库管理员</option>
                        </select>
                    </div>

                    <div style="margin-top:10px" class="form-group">
                        <!-- Button -->
                        <div class="col-sm-12 controls">
                            <button type="submit" id="btn-login" class="btn btn-success">登录</button>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-12 control">
                            <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                                <a href="#" onClick="$('#loginbox').hide(); $('#signupbox').show()">
                                    修改密码
                                </a>
                            </div>
                        </div>
                    </div>

                </form>

            </div>
        </div>
    </div>
</div>


<%--主体内容结束--%>

<jsp:include page="footer.jsp"/>

<script src="https://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="/js/md5.js" type="text/javascript"></script>
<script src="/js/login.js" type="text/javascript"></script>

</body>

</html>


