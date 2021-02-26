<%--
  Created by IntelliJ IDEA.
  User: tala
  Date: 1/17/2021
  Time: 11:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="js/time.js"></script>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <title>Edit Show Page</title>
</head>
<body>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="/shows">Dashboard</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/shows/new">Add Show</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/logout">Log Out</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container mt-3">
    <h1>Edit ${show.title}</h1>

    <p style="color: red;"><form:errors path="show.*"/></p>

    <form:form method="POST" action="/shows/${show.id}/update" modelAttribute="show">
        <p>
            <form:label path="title">Title:</form:label>
            <form:input type="text" path="title" />
        </p>
        <p>
            <form:label path="network">Network:</form:label>
            <form:input type="text" path="network" />
        </p>
        <form:input type="hidden" path="avgRating" value="${show.avgRating}"/>
        <form:input type="hidden" path="userT" value="${user.id}"/>
        <input type="submit" value="Update Show"/> <a href="/shows/${show.id}"><button type="button" class="btn-danger">Cancel</button></a>
    </form:form>

    <br>
    <form action="/shows/${show.id}" method="post">
        <input type="hidden" name="_method" value="delete">
        <input type="submit" value="Delete Show">
    </form>

</div>

</body>
</html>