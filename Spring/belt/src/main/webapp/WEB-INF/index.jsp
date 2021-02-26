<%--
  Created by IntelliJ IDEA.
  User: tala
  Date: 1/17/2021
  Time: 10:39 AM
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
    <title>Index Page</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/">TV Shows</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
            </li>
        </ul>
    </div>
</nav>

<div class="container mt-5">
    <div class="row">
        <div class="col-xs-6 col-md-6">

            <h1>Register</h1>

            <p style="color: red;"><form:errors path="user.*"/></p>

            <!-- Register Form (Spring form) -->
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



        <div class="col-xs-6 col-md-6">
            <h1>Log In</h1>

            <p style="color: red;"><c:out value="${error}" /></p>


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
    </div>
</div>

</body>
</html>
