<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="javatime" uri="http://www.springframework.org/tags/form" %>

<h1>Add new train</h1>
<h1>${station.nameStation}</h1>
<form:form method="POST" action="/sbb_war/schedule/station/${station.idStation}">
    <table >
        <tr>
            <td>Departure time : </td>
            <td><form:input type="datetime" path="departureTime"  /></td>
            <td>Arrival time : </td>
            <td><form:input type="datetime" path="arrivalTime"  /></td>
            <td>Train</td>
            <td>
                <form:select name="train" path="trainId">
                    <c:forEach items="${trains}" var="train">
                        <option value="${train.id}">${train.trainName}</option>
                    </c:forEach>
                </form:select>
            </td>
            <td></td>
            <td><input type="submit" value="Create" /></td>
        </tr>
    </table>
</form:form>
