<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Dashboard</title>
</head>
<body>
<div>
    <h1>Welcome, <c:out value="${user.name}" />!</h1>
    <p><c:out value="${error}" /></p>
    <h3>TV Shows</h3>
    <table>
        <thead>
        <tr>
            <th>Show</th>
            <th>Network</th>
            <th>Avg Rating</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${shows}" var="show">
            <tr>
                <td><a href="/shows/${show.id}">${show.title}</a></td>
                <td>${show.network}</td>
                <td>${show.avgRating}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p><a href="/shows/new"><button>Add Show</button></a></p>
    <p><a href="/logout"><button>Log Out</button></a></p>
</div>
</body>
</html>
