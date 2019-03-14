package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.OrderDetail;
import bean.User;
import dao.OrderDetailDao;
import dao.UserListDao;

/**
 * Servlet implementation class BackOrderDetailServlet
 */
@WebServlet("/BackOrderDetailServlet")
public class BackOrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackOrderDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("BackOrderDetailServlet");
		HttpSession session=request.getSession();
//		if((session.getAttribute("backuser")!=null&&!session.getAttribute("backuser").equals(""))) {
			int id= Integer.parseInt(request.getParameter("userid"));
			OrderDetailDao orderDetailDao=new OrderDetailDao(); 
			List<OrderDetail> orderDetail = orderDetailDao.getOrderDetailByUserId(id);
			request.setAttribute("orderDetailList",orderDetail);
			request.getRequestDispatcher("/backstage/backmainorderdetaillist.jsp").forward(request, response);
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
