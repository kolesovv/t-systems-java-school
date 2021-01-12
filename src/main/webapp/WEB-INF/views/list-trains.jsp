<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Train list</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>SBB</h2>
    <p>Trains:</p>

    <!-- Button trigger modal -->
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter"
            onclick="window.location.href='addTrain'; return false">
        Add train
    </button>

    <!-- Train list -->
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Train name</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="tempTrains" items="${trains}">
            <c:url var="deleteLink" value="/deleteTrain">
                <c:param name="numberTrain" value="${tempTrains.numberTrain}"/>
            </c:url>
            <c:url var="updateLink" value="/updateTrain">
                <c:param name="numberTrain" value="${tempTrains.numberTrain}"/>
            </c:url>
            <tr>
                <td>${tempTrains.trainName}</td>
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
