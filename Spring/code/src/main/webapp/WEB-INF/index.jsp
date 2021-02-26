<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tala
  Date: 1/7/2021
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
<c:out value="${error}"/>
<h3>what is the code?</h3>
    <form action="/code" method="post">
        <input type="text" name="code">
        <button type="submit">Try code!</button>
    </form>
</body>
</html>
