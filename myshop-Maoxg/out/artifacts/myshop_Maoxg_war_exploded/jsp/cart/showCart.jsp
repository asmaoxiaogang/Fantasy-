<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/9/14
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>showCart</title>
    <style>
        #two {
            display: block;
            position: fixed;
            bottom: 100px;
            right: 100px;
            border:1px solid black;
            height: 50px;
            width: 150px;
            background-color: darkseagreen;
        }
        #one {
            display: block;
            position: absolute;
            /*bottom: 150px;*/
            top: 100px;
            right: 100px;
            border:1px solid black;
            height: 50px;
            width: 150px;
            background-color: chocolate;
        }

        input {
            width: 45px;
        }
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

        a{ text-decoration:none}

        #deleteID-a {
            border: 1px solid black;
            background-color: #ffeded;
            padding: 1px 6px;
            border-radius: 15px
        }

        #buyID-a{
            border: 1px solid black;
            background-color: #ffeded;
            padding: 1px 6px;
            border-radius: 15px

        }
        #modify-input{
            border: 1px solid black;
            background-color: #ffeded;
            padding: 1px 6px;
            border-radius: 15px
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
<h1><span style="color: darkred">${sessionScope.username}</span> Come on showCart</h1>
<a id="one" href="cart.action?method=deleteCart&id=${sessionScope.userId}" >清空购物车</a>
<table width="500px" border="1px solid black" align="center" cellspacing="0" cellpadding="0">
    <tr>
        <th class="four">用户号</th>
        <th class="four">商品号</th>
        <th class="four">商品数量</th>
        <th class="four">商品价格</th>
        <td class="four">操作</td>
    </tr>


    <c:if test="${not empty list}">
        <c:forEach items="${list}" var="shoppingCart">
            <form action="cart.action?method=modifyCartNum&userId=${sessionScope.userId}" method="post">
                <tr>
                    <td>${shoppingCart.id}</td>
                    <td>${shoppingCart.pid}</td>
<%--                    <td>${requestScope.goodsName}</td>--%>
                    <td>
                        <input type="number" name="num" value="${shoppingCart.num}">

                        <input id="modify-input" type="submit" value="修改">

                        <input type="hidden" name="id" value="${shoppingCart.pid}" >
                            <%--                    <a href="cart.action?method=modifyCartNum">修改数据</a>--%>

                    </td>
                    <td>${shoppingCart.price}</td>
                    <td colspan="2">
                        <a id="deleteID-a"  href="cart.action?method=deletePidCart&pid=${shoppingCart.pid}">删除</a>
                            <%--<a href="<c:url value="/BrMgrServlet?act=exam&testId=1"/>">查看</a> 参考--%>
                            <%--<a id="buyID-a" href="order.action?method=addOrder">结算</a> 无效写法--%>
                        <a id="buyID-a" href="<c:url value="/order.action?method=addOrder&num=${shoppingCart.num}&price=${shoppingCart.price}"/> ">结算</a>
                    </td>

                </tr>
            </form>

        </c:forEach>
    </c:if>
    <tr>
        <td colspan="5">
            <a id="buttonBuy-a" href="">结算所有</a>
        </td>
    </tr>

</table>
<a id="two" href="goods.action?method=listGoods">返回主页</a>
</body>
</html>
