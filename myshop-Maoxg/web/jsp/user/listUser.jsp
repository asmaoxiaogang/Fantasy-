<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/9/12
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示所有User</title>
</head>
<body>
    <table width="500px" border="1px" align="center">
        <tr>
            <th>Id</th>
            <th>Username</th>
            <th>password</th>
            <th>email</th>
            <th>gender</th>
            <th>flag</th>
            <th>role</th>
            <th>code</th>
        </tr>

        <c:if test="${not empty allUser}">
            <c:forEach items="${allUser}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td>${user.email}</td>
                    <td>${user.gender}</td>
                    <td>${user.flag}</td>
                    <td>${user.role}</td>
                    <td>${user.code}</td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</body>
</html>
