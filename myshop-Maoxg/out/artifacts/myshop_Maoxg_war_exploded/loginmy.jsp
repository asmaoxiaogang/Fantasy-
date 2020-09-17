<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/9/12
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <style>
        a {
            text-decoration:none
        }
        table{
            width: 500px;
            border: 1px solid black;
            align: center;
            cellspacing: 0;
            cellpadding: 0;
        }
        .four{
            background-color: #ECF1F6;
            border: 2px solid #FFF;
            height: 45px;
            line-height: 45px;
            color: #212121;
            font-weight: normal;
        }
        .show {
            background-color: #F6F6F7;
            border: 2px solid #FFF;
            height: 45px;
            line-height: 45px;
            color: #555555;
            text-align: left;
            padding-left: 10px;
        }
        .login-input {
            border: 1px solid black;
            background-color: #ffeded;
            padding: 1px 6px;
            /*padding-left: 10px;*/
            border-radius: 15px
        }
        .showlogin{
            padding-left: 190px;
        }
        .register-a{
            border: 1px solid black;
            background-color: #ffeded;
            padding: 1px 6px;
            margin-left: 10px;
            border-radius: 15px
        }
    </style>
</head>
<body>
<h1>Welcome MyShop</h1>
<form action="user.action?method=loginUser" method="post">
    <table align="center">

        <tr>
            <td class="four">username</td>
            <td class="show">
                <input type="text" name="username" style="color: #999"
                        value="请输入用户名"
                        onfocus="if( this.value=='请输入用户名'){this.value='';this.style.color='#424242'}"
                        onblur="if(this.value=='') {this.value='请输入用户名';this.style.color='#999'}">
            </td>
        </tr>

        <tr>
            <td class="four">password</td>
            <td class="show"><input type="password" name="password">
            </td>
        </tr>

        <tr>
            <td class="four">是否自动登录</td>
            <td class="show">
                <%-- 后期根据status确定是否保存session --%>
                是:<input type="radio" name="status" value="1" checked="checked">
                否:<input type="radio" name="status" value="0" >
            </td>
        </tr>

        <tr >
            <td colspan="2" class="showlogin" >
                <span >
                     <input class="login-input" type="submit" value="登录">
                     <a class="register-a" href="registermy.jsp" style="font-size: 14px">注册</a>
                </span>

            </td>
        </tr>


    </table>

</form>

</body>
</html>
