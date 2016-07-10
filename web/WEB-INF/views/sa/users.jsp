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
</body>
</html>
