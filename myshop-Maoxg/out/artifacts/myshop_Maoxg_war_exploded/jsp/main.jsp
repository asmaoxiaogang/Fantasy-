<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/9/12
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
    <style>

        #one {
            display: block;
            position: fixed;
            bottom: 30px;
            right: 30px;
            border:1px solid black;
            height: 50px;
            width: 200px;
            background-color: #fcc
        }
        #two {
            display: block;
            position: fixed;
            top: 30px;
            right: 30px;
            border:1px solid black;
            height: 50px;
            width: 200px;
            background-color: #ffc
        }
        #three {
            width: 40px;
        }
        #four {
            width: 70px;
            font-size: 10px;
        }

        .four{
            background-color: #ECF1F6;
            border: 1px solid #FFF;
            height: 45px;
            width: 70px;
            line-height: 45px;
            color: #212121;
            font-weight: normal;
        }

        td {
            background-color: #F6F6F7;
            border: 1px solid #FFF;
            height: 45px;
            width: 70px;
            line-height: 45px;
            color: #555555;
            text-align: center;
        }

        /*.this{*/
        /*    !*height: 38px;*!*/
        /*    line-height: 38px;*/
        /*    text-align: center;*/
        /*    font-size: 16px;*/
        /*}*/
    </style>
</head>
<body>

<h1><span style="color: darkred">${sessionScope.username}</span> Come on showCart</h1>

    <a id="two" href="user.action?method=userLoginOut&goodList">注销此次登录</a>

<%--<form action="cart.action?method=addCart" method="post">--%>
    <table width="900px" border="1px" align="center">
        <tr>
            <td class="four">商品号</td>
            <td class="four" colspan="2">商品名字</td>
            <td class="four" colspan="3">生产日期</td>
            <td class="four">图片地址</td>
            <td class="four">价格</td>
            <td class="four">评分</td>
            <td class="four">商品详情</td>
            <td class="four">商品类型</td>
            <td class="four" colspan="2">输入购买数量</td>
        </tr>
        <c:if test="${not empty goodsList}">
            <c:forEach items="${goodsList}" var="goods">
<%--                <form action="cart.action?method=addCart?id=${goods.id}&num&price=${goods.price}" method="get">--%>
                <form action="cart.action" method="post">
                    <tr>
                        <td>
                                ${goods.id}
                            <input type="hidden" name="pid" value="${goods.id}">
                        </td>

                        <td colspan="2">${goods.name}</td>
<%--                        --%>
                        <input type="hidden" name="goodsName" value="${goods.name}">
                        <td colspan="3">${goods.pubdate}</td>
                        <td ><img style="width: 50px" src="${goods.picture}" alt="${goods.name}"></td>
                        <td>
                                ${goods.price}
                            <input type="hidden" name="price" value="${goods.price}">
                        </td>
                        <td>${goods.star}</td>
                        <td>${goods.info}</td>
                        <td>${goods.typeid}</td>
                        <td colspan="2">
                                <%--这里后期要加js校验，限制用户只输入数字类型数据 --%>
                                <%--                        数量 --%>
                            <input id="three" type="number" name="num">
                                    <input type="hidden" name="method" value="addCart">
                                    <input type="hidden" name="id" value="${sessionScope.userId}">
<%--                            <a href="cart.action?method=addCart?$id={goods.id}">加入购物车</a>--%>
                                    <input style="border-radius: 15px; background-color: #ff0036 ;color: #fff; padding: 1px 2px 1px 2px" id="four" type="submit" value="加入购物车">
                        </td>
                            <%--                    --%>

                    </tr>
                </form>
            </c:forEach>
        </c:if>

<%--        <td><input type="submit" value="加入购物车"></td>--%>
    </table>
<%--</form>--%>

    <a id="one"  href="cart.action?method=listCartLimit&id=${sessionScope.userId}">查看购物车</a>

</body>
</html>
