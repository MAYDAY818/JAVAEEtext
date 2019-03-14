package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.BackAdmin;
import dao.UserListDao;

/**
 * Servlet implementation class BackMainServlet
 */
@WebServlet("/BackMainServlet")
public class BackMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("BackMainServlet");
		HttpSession session=request.getSession();
//		if((session.getAttribute("backuser")!=null&&!session.getAttribute("backuser").equals(""))) {
			UserListDao userListDao = new UserListDao();
			int usercount = userListDao.getCount();
			request.setAttribute("usercount", usercount);
			System.out.println(usercount);
			request.getRequestDispatcher("/backstage/backmain.jsp").forward(request, response);
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
