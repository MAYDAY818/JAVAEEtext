package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputServlet
 */
@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		//多选框取值
		String[] hobby = request.getParameterValues("hobby");
		System.out.println(hobby.length);
		for(int i=0;i<hobby.length;i++) {
			System.out.println(hobby[i]);
		}
		
		//多行文本框取值
		String area = request.getParameter("area");
		System.out.println(area);
		
		//下拉列表取值
		String[] sel = request.getParameterValues("sel");
		for(int i=0;i<sel.length;i++) {
			System.out.println(sel[i]);
		}
		
		//隐藏域取值
		String userId = request.getParameter("userId");
		System.out.println(userId);
		
		//单选按钮
		String sex = request.getParameter("sex");
		System.out.println(sex);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
