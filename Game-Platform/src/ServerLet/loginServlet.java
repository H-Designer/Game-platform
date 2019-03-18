package ServerLet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import dao.gamedao;
import msg.information;

/**
 * Servlet implementation class loginServlet
 */
//@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String gameid=request.getParameter("gameid");
		String password=request.getParameter("password");
		gamedao gamedao=new gamedao();
		information infor=new information();
		infor= gamedao.login(gameid);//创建的对象用来接收login函数的返回值
		
		HttpSession session = request.getSession();
		session.setAttribute("gameid", gameid);//放在session中
		if(infor==null)
		{
			JOptionPane.showMessageDialog(null, "用户不存在");	
			 response.sendRedirect("../user-jsp/login.jsp"); 
		}
		else 
		{
			String Password=infor.getPassword();
			if(password.equals(Password))
			{
				if(gameid.equals("admin"))
				{
					response.sendRedirect("../user-jsp/admin.jsp");
				}
				else
				response.sendRedirect("../index.jsp");

			}
			else 
			{
				//request.getRequestDispatcher("/User/login.jsp").forward(request, response);
				JOptionPane.showMessageDialog(null, "密码错误");	
				 response.sendRedirect("../user-jsp/login.jsp"); 
			}
		}	
			
			
	
		doGet(request, response);
	}

}
