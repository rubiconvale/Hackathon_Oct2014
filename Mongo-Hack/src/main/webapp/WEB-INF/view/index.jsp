<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    </head>
    <body>
        <h3>Welcome, Enter The Employee Details</h3>
        <form:form method="POST" action="/Mongo-Hack/searchContractor" modelAttribute="input">
             <table>
                <tr>
                    <td><form:label path="trade">Trade</form:label></td>
                    <td><form:input path="trade"/></td>
                </tr>
                <tr>
                    <td><form:label path="zipCode">zipCode</form:label></td>
                    <td><form:input path="zipCode" maxlength="5" /></td>
                </tr>
                <tr>
                    <td><form:label path="rating">Rating</form:label></td>
                    <td><form:input path="rating"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>