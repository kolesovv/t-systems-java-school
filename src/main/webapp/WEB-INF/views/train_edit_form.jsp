<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Edit train</h1>
<form:form method="POST" action="/sbb/train">
    <table >
        <tr>
            <td></td>
            <td><form:hidden  path="numberTrain" /></td>
        </tr>
        <tr>
            <td>Name : </td>
            <td><form:input path="trainName"  /></td>
            <td>Value fo seats : </td>
            <td><form:input path="seats"  /></td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Save" /></td>
        </tr>
    </table>
</form:form>