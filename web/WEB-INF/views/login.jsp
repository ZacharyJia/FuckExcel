<%--
  User: zachary
  Date: 16/7/9
  Time: 下午10:59
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息采集系统登录</title>
    <%@include file="common/include.jsp"%>
</head>
<body>
    <div class="container">
        <div class="col-sm-6 col-sm-offset-3">
            <h1 class="text-center">信息采集系统登录</h1>
        </div>
        <div class="col-sm-6 col-sm-offset-3">
            <form action="/doLogin" method="post">
                <div class="form-group">
                    <label for="username">用户名</label>
                    <input type="text" class="form-control" id="username" name="username" placeholder="用户名">
                </div>
                <div class="form-group">
                    <label for="password">密码</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="密码">
                </div>
                <div class="form-group">
                    <label for="role">登录身份</label>
                    <select class="form-control" id="role" name="role">
                        <option value="user">普通用户</option>
                        <option value="admin">管理员</option>
                        <option value="super_admin">系统管理员</option>
                    </select>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-default">登录</button>
                </div>
            </form>
        </div>

    </div>

<%@include file="common/footer.jsp"%>
</body>
</html>
