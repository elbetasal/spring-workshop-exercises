<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Agregar Libro</title>
</head>
<body>

<form:form method="post" action="addNewBook" modelAttribute="book">
    <table>
        <tr>
            <td>Name</td>
            <td>
                <form:input path="name" />
                <form:errors path="name" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>ISBN</td>
            <td>
                <form:input path="isbn" />
            </td>
        </tr>
        <tr>
            <td>Phone</td>
            <td>
                <form:input path="phone" />
                <form:errors path="phone" />
            </td>
        </tr>
        <tr>
            <td>Email</td>
            <td>
                <form:input path="authorEmail" />
                <form:errors path="authorEmail" />
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>
</form:form>

</body>

</html>