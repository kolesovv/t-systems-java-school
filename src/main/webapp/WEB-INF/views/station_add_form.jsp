<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Add new station</h1>
<form:form method="POST" action="/sbb_war/station">
    <table >
        <tr>
            <td>Name : </td>
            <td><form:input path="nameStation"  /></td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Create" /></td>
        </tr>
    </table>
</form:form>