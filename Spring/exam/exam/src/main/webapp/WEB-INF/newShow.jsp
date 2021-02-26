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
    <title>New</title>
</head>
<body>
<a href="/shows">Dashboard</a>


<div>
    <h1>Create a new show</h1>
    <p><form:errors path="show.*"/></p>
    <form:form method="POST" action="/shows" modelAttribute="show">
        <p>
            <form:label path="title">Title:</form:label>
            <form:input type="text" path="title"/>
        </p>
        <p>
            <form:label path="network">Network:</form:label>
            <form:input type="text" path="network"/>
        </p>
        <form:input type="hidden" path="userOne" value="${user.id}"/>
        <input type="submit" value="Add TV Show"/>
    </form:form>
</div>
</body>
</html>
