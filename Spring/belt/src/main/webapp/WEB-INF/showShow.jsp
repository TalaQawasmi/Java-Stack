<%--
  Created by IntelliJ IDEA.
  User: tala
  Date: 1/17/2021
  Time: 11:12 AM
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
    <title>Show TV Show Page</title>
</head>
<body>
<!-- NAV BAR -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/shows">TV Shows</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
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
    <div class="row">
        <div class="col-xs-6 col-md-6">
            <h1><c:out value="${show.title}" /></h1>
            <h6>Network: <c:out value="${show.network}" /></h6>
            <h6>Average Rating: <c:out value="${show.avgRating}" /></h6>
            <!-- ONLY USERS THAT CREATED THE SHOW CAN EDIT THE SHOW'S DETAILS -->
            <c:if test = "${show.userT.id == user.id}">
                <p><a href="/shows/${show.id}/edit"><button class="btn-success">Edit This Show</button></a></p>
            </c:if>
            <hr>
            <h3 class="text-center">Users who rated this show:</h3>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Rating</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${show.reviews}" var="s">
                    <tr>
                        <td>${s.user.name}</td>
                        <td>${s.rating}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
        <div class="col-xs-6 col-md-6">
            <h3>Rate this Show</h3>
            <!-- Generic Errors through flash and Model model are displayed here -->
            <p style="color: red;"><c:out value="${error}" /></p>
            <!-- Form errors displayed here if result from @Valid BindResult in controls returns errors -->
            <p style="color: red;"><form:errors path="review.*"/></p>
            <!-- FORM TO CREATE A NEW REVIEW -->
            <form:form method="POST" action="/shows/${show.id}/review" modelAttribute="review">
                <p>
                    <form:label path="rating">Rating:</form:label>
                    <form:select path="rating">
                        <form:option value="5">5</form:option>
                        <form:option value="4">4</form:option>
                        <form:option value="3">3</form:option>
                        <form:option value="2">2</form:option>
                        <form:option value="1">1</form:option>
                    </form:select>
                </p>
                <form:input type="hidden" path="user" value="${user.id}" />
                <form:input type="hidden" path="show" value="${show.id}" />
                <input type="submit" value="Submit Rating"/>
            </form:form>
        </div>
    </div>
</div>

</body>
</html>
