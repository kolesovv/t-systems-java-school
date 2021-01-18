<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<h1>Station List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr>
        <th>Name</th>
        <th>Edit</th>
        <th>Delete</th>
        <th>Find schedules by station</th>
    </tr>
    <c:forEach var="station" items="${stations}">
        <tr>
            <td>${station.nameStation}</td>
            <td><a href="station/${station.idStation}">Edit</a></td>
            <td><a href="station/delete/${station.idStation}">Delete</a></td>
            <td><a href="schedule/station/${station.idStation}">Find</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="station/form">Add new station</a>