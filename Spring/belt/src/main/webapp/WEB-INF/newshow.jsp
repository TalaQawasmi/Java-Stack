<%--
  Created by IntelliJ IDEA.
  User: tala
  Date: 1/17/2021
  Time: 11:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="js/time.js"></script>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <title>New Show Page</title>
</head>
<body>
<!-- NAV BAR -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/shows">TV Shows</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="/shows">Dashboard</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/shows/new">Add Show <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/logout">Log Out</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container mt-3">
    <h1>Create a new show</h1>

    <p style="color: red;"><form:errors path="show.*"/></p>

    <form:form method="POST" action="/shows" modelAttribute="show">
        <p>
            <form:label path="title">Title:</form:label>
            <form:input type="text" path="title"/>
        </p>
        <p>
            <form:label path="network">Network:</form:label>
            <form:input type="text" path="network"/>
        </p>
        <form:input type="hidden" path="userT" value="${user.id}"/>
        <input type="submit" value="Add TV Show"/>
    </form:form>
</div>

</body>
</html>
