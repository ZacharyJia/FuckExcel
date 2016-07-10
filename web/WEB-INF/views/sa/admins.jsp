<%--
  User: zachary
  Date: 16/7/10
  Time: 下午12:16
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统管理</title>
    <%@include file="../common/include.jsp"%>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">系统管理</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="home">主页<span class="sr-only">(current)</span></a></li>
                <li class="active"><a href="admins">管理员管理</a></li>
                <li><a href="users">用户管理</a></li>
                <li><a href="tags">标签管理</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${superAdmin.username}<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/logout">退出</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="col-sm-2">
        <button class="btn btn-block btn-primary" data-toggle="modal" data-target="#addAdminModal">增加管理员</button>
    </div>
    <br /><br /><br />
    <!-- 增加管理员的模态框 -->
    <div class="modal fade" id="addAdminModal" tabindex="-1" role="dialog" aria-labelledby="addAdminModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="addAdminModalLabel">增加管理员</h4>
                </div>
                <form action="/sa/admins/add" method="post">
                <div class="modal-body">
                        <div class="form-group">
                            <label for="username">用户名</label>
                            <input type="text" class="form-control" id="username" name="username">
                        </div>
                        <div class="form-group">
                            <label for="password">密码(英文和特殊符号)</label>
                            <input type="text" class="form-control" id="password" name="password">
                        </div>
                        <div class="form-group">
                            <label for="tags">标签(多个标签以英文逗号隔开)</label>
                            <input type="text" class="form-control" id="tags" name="tags">
                        </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary">增加</button>
                </div>
                </form>
            </div>
        </div>
    </div>

    <div class="col-sm-12">
        <table class="table table-hover">
            <thead>
            <th>用户名</th>
            <th>标签</th>
            <th>操作</th>
            </thead>
            <tbody>
            <c:forEach items="${admins}" var="admin">
                <tr>
                    <td>${admin.username}</td>
                    <td>
                        <c:forEach items="${admin.tags}" var="tag"> <span class="label label-success">${tag}</span> </c:forEach>
                    </td>
                    <td>
                        <a href="/sa/admins/edit?id=${admin.id}" class="btn btn-default"><span class="glyphicon glyphicon-pencil"></span></a>
                        <a href="/sa/admins/delete?id=${admin.id}" class="btn btn-default"><span class="glyphicon glyphicon-trash"></span></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<%@include file="../common/footer.jsp"%>
</body>
</html>
