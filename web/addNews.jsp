<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container snippet-container mt-3 form-control">
    <form class="form-control" action="/addNews" method="post">
        <div class="mb-3">
            <label class="form-label">Title: </label>
            <input placeholder="Enter a Title: " class="form-control" name="title">
        </div>
        <div class="mb-3">
            <label class="form-label">Content: </label>
            <input placeholder="Enter a Content: " class="form-control" name="content">
        </div>
        <div class="mb-3">
            <button type="submit" class="btn btn-success">Next</button>
        </div>
    </form>
</div>
</body>
</html>
