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
 <spring:form modelAttribute="part" method="post" action="/edit">
     <spring:hidden path="id" />
     <spring:input path="title"/>
     <spring:input path="need"/>
     <spring:input path="count"/>
     <spring:button>OK</spring:button>
 </spring:form>
</body>
</html>
