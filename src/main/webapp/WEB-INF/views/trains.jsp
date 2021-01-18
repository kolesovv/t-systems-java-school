<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<h1>Train List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr>
        <th>Name</th>
        <th>Number of seats</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="train" items="${trains}">
        <tr>
            <td>${train.trainName}</td>
            <td>${train.seats}</td>
            <td><a href="train/${train.numberTrain}">Edit</a></td>
            <td><a href="train/delete/${train.numberTrain}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="train/form">Add new train</a>
