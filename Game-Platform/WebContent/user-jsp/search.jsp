<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page import="msg.information"%>
    <%@page import="dao.gamedao"%>
    <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>搜索游戏</title>
</head>
<body>
<h3 style="text-align: center;">根据您的搜索内容，本网站搜索到的内容如下</h3>
<hr color="blue" />
		<table align="center" border="1">
				   <tr >
				   			<td colspan="3" align="center">系统信息数据</td>
				   </tr>
		
					<tr>
							<td style="text-align: center;">游戏名称</td>
							<td style="text-align: center;">游戏ID</td>
							<td style="text-align: center;">电话号码</td>
					</tr>
							   <%
							   			String gamename=request.getParameter("gamename");
										gamedao gamedao=new gamedao();
										List<information> informations=gamedao.selectgame("gamename");
										for(information infor:informations )
										{
							%>
					<tr>
							<td style="text-align: center;"><input type="text" value="<%=infor.getGamename()%>" name="gamename"disabled="disabled"></td>
							<td style="text-align: center;"><input type="text" value="<%=infor.getGameid()%>" name="gameid"disabled="disabled"></td>
							<td style="text-align: center;"><input type="text" value="<%=infor.getPhone()%>" name="phone"disabled="disabled"></td>
					</tr>
						<%} %>
	</table>

</body>
</html>