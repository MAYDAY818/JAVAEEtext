package com.baidu.paging.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baidu.paging.bean.BookBean;
import com.baidu.paging.dao.BookDao;

/**
 * Servlet implementation class BookServletPaging2
 */
@WebServlet("/BookServletPaging2")
public class BookServletPaging2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServletPaging2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String currentPageStr = request.getParameter("currentPage");
		int currentPage = 1;
		if (currentPageStr != null && !currentPageStr.equals("")) {
			currentPage = Integer.parseInt(currentPageStr);
		}
		BookDao bookDao = new BookDao();
		int columnCount = bookDao.getCount();
		
		int fromIndex = 0 + (currentPage - 1) * 10;
		int count = (fromIndex + 10) > columnCount ? columnCount % 10 : 10;

		List<BookBean> subBookList = bookDao.getSubBook(fromIndex, count);
		
		
		request.setAttribute("subBookList", subBookList);
		request.setAttribute("currentPage", currentPage);
		int a = columnCount%10==0?0:1;
		int pageCount = columnCount/10 +a;
		System.out.println("pageCount:"+pageCount);
		request.setAttribute("pageCount", pageCount);
		
		
		request.getRequestDispatcher("showbookpaging2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
