<%--
  Created by IntelliJ IDEA.
  User: ZERO
  Date: 2021/6/5
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link href="/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">


    <style type="text/css">
        .info{
            color: red;
            font-weight:bold;
            text-align: center;
        }
    </style>
</head>
<script src="/static/bootstrap/js/bootstrap.min.js"></script>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                欢迎登陆

            </h3>
            <div></div>


            <form class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/login">
                <div class="info">${requestScope.msg}</div>
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="inputEmail3" name="username"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="inputPassword3" name="password"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <div class="checkbox">
                            <label><input type="checkbox" />记住密码</label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">提交</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
