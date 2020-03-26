<%--
  Created by IntelliJ IDEA.
  User: Welisit
  Date: 2020/3/19
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String baseUrl = request.getScheme() + "://" +
            request.getServerName() + ":"
            + request.getServerPort() +
            request.getContextPath() + "/";
    pageContext.setAttribute("baseUrl", baseUrl);
%>
<base href="<%=baseUrl%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css">
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
