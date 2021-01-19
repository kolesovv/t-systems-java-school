<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<h1>${station.nameStation}</h1>
<h2>Train schedule</h2>
<table border="2" width="70%" cellpadding="2">
    <tr>
        <th>Train</th>
        <th>Departure time</th>
        <th>Arrival time</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="schedule" items="${schedule}">
        <tr>
            <td>${schedule.train.trainName}</td>
            <td><fmt:formatDate value="${schedule.departureTime}" pattern="HH:mm:ss"></fmt:formatDate></td>
            <td><fmt:formatDate value="${schedule.arrivalTime}" pattern="HH:mm:ss"></fmt:formatDate></td>
            <td><a href="/sbb_war/schedule/${schedule.id}">Edit</a></td>
            <td><a href="/sbb_war/schedule/delete/${schedule.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="schedule/station/form">Add new schedule</a>