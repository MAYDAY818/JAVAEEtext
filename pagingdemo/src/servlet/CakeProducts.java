package servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import bean.Cake;
import dao.CakeListDao;

/**
 * Servlet implementation class CakeProducts
 */
@WebServlet("/CakeProducts")
public class CakeProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CakeProducts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String currentPageStr = request.getParameter("currentPage");
		int currentPage = 1;
		if (currentPageStr != null && !currentPageStr.equals("")) {
			currentPage = Integer.parseInt(currentPageStr);
		}
		CakeListDao cakeListDao = new CakeListDao();
		HttpSession session = request.getSession();
		List<Cake> cakeList = null;
		
		if( request.getParameter("size")!=null && !request.getParameter("size").equals("")) {
			cakeList = cakeListDao.getCakeBySize( Integer.parseInt(request.getParameter("size")));
		}else if ( request.getParameter("flavor")!=null && !request.getParameter("flavor").equals("")) {
			System.out.println(request.getParameter("flavor").toString());
			cakeList = cakeListDao.getCakeByFlavor(request.getParameter("flavor"));
		}else if ( request.getParameter("searchname")!=null && !request.getParameter("searchname").equals("")){
			cakeList = cakeListDao.getCakeByName(request.getParameter("searchname"));
		}else{
			cakeList = cakeListDao.getAllCake();
		}

		List<Cake> subCakeList = new ArrayList<Cake>();

		int fromIndex = 0 + (currentPage - 1) * 9;
		int toIndex = (fromIndex + 9) > cakeList.size() ? cakeList.size() - 1 : (fromIndex + 9);

		subCakeList = cakeList.subList(fromIndex, toIndex);
		request.setAttribute("subCakeList", subCakeList);
		request.setAttribute("currentPage", currentPage);
		int i = (cakeList.size() % 9 == 0)?0:1;
		int pageCount = (cakeList.size() / 9) + i;
		request.setAttribute("pageCount", pageCount);
		request.getRequestDispatcher("products.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
