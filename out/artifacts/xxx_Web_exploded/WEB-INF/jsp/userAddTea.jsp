<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/util/headTea.jsp"%>


<div class="row clearfix" id="IBody">
    <div class="col-md-12 column">
        <h3 class="text-center" >
            添加用户
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
        <form class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/user/addUser">
            <div class="form-group">
                <label class="col-sm-2 control-label">用户ID</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputUserCode" name="userCode"/>
                    <%--错误提示--%>
                    <font color="red"></font>
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-2 control-label">用户名</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputUserName" name="userName"/>
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-2 control-label">用户类型</label>
                <div class="col-sm-10">
                    <%--<input type="text" class="form-control" id="inputUserType" name="userType"/>--%>
                    <select name="userType" id="userType">
                        <option value="1">学生</option>

                    </select>

                </div>
            </div>

            <div class="form-group">
                <label  class="col-sm-2 control-label">密码</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="inputPassword" name="password"/>
                </div>
            </div>

            <div class="form-group">
                <label  class="col-sm-2 control-label">电话</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputPhone" name="phone"/>
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-2 control-label">备注</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputPost" name="post"/>
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
