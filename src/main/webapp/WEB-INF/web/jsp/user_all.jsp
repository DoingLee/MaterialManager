<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>物料管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <link href="/css/user_all.css" rel="stylesheet" type="text/css"/>

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
    <div>
        <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active"><a href="#">所有用户</a></li>
            <li role="presentation"><a href="/user/page/add/">添加用户</a></li>
        </ul>
    </div>

    <div>
        <table class="table" >
            <caption>用户信息</caption>
            <thead>
            <tr>
                <th>账号</th>
                <th>姓名</th>
                <th>权限</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody id="table-body">
            <%--待查询插入--%>
            </tbody>

            <%--<tbody>--%>
            <%--<tr>--%>
                <%--<td>00000</td>--%>
                <%--<td>测试者</td>--%>
                <%--<td>无</td>--%>
                <%--<td>--%>
                    <%--<button type="button" class="btn btn-danger">删除</button>--%>
                <%--</td>--%>
            <%--</tr>--%>
            <%--</tbody>--%>

        </table>
    </div>
</div>

<%--主体内容结束--%>

<jsp:include page="footer.jsp"/>

<script src="https://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="/js/user_all.js" type="text/javascript"></script>

</body>

</html>
