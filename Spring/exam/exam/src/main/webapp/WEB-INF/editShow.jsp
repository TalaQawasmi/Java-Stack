<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Tala
  Date: 1/17/2021
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>

<div >
    <h1>Edit ${show.title}</h1>

    <p><form:errors path="show.*"/></p>

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
        <form:input type="hidden" path="userOne" value="${user.id}"/>
        <input type="submit" value="Update Show"/> <a href="/shows/${show.id}"><button type="button" >Cancel</button></a>
    </form:form>

    <br>
    <form action="/shows/${show.id}" method="post">
        <input type="hidden" name="_method" value="delete">
        <input type="submit" value="Delete Show">
    </form>

</div>
</body>
</html>
