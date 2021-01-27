<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<h1>Passenger List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Date of birth</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="passenger" items="${passengers}">
        <tr>
            <td>${passenger.name}</td>
            <td>${passenger.surname}</td>
            <td>${passenger.dateOfBirth}</td>
            <td><a href="passenger/${passenger.id}">Edit</a></td>
            <td><a href="passenger/delete/${passenger.id}">Delete</a></td>
            &lt;%&ndash;<td><a href="schedule/station/${station.idStation}">Find</a></td>&ndash;%&gt;
        </tr>
    </c:forEach>
</table>
<br/>
<a href="passenger/form">Add new passenger</a>--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Passengers</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Passengers List</h2>
    <td>
    <th>
        <form action="passenger/form">
            <button type="submit" class="btn btn-light">Add new station</button>
        </form>
    </th>
    <th>
        <form action="/sbb">
            <button type="submit" class="btn btn-light">Back to admin page</button>
        </form>
    </th>
    </td>
    <title></title>
    <%--<p>The .table-striped class adds zebra-stripes to a table:</p>--%>
    <table class="table table-sm">
        <thead>
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Date of birth</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="passenger" items="${passengers}">
            <tr>
                <td>${passenger.name}</td>
                <td>${passenger.surname}</td>
                <td>${passenger.dateOfBirth}</td>
                <td>
                    <form action="passenger/${passenger.id}">
                        <button type="submit" class="btn btn-light">Edit</button>
                    </form>
                </td>
                <td>
                    <form action="passenger/delete/${passenger.id}">
                        <button type="submit" class="btn btn-warning">Delete</button>
                    </form>
                </td>
                <%--<td>
                    <form action="schedule/station/${station.idStation}">
                        <button type="submit" class="btn btn-info">Go</button>
                    </form>
                </td>--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>