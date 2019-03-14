package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;

/**
 * Servlet implementation class LoginCheckServlet
 */
@WebServlet("/LoginCheckServlet")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("userName");
		String password = request.getParameter("password");
		String autoLogin = request.getParameter("autoLogin");
		if(!"".equals(name) && !"".equals(password)) {
			HttpSession session = request.getSession();
			UserBean user = new UserBean(name,password);
			session.setAttribute("user", user);
			if("on".equals(autoLogin)) {
				session.setMaxInactiveInterval(60*60*24*7);
				Cookie cookie = new Cookie("JSESSIONID",session.getId());
				cookie.setMaxAge(60*60*24*7);
				response.addCookie(cookie);
			}
			response.sendRedirect("ProductListServlet");
		}else {
			String msg = "用户名或密码为空";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("LoginPageServlet").forward(request,response);
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
