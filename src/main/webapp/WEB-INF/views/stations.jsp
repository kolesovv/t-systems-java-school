<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/resources/css/bootstrap.4.5.3.min.css">

    <title>Stations</title>
</head>
    <h1>Station List</h1>
<body>

<table class="table">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Schedule</th>
        <th>Edit</th>
        <th>Delete</th>
        <th>Find schedules by station</th>
    </tr>
    <c:forEach var="stationDTO" items="${stationList}">
        <tr>
            <td>${stationDTO.id}</td>
            <td>${stationDTO.nameStation}</td>
            <td><c:forEach var="schedule" items="${stationDTO.scheduleStationDTOS}">
                ${schedule.toString()}<br>
            </c:forEach>
            </td>
            <td>
                <form action="station/${stationDTO.id}" method="get">
                    <button type="submit" class="btn btn-primary">Edit</button>
                </form>
                <br>
                <form action="station/delete/${stationDTO.id}" method="get">
                    <button type="submit" class="btn btn-primary">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="station/form" role="button" class="btn btn-warning">Add new station</a>

</body>
</html>