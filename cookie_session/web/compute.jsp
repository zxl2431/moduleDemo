<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: zhangxianlin
  Date: 2022/3/17
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL运算</title>
</head>
<body>
    <%
        request.setAttribute("x",3);
        request.setAttribute("y",4);
        request.setAttribute("z","5");

        request.setAttribute("flag", true);
        request.setAttribute("info", false);

        request.setAttribute("str",null);
        request.setAttribute("list",new ArrayList<>());
    %>
    ${x + y}<br>
    ${x - y}<br>
    ${x * y}<br>
    ${x / y}<br>
    ${x % y}<br>
    <%--注意事项:
        1 在EL中，只要是数字就能执行运算，EL在执行计算的时候，默认，将所有数据转换成Long类型
        2 在EL中，如果在一个算式中有数据不存在，那么这个数据不参与运算，不报错继续执行。
    --%>
    ${x+y+z}<br>
    ${x+y+z+a}<br>

    ${flag && info }
    ${flag || info }
    ${!info } <br>

    ${empty str}<br>
    ${empty list}<br>
    ${str == null? "数据为空":str}<br>

</body>
</html>
