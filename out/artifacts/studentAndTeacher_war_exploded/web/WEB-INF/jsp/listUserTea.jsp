<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/util/headTea.jsp"%>


<div class="row clearfix" id="IBody">
    <div class="col-md-12 column">
        <h3 class="text-center" >
            用户管理列表
        </h3>
    </div>

    <div class="col-md-8 column">
        <form id="userForm" method="post" action="${pageContext.request.contextPath}/user/queryUser">
            <input name="method" value="query" class="input-text" type="hidden">
            <span>用户名：</span>
            <input name="queryUserName" class="input-text"	type="text" value="${queryUserName}">

            <span>用户角色：</span>
            <select name="userType">
                <option value="">--请选择--</option>
                <c:forEach items="${roleList}" var="role">
                    <c:choose>
                        <c:when test="${userType==role.userType}" >
                            <option selected="selected" value="${role.userType }">${role.roleName}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${role.userType }">${role.roleName}</option>
                        </c:otherwise>
                    </c:choose>
                    <%--<option <c:if test="${role.userType==userType}"> selected="selected"</c:if> value="${role.userType }">${role.roleName}</option>--%>
                </c:forEach>

            </select>

            <input type="hidden" name="pageIndex" value="1"/>
            <input	value="查 询" type="submit" id="searchbutton">
        </form>

    </div>

    <div class="col-md-4 column">
        <a href="${pageContext.request.contextPath}/user/toAddUser"> <button type="button" class="btn btn-success btn-sm">添加用户</button> </a>
    </div>


    <div class="col-md-12 column">
        <table class="table table-hover table-striped table-bordered">
            <thead>
                <tr>
                    <th>账号</th>
                    <th>名字</th>
                    <th>类型</th>
                    <th>密码</th>
                    <th>手机号</th>
                    <th>备注</th>
                    <th>操作</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="userlist" items="${userlist}">
                    <tr>
                        <td>${userlist.userCode}</td>
                        <td>${userlist.userName}</td>
                        <td>${userlist.roleName}</td>
                        <td>${userlist.password}</td>
                        <td>${userlist.phone}</td>
                        <td>${userlist.post}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/user/toUpdateUser?id=${userlist.id}"> <button type="button" class="btn btn-default btn-warning">修改</button> </a>
                            <span> | </span>
                            <a href="${pageContext.request.contextPath}/user/deleteUser?id=${userlist.id}" onclick="delcfm()"> <button type="button" class="btn btn-default btn-danger">删除</button> </a>
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
