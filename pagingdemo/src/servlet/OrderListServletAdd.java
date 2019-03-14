package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.OrderDetailDao;

/**
 * Servlet implementation class OrderListServletAdd
 */
@WebServlet("/OrderListServletAdd")
public class OrderListServletAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderListServletAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("OrderListServletAdd");
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		int cakeid= Integer.parseInt(request.getParameter("cakeid"));
		System.out.println("OrderListServletAddcakeidget");
		int quantity = 1;
//		int quantity = Integer.parseInt(request.getParameter("quantity"));
		OrderDetailDao orderListDao=new OrderDetailDao();
		User user = (User)session.getAttribute("user");
		if(user.getUser_class_name()==null&&user.getUser_class_name().equals("")) {
			System.out.println("OrderListServletAddtrue");
			out.print("<script>alert('Please login!');window.location.href='index.jsp'</script>");
		}else {
			System.out.println("OrderListServletAddfalse");
			orderListDao.addOrderDetailById(user.getUser_class_id(),cakeid,quantity);
			System.out.println("加入购物车");
			request.getRequestDispatcher("OrderListServlet").forward(request, response);
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
