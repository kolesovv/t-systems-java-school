<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Add schedule</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h1></h1>
    <h2>Add schedule for current train</h2>
    <form:form method="POST" action="/sbb/schedule/train/edit">
        <table class="table table-sm">
            <tr>
                <td>Arrival time</td>
                <td><form:input path="arrivalTime" type="time" class="form-control"/></td>
                <td>Departure time: </td>
                <td><form:input path="departureTime" type="time" class="form-control"/></td>
                <td>Station</td>
                <td>
                    <form:select path="itemId" class="form-control">
                        <form:options items="${stations}" itemLabel="nameStation" itemValue="idStation"/>
                    </form:select>
                </td>
                <td></td>
                <td><button type="submit" class="btn btn-light">Create</button></td>
            </tr>
        </table>
    </form:form>
</div>

</body>
</html>