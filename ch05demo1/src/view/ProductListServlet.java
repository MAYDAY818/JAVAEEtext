package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;

/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/ProductListServlet")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(session.getAttribute("user")==null) {
			out.print("未登录");
		}else {
			UserBean user = (UserBean)session.getAttribute("user");
			out.print(user.getUserName()+"已登录");
		}
		out.print("<br>");
		out.print("当前在线人数：" + getServletContext().getAttribute("onlineNum")+"<br>");
		out.print("当前在线会员数：" + getServletContext().getAttribute("vipNum")+"<br>");
		out.print("<br>");
		out.println("<a>JavaEE</a><br>");
		out.println("<a>JavaSE</a><br>");
		out.println("<a>Spring</a><br>"); 
		out.print("<br>");
		out.println("<a href='LoginPageServlet'>去登录</a><br>"); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
