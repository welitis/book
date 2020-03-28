<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
	<%@include file="/pages/common/header.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">我的订单</span>
		<%@include file="/pages/common/user_info.jsp"%>
	</div>
	
	<div id="main">
		
		<table>
			<tr>
				<td>订单号</td>
				<td>日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
			</tr>		
			<c:forEach items="${requestScope.orderList}" var="order">
				<tr>
					<td>${order.orderId}</td>
					<td>${order.createTime}</td>
					<td>${order.price}</td>
					<c:if test="${order.status == 0}">
						<td>未发货</td>
					</c:if>
					<c:if test="${order.status == 1}">
						<td><a href="orderServlet?action=receiveOrder&orderId=${order.orderId}" class="receive_class" order_id="${order.orderId}">待签收</a></td>
					</c:if>
					<c:if test="${order.status == 2}">
						<td>已完成</td>
					</c:if>
					<td><a href="orderServlet?action=showOrderDetail&orderId=${order.orderId}">查看详情</a></td>
				</tr>
			</c:forEach>
	<script type="text/javascript">
		$(function () {
			var orderId = $("a.receive_class").attr("order_id");
			$("a.receive_class").click(function () {
				return confirm("确定要签收订单号【"+ orderId +"】的订单吗？");
			})
		})
	</script>
		</table>
		
	
	</div>

	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>