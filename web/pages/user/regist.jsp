<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <title>尚硅谷会员注册页面</title>
    <%@include file="/pages/common/header.jsp"%>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>
</head>
<body>
<div id="login_header">
    <a href="index.jsp"><img class="logo_img" alt="logo" src="static/img/logo.gif"></a>
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册尚硅谷会员</h1>
                    <span class="errorMsg">${ requestScope.msg }</span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="regist">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
                               name="username" value="${ requestScope.parameterMap.get("username")[0] }" id="username"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                               name="password" id="password"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1"
                               name="repwd" id="repwd"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1"
                               name="email" value="${requestScope.parameterMap.get("email")[0]}" id="email"/>
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" name="code" style="width: 150px;" value="${ requestScope.parameterMap.get("code")[0] }" id="code"/>
                        <img src="${baseUrl}kaptcha.jpg" alt="验证码" style="width: 100px; height: 35px;" id="code_img">
                        <script type="text/javascript">
                            $("#code_img").click(function () {
// 在事件响应的function 函数中有一个this 对象。这个this 对象，是当前正在响应事件的dom 对象
// src 属性表示验证码img 标签的图片路径。它可读，可写
// alert(this.src);
                                this.src = "${basePath}kaptcha.jpg?d=" + new Date();
                            });
                        </script>
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>