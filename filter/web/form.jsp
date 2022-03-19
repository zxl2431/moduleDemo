<%--
  Created by IntelliJ IDEA.
  User: zhangxianlin
  Date: 2022/3/19
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath }/encoding">
    请发表你的言论：<input type="text" name="message">
    <input type="submit" value="提交">
</form>
</body>
</html>
