<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MY
  Date: 27.07.2019
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Articles</title>
</head>
<body>
<div>
    <form method="get" action="/article">
        <input type="text" name="phrase" value="${lastPhrase}">
        Search only in title:
        <input type="checkbox" ${param.titleOnly == 'on' ? 'checked' : ''} name="titleOnly" >
        <input type="submit" value="Wyszukaj">
    </form>
</div>
<a href="/article/add">Dodaj artykuł</a>
<c:forEach var="article" items="${articles}">
    <div>
        <a href="/article/${article.id}"> ${article.title} </a> - ${article.publishDate}
    </div>
</c:forEach>
</body>
</html>
