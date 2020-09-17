<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/9/13
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示所有商品</title>
</head>
<body>
<table width="600px" border="1px" align="center">
    <tr>
        <td>id</td>
        <td>商品名字</td>
        <td>生产日期</td>
        <td>图片地址</td>
        <td>价格</td>
        <td>评分</td>
        <td>商品详情</td>
        <td>商品类型</td>
    </tr>
    <c:if test="${not empty goodsList}">
        <c:forEach items="${goodsList}" var="goods">
            <tr>
                <td>${goods.id}</td>
                <td>${goods.name}</td>
                <td>${goods.pubdate}</td>
                <td>${goods.picture}</td>
                <td>${goods.price}</td>
                <td>${goods.star}</td>
                <td>${goods.info}</td>
                <td>${goods.typeid}</td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
