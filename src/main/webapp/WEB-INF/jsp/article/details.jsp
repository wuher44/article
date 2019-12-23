<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MY
  Date: 28.07.2019
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    body {
        background-color: chartreuse;
    }
    .commentsForm{
        background-color: gold;
        padding: 15px;
    }
</style>
<head>
    <title>Article Details</title>
</head>
<body>

<div style="padding: 15px; background-color: lightcoral">
    <h1>${article.title}</h1>
    <div>${article.content}</div>
</div>
<a href="/article">Wróć do listy</a>
<div>
    <h3>Komentarze :</h3>
    <form class="commentsForm" method="post" action="/comment?articleId=${article.id}">
        <label>Autor :</label><br>
        <input type="text" name="author"><br>
        <label>Treść :</label>
        <input type="text" name="content"><br>
        <input type="submit" value="Dodaj komentarz">
    </form>
</div>
<div>
    <c:forEach var="comment" items="${article.comments}">
        <div style="padding-bottom: 5px;">
           <div >${comment.author}</div>
           <div >${comment.content}</div>


        </div>
    </c:forEach>
</div>
</body>
</html>
