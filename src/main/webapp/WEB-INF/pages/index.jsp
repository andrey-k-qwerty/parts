<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 13.05.2019
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" type="text/css"
          href="https://cdn.datatables.net/v/bs4-4.1.1/jq-3.3.1/dt-1.10.18/datatables.min.css"/>

    <script type="text/javascript"
            src="https://cdn.datatables.net/v/bs4-4.1.1/jq-3.3.1/dt-1.10.18/datatables.min.js"></script>
</head>
<body>
<script>
    $(document).ready(function () {
        var table = $('#parttable').DataTable({
            "language": {
                "url": "//cdn.datatables.net/plug-ins/1.10.19/i18n/Russian.json"
            },
            "sAjaxSource": "/getpart",
            "sAjaxDataProp": "",
            "order": [[0, "asc"]],
            "columns": [
                {"data": "title"},
                {"data": "need"},
                {"data": "count"},
                {
                    "data": null, render: function (data, type, row) {
                        return "<a href=\"/edit/" + data.id + "\">edit</a>";
                    }
                },
                {
                    "data": null, render: function (data, type, row) {
                        return "<a href=\"/delete/" + data.id + "\">delete</a>";
                    }
                },

            ]
        })
    });
</script>
<!--script>
  $(document).ready(function() {
    $('#parttable').DataTable();
  } );
</script-->
<table id="parttable" class="table table-striped">
    <thead>
    <tr>
        <th>Наименование</th>
        <th>Необходимость</th>
        <th>Количество</th>
        <th>Редактирование</th>
        <th>Удаление</th>
    </tr>
    </thead>
    <tbody>
    <%-- <c:forEach items="${parts}" var="part">
       <tr>
         <td>${part.title}</td>
         <td>${part.need}</td>
         <td>${part.count}</td>
         <td><a href="/edit/${part.id}">edit</a></td>
         <td><a href="/delete/${part.id}">delete</a></td>
       </tr>
     </c:forEach>--%>
    </tbody>
    <tfoot>
    <tr>
        <th>Можно собрать</th>
        <th>0</th>
        <th>компьютеров</th>
    </tr>
    </tfoot>

</table>
<form:form method="GET" action="/add">
    <input type = "submit" value = "Добавить"/>
</form:form>
</body>
</html>
