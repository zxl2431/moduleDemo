<%--
  Created by IntelliJ IDEA.
  User: zhangxianlin
  Date: 2022/3/18
  Time: 0:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--使用taglib指令引入jstl--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>choose标签</title>
</head>
<body>
<%
    request.setAttribute("num", 4);
    request.setAttribute("flag", 1);

%>
<!-- c:choose 表示那些when 和 otherwise是一组的 -->
<c:choose>
    <c:when test="${num == 1 }">星期一</c:when>
    <c:when test="${num == 2 }">星期二</c:when>
    <c:when test="${num == 3 }">星期三</c:when>
    <c:when test="${num == 4 }">星期四</c:when>
    <c:when test="${num == 5 }">星期五</c:when>
    <c:when test="${num == 6 }">星期六</c:when>
    <c:when test="${num == 7 }">星期日</c:when>
    <c:otherwise>参数不合法</c:otherwise>
</c:choose>

<c:choose>
    <c:when test="${flag == 1 }">白天</c:when>
    <c:when test="${flag == 2 }">黑夜</c:when>
    <c:otherwise>参数不合法</c:otherwise>
</c:choose>
</body>
</html>
