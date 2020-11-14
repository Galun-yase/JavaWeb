<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>豪大大首页</title>
	<%@ include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function () {
			// 给加入购物车按钮绑定单击事件
			$("button.addToCart").click(function () {
				/**
				 * 在事件响应的function函数 中，有一个this对象，这个this对象，是当前正在响应事件的dom对象
				 * @type {jQuery}
				 */
				var bookId = $(this).attr("bookId");
				//location.href = "http://localhost:8080/book/cartServlet?action=addItem&bookId=" + bookId;

				$.getJSON("http://localhost:8080/book/cartServlet","action=ajaxaddItem&bookId="+bookId,function (data) {

					$("#cartTotalCount").text("您的购物车有"+data.totalCount+"件商品");
					$("#cartLastName").text(data.lastName);


				});

			});
		});

	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.jpg" >
			<span class="wel_word">豪大大地产</span>
			<div>

				<c:if test="${empty sessionScope.user.username}">
					<a href="pages/user/login.jsp">登录</a>  |
					<a href="pages/user/regist.jsp">注册</a>
				</c:if>
				<c:if test="${not empty sessionScope.user.username}">
					<span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临豪大大地产</span>
					<a href="pages/order/order.jsp">我的订单</a>
					<a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
				</c:if>
&nbsp;&nbsp;
				<a href="pages/cart/cart.jsp">交易中心</a>
				<a href="pages/manager/manager.jsp">后台管理</a>
			</div>
	</div>
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="client/bookServlet" method="get">
					<input type="hidden" name="action" value="pageByPrice">
					价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
						<input id="max" type="text" name="max" value="${param.max}"> 元
						<input type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align: center">
				<c:if test="${empty sessionScope.cart.items}">
					<span id="cartTotalCount"></span>
					<div>
						<span id="cartLastName" style="color: red" >当前购物车为空</span>
					</div>
				</c:if>
				<c:if test="${not empty sessionScope.cart.items}">
					<span id="cartTotalCount">您的购物车中有${sessionScope.cart.totalCount}件商品</span>
					<div>
						您刚刚将<span id="cartLastName" style="color: red" >${sessionScope.lastname}</span>加入到了购物车中
					</div>
				</c:if>
			</div>

			<%--hhhhh--%>
			<c:forEach items="${requestScope.page.items}" var="book">
			<div class="b_list">
				<div class="img_div">
					<img class="book_img" alt="" src="static/img/default.jpg" />
				</div>
				<div class="book_info">
					<div class="book_name">
						<span class="sp1">房源标题:</span>
						<span class="sp2">${book.title}</span>
					</div>
					<div class="book_author">
						<span class="sp2">${book.building_num}</span>
						<span class="sp1">栋|</span>
						<span class="sp2">${book.building_unit}</span>
						<span class="sp1">单元|</span>
						<span class="sp2">${book.building_floor_num}</span>
						<span class="sp1">室</span>
					</div>
					<div class="book_price">
						<span class="sp1">租金:</span>
						<span class="sp2">${book.rent}</span>
					</div>
					<div class="book_sales">
						<span class="sp1">朝向:</span>
						<span class="sp2">${book.orientation}</span>
					</div>
					<div class="book_amount">
						<span class="sp1">联系人:</span>
						<span class="sp2">${book.contact}</span>
					</div>
					<div class="book_amount">
						<span class="sp1">电话:</span>
						<span class="sp2">${book.mobile}</span>
					</div>
					<div class="book_add">
						<button bookId="1<%--${book.id}--%>" class="addToCart">加入购物车</button>
					</div>
				</div>
			</div>
			</c:forEach>
			<%--hhhhh--%>


		</div>

		<%@include file="/pages/common/page_nav.jsp"%>
	
	</div>

	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>