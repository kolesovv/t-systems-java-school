<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Add new train</h1>
<form:form method="POST" action="../train">
    <table >
        <tr>
            <td>Name : </td>
            <td><form:input path="trainName"  /></td>
            <td>Value of seats : </td>
            <td><form:input path="seats"  /></td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Create" /></td>
        </tr>
    </table>
</form:form>