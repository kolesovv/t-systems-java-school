<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Edit station</h1>
<form:form method="POST" action="/sbb_war/station">
    <table >
        <tr>
            <td></td>
            <td><form:hidden  path="idStation" /></td>
        </tr>
        <tr>
            <td>Name : </td>
            <td><form:input path="nameStation"  /></td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Save" /></td>
        </tr>
    </table>
</form:form>