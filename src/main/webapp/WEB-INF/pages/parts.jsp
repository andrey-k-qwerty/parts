<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 13.05.2019
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Комплектующие</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Наименование</th>
        <th>Необходимость</th>
        <th>Количество</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${parts}" var="part">
        <tr>
            <td>${part.title}</td>
            <td>${part.need}</td>
            <td>${part.count}</td>
            <td><a href="/edit/${part.id}">edit</a></td>
            <td><a href="/delete/${part.id}">delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
    <tfoot>
    <tr>
        <th>Можно собрать</th>
        <th>0</th>
        <th>компьютеров</th>
    </tr>
    </tfoot>

</table>

<spring:form method="GET" action="/add">
      <input type = "submit" value = "Добавить"/>
</spring:form>


</body>
</html>
