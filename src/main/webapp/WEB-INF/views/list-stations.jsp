<%--
  Created by IntelliJ IDEA.
  User: Kolesov Sergey
  Date: 19.12.2020
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <th>Station</th>
        </tr>
        <c:forEach var="tempStations" items="${stations}">
            <tr>
                <td>${tempStations.name}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
