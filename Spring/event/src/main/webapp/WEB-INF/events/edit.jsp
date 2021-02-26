<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <style>
        .user-form {
            display: inline-block;
            width: 45%;
            vertical-align: top;
            margin: 20px;
        }
        .event-details-side {
            display: inline-block;
            width: 45%;
            vertical-align: top;
            margin: 20px;
        }
        .messages{
            border: solid black;
            min-height: 10px;
            max-height: 200px;
            overflow-y: scroll;
        }
        .delete-form {
            display: inline-block;
        }
    </style>
    <meta charset="ISO-8859-1">
    <title>Event Planner</title>
</head>
<body>
<div class="container">
    <h2><span>Welcome, ${ user.firstName }</span><span style="float: right"><a href="/logout">logout</a></span></h2>
    <hr />
    <h2>Edit <strong>${ event.name }</strong></h2>
    <form:form action="/events/${ event.id }" method="POST" modelAttribute="event">
        <input type="hidden" name="_method" value="put">
        <form:hidden value="${ userId }" path="planner"/>
        <div class="form-group">
            <form:label path="name">Name</form:label>
            <form:errors path="name"></form:errors>
            <form:input class="form-control" path="name"></form:input>
        </div>
        <div class="form-group">
            <form:label path="eventDate">Date</form:label>
            <form:errors path="eventDate"></form:errors>
            <form:input class="form-control" type="date" path="eventDate"></form:input>
        </div>
        <div class="form-group">
            <form:label path="city">City</form:label>
            <form:errors path="city"/>
            <form:input class="form-control" path="city" />
        </div>
        <div class="form-group">
            <form:label path="state">State</form:label>
            <form:errors path="state"/>
            <form:select class="form-control" path="state">
                <c:forEach items="${ states }" var="state">
                    <c:choose>
                        <c:when  test="${ state.equals(event.state) }">
                            <option selected value="${ state }">${ state }</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${ state }">${ state }</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
        </div>
        <button>Update Event</button>
    </form:form>
</div>
</body>
</html>
