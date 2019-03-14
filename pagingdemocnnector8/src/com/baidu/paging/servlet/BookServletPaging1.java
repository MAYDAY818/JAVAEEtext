package com.baidu.paging.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
 * Servlet implementation class BookServletPaging
 */
@WebServlet("/BookServletPaging1")
public class BookServletPaging1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookServletPaging1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String currentPageStr = request.getParameter("currentPage");
		int currentPage = 1;
		if (currentPageStr != null && !currentPageStr.equals("")) {
			currentPage = Integer.parseInt(currentPageStr);
		}
		BookDao bookDao = new BookDao();
		HttpSession session = request.getSession();
		List<BookBean> bookList = null;
		if (session.getAttribute("bookList") == null) {
			bookList = bookDao.getAllBook();
			session.setAttribute("bookList", bookList);
		} else {
			bookList = (List<BookBean>) session.getAttribute("bookList");
		}
		List<BookBean> subBookList = new ArrayList<BookBean>();

		int fromIndex = 0 + (currentPage - 1) * 10;
		int toIndex = (fromIndex + 10) > bookList.size() ? bookList.size() - 1 : (fromIndex + 10);

		subBookList = bookList.subList(fromIndex, toIndex);
		request.setAttribute("subBookList", subBookList);
		request.setAttribute("currentPage", currentPage);
		int i = (bookList.size() % 10 == 0)?0:1;
		int pageCount = (bookList.size() / 10) + i;
		request.setAttribute("pageCount", pageCount);

		request.getRequestDispatcher("showbookpaging.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
