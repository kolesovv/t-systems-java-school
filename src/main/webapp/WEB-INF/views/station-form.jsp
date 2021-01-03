<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Add new station</title>
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
            onclick="window.location.href='list-stations';return false">Back to list</button>
    <form:form action="saveStation" modelAttribute="station" method="post" class="was-validated">
        <form:hidden path="idStation"/>
        <div class="form-group">
            <label for="stationName">Station name:</label>
            <form:input path="nameStation" type="text" class="form-control" id="stationName"
                        required="required" placeholder="Station name"
                        name="stationName"/>
            <div class="valid-feedback">Valid.</div>
            <div class="invalid-feedback">Please fill out this field.</div>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form:form>
</div>

</body>
</html>
