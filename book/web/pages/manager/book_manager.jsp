<%@ page import="com.welisit.bean.Book" %>
<%@ page import="com.welisit.bean.Page" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
	<%@include file="/pages/common/header.jsp"%>
</head>
<body>
<script type="text/javascript">
	$(function () {
// 给删除的a 标签绑定单击事件，用于删除的确认提示操作
		$("a.deleteClass").click(function () {
// 在事件的function 函数中，有一个this 对象。这个this 对象，是当前正在响应事件的dom 对象。
			/**
			 * confirm 是确认提示框函数
			 * 参数是它的提示内容
			 * 它有两个按钮，一个确认，一个是取消。
			 * 返回true 表示点击了，确认，返回false 表示点击取消。
			 */
			return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() + "】?");
// return false// 阻止元素的默认行为===不提交请求
		});
	});
</script>
	
	<div id="header">
		<a href="index.jsp"><img class="logo_img" alt="" src="static/img/logo.gif" ></a>
			<span class="wel_word">图书管理系统</span>
		<%@include file="/pages/common/manager.jsp"%>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
			<c:forEach items="${ requestScope.page.items }" var="book" >
				<tr>
					<td>${ book.name }</td>
					<td>${ book.price }</td>
					<td>${ book.author }</td>
					<td>${ book.sales }</td>
					<td>${ book.stock }</td>
					<td><a href="manager/bookServlet?action=getBook&id=${book.id}&pageNo=${requestScope.page.pageNo}" >修改</a></td>
					<td><a href="manager/bookServlet?action=delete&id=${ book.id }&pageNo=${requestScope.page.pageNo}" class="deleteClass">删除</a></td>
				</tr>
			</c:forEach>

			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp?action=add&pageNo=${requestScope.page.pageTotal}">添加图书</a></td>
			</tr>

		</table>
		<%@include file="/pages/common/page_nav.jsp"%>
	</div>

	<%@include file="/pages/common/footer.jsp"%>
</body>

</html>