<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <h2>Trains List</h2>
    <td>
        <th>
            <form action="train/form">
                <button type="submit" class="btn btn-light">Add new train</button>
            </form>
        </th>
        <th>
            <form action="/sbb">
                <button type="submit" class="btn btn-light">Back to admin page</button>
            </form>
        </th>
    </td>
    <%--<p>The .table-striped class adds zebra-stripes to a table:</p>--%>
    <table class="table table-sm">
        <thead>
        <tr>
            <th>Name</th>
            <th>Number of seats</th>
            <th>Passengers</th>
            <th>Edit</th>
            <th>Delete</th>
            <th>Schedule</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="train" items="${trains}">
            <tr>
                <td>${train.trainName}</td>
                <td>${train.seats}</td>
                <td>
                    <form action="train/${train.numberTrain}/passengers">
                        <button type="submit" class="btn btn-light">Passengers</button>
                    </form>
                </td>
                <td>
                    <form action="train/${train.numberTrain}">
                        <button type="submit" class="btn btn-light">Edit</button>
                    </form>
                </td>
                <td>
                    <form action="train/delete/${train.numberTrain}">
                        <button type="submit" class="btn btn-warning">Delete</button>
                    </form>
                </td>
                <td>
                    <form action="schedule/train/${train.numberTrain}">
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
