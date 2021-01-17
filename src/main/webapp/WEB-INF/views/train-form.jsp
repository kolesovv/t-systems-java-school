<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <button type="submit" class="btn btn-secondary"
            onclick="window.location.href='admin';return false">Back to list</button>
    <form:form action="savetrain" modelAttribute="train" method="post">
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">Train</span>
            </div>
            <form:input path="trainName" type="text" class="form-control"/>
            <div class="input-group-prepend">
                <span class="input-group-text">Seats</span>
            </div>
            <form:input path="seats" type="number" class="form-control"/>
        </div>
        <button type="submit" class="btn btn-secondary">Submit</button>
    </form:form>
</div>

</body>
</html>



<%--
<form:form action="savetrain" modelAttribute="train" method="post" class="was-validated">
    <form:hidden path="numberTrain"/>
    <div class="form-group">
        <label for="trainName">Train name:</label>
        <form:input path="trainName" type="text" class="form-control" id="trainName"
                    required="required" placeholder="Train name"
                    name="trainName"/>
        <form:input path="seats" type="text" class="form-control" id="seats"
                    required="required" placeholder="Seats"
                    name="seats"/>
        <div class="valid-feedback">Valid.</div>
        <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form:form>
--%>
