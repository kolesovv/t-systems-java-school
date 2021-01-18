<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<h1>Schedule List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr>
        <th>Departure time</th>
        <th>Arrival time</th>
        <th>Name of station</th>
        <th>Train</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="schedule" items="${schedule}">
        <tr>
            <td><fmt:formatDate value="${schedule.departureTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
            <td><fmt:formatDate value="${schedule.arrivalTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
            <td>${schedule.station.nameStation}</td>
            <td>${schedule.train.trainName}</td>
            <td><a href="schedule/${schedule.id}">Edit</a></td>
            <td><a href="schedule/delete/${schedule.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="station/form">Add new schedule</a>