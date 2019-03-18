<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@page import="msg.information"%>
    <%@page import="dao.gamedao"%>
    <%@page import="java.util.List"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>超级管理员</title>
</head>
<body>
<h3 style="text-align: center;">欢迎管理员进行系统数据的管理</h3>
<hr color="blue" />


 <form method="post" action="${pageContext.request.contextPath}/ServerLet/adminServlet">

		<table align="center" border="1">
				   <tr >
				   			<td colspan="6" align="center">系统信息数据</td>
				   </tr>
				
					<tr>
							<td style="text-align: center;">序号</td>
							<td style="text-align: center;">游戏名称</td>
							<td style="text-align: center;">游戏ID</td>
							<td style="text-align: center;">密码</td>
							<td style="text-align: center;">电话号码</td>
							<td style="text-align: center;">操作</td>
					</tr>
					   <%
							gamedao gamedao=new gamedao();
							List<information> informations=gamedao.selectall();
							for(information infor:informations )
							{
				%>
					<tr>
							<td style="text-align: center; "><input type="text"   value="<%=infor.getId()%>" name="id" > </td>
							<td style="text-align: center;"><input type="text" value="<%=infor.getGamename()%>" name="gamename"></td>
							<td style="text-align: center;"><input type="text" value="<%=infor.getGameid()%>" name="gameid"></td>
							<td style="text-align: center;"><input type="text" value="<%=infor.getPassword()%>" name="password"></td>
							<td style="text-align: center;"><input type="text" value="<%=infor.getPhone()%>" name="phone"></td>
							<td  style="text-align: center;"><input type="submit" value="修改"  ><a href="${pageContext.request.contextPath}/ServerLet/adminServlet?id=<%=infor.getId() %>">删除</a></td>
					</tr>
				<%} %>
	</table>
	</form>

</body>
</html>