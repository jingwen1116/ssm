<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/util/headTea.jsp"%>


<div class="row clearfix" id="IBody">
    <div class="col-md-12 column">
        <h3 class="text-center" >
            修改课程
        </h3>
    </div>

    <div class="col-md-12 column">
        <ul class="breadcrumb">
            <li>
                <a href="${pageContext.request.contextPath }/toWelcome">首页</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/course/queryCourse">课程管理</a>
            </li>
            <li class="active">
                <span class="pathId"></span>
            </li>
        </ul>
    </div>

    <div class="col-md-12 column">
        <form class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/course/updateCourse">
            <input type="hidden" name="cid" value="${course.cid}"/>
            <div class="form-group">
                <label class="col-sm-2 control-label">课程名称</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputUserCode" name="courseName" value="${course.courseName}"/>
                    <%--错误提示--%>
                    <font color="red"></font>
                </div>
            </div>

            <div class="form-group">
                <label  class="col-sm-2 control-label">选择教师</label>
                <div class="col-sm-10">
                    <select name="userCode" id="userCode">
                        <c:forEach items="${userList}" var="userList">
                            <c:choose>
                                <c:when test="${userList.userCode==course.userCode}">
                                    <option value="${userList.userCode}" selected="selected">${userList.userName}</option>
                                </c:when>
                            </c:choose>
                        </c:forEach>

                        <%--<c:forEach items="${roleList}" var="role">--%>
                            <%--<option value="${role.userType}">${role.roleName}</option>--%>
                        <%--</c:forEach>--%>
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
