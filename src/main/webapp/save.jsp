<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2021/7/11
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>添加账户</h1>
<form name="accountForm" action="${pageContext.request.contextPath}/account/save" method="post">
    名称:<input type="text" name="name"><br>
    账户金额:<input type="text" name="money"><br>
    <input type="submit" value="保存">
</form>
</body>
</html>
