package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.UserListDao;

/**
 * Servlet implementation class BackSearchUserServlet
 */
@WebServlet("/BackSearchUserServlet")
public class BackSearchUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackSearchUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("BackSearchUserServlet");
		int userid = Integer.parseInt(request.getParameter("userId"));
		HttpSession session=request.getSession();
//		if((session.getAttribute("backuser")!=null&&!session.getAttribute("backuser").equals(""))) {
			UserListDao userListDao = new UserListDao();
			User user = userListDao.getUserById(userid);
			System.out.println("User");
			request.setAttribute("userList", user);
			request.getRequestDispatcher("/backstage/backmainlist.jsp").forward(request, response);
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
