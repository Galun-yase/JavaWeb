<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑房源</title>
	<%@ include file="/pages/common/head.jsp"%>
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
			<img class="logo_img" alt="" src="static/img/logo.jpg" >
			<span class="wel_word">编辑房源</span>
			<%@include file="/pages/common/manager_menu.jsp"%>
		</div>
		
		<div id="main">
			<form action="manager/bookServlet">
				<input type="hidden" name="pageNo" value="${param.pageNo}">
				<input type="hidden" name="action" value="${ empty param.id?"add":"update"}" />
				<input type="hidden" name="id" value="${param.id}">
				<table>
					<tr>
						<td>房源标题</td>
						<td>租金</td>
						<td>朝向</td>
						<td>联系人</td>
						<td>联系人电话</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						<td><input name="title" type="text" value="${requestScope.book.title}"/></td>
						<td><input name="rent" type="text" value="${requestScope.book.rent}"/></td>
						<td><input name="orientation" type="text" value="${requestScope.book.orientation}"/></td>
						<td><input name="contact" type="text" value="${requestScope.book.contact}"/></td>
						<td><input name="mobile" type="text" value="${requestScope.book.mobile}"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
			
	
		</div>

		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>