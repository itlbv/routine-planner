<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Routines
<c:forEach items="${routines}" var="routine">
    <jsp:useBean id="routine" type="com.itlbv.routineplanner.model.Routine"/>
    <%--        <tr class="${meal.excess ? 'excess' : 'normal'}">     --%>
    <tr>
        <td>${routine.name}</td>
        <td><a href="routines?action=update&id=${routine.id}">Update</a></td>
        <td><a href="routines?action=delete&id=${routine.id}">Delete</a></td>
    </tr>
</c:forEach>
</body>
</html>
