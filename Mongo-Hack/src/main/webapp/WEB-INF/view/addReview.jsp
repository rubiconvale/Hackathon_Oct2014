<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<h3>Welcome, Enter The Employee Details</h3>
<%--<form method="POST" action="/Mongo-Hack/addReview" name="review">--%>
<form name="review" action="/Mongo-Hack/addReview" method="POST"/>
    <input type="hidden" name="contractorId" value="${contractorId}"/>
    <table>
        <tr>
            <td><label>Name</label></td>
            <td><input name="author"/></td>
        </tr>
        <tr>
            <td><label>Comment</label></td>
            <td><input name="comment"/></td>
        </tr>
        <tr>
            <td><label>Rating</label></td>
            <td><input name="rating"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form>
</body>
</html>