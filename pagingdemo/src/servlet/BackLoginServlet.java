package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.BackAdmin;
import bean.User;
import dao.UserListDao;

/**
 * Servlet implementation class BackLoginServlet
 */
@WebServlet("/BackLoginServlet")
public class BackLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String name = request.getParameter("username");
		String password = request.getParameter("pwd");
			if(!name.equals("")&&!password.equals("")){
				if(name.equals("admin")&&password.equals("123")) {	
					BackAdmin backadmin = new BackAdmin(name,password);
					session.setAttribute("backadmin",backadmin);
					UserListDao userListDao = new UserListDao();
					int usercount = userListDao.getCount();
					request.setAttribute("usercount", usercount);
					request.setAttribute("right", new String("backstage/backmain.jsp"));
					PrintWriter out = response.getWriter();
					out.print("<script>alert('Login In Successd!')</script>");
					request.getRequestDispatcher("/backstage/backindex.jsp").forward(request, response);
				}else {
					System.out.println("账户密码错误");
					PrintWriter out = response.getWriter();
					out.print("<script>alert('Account password error!');window.location.href='/backstage/backlogin.jsp'</script>");
				}		
			}else {
				System.out.println("请输入账号和密码");
				PrintWriter out = response.getWriter();
				out.print("<script>alert('Please enter your account number and password!');window.location.href='/backstage/backlogin.jsp'</script>");
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
