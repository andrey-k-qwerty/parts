<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 13.05.2019
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Редактор</title>
</head>
<body>
<c:if test="${empty part.title}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty part.title}">
    <c:url value="/edit" var="var"/>
</c:if>

<spring:form modelAttribute="part" method="post" action="${var}">
    <spring:hidden path="id"/> <br>

    <spring:input path="title"/><br>

    <spring:input path="need"/><br>

    <spring:input path="count"/><br>
    <spring:button>OK</spring:button>
</spring:form>
</body>
</html>
