<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lab2</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="#">
        Lab 2
    </a>
</nav>

<div class="row">
    <div class="col-lg-3 col-md-4 col-sm-12">
        <jsp:include page="forms/managers/managers.jsp"/>
    </div>
    <div class="col-lg-3 col-md-4 col-sm-12">
        <jsp:include page="forms/programmers/programmers.jsp"/>
    </div>
    <div class="col-lg-3 col-md-4 col-sm-12">
        <jsp:include page="forms/projects/projects.jsp"/>
    </div>
    <div class="col-lg-3 col-md-4 col-sm-12">
        <jsp:include page="forms/technologies/technologies.jsp"/>
    </div>
    <div class="col-lg-3 col-md-4 col-sm-12">
        <jsp:include page="forms/programmers_technologies/programmers_technologies.jsp"/>
    </div>
    <div class="col-lg-3 col-md-4 col-sm-12">
        <jsp:include page="forms/projects_technologies/projects_technologies.jsp"/>
    </div>
    <div class="col-lg-3 col-md-4 col-sm-12">
        <jsp:include page="forms/generator.jsp"/>
    </div>
</div>
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
