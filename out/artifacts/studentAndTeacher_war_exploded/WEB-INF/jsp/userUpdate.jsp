<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/util/head.jsp"%>


<div class="row clearfix" id="IBody">
    <div class="col-md-12 column">
        <h3 class="text-center" >
            修改用户
        </h3>
    </div>

    <div class="col-md-12 column">
        <ul class="breadcrumb">
            <li>
                <a href="${pageContext.request.contextPath }/toWelcome">首页</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/user/queryUser">用户管理</a>
            </li>
            <li class="active">
                <span class="pathId"></span>
            </li>
        </ul>
    </div>

    <div class="col-md-12 column">
        <form class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/user/updateUser">
            <input type="hidden" name="id" value="${thisUser.id}"/>
            <div class="form-group">
                <label class="col-sm-2 control-label">用户ID</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputUserCode" name="userCode" value="${thisUser.userCode}"/>
                    <%--错误提示--%>
                    <font color="red"></font>
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-2 control-label">用户名</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputUserName" name="userName" value="${thisUser.userName}"/>
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-2 control-label">用户类型</label>
                <div class="col-sm-10">
                    <select name="userType" id="userType">

                        <c:choose>
                            <c:when test="${thisUser.userType == 0 }">
                                <option value="0" selected="selected">系统管理员</option>
                                <option value="1">学生</option>
                                <option value="2">老师</option>
                            </c:when>
                            <c:when test="${thisUser.userType == 1 }">
                                <option value="0">系统管理员</option>
                                <option value="1" selected="selected">学生</option>
                                <option value="2">老师</option>
                            </c:when>
                            <c:otherwise>
                                <option value="0">系统管理员</option>
                                <option value="1">学生</option>
                                <option value="2" selected="selected">老师</option>
                            </c:otherwise>
                        </c:choose>

                        <%--<c:forEach items="${roleList}" var="role">--%>
                            <%--<option value="${role.userType}">${role.roleName}</option>--%>
                        <%--</c:forEach>--%>
                    </select>

                </div>
            </div>

            <div class="form-group">
                <label  class="col-sm-2 control-label">密码</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputPassword" name="password" value="${thisUser.password}"/>
                </div>
            </div>

            <div class="form-group">
                <label  class="col-sm-2 control-label">电话</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputPhone" name="phone" value="${thisUser.phone}" />
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-2 control-label">备注</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputPost" name="post" value="${thisUser.post}"/>
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
