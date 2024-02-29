<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container snippet-container mt-3 form-control">
    <form class="form-control" action="/addComment" method="post">
        <div class="mb-3">
            <label class="form-label">Comment: </label>
            <input placeholder="Enter a Title: " class="form-control" name="comment">
        </div>
        <input type="hidden" value="<%=request.getAttribute("id")%>" name="news_id">
        <div class="mb-3">
            <button type="submit" class="btn btn-success">Next</button>
        </div>
    </form>
</div>
</body>
</html>
