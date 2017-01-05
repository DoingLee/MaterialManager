<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>物料管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <link href="/css/user_add.css" rel="stylesheet" type="text/css"/>

    <!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
    <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<jsp:include page="header.jsp"/>

<%--主体内容--%>

<div id="main-div">
    <%--头部--%>
    <div>
        <ul class="nav nav-tabs" role="tablist" id="tablist">
            <li role="presentation"><a href="/user/page/all/">所有用户</a></li>
            <li role="presentation" class="active"><a href="#">添加用户</a></li>
            <li role="presentation"><a href="/order_track/page/manager/">配料流水</a></li>
        </ul>
    </div>

    <%--内容--%>
    <div class="container" style="width:60%">
        <h2>新用户</h2>

        <form id="form" action="/user/" method="post">
            <div class="form-group">
                <label for="accountId">账号ID:</label>
                <input type="text" class="form-control" id="accountId" name="accountId" placeholder="账号ID">
            </div>
            <div class="form-group">
                <label for="userName">用户姓名:</label>
                <input type="text" class="form-control" id="userName" name="userName" placeholder="用户姓名">
            </div>
            <div class="form-group">
                <label for="password">密码:</label>
                <input type="text" class="form-control" id="password" name="password" placeholder="密码">
            </div>
            <div class="form-group">
                <label for="userType">用户类型</label>
                <select class="form-control" id="userType" name="userType">
                    <option>取料操作员</option>
                    <option>投料操作员</option>
                    <option>产品设计员</option>
                    <option>仓库管理员</option>
                </select>
            </div>
            <button type="submit" class="btn btn-default">提交</button>
        </form>
    </div>

</div>

<%--主体内容结束--%>

<jsp:include page="footer.jsp"/>

<script src="https://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="/js/md5.js" type="text/javascript"></script>
<script src="/js/user_add.js" type="text/javascript"></script>

</body>

</html>
