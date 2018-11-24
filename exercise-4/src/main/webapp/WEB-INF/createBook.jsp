<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Agregar Libro</title>
</head>
<body>

<h1>${welcomeMessage}</h1>
<form:form method="post" action="addNewBook" modelAttribute="book">
    <table>
        <tr>
            <td>Name</td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td>ISBN</td>
            <td><form:input path="isbn" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>
</form:form>

</body>

</html>