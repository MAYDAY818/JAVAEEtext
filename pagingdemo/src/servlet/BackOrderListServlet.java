package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Order;
import bean.User;
import dao.OrderListDao;
import dao.UserListDao;

/**
 * Servlet implementation class BackOrderListServlet
 */
@WebServlet("/BackOrderListServlet")
public class BackOrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackOrderListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("BackMainOrderListServlet");
		HttpSession session=request.getSession();
//		if((session.getAttribute("backuser")!=null&&!session.getAttribute("backuser").equals(""))) {
			OrderListDao orderListDao = new OrderListDao();
			List<Order> orderList = orderListDao.getAllOrder();
			System.out.println("getAllOrder");
			request.setAttribute("orderList", orderList);
			request.getRequestDispatcher("/backstage/backmainorderlist.jsp").forward(request, response);
//		}else {
//			PrintWriter out = response.getWriter();
//			out.print("<script>alert('Please Login');window.location.href='/backstage/backlogin.jsp'</script>");
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
