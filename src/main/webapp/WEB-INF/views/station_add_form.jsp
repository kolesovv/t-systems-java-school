<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>New station</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Add new station</h2>
    <%--<p>The .table-striped class adds zebra-stripes to a table:</p>--%>
    <form:form method="POST" action="../station/">
        <table >
            <tr>
                <td>Name : </td>
                <td><form:input type="text" class="form-control form-control" path="nameStation"  /></td>
            </tr>
            <tr>
                <td> </td>
                <td><input type="submit" class="btn btn-info" value="Create" /></td>
            </tr>
        </table>
    </form:form>
</div>

</body>
</html>