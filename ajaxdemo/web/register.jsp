<%--
  Created by IntelliJ IDEA.
  User: zhangxianlin
  Date: 2022/3/23
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>会员注册</title>
    <script src="js/jquery-3.3.1.js" type="text/javascript"></script>
    <script type="text/javascript">
        function checkUsername(obj) {
            // 获取输入框的值
            var username = $(obj).val();
            $.post(
                "${pageContext.request.contextPath}/user",
                {"username":username},
                function (data) {
                    if(data.isExist) {
                        $("#usernameInfo").html("输入用户名已经存在").css("color", "red");
                    }else{
                        $("#usernameInfo").html("用户名可以使用").css("color", "green");
                    }
                },
                "json"
            )
        }
    </script>
</head>
<body>
<div>
    <font>会员注册</font>USER REGISTER
    <form class="form-horizontal" style="margin-top: 5px;">
        用户名<input type="text" name="username" onblur="checkUsername(this)" placeholder="请输入用户名">
        <span id="usernameInfo" style="color:red"></span><br/>
        密码<input type="password" placeholder="请输入密码"><br/>
        <input type="submit" value="注册"/>
    </form>
</div>
</body>
</html>
