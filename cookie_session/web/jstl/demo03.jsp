<%--
  Created by IntelliJ IDEA.
  User: zhangxianlin
  Date: 2022/3/18
  Time: 0:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>foreach标签</title>
</head>
<body>
<%-- 演示foreach标签 --%>
<%
    for (int i = 1; i <= 5; i++) {

    }
%>
<%--
begin="1" int i = 1;
end="5"   i<=5;
step="6" 步长，控制循环，间隔几次循环，执行一次循环体中的内容

step="1" 1 2 3 4 5  M M M M M
step="2" 12 34 5    M M M
step="3" 123 45     M M
step="4" 1234 5     M M
step="5" 12345      M

--%>
<c:forEach begin="1" end="5" step="1" >
    M
</c:forEach>

<br>
<%--
var 属性在不循环对象的时候，相当于将for循环中的循环变量i，每次都记录下来。
--%>
<c:forEach begin="11" end="15" step="1" var="info">
    ${info}
</c:forEach>

<br>
<%--
varStatus :保存了当前循环过程中的信息，信息包括以下内容：
  1	  	public java.lang.Integer getBegin()
  		 返回为标签设置的begin属性的值，如果没有设置begin属性则返回null
  2		public int getCount()
 		 返回当前已循环迭代的次数
  3		public java.lang.Object getCurrent()
 		 返回当前迭代到的元素对象
  4		public java.lang.Integer getEnd()
		  返回为标签设置的end属性的值，如果没有设置end属性则返回null
  5		public int getIndex()
 		 返回当前迭代的索引号
  6		public java.lang.Integer getStep()
 		 返回为标签设置的step属性的值，如果没有设置step属性则返回null
  7		public boolean isFirst()
 		 返回当前是否是第一次迭代操作
  8		public boolean isLast()
 		 返回当前是否是最后一次迭代操作
--%>
<c:forEach begin="11" end="15" step="1" var="info" varStatus="sta">
    <td>${sta.index}</td>
    <td>${sta.count}</td>
    <td>${sta.first}</td>
    <td>${sta.last}</td><br>
</c:forEach>

</body>
</html>
