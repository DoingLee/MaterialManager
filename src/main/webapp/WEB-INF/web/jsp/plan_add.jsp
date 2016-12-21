<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>物料管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <link href="/css/plan_add.css" rel="stylesheet" type="text/css"/>

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
            <li role="presentation" class="active"><a href="#">添加生产流程</a></li>
            <li role="presentation"><a href="/QRname/page/check/">查看名称素材</a></li>
            <li role="presentation"><a href="/QRname/page/add/">添加名称素材</a></li>
        </ul>
    </div>

    <%--内容--%>
    <div class="container" style="width:60%">
        <h2>添加生产流程</h2>

        <form id="form" action="/user/" method="post">
            <div class="form-group">
                <label for="productName">产品名称:</label>
                <input type="text" class="form-control" id="productName" name="productName" placeholder="">
            </div>
            <div class="form-group">
                <label for="processOrder">步骤:</label>
                <input type="number" class="form-control" id="processOrder" name="processOrder" placeholder="">
            </div>
            <div class="form-group">
                <label for="materialName">原料</label>
                <select class="form-control" id="materialName" name="materialName">
                    <%--待插入选项--%>
                    <%--<option>root</option>--%>
                    <%--<option>warehouse_manager</option>--%>
                    <%--<option>product_planer</option>--%>
                    <%--<option>line_worker</option>--%>
                </select>
            </div>
            <div class="form-group">
                <label for="weight">质量(g):</label>
                <input type="text" class="form-control" id="weight" name="weight" placeholder="">
            </div>
            <div class="form-group">
                <label for="blenderName">混料罐</label>
                <select class="form-control" id="blenderName" name="blenderName">
                    <%--待插入选项--%>
                    <%--<option>root</option>--%>
                    <%--<option>warehouse_manager</option>--%>
                    <%--<option>product_planer</option>--%>
                    <%--<option>line_worker</option>--%>
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

<script src="/js/plan_add.js" type="text/javascript"></script>

</body>

</html>
