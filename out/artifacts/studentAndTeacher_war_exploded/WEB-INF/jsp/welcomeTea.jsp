<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/util/headTea.jsp"%>


            <div class="row clearfix" id="IBody">
                <div class="col-md-12 column">
                    <h3 class="text-center" >
                        欢迎你 ：${sessionScope.user.userName}
                    </h3>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/jsp/util/foot.jsp" %>