<%--
  Created by IntelliJ IDEA.
  User: tala
  Date: 1/8/2021
  Time: 7:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="style.css" rel="stylesheet"/>
    <title>Main Page</title>
</head>
<body>
<form>
    <label>Your Gold:<input type="number" name="number"> ${gold}</label>
</form>
<div class="block">
    <form action="/" method="post">
        <h2>Farm</h2><br>
        <p>(earns 10-20 gold)</p><br>
        <button type="submit" name="farm">Find Gold!</button>
    </form>
</div>
<div class="block">
    <form action="/" method="post">
        <h2>Cave</h2><br>
        <p>(earns 5-10 gold)</p><br>
        <button type="submit" name="cave" >Find Gold!</button>
    </form>
</div>
<div class="block">
    <form action="/" method="post">
        <h2>House</h2><br>
        <p>(earns 2-5 gold)</p><br>
        <button type="submit" name="house" >Find Gold!</button>
    </form>
</div>
<div class="block">
    <form action="/" method="post">
        <h2>Casino!</h2><br>
        <p>(earns/takes 0-50 gold)</p><br>
        <button type="submit" name="casino" >Find Gold!</button>
    </form>
</div>
<div>
    <c:forEach var="activity" items="${activites}" >
        <h1> ${activity}</h1>
    </c:forEach>
</div>
</body>
</html>
