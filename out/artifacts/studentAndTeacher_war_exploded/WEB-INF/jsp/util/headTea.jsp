<%--
  Created by IntelliJ IDEA.
  User: ZERO
  Date: 2021/6/6
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>课程管理系统</title>
    <link href="/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <style type="text/css">
        .footer{
            height: 150px;
            background-color: #fbffff;
        }

        /*#IBody{*/
            /*height: 700px;*/
        /*}*/
    </style>


</head>
<script src="/static/bootstrap/js/bootstrap.min.js"></script>
<script src="/static/bootstrap/js/jquery.min.js"></script>

<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <ul class="nav nav-tabs">
                <li class="active">
                    <a href="${pageContext.request.contextPath }/toWelcome">首页</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath }/user/queryUser">学生管理</a>
                </li>
                <li class="">
                    <a href="${pageContext.request.contextPath }/course/queryCourse">课程管理</a>
                </li>
                <li class="">
                    <a href="${pageContext.request.contextPath }/selectCourse/querySelectCourse">选课管理</a>
                </li>

                <li class="dropdown pull-right">
                    <a href="${pageContext.request.contextPath }/logout">退出登录</a>
                </li>
            </ul>

