package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
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
		//response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		Object object = session.getAttribute("user");
		PrintWriter out = response.getWriter();

		out.print("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"UTF-8\">\r\n" + 
				"<title>Insert title here</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n");
		if(object == null) {
			out.print("未登录<a href='LoginPageServlet'>去登录</a><br>");
		}else {
			UserBean user = (UserBean)session.getAttribute("user");
			out.print("登录人："+user.getName()+"<a href='LogoutServlet'>注销</a><br>");
		}
		ServletContext application = getServletContext();
		Object onlineNumObj = application.getAttribute("onlineNum");
		if(onlineNumObj == null) {
			out.print("当前在线人数：0");
		}else {
			out.print("当前在线人数："+onlineNumObj);
		}
		Object vipNumObj = application.getAttribute("vipNum");
		if(vipNumObj == null) {
			out.print("当前在线会员数：0");
		}else {
			out.print("当前在线会员数："+vipNumObj);
		}
		
		out.print("	JavaEE指南<a href=\"AddShoppingCartServlet?bookName=JavaEE指南\">加入购物车</a><br>\r\n" + 
				"	JavaES指南<a href=\"AddShoppingCartServlet?bookName=JavaSE指南\">加入购物车</a><br>\r\n" + 
				"	Spring指南<a href=\"AddShoppingCartServlet?bookName=Spring指南\">加入购物车</a><br>\r\n" + 
				"	<a href=\"ShowShoppingCartServlet\">查看购物车</a><br>\r\n" + 
				"</body>\r\n" + 
				"</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
