<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: zhangxianlin
  Date: 2022/3/16
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试jsp</title>
</head>
<body>
    <%
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
        String curTime = dateFormat.format(date);
        request.setAttribute("curTime",curTime);
    %>

    当前系统时间:<span style="color: red;"><%=request.getAttribute("curTime")%></span>
</body>
</html>
