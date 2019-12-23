<%--
  Created by IntelliJ IDEA.
  User: MY
  Date: 27.07.2019
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodaj artykuł</title>
</head>
<body>
<form method="post" action="/article">

    <label>Title: </label>
    <input type="text" name="title"><br>
    <label>Content </label>
    <textarea rows="20" cols="200" name="content"></textarea>
    <input type="submit" value="Dodaj">
</form>
</body>
</html>
