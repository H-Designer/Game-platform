<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html >
<head>
<title>来注册吧</title>
<link rel="stylesheet" href="../css/style.css" />
<body>

<div class="register-container">
	<h1>注册账号</h1>
	
	<div class="connect">
		<p>祝您游戏愉快</p>
	</div>
	
	<form action="${pageContext.request.contextPath }/ServerLet/registerServlet" method="post" id="registerForm">
		<div>
			<input type="text" name="gamename" class="gamename" placeholder="游戏名称" autocomplete="off"/>
		</div>
		<div>
			<input type="text" name="gameid" class="username" placeholder="游戏账号" autocomplete="off"/>
		</div>
		<div>
			<input type="text" name="phone" class="phone" placeholder="电话号码" autocomplete="off"/>
		</div>
		<div>
			<input type="password" name="password" class="password" placeholder="输入密码" oncontextmenu="return false" onpaste="return false" />
		</div>
		<div>
			<input type="password" name="confirm_password" class="confirm_password" placeholder="再次输入密码" oncontextmenu="return false" onpaste="return false" />
		</div>
		<button id="submit" type="submit">注 册</button>
	</form>
	<a href="login.jsp">
		<button type="button" class="register-tis">已经有账号？</button>
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