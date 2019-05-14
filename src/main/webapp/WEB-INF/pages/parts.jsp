<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 13.05.2019
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <td> <a href="/edit/${part.id}">edit</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
