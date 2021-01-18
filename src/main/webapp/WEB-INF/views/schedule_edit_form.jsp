<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Edit station</h1>
<form:form method="POST" action="/sbb/schedule">
    <table >
        <tr>
            <td></td>
            <td><form:hidden  path="id" /></td>
        </tr>
        <tr>
            <td>Station : </td>
            <td><form:input path="station"/></td>
        </tr>
        <tr>
            <td>Departure : </td>
            <td><form:input path="departureTime"/></td>
        </tr>
        <tr>
            <td>Arrival : </td>
            <td><form:input path="arrivalTime"/></td>
        </tr>
        <tr>
            <td>Train : </td>
            <td><form:input path="train"/></td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Save" /></td>
        </tr>
    </table>
</form:form>