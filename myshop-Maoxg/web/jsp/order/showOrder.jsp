<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/9/16
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>orderMsgShow</title>
    <style>
        .four{
            background-color: #ECF1F6;
            border: 2px solid #FFF;
            height: 45px;
            line-height: 45px;
            color: #212121;
            font-weight: normal;
        }

        td {
            background-color: #F6F6F7;
            border: 2px solid #FFF;
            height: 45px;
            line-height: 45px;
            color: #555555;
            text-align: center;
        }

        #buttonBuy-a{
            border: 1px solid black;
            padding: 2px;
            background-color: #ffeded;
            border-radius: 15px
        }

    </style>
</head>
<body>
<h1><span style="color: darkred">${sessionScope.username}</span>Welcome Come MyShop</h1>
    <table width="900px" border="1px solid black" align="center" cellspacing="0" cellpadding="0">
        <tr>
            <td class="four">id</td>
            <td class="four">用户名</td>
            <td class="four">金额</td>
            <td class="four">状态</td>
            <td class="four">创建时间</td>
            <td class="four">收获地址</td>
            <td class="four">操作</td>
        </tr>

        <c:if test="${not empty list}">
            <c:forEach items="${list}" var="order">
                <tr>
                    <td>${order.id}</td>
                    <td>${order.uid}</td>
                    <td>${order.money}</td>
                    <td>${order.status}</td>
                    <td>${order.time}</td>
                    <td>${order.aid}</td>
                    <td>
                            <%--点击确认按钮后就跳转到首页--%>
                                <input id="buttonBuy-a" type="submit" value="去支付">
                    </td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</body>
</html>
