package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowShoppingCartServlet
 */
@WebServlet("/ShowShoppingCartServlet")
public class ShowShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowShoppingCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		Cookie[] cookies = request.getCookies();
//		if (cookies != null) {
//			response.sendRedirect("LoginPageServlet");
//		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		HttpSession session = request.getSession();
		Object shoppingcart = session.getAttribute("shoppingcart");
		if (shoppingcart == null) {
			writer.write("购物车竟然是空的，再忙，也要记得买本书犒赏自己~");
		} else {
			writer.write("你想要购买的:<br>");
			List<String> booklist = (List<String>) shoppingcart;
			for (int i = 0; i < booklist.size(); i++) {
				writer.write(i + ": " + booklist.get(i).toString() + "<br>");
			}
		}
		writer.write("<a href=\"ProductList.html\">Return to Shopping</a>");

	}

}
