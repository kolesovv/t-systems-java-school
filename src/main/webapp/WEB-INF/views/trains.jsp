<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Trains</title>
</head>
<body>

<div class="container">
    <div class="row justify-content-md-center">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Number</th>
                <th scope="col">Seats</th>
                <th scope="col">Schedule</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="trainDTO" items="${trainList}">
                <tr>
                    <td>${trainDTO.trainName}</td>
                    <td>${trainDTO.seats}</td>
                    <td><c:forEach var="route" items="${trainDTO.schedulePath}">
                        ${route.toString()}<br>
                    </c:forEach>
                    </td>
                    <td>
                        <form action="../train/edit/${trainDTO.id}" method="get">
                            <button type="submit" class="btn btn-primary">Edit</button>
                        </form>
                        <br>
                        <form action="../train/delete/${trainDTO.id}" method="get">
                            <button type="submit" class="btn btn-primary">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="train/form"  role="button" class="btn btn-warning">Add new train</a>
    </div>
    <%--<a href="/"  role="button" class="btn btn-primary btn-lg">Back to admin page</a>--%>
</div>
</body>
</html>
