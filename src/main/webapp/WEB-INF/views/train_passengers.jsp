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
    <h2>Passengers List</h2>
    <title></title>
    <%--<p>The .table-striped class adds zebra-stripes to a table:</p>--%>
    <table class="table table-sm">
        <thead>
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Date of birth</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="passenger" items="${passengers}">
            <tr>
                <td>${passenger.name}</td>
                <td>${passenger.surname}</td>
                <td>${passenger.dateOfBirth.toString()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>