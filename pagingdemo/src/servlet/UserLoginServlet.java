package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import bean.User;
import dao.UserListDao;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			UserListDao userListDao = new UserListDao();
			if(!email.equals("")&&!password.equals("")) {
				User user=userListDao.checkUser(email, password);
				if(!user.getUser_class_name().equals("")) {	
					session.setAttribute("user",user);
					PrintWriter out = response.getWriter();
					out.print("<script>alert('Login In Successd!');window.location.href='index.jsp'</script>");
				}else {
					System.out.println("账户密码错误");
					PrintWriter out = response.getWriter();
					out.print("<script>alert('Account password error!');window.location.href='index.jsp'</script>");
				}		
			}else {
				System.out.println("请输入账号和密码");
				PrintWriter out = response.getWriter();
				out.print("<script>alert('Please enter your account number and password!');window.location.href='index.jsp'</script>");
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
