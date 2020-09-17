<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/9/16
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>getAddress</title>
    <style>
        #inputAddress-table{
            /*width: 600px;*/
            border: 1px solid black;
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

        td {
            background-color: #F6F6F7;
            border: 2px solid #FFF;
            height: 45px;
            line-height: 45px;
            color: #555555;
            text-align: center;
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
    </style>
</head>
<body>
<h1><span style="color: darkred">${sessionScope.username}</span>:&nbsp;请填写您的收货信息</h1>
    <form action="address.action?method=addAddress" method="post">
        <table id="inputAddress-table" align="center">
            <table align="center" border="1px solid black" width="600px" >
                <tr>
                    <td class="four">地址信息:</td>
                    <td class="show">
					<span>
					<select name="province" >
						<option>省份</option>
						<option>河南</option>
						<option>江苏</option>
					</select>
				</span>
                        <span>
					<select name="city" >
						<option>市</option>
						<option>安阳市</option>
						<option>苏州市</option>
					</select>
				</span>
                        <span>
					<select name="area" >
						<option>区/县</option>
						<option>文峰区</option>
						<option>昆山市</option>
					</select>
				</span>
                        <span>
					<select name="street" >
						<option>街道/镇</option>
						<option>南关街道</option>
						<option>开发区</option>
					</select>
				</span>

                    </td>
                </tr>
                <tr>
                    <td class="four">详细信息:</td>
                    <td class="show"><span>
					<input type="text" name="details"  style="color: #999" value="请输入详细地址"
                           onfocus="if( this.value=='请输入详细地址'){this.value='';this.style.color='#424242'}"
                           onblur="if(this.value=='') {this.value='请输入详细地址';this.style.color='#999'}">
				</span></td>
                </tr>
                <tr>
				<span>
					<td class="four">收货人姓名:</td>
					<td class="show"><input type="text" name="name"  style="color: #999" value="请输入收货人姓名"
                                            onfocus="if( this.value=='请输入收货人姓名'){this.value='';this.style.color='#424242'}"
                                            onblur="if(this.value=='') {this.value='请输入收货人姓名';this.style.color='#999'}"></td>
				</span>
                </tr>

                <tr>
				<span>
					<td class="four">手机号:</td>
					<td class="show"><input type="text" name="phone"  style="color: #999" value="请输入手机号"
                                            onfocus="if( this.value=='请输入手机号'){this.value='';this.style.color='#424242'}"
                                            onblur="if(this.value=='') {this.value='请输入手机号';this.style.color='#999'}"></td>

				</span>

                </tr>
                <tr>
                    <td class="four">操作:</td>
                    <td class="show"><input type="submit" value="确认"> </td>
                </tr>

            </table>

        </table>
    </form>

</body>
</html>
