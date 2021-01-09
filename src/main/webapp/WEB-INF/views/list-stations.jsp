<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Station list</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>SBB</h2>
    <p>Stations:</p>

    <!-- Button trigger modal -->
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter"
            onclick="window.location.href='addStation'; return false">
        Add station
    </button>

    <!-- Station list -->
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Station name</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="tempStations" items="${stations}">
            <c:url var="deleteLink" value="/deleteStation">
                <c:param name="stationId" value="${tempStations.idStation}"/>
            </c:url>
            <c:url var="updateLink" value="/updateStation">
                <c:param name="stationId" value="${tempStations.idStation}"/>
            </c:url>
            <tr>
                <td>${tempStations.nameStation}</td>
                <td>
                    <a href="${updateLink}">update</a>
                </td>
                <td>
                    <a href="${deleteLink}">delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>