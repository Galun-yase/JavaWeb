<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>房源管理</title>
	<%@ include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function () {
			$("a.deleteClass").click(function () {

				//confirm确认框，确认返回true，取消返回false

				return confirm("你确定要删除【"+$(this).parent().parent().find("td:first").text() + "】?");
				//return false 表示阻止提交
			});
		});

	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="/static/img/logo.jpg" >
			<span class="wel_word">房源管理系统</span>
			<%@include file="/pages/common/manager_menu.jsp"%>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>房源标题</td>
				<td>栋/单元/楼层</td>
				<td>租金</td>
				<td>朝向</td>
				<td>联系人</td>
				<td>联系人电话</td>
				<td colspan="2">操作</td>
			</tr>

			<c:forEach items="${requestScope.page.items}" var="book">
				<tr>
					<td>${book.id}</td>
					<td>${book.building_num}/${book.building_unit}/${book.building_floor_num}</td>
					<td>${book.rent}</td>
					<td>${book.orientation}</td>
					<td>${book.contact}</td>
					<td>${book.mobile}</td>

					<td><a href="manager/bookServlet?action=getBook&id=${book.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
					<td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
				</tr>
			</c:forEach>

			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a class="add_a" href="pages/manager/book_edit.jsp?&pageNo=${requestScope.page.pageTotal}">添加房源</a></td>
			</tr>	
		</table>

		<%--静态包含分页条--%>
		<%@include file="/pages/common/page_nav.jsp" %>

	</div>

	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>