<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Main</title>
</head>
<body>

        <div class="register">
            <h1>Register</h1>
            <form:form method="POST" action="/users" modelAttribute="user">
                <p>
                    <form:label path="name">Name:</form:label>
                    <form:input type="text" path="name"/>
                </p>
                <p>
                    <form:label path="email">Email:</form:label>
                    <form:input type="email" path="email"/>
                </p>
                <p>
                    <form:label path="password">Password:</form:label>
                    <form:password path="password"/>
                </p>
                <p>
                    <form:label path="passwordConfirmation">Password Confirmation:</form:label>
                    <form:password path="passwordConfirmation"/>
                </p>
                <input type="submit" value="Register!"/>
            </form:form>
        </div>
    <div class="login">
            <h1>Log In</h1>
            <p><c:out value="${error}" /></p>

            <form method="post" action="/login">
                <p>
                    <label for="email">Email</label>
                    <input type="text" id="email" name="email"/>
                </p>
                <p>
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password"/>
                </p>
                <input type="submit" value="Login!"/>
            </form>
    </div>
        <p style><form:errors path="user.*"/></p>

</body>
</html>
