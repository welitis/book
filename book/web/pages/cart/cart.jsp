<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%@include file="/pages/common/header.jsp"%>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
		<%@include file="/pages/common/user_info.jsp"%>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>

			<c:if test="${empty sessionScope.cart.items }">
			<tr>
				<td colspan="5">
					<p>当前购物车为空，快去书城挑选商品吧！<a href="index.jsp">去书城</a></p>
				</td>
			</tr>
			</c:if>

			<c:if test="${not empty sessionScope.cart.items }">
				<c:forEach items="${sessionScope.cart.items.values()}" var="item">
					<tr>
						<td>${item.name}</td>
						<td>
							<input class="updateCount" type="text" name="count" itemid="${item.id}" value="${item.count}">
						</td>
						<td>${item.price}</td>
						<td>${item.totalPrice}</td>
						<td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${item.id}">删除</a></td>
					</tr>
				</c:forEach>
			</c:if>
			<script type="text/javascript">
				$(function () {
					// 删除某个商品
					$("a.deleteItem").click(function () {
						var name = $(this).parent().parent().find("td:first").text();
						return confirm("确定要删除【" + name + "】吗？");
					});
					// 清空购物车
					$("#clearCart").click(function () {
						return confirm("确定要清空购物车吗？");
					});

					// 更新商品数量
					$("input.updateCount").change(function () {
						var count = $(this).val();
						var id = $(this).attr("itemid");
						let result = confirm("确定要更改数量为【" + count + "】");
						if (result) {
							var url = "${baseUrl}cartServlet?action=updateCount&id=" + id + "&count=" + count;
							location.href = url;
						} else {
							this.value = this.defaultValue;
						}
					})
				})
			</script>
		</table>
		<c:if test="${not empty sessionScope.cart.items}">
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${empty sessionScope.cart.totalCount? 0:sessionScope.cart.totalCount}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${empty sessionScope.cart.totalPrice? 0:sessionScope.cart.totalPrice}</span>元</span>
				<span class="cart_span"><a id="clearCart" href="cartServlet?action=clear">清空购物车</a></span>
				<span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
			</div>
		</c:if>
	</div>
	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>