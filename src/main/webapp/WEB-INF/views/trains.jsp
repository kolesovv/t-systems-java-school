<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/resources/css/bootstrap.4.5.3.min.css">

    <title>Trains</title>
</head>
    <h1>Train list</h1>
<body>

<table>
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Number</th>
        <th scope="col">Seats</th>
        <th scope="col">Schedule</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="trainDTO" items="${trainList}">
        <tr>
            <td>${trainDTO.id}</td>
            <td>${trainDTO.trainName}</td>
            <td>${trainDTO.seats}</td>
            <td>
                <table>
                    <thead>
                    <tr>
                        <th scope="col">Station</th>
                        <th scope="col">Departure</th>
                        <th scope="col">Arrival</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="route" items="${trainDTO.schedulePath}">
                        <tr>
                            <td>${route.stationName}</td>
                            <td>${route.departureTime}</td>
                            <td>${route.arrivalTime}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </td>
            <td>
                <form action="train/edit/${trainDTO.id}" method="get">
                    <button type="submit" class="btn btn-primary">Edit</button>
                </form>
                <br>
                <form action="train/delete/${trainDTO.id}" method="get">
                    <button type="submit" class="btn btn-primary">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="train/form"  role="button" class="btn btn-warning">Add new train</a>

</body>
</html>
