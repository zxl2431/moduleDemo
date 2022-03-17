<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: zhangxianlin
  Date: 2022/3/18
  Time: 0:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--演示循环数组--%>
<%
    int[] arr = {666,888,999,1024};
    request.setAttribute("arr", arr);

%>
<%-- var在循环对象的时候，临时保存被循环到元素 --%>
<c:forEach items="${arr }" var="num">
    ${num }
</c:forEach>
<hr>
<%
    List list = new ArrayList();
    list.add("卡奴");
    list.add("兰恩");
    list.add("云娜");

    request.setAttribute("list", list);

%>
<c:forEach items="${list }" var="wind">
    ${wind }
</c:forEach>
<hr>
<%
    Map map = new HashMap();
    map.put("ms1", "简历");
    map.put("ms2", "身份证");
    map.put("ms3", "学历证明");
    map.put("ms4", "体检报告");

    request.setAttribute("map", map);

%>
<c:forEach items="${map }" var="entry">

    ${entry.key }
    ${entry.value }
</c:forEach>
</body>
</html>
