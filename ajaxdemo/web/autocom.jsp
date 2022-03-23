<%--
  Created by IntelliJ IDEA.
  User: zhangxianlin
  Date: 2022/3/23
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>自动补全</title>
    <style type="text/css">
        .content{
            width:643px;
            margin:200px auto;
            text-align: center;
        }
        input[type='text']{
            width:530px;
            height:40px;
            font-size: 14px;
        }
        input[type='button']{
            width:100px;
            height:46px;
            background: #38f;
            border: 0;
            color: #fff;
            font-size: 15px
        }
        .show{
            position: absolute;
            width: 535px;
            border: 1px solid #999;
            border-top: 0;
            display: none;
        }
    </style>
    <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
    <script type="text/javascript">
        function searchWord(obj) {
            //
            var word = $(obj).val()
            $.post(
                "${pageContext.request.contextPath}/search",
                {"word":word},
                function (data) {
                    if(data) {
                        var content = "";
                        for(var i=0; i<data.length;i++) {
                            content+="<div>"+data[i].name+"</div>";
                        }
                        $("#show").html(content).show();
                    }
                },
                "json"
            )
        }
    </script>

</head>
<body>
    <div class="content">
        <img alt="" src="logo.png"><br/><br/>
        <input type="text" name="word" onkeyup="searchWord(this)">
        <input type="button" value="搜索一下">
        <div class="show" id="show"></div>
    </div>
</body>
</html>
