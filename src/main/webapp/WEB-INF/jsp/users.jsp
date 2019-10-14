<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<jsp:include page="fragments/header.jsp"/>

<h1 class="text-center">Users</h1>

<div class="container">
    <table class="table">
        <thead class="thead-light">
        <tr>
            <th scope="col">#</th>
            <th scope="col">User</th>
            <th scope="col">Update</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <jsp:useBean id="user" type="com.itlbv.routineplanner.model.User"/>
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td><a class="btn btn-primary btn-sm" href="users?action=update&id=${user.id}">Update</a></td>
                <td><a class="btn btn-primary btn-sm" href="users?action=delete&id=${user.id}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<jsp:include page="fragments/footer.jsp"/>
</body>

</html>