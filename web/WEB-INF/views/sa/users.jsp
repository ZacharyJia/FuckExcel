<%--
  User: zachary
  Date: 16/7/10
  Time: 下午12:17
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统管理</title>
    <%@include file="../common/include.jsp"%>
    <script type="text/javascript">
        function deleteConfirm() {
            return confirm("删除后不可恢复,确定要删除吗?");
        }

        function ajax_get_user_info(id) {
            $.ajax({
                url     : "/sa/users/get",
                type    : "post",
                data    : {
                    id: id
                },
                dataType: "json",
                async   : false,
                success : function(data) {
                    $("#new_username").val(data.username);
                    $("#new_tags").val(data.tags);
                    $("#user_id").val(data.id);
                },
                error   : function() {

                }
            })
        }
    </script>
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
                <li><a href="admins">管理员管理</a></li>
                <li class="active"><a href="users">用户管理</a></li>
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
        <button class="btn btn-block btn-primary" data-toggle="modal" data-target="#addUserModal">增加用户</button>
    </div>
    <br /><br /><br />
    <!-- 增加用户的模态框 -->
    <div class="modal fade" id="addUserModal" tabindex="-1" role="dialog" aria-labelledby="addUserModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="addAdminModalLabel">增加用户</h4>
                </div>
                <form action="/sa/users/add" method="post">
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="username">用户名</label>
                            <input type="text" class="form-control" id="username" name="username">
                        </div>
                        <div class="form-group">
                            <label for="password">密码(英文、数字和特殊符号)</label>
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

    <!-- 编辑用户的模态框 -->
    <div class="modal fade" id="editUserModal" tabindex="-1" role="dialog" aria-labelledby="editUserModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="editAdminModalLabel">编辑用户</h4>
                </div>
                <form action="/sa/users/edit" method="post">
                    <div class="modal-body">
                        <input type="hidden" id="user_id" name="user_id">
                        <div class="form-group">
                            <label for="username">用户名</label>
                            <input type="text" class="form-control" id="new_username" disabled="disabled">
                        </div>
                        <div class="form-group">
                            <label for="password">密码(英文、数字和特殊符号)</label>
                            <input type="text" class="form-control" id="new_password" name="new_password" placeholder="不改请留空">
                        </div>
                        <div class="form-group">
                            <label for="tags">标签(多个标签以英文逗号隔开)</label>
                            <input type="text" class="form-control" id="new_tags" name="new_tags">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="submit" class="btn btn-primary">修改</button>
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
            <c:forEach items="${userList}" var="user">
                <tr>
                    <td>${user.username}</td>
                    <td>
                        <c:forEach items="${user.tags}" var="tag"> <span class="label label-success">${tag}</span> </c:forEach>
                    </td>
                    <td>
                        <a href="#" class="btn btn-default" data-toggle="modal" data-target="#editUserModal" onclick="ajax_get_user_info('${user.id}')"><span class="glyphicon glyphicon-pencil"></span></a>
                        <a href="/sa/admins/delete?id=${user.id}" class="btn btn-default" onclick="return deleteConfirm()"><span class="glyphicon glyphicon-trash"></span></a>
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
