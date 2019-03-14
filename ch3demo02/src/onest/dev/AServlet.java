package onest.dev;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AServlet
 */
@WebServlet("/AServlet")
public class AServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取servletconfig
		ServletConfig config = getServletConfig();
		String role = config.getInitParameter("role");
		//获取整个应用唯一一个servletcontext对象
		ServletContext context = getServletContext();
		String info = context.getInitParameter("info");
		
		if(context.getAttribute("count")==null) {
			context.setAttribute("count", 1);
		}else {
			Integer c= Integer.parseInt(context.getAttribute("count").toString());
			c = c + 1 ;
			context.setAttribute("count", c);
		}
		
		response.getWriter().print("role"+ role +"info"+ info);
		PrintWriter out = response.getWriter();
		out.print("role");
		out.print("info");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
