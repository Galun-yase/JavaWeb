<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>豪大大会员注册页面</title>
	<%@ include file="/pages/common/head.jsp"%>
	<style type="text/css">
		h1 {
			text-align: center;
			margin-top: 200px;
		}

		h1 a {
			color:red;
		}
	</style>
</head>
<body>
		<div id="header">
				<img class="logo_img" alt="" src="static/img/logo.jpg" >
				<span class="wel_word"></span>
				<%--静态包含所有公共的页面--%>
				<%@ include file="/pages/common/login_success_menu.jsp"%>
		</div>
		
		<div id="main">
		
			<h1>注册成功! <a href="pages/client/index.jsp">转到主页</a></h1>
	
		</div>

		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>