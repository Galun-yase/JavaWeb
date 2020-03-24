<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<meta charset="UTF-8">
	<title>尚硅谷会员注册页面</title>

	<%@ include file="/pages/common/head.jsp"%>

	<script type="text/javascript">
		//页面加载完成后
		$(function(){


			$("#code_img").click(function () {
				this.src="${basePath}Kaptcha.jpg?d="+new Date();
			});





			//给注册按钮绑定单击事件
			$("#sub_btn").click(function(){
				//验证用户名：必须由字母，数字，下划线组成，并且长度为5到12位
				  //1 获取用户名输入框里的内容
				  var usernameText=$("#username").val();
				  //2 创建正则表达式对象
				  var usernamePatt=/^\w{5,12}$/;
				  //3 用test方法验证
				  if (!usernamePatt.test(usernameText)){
				  	$("span.errorMsg").text("用户名不合法");

				  	return false;
				  }

				//验证密码：必须由字母，数字，下划线组成，并且长度为5到12位
				//1 获取用户名输入框里的内容
				var passwordText=$("#password").val();
				//2 创建正则表达式对象
				var passwordPatt=/^\w{5,12}$/;
				//3 用test方法验证
				if (!passwordPatt.test(passwordText)){
					$("span.errorMsg").text("密码不合法");

					return false;
				}

				//验证确认密码：和密码相同
				  var repwdText=$("#repwd").val();
				  if (repwdText!=passwordText){
				  	$("span.errorMsg").text("确认密码和密码不一致！");
				  	return false;
				  }

				 //验证邮箱：xxxx@xxx.com
				  var emailText=$("#email").val();
				  var emailPatt=/^[A-Za-z0-9]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
				  if (!emailPatt.test(emailText)){
				  	$("span.errorMsg").text("邮箱格式不合法！");
				  	return false;
				  }

				 //验证码：验证已输入
				var codeText=$("#code").val();
				codeText=$.trim(codeText);
				if (codeText==null ||codeText==""){
					$("span.errorMsg").text("验证码不能为空！");
					return false;
				}
				$("#span.errorMsg").val("");
			});
		});
	</script>


	<style type="text/css">
		.login_form{
			height:420px;
			margin-top: 25px;
		}
	
</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
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
								<span class="errorMsg">
									${ requestScope.msg }
								</span>
							</div>
							<div class="form">
								<form action="userServlet"method="post">
									<label>用户名称：</label>
									<input type="hidden" name="action" value="regist">
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username"
										value="${ requestScope.username }"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email"
											value="${requestScope.email}" />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" name="code" style="width: 100px;" id="code" />
									<img id="code_img" alt="" src="Kaptcha.jpg" style="float: right; margin-right: 40px;width: 100px;height: 38px;">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>