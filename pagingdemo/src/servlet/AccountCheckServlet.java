package servlet;

import java.io.IOException;  
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserListDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AccountCheckServlet
 */
@WebServlet("/AccountCheckServlet")
public class AccountCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountCheckServlet() {
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
	 * @return 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("邮箱验证");
		String useremail = request.getParameter("useremail");  
		System.out.println(useremail);
        //System.out.println("收到了请求"+username);  
        int i=0;
        PrintWriter out = response.getWriter();  
        UserListDao userListDao = new UserListDao();
        List<User> userList=userListDao.getAllUser();
        for(User user:userList) {
        	System.out.println(user.getUser_class_email());
        	if(user.getUser_class_email().equals(useremail)) 
        		i=1;
        }
        if(i==1){//本来要连接数据库查询，这里为了方便便直接定义。  
        	out.println("false");
        	
            
        }else{  
        	out.println("true");
            System.out.println("邮箱可以注册");
        }  
        out.flush();  
	}

}
