package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Order;
import bean.OrderDetail;
import bean.User;
import dao.OrderDetailDao;
import dao.OrderListDao;

/**
 * Servlet implementation class OrderListServlet
 */
@WebServlet("/OrderListServlet")
public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /*
     * @see HttpServlet#HttpServlet()
     */
    public OrderListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		OrderDetailDao orderListDao=new OrderDetailDao();
		User user = (User)session.getAttribute("user");
		System.out.println(user.getUser_class_name());
		System.out.println(user.getUser_class_name());
		if(user.getUser_class_name()==null&&user.getUser_class_name().equals("")) {
			PrintWriter out = response.getWriter();
			out.print("<script>alert('Please login!');window.location.href='index.jsp'</script>");
		}else {
			OrderDetailDao orderDetailDao = new OrderDetailDao();
			List<OrderDetail> orderDetailList = orderDetailDao.getOrderDetailById(user.getUser_class_id());
			request.setAttribute("subOrderDetailList",orderDetailList);
			request.getRequestDispatcher("checkout.jsp").forward(request, response);
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
