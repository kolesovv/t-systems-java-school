<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<h1>Passenger List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Date of birth</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="passenger" items="${passengers}">
        <tr>
            <td>${passenger.name}</td>
            <td>${passenger.surname}</td>
            <td>${passenger.dateOfBirth}</td>
            <td><a href="passenger/${passenger.id}">Edit</a></td>
            <td><a href="passenger/delete/${passenger.id}">Delete</a></td>
            <%--<td><a href="schedule/station/${station.idStation}">Find</a></td>--%>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="passenger/form">Add new passenger</a>