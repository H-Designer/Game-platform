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
 * Servlet implementation class PIMServlet
 */
@WebServlet("/PIMServlet")
public class PIMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PIMServlet() {
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
		HttpSession session = request.getSession();
		String sessionid=(String)session.getAttribute("gameid");
		String gamename=request.getParameter("gamename");
		String gameid=request.getParameter("gameid");
		String password=request.getParameter("password");
		String phone=request.getParameter("phone");
		gamedao gamedao=new gamedao();
		information infor=new information();
		infor.setGameid(gameid);
		infor.setPhone(phone);
		infor.setGamename(gamename);
		infor.setPassword(password);
		infor.setSessionid(sessionid);
		gamedao.update(infor);
		JOptionPane.showMessageDialog(null, "修改成功，重新登陆");	
		 response.sendRedirect("../user-jsp/login.jsp"); 
		doGet(request, response);
	}
}
