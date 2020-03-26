<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>
	<%@include file="/pages/common/header.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
</style>
</head>
<body>
		<div id="header">
			<a href="index.jsp"><img class="logo_img" alt="logo" src="static/img/logo.gif"></a>
			<span class="wel_word">编辑图书</span>
			<%@include file="/pages/common/manager.jsp"%>
		</div>
		
		<div id="main">
			<form action="manager/bookServlet" method="get">
				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>作者</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						<input type="hidden" name="action" value="${ empty param.id ? "add":"update" }">
						<input type="hidden" name="id" value="${ param.id }">
						<input type="hidden" name="pageNo" value="${param.pageNo}">
						<td><input name="name" type="text" value="${ requestScope.book.name }"/></td>
						<td><input name="price" type="text" value="${ requestScope.book.price }"/></td>
						<td><input name="author" type="text" value="${ requestScope.book.author }"/></td>
						<td><input name="sales" type="text" value="${ requestScope.book.sales }"/></td>
						<td><input name="stock" type="text" value="${ requestScope.book.stock }"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
			
	
		</div>

		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>