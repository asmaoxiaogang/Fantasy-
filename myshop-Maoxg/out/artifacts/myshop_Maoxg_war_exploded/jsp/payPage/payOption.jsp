<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/9/16
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>支付方式选择</title>
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
    </style>
</head>
<body>
<h1>请选择您的支付方式</h1>
    <table width="600px" border="1px solid black" align="center">
        <tr>
            <td colspan="3" class="four">请选择您需要的支付方式</td>
        </tr>
        
        <tr>
            <td class="four">微信</td>
            <td class="four">支付宝</td>
            <td class="four">银联</td>
        </tr>
        <tr>
            <td>
                <a href="">
                    <img width="200px" src="${pageContext.request.contextPath}/img/1.jpg" alt="微信支付">
                </a>
            </td>

            <td>
                <a href="">
                    <img width="200px" src="${pageContext.request.contextPath}/img/2.jpg" alt="支付宝支付">
                </a>
            </td>

            <td>
                <a href="">
                    <img width="200px" src="${pageContext.request.contextPath}/img/3.jpg" alt="银联支付">
                </a>
            </td>
        </tr>
    </table>
</body>
</html>
