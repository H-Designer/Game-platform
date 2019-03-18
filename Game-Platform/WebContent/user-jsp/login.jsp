<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html >
<head>
<title>来登陆吧</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="stylesheet" href="../css/style.css" />

<body>

<div class="login-container">
	<h1>欢迎登陆销魂游戏交易平台</h1>
	
	<div class="connect">
		<p>祝您游戏愉快</p>
	</div>
	
	<form action="${pageContext.request.contextPath }/ServerLet/loginServlet" method="post" id="loginForm">
		<div>
			<input type="text" name="gameid" class="username" placeholder="游戏账号" autocomplete="off"/>
		</div>
		<div>
			<input type="password" name="password" class="password" placeholder="密码" oncontextmenu="return false" onpaste="return false" />
		</div>
		<button id="submit" type="submit">登 录</button>
	</form>

	<a href="register.jsp">
		<button type="button" class="register-tis">还有没有账号？</button>
	</a>

</div>
<script src="../js/jquery.min.js"></script>
<script src="../js/common.js"></script>
<!--背景图片自动更换-->
<script src="../js/supersized.3.2.7.min.js"></script>
<script src="../js/supersized-init.js"></script>
<!--表单验证-->
<script src="../js/jquery.validate.min.js?var1.14.0"></script>

</body>
</html>