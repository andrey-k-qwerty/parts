<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 13.05.2019
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Комплектующие</title>
    <link rel="stylesheet" type="text/css"
          href="/assets/datatables.min.css"/>


    <script type="text/javascript"
            src="/assets/datatables.min.js"></script>

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
                // {"data": "need"},
                {"data": null, render: function (data, type, row) {
                    console.log(data.need)
                    if (data.need == true)

                        return "да";
                    else  return "нет";
                    }},
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
<%--<script>--%>
<%--  $(document).ready(function() {--%>
<%--    $('#parttable').DataTable();--%>
<%--  } );--%>
<%--</script>--%>
<H1>Список комлектующих</H1>
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
        <th>${count}</th>
        <th>компьютеров</th>
    </tr>
    </tfoot>

</table>
<form:form method="GET" action="/add">
    <input type = "submit" value = "Добавить"/>
</form:form>
</body>
</html>
