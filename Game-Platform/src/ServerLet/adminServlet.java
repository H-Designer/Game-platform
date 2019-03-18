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
 * Servlet implementation class adminServerlet
 */
@WebServlet("/adminServerlet")
public class adminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		gamedao gamedao=new gamedao();
		gamedao.delete(id);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		JOptionPane.showMessageDialog(null, "删除成功");	
		 response.sendRedirect("../user-jsp/admin.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int  id=Integer.parseInt(request.getParameter("id"));
		String gamename =request.getParameter("gamename");
		String password =request.getParameter("password");
		String gameid =request.getParameter("gameid");
		String phone =request.getParameter("phone");
		System.out.println(id);
		information infor=new information();
		infor.setGameid(gameid);
		infor.setPhone(phone);
		infor.setGamename(gamename);
		infor.setPassword(password);
		infor.setId(id);
		gamedao gamedao=new gamedao();
		gamedao.update1(infor);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		JOptionPane.showMessageDialog(null, "修改成功");	
		 response.sendRedirect("../user-jsp/admin.jsp");
	}

}
