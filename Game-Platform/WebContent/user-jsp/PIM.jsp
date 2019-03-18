<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="msg.information"%>
    <%@page import="dao.gamedao"%>
    <%@page import=" javax.swing.JOptionPane"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人信息管理后台</title>
</head>
<body>
<h3 style="text-align: center;">欢迎进行个人信息数据的管理</h3>
<hr color="blue" />
<%
		    String gameid=(String) session.getAttribute("gameid");
			
			gamedao gamedao=new gamedao();
			information infor=new information();
			infor= gamedao.select(gameid);//创建的对象用来接收login函数的返回值
		
%>
<form method="post" action="${pageContext.request.contextPath}/ServerLet/PIMServlet">
		<table align="center" border="1">
				   <tr >
				   			<td colspan="4" align="center"><%=gameid %>您可修改下列个人信息</td>
				   </tr>
					<tr>
							<td>游戏名称</td>
							<td>游戏ID</td>
							<td>密码</td>
							<td>电话号码</td>
					</tr>
					<tr>
							<td><input type="text" value="<%=infor.getGamename()%>" name="gamename"></td>
							<td><input type="text" value="<%=infor.getGameid()%>" name="gameid"></td>
							<td><input type="text" value="<%=infor.getPassword()%>" name="password"></td>
							<td><input type="text" value="<%=infor.getPhone()%>" name="phone"></td>
					</tr>
					<tr>
							<td  colspan="4" align="center"><input type="submit" value="提交"></td>
					</tr>
	</table>
</form>
</body>
</html>