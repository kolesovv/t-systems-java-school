<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Train</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Find trains:</h2>
    <%--<p>The .table-striped class adds zebra-stripes to a table:</p>--%>
    <%--<form:form method="POST" action="../station/">--%>
        <table >
            <tr>
                <td>FROM:</td>
                <td>
                    <form:select path="${scheduleModel.stationDeparture}" name="stationDeparture"  id="stationDeparture">
                        <c:forEach var="stationFrom" items="${stations}">
                            <option value="${stationFrom.idStation}">${stationFrom.nameStation}</option>
                        </c:forEach>
                    </form:select>
                </td>
                <td>TO:</td>
                <td>
                    <form:select path="${scheduleModel.stationArrival}" name="stationArrival"  id="stationArrival">
                        <c:forEach var="stationTo" items="${stations}">
                            <option value="${stationTo.idStation}">${stationTo.nameStation}</option>
                        </c:forEach>
                    </form:select>
                </td>
                <td></td>
                <td><input type="submit" value="SEARCH" /></td>
            </tr>
        </table>
    <%--</form:form>--%>
</div>

</body>
</html>