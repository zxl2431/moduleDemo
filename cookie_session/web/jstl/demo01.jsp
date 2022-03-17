<%--
  Created by IntelliJ IDEA.
  User: zhangxianlin
  Date: 2022/3/17
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--使用taglib指令引入jstl--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jstl-if标签</title>
</head>
<body>

    <%--使用if标签
       test属性就相当于if语句中的判断表达式
       if(表达式){要执行的代码}
       jstl标签一般都要结合EL表达式使用
    --%>
    <c:if test="${3>5}">
        你说的对
    </c:if>

    <%--jstl没有else标签，所以只能再写一个if，条件变成与这个刚好相反--%>
    <c:if test="${3<=5}">
        你说错了 <br>
    </c:if>

    <c:if test="${true}" scope="session" var="flag">
        测试if标签，设置test为true
    </c:if>
    <br>测试if标签,获取test属性的值，从知道的session容器中获取：${sessionScope.flag}


</body>
</html>
