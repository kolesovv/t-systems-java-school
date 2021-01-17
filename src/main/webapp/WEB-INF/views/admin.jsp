<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container-fluid">
    <h2>Small Table</h2>
    <p>The .table-sm class makes the table smaller by cutting cell padding in half:</p>
    <div class="row">
        <div class="col">
            <div class="btn-group">
                <button type="button" class="btn btn-primary"
                        onclick="window.location.href='admin/addtrain'; return false">Add train</button>
                <button type="button" class="btn btn-primary"
                        onclick="window.location.href='admin/addstation'; return false">Add station</button>
                <button type="button" class="btn btn-primary">Add schedule</button>
            </div>
            <table class="table table-bordered table-sm">
                <thead>
                <tr>
                    <th>Train</th>
                    <th>Station</th>
                    <th>Departure time</th>
                    <th>Arrival time</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="scheduleTemp" items="${schedule}">
                <tr>
                    <td>${scheduleTemp.train.trainName}</td>
                    <td>${scheduleTemp.station.nameStation}</td>
                    <td>${scheduleTemp.departureTime}</td>
                    <td>${scheduleTemp.arrivalTime}</td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col"></div>
    </div>
</div>
</body>
</html>

<%--
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter"
        onclick="window.location.href='addStation'; return false">
    Add station
</button>--%>
