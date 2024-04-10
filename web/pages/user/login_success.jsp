<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <title>尚硅谷会员注册页面</title>
    <%@include file="/pages/common/header.jsp"%>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: red;
        }
    </style>
</head>
<body>
<div id="header">
    <a href="index.jsp"><img class="logo_img" alt="logo" src="static/img/logo.gif"></a>
    <%@include file="/pages/common/user_info.jsp"%>
</div>

<div id="main">

    <h1>欢迎回来 <a href="index.jsp">转到主页</a></h1>

</div>

<%@include file="/pages/common/footer.jsp"%>
</body>
</html>