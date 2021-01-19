<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Add new passenger</h1>
<form:form method="POST" action="/sbb_war/passenger">
    <table >
        <tr>
            <td>Name : </td>
            <td><form:input path="name"  /></td>
            <td>Surname : </td>
            <td><form:input path="surname"  /></td>
            <td>Date of birth:  </td>
            <td><form:input type="date" path="dateOfBirth"  /></td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Create" /></td>
        </tr>
    </table>
</form:form>