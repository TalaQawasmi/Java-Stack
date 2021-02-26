<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tala
  Date: 1/7/2021
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>counter</title>
</head>
<body>
<p>You have visited <a href="/">http://localhost:8080/</a> <c:out value="${counter}"/>times</p>
<a href="/">Click to go to main page</a>

</body>
</html>
