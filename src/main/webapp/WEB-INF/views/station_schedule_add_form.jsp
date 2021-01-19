<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Add new train</h1>
<form:form method="POST" action="/sbb_war/schedule/station">
    <table >
        <tr>
            <td>Station :</td>
            <td><form:input type="number" path="station"  /></td>
            <td>Departure time : </td>
            <td><form:input type="date" path="departureTime"  /></td>
            <td>Arrival time : </td>
            <td><form:input type="date" path="arrivalTime"  /></td>
            <td>Train</td>
            <td><form:input type="number" path="train" /></td>
            <td></td>
            <td><input type="submit" value="Create" /></td>
        </tr>
    </table>
</form:form>