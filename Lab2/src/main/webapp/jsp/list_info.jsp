<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List info</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="#">
        Select result
    </a>
</nav>
<ul class="list-group">
    <% boolean isPrimary = true; %>
    <c:forEach var="item" items="${items}">
        <li class="list-group-item list-group-item-<%= isPrimary ? "primary" : "secondary"%>">${item}</li>
        <% isPrimary = !isPrimary; %>
    </c:forEach>
</ul>

</body>
</html>
