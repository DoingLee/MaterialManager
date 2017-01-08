<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>物料管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <link rel="stylesheet" href="/calendar/css/application.css" />
    <%--<link rel="stylesheet" href="/calendar/css/home.css" />--%>

    <link href="/css/report.css" rel="stylesheet" type="text/css"/>

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
            <li role="presentation"><a href="/user/page/add/">添加用户</a></li>
            <li role="presentation"><a href="/order_track/page/manager/">配料流水</a></li>
            <li role="presentation" ><a href="/order/page/check/manager/">查看订单</a></li>
            <li role="presentation"class="active"><a href="">统计报表</a></li>
        </ul>
    </div>

    <%--内容--%>
    <div id="container" >

        <div id="search-time">
            <div class="daterange daterange--double one" style="margin-top: 30px"></div>
            <div class="margin">
                <button type="button" class="btn btn-primary" id="btn_search">查询</button>
            </div>
        </div>


        <div id="report-body" class="margin">

            <%--订单统计信息--%>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title" >订单统计信息</h3>
                </div>
                <%--步骤表格--%>
                <div class="panel-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>完成订单数量</th>
                            <th>挂单数量</th>
                        </tr>
                        </thead>
                        <tbody id="order-table-body">
                        <%--待查询插入--%>
                        <%--<tr>--%>
                        <%--<td>1</td>--%>
                        <%--<td>1</td>--%>
                        <%--</tr>--%>
                        </tbody>
                    </table>
                </div>
            </div>

            <%--时间统计信息--%>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title" >工单统计信息</h3>
                    </div>
                    <%--步骤表格--%>
                    <div class="panel-body">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>平均处理工单时间</th>
                                <th>平均取料时间（工单）</th>
                                <th>平均取料时间（单个原料）</th>
                                <th>平均复核时间（工单）</th>
                                <th>平均复核时间（单个原料）</th>
                                <th>平均投料时间（工单）</th>
                                <th>平均投料时间（单个原料）</th>
                            </tr>
                            </thead>
                            <tbody id="time-table-body">
                            <%--待查询插入--%>
                            <%--<tr>--%>
                            <%--<td>1</td>--%>
                            <%--<td>1</td>--%>
                            <%--<td>1</td>--%>
                            <%--<td>1</td>--%>
                            <%--<td>1</td>--%>
                            <%--<td>1</td>--%>
                            <%--<td>1</td>--%>
                            <%--</tr>--%>
                            </tbody>

                        </table>
                    </div>
                </div>

        </div>


    </div>

</div>

<%--主体内容结束--%>

<jsp:include page="footer.jsp"/>

<%--<script src="https://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>--%>
<script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="/calendar/js/vendor/jquery.js"></script>
<script src="/calendar/js/vendor/moment.js"></script>

<script src="/calendar/js/Calendar.js"></script>

<script src="/js/report.js" type="text/javascript"></script>


</body>

</html>
