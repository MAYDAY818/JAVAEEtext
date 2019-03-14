package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bean.User;
import dao.Mysqldao;
import dao.UserListDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class Demo01
 */
@WebServlet("/Demo01")
public class Demo01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Demo01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Mysqldao mysqldao = new Mysqldao();
		UserListDao userListDao = new UserListDao();
		List<User> userlist = userListDao.getAllUser();
		System.out.println(userlist.toString());
		JSONArray jsonArry = new JSONArray();
		int i = 0 ;
		for(User user : userlist ) {
			JSONObject userdemo = new JSONObject(); 
			userdemo.put("id", user.getId());
			userdemo.put("name", user.getName());
			userdemo.put("password", user.getPassword());
			jsonArry.add(i,userdemo);
		}
		response.getWriter().write(jsonArry.toString());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
