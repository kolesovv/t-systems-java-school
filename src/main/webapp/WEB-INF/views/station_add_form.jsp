<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Add station</h1>
<form:form method="POST" action="../station/">
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
            <td><input type="submit" value="Add" /></td>
        </tr>
    </table>
</form:form>