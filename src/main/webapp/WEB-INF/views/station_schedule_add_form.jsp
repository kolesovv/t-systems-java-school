<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>${station.nameStation}</h1>
<h2>Add schedule for current station</h2>
<form:form method="POST" action="/sbb/schedule/station">
    <table >
        <tr>
            <td><form:hidden value="${station.idStation}" name="name" path="station.idStation"/></td>
            <td>Departure time : </td>
            <td><form:input type="text" path="departureTime" placeholder="2021-01-01 01:00:00.0"/></td>
            <td>Arrival time : </td>
            <td><form:input type="text" path="arrivalTime" placeholder="2021-01-01 01:00:00.0"/></td>
            <td>Train</td>
            <td>
                <form:select path="train.numberTrain" name="trainId"  id="train">
                    <c:forEach var="train" items="${trains}">
                        <option value="${train.numberTrain}">${train.trainName}</option>
                    </c:forEach>
                </form:select>
            </td>
            <td></td>
            <td><input type="submit" value="Create" /></td>
        </tr>
    </table>
</form:form>