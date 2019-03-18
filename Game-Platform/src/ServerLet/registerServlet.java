package ServerLet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import dao.gamedao;
import msg.information;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
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
		String phone=request.getParameter("phone");
		String gameid=request.getParameter("gameid");
		String gamename=request.getParameter("gamename");
		String password=request.getParameter("password");
		
		gamedao gamedao=new gamedao();
		information infor1=new information();
		infor1= gamedao.login(gameid);//创建的对象用来接收login函数的返回值
		//String Password=infor.getPassword();
		if(infor1==null)
		{
			information infor=new information();
			infor.setGameid(gameid);
			infor.setPhone(phone);
			infor.setGamename(gamename);
			infor.setPassword(password);
			gamedao.register(infor);
			JOptionPane.showMessageDialog(null, "注册成功");	
			 response.sendRedirect("../user-jsp/login.jsp");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "该用户名已注册");	
			 response.sendRedirect("../user-jsp/register.jsp"); 
		}
		doGet(request, response);
	}

}
