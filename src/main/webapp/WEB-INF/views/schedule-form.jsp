<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="select" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Add new train</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>SBB</h2>
    <button type="submit" class="btn btn-primary"
            onclick="window.location.href='list-paths';return false">Back to list</button>
    <form:form action="saveSchedule" modelAttribute="schedule" method="post" class="was-validated">
        <form:hidden path="id"/>
        <%--Input date--%>
        <div class="form-group row">
        <label for="departure-date-input" class="col-2 col-form-label">Departure date</label>
        <div class="col-10">
            <form:input path="departureTime" class="form-control" type="date" id="departure-date-input"/>
        </div>
        <%--Input date--%>
        <div class="form-group row">
        <label for="arrival-date-input" class="col-2 col-form-label">Departure date</label>
        <div class="col-10">
            <form:input path="arrivalTime" class="form-control" type="date" id="arrival-date-input"/>
        </div>
        <%--Inpute train--%>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <label class="input-group-text" for="inputTrain">Train</label>
            </div>
            <select:form class="custom-select" id="inputTrain">
                    <form:options value="${train}"/>
            </select:form>
        </div>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <label class="input-group-text" for="inputTrain">Path</label>
            </div>
            <select:form class="custom-select" id="inputPath">
                    <form:options value="${train}"/>
            </select:form>
        </div>
    </form:form>
</div>

</body>
</html>
