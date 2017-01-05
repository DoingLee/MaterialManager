<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>物料管理系统</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <!-- 引入 Bootstrap -->
  <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

  <link href="/css/order_track.css" rel="stylesheet" type="text/css"/>

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
    <ul class="nav nav-tabs" role="tablist", id="tablist">
      <li role="presentation"><a href="/user/page/all/">所有用户</a></li>
      <li role="presentation"><a href="/user/page/add/">添加用户</a></li>
      <li role="presentation"class="active"><a href="">配料流水</a></li>
    </ul>
  </div>

  <%--根据订单号查询订单表单--%>
  <div id="form-div">
    <form class="form-horizontal" role="form" id="form">
      <div class="form-group">
        <label for="orderId" class="col-sm-2 control-label">订单号：</label>
        <div class="col-sm-10">
          <input type="number" class="form-control" id="orderId" name="orderId">
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button type="submit" class="btn btn-success">查询</button>
        </div>
      </div>
    </form>
  </div>

  <%--查询结果--%>
  <div id="table-div">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h3 class="panel-title" id="product-name-title">配料流水</h3>
      </div>
      <%--步骤表格--%>
      <div class="panel-body">
        <table class="table">
          <thead>
          <tr>
            <th>订单号</th>
            <th>操作员</th>
            <th>动作</th>
            <th>时间</th>
          </tr>
          </thead>
          <tbody id="table-body">
          <%--待查询插入--%>
          <%--<tr>--%>
          <%--<td>订单号</td>--%>
          <%--<td>操作员</td>--%>
          <%--<td>动作</td>--%>
          <%--<td>时间</td>--%>
          <%--</tr>--%>
          </tbody>
        </table>
      </div>
    </div>
  </div>

</div>

<%--主体内容结束--%>

<jsp:include page="footer.jsp"/>

<script src="https://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="/js/order_track.js" type="text/javascript"></script>

</body>

</html>
