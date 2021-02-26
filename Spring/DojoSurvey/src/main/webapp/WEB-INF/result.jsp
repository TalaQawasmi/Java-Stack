<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tala
  Date: 1/6/2021
  Time: 2:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Results</title>
</head>
<body>
<div>
<h1>Submitted Information</h1>
<h3>Name: <c:out value="${name}"/> </h3>
<h3>Location: <c:out value="${location}"/></h3>
<h3>Language: <c:out value="${language}"/></h3>
<h3>Comment: <c:out value="${comment}"/></h3>
</div>
</body>
</html>
