<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<jsp:include page="fragments/header.jsp"/>

<h1 class="text-center">Routines</h1>

<div class="container">
    <table class="table">
        <thead class="thead-light">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Routine</th>
            <th scope="col">Update</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${routines}" var="routine">
            <jsp:useBean id="routine" type="com.itlbv.routineplanner.model.Routine"/>
            <tr>
                <td>${routine.id}</td>
                <td>${routine.name}</td>
                <td><a class="btn btn-primary btn-sm" href="routines?action=update&id=${routine.id}">Update</a></td>
                <td><a class="btn btn-primary btn-sm" href="routines?action=delete&id=${routine.id}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<jsp:include page="fragments/footer.jsp"/>
</body>

</html>