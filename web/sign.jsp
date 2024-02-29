<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>

    <div class="container snippet-container mt-5 form-control">
        <form action="/signin" method="post">
            <div class="mb-3">
                <label class="form-label">Email: </label>
                <input placeholder="Enter an email: " class="form-control" name="email">
            </div>
            <div class="mb-3">
                <label class="form-label">Password: </label>
                <input type="password" placeholder="Enter an password: " class="form-control" name="password">
            </div>
            <div class="mb-3">
                <button type="submit" class="btn btn-success">Next</button>
            </div>
        </form>
    </div>
</body>
</html>
