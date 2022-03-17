<%--
  Created by IntelliJ IDEA.
  User: zhangxianlin
  Date: 2022/3/17
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--获取数组--%>
${arr[4]} <br>
<%--获取list--%>
获取list集合：${list}<br>
获取list集合某一个数据：${list[0]}<br>
<%--获取map--%>
获取map集合：${map}<br>
获取map集合某一数据：${map.language1}<br>
获取map集合特殊key数据：${map["aa.bb.cc"]}<br>
</body>
</html>
