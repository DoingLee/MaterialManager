<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>物料管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <link href="/css/inventory_add_weight.css" rel="stylesheet" type="text/css"/>

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
            <li role="presentation"><a href="/order/page/check/">查看订单</a></li>
            <li role="presentation"><a href="/inventory/page/check_lack/">订单原料缺货情况</a></li>
            <li role="presentation" class="active"><a href="">添加库存原料</a></li>
            <li role="presentation"><a href="/order_track/page/">配料流水</a></li>
        </ul>
    </div>

    <%--内容--%>
    <div id="form-panel-div">
        <%--添加原料质量--%>
        <div class="panel panel-default" >
            <div class="panel-heading">
                <h3 class="panel-title">增加原料质量</h3>
            </div>

            <div class="panel-body">
                <div class="container">
                    <form id="add-weight-form" class="my-form">
                        <div class="form-group">
                            <label for="materialName">原料名称:</label>
                            <select class="form-control" id="materialName" name="materialName">
                                <%--待添加可选原料名称--%>
                                <%--<option>line_worker</option>--%>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="weight">添加质量(g):</label>
                            <input type="number" class="form-control" id="weight" name="weight" placeholder="">
                        </div>
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>

        <%--添加新原料--%>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">添加新原料</h3>
            </div>
            <div class="panel-body">
                <div class="container">
                    <form id="add-material-form" class="my-form">
                        <div class="form-group">
                            <label for="materialName1">原料名称:</label>
                            <select class="form-control" id="materialName1" name="materialName">
                                <%--待添加可选原料名称--%>
                                <%--<option>line_worker</option>--%>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="location">位置:</label>
                            <input type="text" class="form-control" id="location" name="location" placeholder="">
                        </div>
                        <div class="form-group">
                            <label for="totalWeight">总质量:</label>
                            <input type="number" class="form-control" id="totalWeight" name="totalWeight" placeholder="">
                        </div>
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>

<%--主体内容结束--%>

<jsp:include page="footer.jsp"/>

<script src="https://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="/js/inventory_add_weight.js" type="text/javascript"></script>

</body>

</html>
