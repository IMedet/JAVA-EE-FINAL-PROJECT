<%@ page import="db.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>

<div class="container">
    <div class="row">
        <div class="col">
            <%
                User currentUser = (User) request.getSession().getAttribute("CURRENT_USER");
            %>
            <h3 class="text-center mt-5">Hello <%=currentUser.getFull_name()%></h3>
        </div>
    </div>
</div>
</body>
</html>
