package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    int i= 0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		if(username.isEmpty()&&password.isEmpty()) {
			out.print("<script language='javascript'>alert('请填入用户名和密码');</script>");
			i = 1;
			this.doPost(request, response);
			
		}
		if(request.getParameter("dianji")!=null) { 
			//第一个按钮被按下了 
			Cookie cookiename = new Cookie("userName",username);
			Cookie cookieword = new Cookie("passWord",password);
			cookiename.setMaxAge(60*60*24*7);
			cookieword.setMaxAge(60*60*24*7);
			response.addCookie(cookiename);
			response.addCookie(cookieword);
			} 
		i = 0;
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (i == 1) {
			response.sendRedirect("LoginPageServlet");
		}else {
			response.sendRedirect("ProductList.html");
		}

	}

}
