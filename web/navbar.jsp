<%@ page import="db.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
</head>
<body>
<div class="container mt-12" style="border-bottom: 1px #ccc solid">
    <nav class="navbar navbar-expand-lg" style="background-color: white" >
        <div class="container-fluid">
            <a class="navbar-brand" href="/mainPage"  style="color: black; font-weight: bold; font-size: 25px">BITLAB NEWS</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon" ></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                    <%
                        User onlineUser = (User) request.getSession().getAttribute("CURRENT_USER");

                        if(onlineUser==null){
                    %>
                    <li class="nav-item">
                        <a class="nav-link" href="/signin" style="color: black">Sign</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/register" style="color: black">Register</a>
                    </li>
                    <%
                        }else{
                    %>
                    <li class="nav-item">
                        <a class="nav-link" href="/profile" style="color: black"><%=onlineUser.getFull_name()%></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/addNews" style="color: black">Add News</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/logout" style="color: black">Logout</a>
                    </li>

                    <%
                        }
                    %>
                </ul>
            </div>

        </div>
    </nav>
</div>
</body>
</html>
