<%@ page import="java.util.ArrayList" %>
<%@ page import="db.News" %>
<%@ page import="db.Comment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>

<div class="container snippet-container mt-3 form-control">
    <%
        News news = (News) request.getAttribute("news");
        ArrayList<Comment> comments = (ArrayList<Comment>) request.getAttribute("comments");
    %>
    <div class="row">
        <div class="col">
            <div class="card mt-3 mb-3">
                <div class="card-header">
                    <%=news.getUser().getFull_name()%>
                </div>
                <div class="card-body">
                    <h5 class="card-title"><%=news.getTitle()%></h5>
                    <p class="card-text"><%=news.getContent()%></p>
                    <p class="card-text"><%=news.getPostdate()%></p>
                    <div class="btn btn-success ">
                    <a href="/addComment?id=<%=news.getId()%>" style="color: white">Add Comment</a>
                    </div>
                </div>
            </div>



            <%
                for(Comment comment: comments){
            %>
            <div class="card mt-1" style="border: 4px solid #0a53be">
                <div class="card-body">
                    <h6 class="card-title"><%=comment.getUser().getFull_name()%></h6>
                    <p class="card-text"><%=comment.getComment()%></p>
                    <p class="card-text"><%=comment.getPostdate()%></p>
                </div>
            </div>
            <%
                }
            %>
        </div>
    </div>
</div>
</body>
</html>
