<%--
  Created by IntelliJ IDEA.
  User: Tala
  Date: 1/17/2021
  Time: 10:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show</title>
</head>
<body>

<div>
    <div>
        <div>
            <h1><c:out value="${show.title}" /></h1>
            <h4>Network: <c:out value="${show.network}" /></h4>
            <h4>Average Rating: <c:out value="${show.avgRating}" /></h4>
            <c:if test = "${show.userOne.id == user.id}">
                <p><a href="/shows/${show.id}/edit"><button>Edit This Show</button></a></p>
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
        <div >
            <h3>Rate this Show</h3>
            <p><c:out value="${error}" /></p>
            <p><form:errors path="review.*"/></p>
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
            <p><a href="/shows"><button>Shows table</button></a></p>
        </div>
    </div>
</div>

</body>
</html>
