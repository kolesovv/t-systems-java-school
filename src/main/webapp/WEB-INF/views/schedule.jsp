<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Schedules</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>SBB</h2>
    <p>Schedules:</p>

    <!-- Button trigger modal -->
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter"
            onclick="window.location.href='addSchedule'; return false">
        Add new schedule
    </button>

    <!-- Schedule list -->
    <table class="table table-striped">
        <thead>
        <tr>
            <th>id</th>
            <th>Departure time</th>
            <th>Arrival time</th>
            <th>Path</th>
            <th>Train</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="tempPath" items="${schedule}">
            <c:url var="deleteLink" value="/">
                <c:param name="scheduleId" value="${tempPath.id}"/>
            </c:url>
            <c:url var="updateLink" value="/">
                <c:param name="scheduleId" value="${tempPath.id}"/>
            </c:url>
            <tr>
                <td>${tempPath.id}</td>
                <td>${tempPath.departureTime}</td>
                <td>${tempPath.arrivalTime}</td>
                <td>${tempPath.path}</td>
                <td>${tempPath.train}</td>
                <td>
                    <a href="">update</a>
                </td>
                <td>
                    <a href="">delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>