<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="javax.servlet.http.HttpSession"%>
    
<!DOCTYPE html>
<% 
			String gameid=(String) session.getAttribute("gameid");
%>
<html>
<head>
<link href="${pageContext.request.contextPath }/css/index.css" rel="stylesheet">
<title>销魂游戏交易平台</title> 
   
<body background="images/back.png">

<script type="text/javascript">
var ar = [
    'images/dnf.jpg',
    'images/lol.jpg',
    'images/wangzhe.jpg',
    'images/chiji.jpg',
    'images/lanyue.jpg',
    
];
var index = 0;
 
function showImg() {
    document.getElementById('imgContainer').innerHTML = '<img src="' + (ar[++index % ar.length]) + '" />';
}
 
window.onload = function() {
    window.setInterval('showImg()', 1000); //每两秒钟切换一次
}
</script>
	<div class="head1">
			<div class="head">
					<div class="test" >欢迎使用使用销魂游戏交易平台！祝您游戏愉快</div>
					<%
							if(gameid!=null)
							{
					%>
					<a href ="./user-jsp/PIM.jsp" ><%=gameid %></a>&nbsp;玩家欢迎回来！
					<a href="./user-jsp/login.jsp">退出登录</a>
					<%
							}
							else
							{
					%>
								<a href="./user-jsp/login.jsp">登陆</a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="./user-jsp/register.jsp">注册</a>
					<%
							}
					%>
			</div>
			<div class="logo"><img src="images/logo.jpg" height="150px" width="220px"></div>
			<div class="search" >
					<form action="${pageContext.request.contextPath }/user-jsp/search.jsp" method="">
						<input type="text"  style="height: 40px; width: 316px" value="游戏名"  name="gamename" >
						<div class="sousuo"><input type="submit" value="搜索" ></div>
					</form>
			</div>
	</div>
	<hr color=" blue "/>
	<div class="left1"><div id="imgContainer"></div></div>
	<div class="center1"><a href="./user-jsp/lol.jsp"><img src="images/lollogo.jpg" height="250px" width="250px" title="英雄联盟" ></a></div>
	<div class="center2"><a href="./user-jsp/dnf.jsp"><img src="images/dnflogo.jpg" height="250px" width="250px" title="地下城与勇士" ></a></div>
	<div class="right1"><a href="./user-jsp/chiji.jsp"><img src="images/chijilogo.jpg" height="250px" width="250px" title="绝地求生"></a></div>
	<div class="center3"><a href="./user-jsp/wangzhe.jsp"><img src="images/wangzhelogo.jpg" height="250px" width="250px" title="王者荣耀"></a></div>
	<div class="center4"><a href="./user-jsp/cf.jsp"><img src="images/cflogo.jpg" height="250px" width="250px" title="穿越火线"></a></div>
	<div class="right2"><a href="./user-jsp/lanyue.jsp"><img src="images/lanyuelogo.jpg" height="250px" width="250px" title="贪玩蓝月"></a></div>
	<div class="button">
		<p style="text-align: center;">网络文化经营许可证： 冀网文 （2018）****-****号      ip证：******     公安网备号：******</p>
		<p style="text-align: center;">关于我们 | 联系我们 | 投诉建议 | 免费声明 | 返回首部 </p>
		<p style="text-align: center;">本网站于18年石家庄铁道大学信息科学技术学院软件工程专业16级信1605-3班学生赵春辉完成</p>
	</div>
</body>
</html>
