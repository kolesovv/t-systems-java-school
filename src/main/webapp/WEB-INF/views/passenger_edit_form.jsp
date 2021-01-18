<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Edit station</h1>
<form:form method="POST" action="/sbb_war/passenger">
    <table >
        <tr>
            <td></td>
            <td><form:hidden  path="id" /></td>
        </tr>
        <tr>
            <td>Name : </td>
            <td><form:input path="name"  /></td>
        </tr>
        <tr>
            <td>Surname : </td>
            <td><form:input path="surname"  /></td>
        </tr>
        <tr>
            <td>Date of birth : </td>
            <td><form:input type="date" path="dateOfBirth"  /></td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Save" /></td>
        </tr>
    </table>
</form:form>