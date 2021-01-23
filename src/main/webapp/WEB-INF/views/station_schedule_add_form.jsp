<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>${station.nameStation}</h1>
<h2>Add schedule for current station</h2>
<form:form method="POST" action="/sbb/schedule/station">
    <table >
        <tr>
            <td><form:hidden value="${station}" path="station"/></td>
            <td>Departure time : </td>
            <td><form:input type="text" path="departureTime"  /></td>
            <td>Arrival time : </td>
            <td><form:input type="text" path="arrivalTime"  /></td>
            <td>Train</td>
            <td>
                <form:select name="train" path="train">
                    <%--<c:forEach var="train" items="${trains}">--%>
                        <form:option value="NONE"> --SELECT--</form:option>
                        <form:options items="${trains}"></form:options>
                    <%--</c:forEach>--%>
                </form:select>
            </td>
            <td></td>
            <td><input type="submit" value="Create" /></td>
        </tr>
    </table>
</form:form>