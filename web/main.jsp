<%@ page import="java.util.ArrayList" %>
<%@ page import="db.News" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>

<div class="container snippet-container mt-3 form-control">
    <%
        ArrayList<News> news = (ArrayList<News>) request.getAttribute("news");

        for(News news1 : news){
    %>
    <div class="row">
        <div class="col">
            <div class="card mt-3">
                <div class="card-header">
                    <%=news1.getUser().getFull_name()%>
                </div>
                <div class="card-body">
                    <h5 class="card-title"><%=news1.getTitle()%></h5>
                    <p class="card-text"><%=news1.getContent()%></p>
                    <p class="card-text"><%=news1.getPostdate()%></p>
                    <a href="/comments?id=<%=news1.getId()%>" class="btn btn-primary">Comments</a>
                    <%
                        User user = (User) request.getSession().getAttribute("CURRENT_USER");
                        if(user!=null && user.getRole_id().equals("1")){
                    %>
                    <a href="/delete?id=<%=news1.getId()%>" class="btn btn-danger">Delete</a>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
    </div>
    <%
        }
    %>
</div>
</body>
</html>
