<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>物料管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <link href="/css/qr_name_check.css" rel="stylesheet" type="text/css"/>

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
        <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" ><a href="/plan/page/check/">查看生产流程</a></li>
            <li role="presentation"><a href="/plan/page/add/">添加生产流程</a></li>
            <li role="presentation" class="active"><a href="#">查看名称素材</a></li>
            <li role="presentation"><a href="/QRname/page/add/">添加名称素材</a></li>
        </ul>
    </div>

    <%--原料名素材面板--%>
    <div id="material-div">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title" id="material-name-title">原料名素材</h3>
            </div>

            <%--表格--%>
            <table class="table">
                <tbody id="material-table-body">
                <%--待查询插入--%>
                <%--<tr>--%>
                    <%--<td>名字</td>--%>
                    <%--<td>--%>
                        <%--<img src="http://qr.liantu.com/api.php?text=名字" class="img-responsive" alt="Responsive image">--%>
                    <%--</td>--%>
                <%--</tr>--%>
                </tbody>
            </table>

        </div>
    </div>

    <%--混料罐名素材面板--%>
    <div id="blender-div">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title" id="blender-name-title">混料罐名素材</h3>
            </div>

            <%--表格--%>
            <table class="table">
                <tbody id="blender-table-body">
                <%--待查询插入--%>
                <%--<tr>--%>
                    <%--<td>名字</td>--%>
                    <%--<td>--%>
                        <%--<img src="http://qr.liantu.com/api.php?text=名字" class="img-responsive" alt="Responsive image">--%>
                    <%--</td>--%>
                <%--</tr>--%>
                </tbody>
            </table>

        </div>
    </div>
</div>


<%--主体内容结束--%>

<jsp:include page="footer.jsp"/>

<script src="https://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="/js/qr_name_check.js" type="text/javascript"></script>

</body>

</html>
