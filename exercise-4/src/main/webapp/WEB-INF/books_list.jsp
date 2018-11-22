<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Books Store</title>
</head>
<body>
<h1>
    Available Books
</h1>
<table>
    <thead >
        <tr>
            <td>
                Id
            </td>
            <td>
                Name
            </td>
            <td>
                ISBN
            </td>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book" varStatus="status">
        <tr>
            <td>
                ${book.id}
            </td>
            <td>
                ${book.name}
            </td>
            <td>
                ${book.isbn}
            </td>
        </tr>

    </c:forEach>
    </tbody>

</table>
</body>
</html>