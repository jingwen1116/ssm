<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/util/headTea.jsp"%>


<div class="row clearfix" id="IBody">
    <div class="col-md-12 column">
        <h3 class="text-center" >
            添加选课
        </h3>
    </div>

    <div class="col-md-12 column">
        <ul class="breadcrumb">
            <li>
                <a href="${pageContext.request.contextPath }/toWelcome">首页</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/selectCourse/querySelectCourse">课程管理</a>
            </li>
            <li class="active">
                <span class="pathId"></span>
            </li>
        </ul>
    </div>

    <div class="col-md-12 column">
        <form class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/selectCourse/addSelectCourse">

            <div class="form-group">
                <label  class="col-sm-2 control-label">学生姓名</label>
                <div class="col-sm-10">
                    <select name="sid" id="sid">
                        <c:forEach items="${userList}" var="user">
                            <option value="${user.id}">${user.userName}</option>
                        </c:forEach>
                    </select>

                </div>
            </div>

            <div class="form-group">
                <label  class="col-sm-2 control-label">课程名称</label>
                <div class="col-sm-10">
                    <select name="cid" id="cid">
                        <c:forEach items="${courseList}" var="courseList">
                            <c:if test="${user.userCode==courseList.userCode}">
                                <option value="${courseList.cid}">${courseList.courseName}</option>
                            </c:if>

                        </c:forEach>
                    </select>

                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">保存</button>
                </div>
            </div>
        </form>
    </div>
</div>
</div>
</div>
</div>

<%@include file="/WEB-INF/jsp/util/foot.jsp" %>
