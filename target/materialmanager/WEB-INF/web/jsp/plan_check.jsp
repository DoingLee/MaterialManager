<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>物料管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <link href="/css/plan_check.css" rel="stylesheet" type="text/css"/>

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
            <li role="presentation" class="active"><a href="#">查看生产流程</a></li>
            <li role="presentation"><a href="/plan/page/add/">添加生产流程</a></li>
            <li role="presentation"><a href="/QRname/page/check/">查看名称素材</a></li>
            <li role="presentation"><a href="/QRname/page/add/">添加名称素材</a></li>
        </ul>
    </div>

    <%--查询产品生产计划表单--%>
    <div id="form-div">
        <form class="form-horizontal" role="form" id="form">
            <div class="form-group">
                <label for="inputProduct" class="col-sm-2 control-label">产品名称：</label>

                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputProduct" name="productName">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-success">查询生产计划</button>
                </div>
            </div>
        </form>
    </div>

    <%--查询结果--%>
    <div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title" id="product-name-title">产品流程</h3>
            </div>
            <%--步骤表格--%>
            <div class="panel-body">
                <table class="table">
                    <thead>
                    <tr>
                        <th>步骤</th>
                        <th>产品名称</th>
                        <th>原料</th>
                        <th>质量(g)</th>
                        <th>混料罐</th>
                        <th>删除</th>
                    </tr>
                    </thead>
                    <tbody id="table-body">
                    <%--待查询插入--%>
                    </tbody>
                    <%--<tbody>--%>
                    <%--<tr>--%>
                        <%--<td>1</td>--%>
                        <%--<td>原料1</td>--%>
                        <%--<td>100</td>--%>
                        <%--<td>混料罐1</td>--%>
                        <%--<td>--%>
                            <%--<button type="button" class="btn btn-danger">删除</button>--%>
                        <%--</td>--%>
                    <%--</tr>--%>
                    <%--</tbody>--%>

                </table>
            </div>
        </div>
        <button type="button" class="btn btn-warning" id="btn_delete_product">删除所有步骤</button>
    </div>

</div>

<%--主体内容结束--%>

<jsp:include page="footer.jsp"/>

<script src="https://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="/js/plan_check.js" type="text/javascript"></script>

</body>

</html>
