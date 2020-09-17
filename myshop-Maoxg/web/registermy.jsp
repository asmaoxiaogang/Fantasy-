<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/9/12
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="user.action?method=registerUser" method="post" >
<table width="500px" border="1px" align="center">
    <tr>
        <td>用户名</td>
        <td><input type="text" name="username"></td>
    </tr>
    <tr>
        <td>密码</td>
        <td><input type="password" name="password"></td>
    </tr>
    <tr>
        <td>确认密码</td>
        <td><input type="password" name="password"></td>
    </tr>
    <tr>
        <td>邮箱</td>
        <td><input type="email" name="email"></td>
    </tr>
    <tr>
        <td>gender</td>
        <td>
            <input type="radio" name="gender" value="0" checked="checked">男
            <input type="radio" name="gender" value="1">女
        </td>
    </tr>
    <%--这里的flag为激活状态，默认为1为激活； 0未激活，2无效--%>
    <input type="hidden" name="flag" value="1">
    <%-- role为身份标记默认为1为会员；0为管理员--%>
    <input type="hidden" name="role" value="1">
    <%--code为激活码，默认为空。    --%>
    <input type="hidden" name="code" value="">
    <tr>
        <td colspan="2"><input type="submit" value="提交"></td>
    </tr>
</table >
</form>
<a href="loginmy.jsp">登录</a>

</body>
</html>
