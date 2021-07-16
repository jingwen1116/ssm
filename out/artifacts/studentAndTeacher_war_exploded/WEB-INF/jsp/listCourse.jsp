<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/util/head.jsp"%>


<div class="row clearfix" id="IBody">
    <div class="col-md-12 column">
        <h3 class="text-center" >
            课程管理列表
        </h3>
    </div>

    <div class="col-md-8 column">
        <form id="userForm" method="post" action="${pageContext.request.contextPath}/course/queryCourse">
            <input name="method" value="query" class="input-text" type="hidden">
            <span>课程名：</span>
            <input name="courseName" class="input-text"	type="text" value="${courseName}">

            <span>授课老师：</span>
            <input name="userName" class="input-text" type="text" value="${userName}">

            <input type="hidden" name="pageIndex" value="1"/>
            <input	value="查 询" type="submit" id="searchbutton">
        </form>

    </div>

    <div class="col-md-4 column">
        <a href="${pageContext.request.contextPath}/course/toAddCourse"> <button type="button" class="btn btn-success btn-sm">添加课程</button> </a>
    </div>


    <div class="col-md-12 column">
        <table class="table table-hover table-striped table-bordered">
            <thead>
                <tr>
                    <th>课程名称</th>
                    <th>老师号</th>
                    <th>授课老师</th>
                    <th>操作</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="courseList" items="${courseList}">
                    <tr>
                        <td>${courseList.courseName}</td>
                        <td>${courseList.userCode}</td>
                        <td>${courseList.userName}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/course/toUpdateCourse?cid=${courseList.cid}"> <button type="button" class="btn btn-default btn-warning">修改</button> </a>
                            <span> | </span>
                            <a href="${pageContext.request.contextPath}/course/deleteCourse?cid=${courseList.cid}" onclick="delcfm()"> <button type="button" class="btn btn-default btn-danger">删除</button> </a>
                            <div style="color: red">${requestScope.msg}</div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
        <!--引入翻页控件， 需给定三个参数 ：记录总数、当前第几页、总共几页-->
        <c:import url="rollpage.jsp">
            <c:param name="totalCount">${totalCount}</c:param>
            <c:param name="currentPageNo">${currentPageNo}</c:param>
            <c:param name="totalPageCount">${totalPageCount}</c:param>
        </c:import>

    </div>

</div>
</div>
</div>
</div>

<%@include file="/WEB-INF/jsp/util/foot.jsp" %>
