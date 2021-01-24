<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Trains</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h1>${stationSchedule.station.nameStation}</h1>
    <h2>Train schedule</h2>
    <td>
        <form action="../station/${stationSchedule.station.idStation}/form">
            <button type="submit" class="btn btn-dark">Add new schedule</button>
        </form>
    </td>
    <%--<p>The .table-striped class adds zebra-stripes to a table:</p>--%>
    <table class="table table-sm">
        <thead>
        <tr>
            <th>Train</th>
            <th>Departure time</th>
            <th>Arrival time</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="stationScheduleItem" items="${stationSchedule.scheduleItemList}">
        <tr>
            <td>${stationScheduleItem.train.trainName}</td>
            <td><fmt:formatDate value="${stationScheduleItem.departureTime}" pattern="HH:mm:ss"></fmt:formatDate></td>
            <td><fmt:formatDate value="${stationScheduleItem.arrivalTime}" pattern="HH:mm:ss"></fmt:formatDate></td>
            <td>
                <form action="/sbb_war/schedule/${schedule.id}">
                    <button type="submit" class="btn btn-light">Edit</button>
                </form>
            </td>
            <td>
                <form action="/sbb_war/schedule/${schedule.id}">
                    <button type="submit" class="btn btn-warning">Delete</button>
                </form>
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>