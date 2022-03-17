<%--
  Created by IntelliJ IDEA.
  User: zhangxianlin
  Date: 2022/3/17
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式</title>
</head>
<body>
<%-- 在jsp设置request中的几个数据
    <%...%> Java语句
    <%=...%> 输出到客户端浏览器上
    <%!...%> 的作用是在类中调价方法或成员
--%>
<%
    request.setAttribute("num1", 10);
    request.setAttribute("num2", 20);
    request.setAttribute("num3", 30);
    request.setAttribute("num4", 40);
%>
java代码输出: <%= (Integer)request.getAttribute("num1") +
        (Integer)request.getAttribute("num2") +
        ( (Integer)request.getAttribute("num3") - (Integer)request.getAttribute("num4"))

%>
</body>
</html>
