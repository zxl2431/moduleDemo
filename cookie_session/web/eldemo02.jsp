<%--
  Created by IntelliJ IDEA.
  User: zhangxianlin
  Date: 2022/3/17
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
EL就是用来简化java代码的
$从域的对象中查找指定的数据
--%>
<%-- 在jsp设置(request)四个数据（10 20 30 40 ）的向页面输出（10+20+（30-40））计算结果 --%>
<%
    request.setAttribute("num1", 10);
    request.setAttribute("num2", 20);
    request.setAttribute("num3", 30);
    request.setAttribute("num4", 40);

    request.setAttribute("addr","上海");
    request.getSession().setAttribute("addr","北京");
    request.getSession().getServletContext().setAttribute("addr","广州");

%>
使用EL表达式输出：${num1 + num2 + (num3 - num4)}<br>
${addr} <br>
指定从request容器获取数据：${requestScope.addr}<br>
指定从session容器获取数据：${sessionScope.addr}<br>
指定从servletcontext容器获取数据：${applicationScope.addr}<br>

</body>
</html>
