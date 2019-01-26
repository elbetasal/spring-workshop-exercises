<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head></head>

<body>
<h1>Home</h1>

<security:authorize access="hasRole('ROLE_USER')">
    <br/> <br/>
    <a href="<c:url value="/user/hello.html" />">Solo para Usuarios</a>
    <br/> <br/>
</security:authorize>

<security:authorize access="hasRole('ROLE_ADMIN')">
    <br/>
    <a href="<c:url value="/admin/hello.html" />">Solo para Admins</a>
    <br/>
</security:authorize>

<a href="<c:url value="/perform_logout" />">Bye</a>

</body>
</html>