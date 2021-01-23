<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Stations</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Stations List</h2>
    <td>
        <form action="station/form">
            <button type="submit" class="btn btn-link">Add new station</button>
        </form>
    </td>
    <%--<p>The .table-striped class adds zebra-stripes to a table:</p>--%>
    <table class="table table-sm">
        <thead>
        <tr>
            <th>Name</th>
            <th>Edit</th>
            <th>Delete</th>
            <th>Schedule</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="station" items="${stations}">
            <tr>
                <td>${station.nameStation}</td>
                <td>
                    <form action="station/${station.idStation}">
                        <button type="submit" class="btn btn-light">Edit</button>
                    </form>
                </td>
                <td>
                    <form action="station/delete/${station.idStation}">
                        <button type="submit" class="btn btn-warning">Delete</button>
                    </form>
                </td>
                <td>
                    <form action="schedule/station/${station.idStation}">
                        <button type="submit" class="btn btn-info">Go</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>