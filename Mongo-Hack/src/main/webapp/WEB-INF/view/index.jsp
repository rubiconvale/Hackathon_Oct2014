<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<h3>Welcome, Search for Contractors</h3>

<form name="input" method="GET" action="/Mongo-Hack/searchContractor">
    <table>
        <tr>
            <td><label path="trade">Trade</label></td>
            <%--<td><form:input path="trade"/></td>--%>
            <td>
                <select name="trade">
                    <option value="DRILLING">Drilling</option>
                    <option value="WELDING">Welding</option>
                    <option value="MASONRY">Masonry</option>
                    <option value="PAINTING">Painting</option>
                    <option value="ELECTRICIAN">Electrician</option>
                    <option value="JANITORIAL">Janitorial</option>
                </select>
            </td>
        </tr>
        <tr>
            <td><label path="zipCode">zipCode</label></td>
            <td><input name="zipCode" maxlength="5"/></td>
        </tr>
        <tr>
            <td><label path="rating">Rating</label></td>
            <%--<td><input path="rating"/></td>--%>
            <td>
                <select name="rating">
                    <option value="5">5-Star</option>
                    <option value="4">4-Star</option>
                    <option value="3">3-Star</option>
                    <option value="2">2-Star</option>
                    <option value="1">1-Star</option>
                </select>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form>
</body>
</html>