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
    <title>Home page</title>
</head>
<body>
<form action="/path" method="post">
<lable>Name: <input type="text" name="name"></lable><br>
<lable>Dojo Location: </lable>
<select name="location">
    <option>Ramallah</option>
    <option>Nablus</option>
    <option>Hebron</option>
    <option>Bethlehem</option>
    <option>Jenin</option>
</select><br>
<lable>Favorite Language </lable>
<select name="language">
    <option>English</option>
    <option>Arabic</option>
    <option>French</option>
    <option>Spanish</option>
</select><br>
<label>Comment (optional):<textarea name="comment"></textarea></label>
<input type="submit" value="button">
</form>
</body>
</html>
