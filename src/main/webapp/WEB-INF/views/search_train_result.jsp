<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<h1>Schedule List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr>
        <th>Train</th>
        <th>Departure time</th>
        <th>Arrival time</th>
    </tr>
    <c:forEach var="schedule" items="${trainItemList}">
        <tr>
            <td>${schedule.train}</td>
            <td>${schedule.dateStationArrival}</td>
            <td>${schedule.dateStationDeparture}</td>
        </tr>
    </c:forEach>
</table>
<br/>