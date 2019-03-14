package com;

import java.io.*;
import java.util.List;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShoppingCartServlet
 */
@WebServlet("/ShoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		String bookName = request.getParameter("bookname");
		
		HttpSession session =request.getSession();
		String userName = (String)session.getAttribute("userName");
		Object object = session.getAttribute("cartlist");
		
		List<String> cartlist;
		if(object == null) {
			cartlist = new ArrayList<String>();
			cartlist.add(bookName);
		}else {
			cartlist = (List)object;
			cartlist.add(bookName);
		}
		session.setAttribute("cartlist", cartlist);
		
		
		PrintWriter out = response.getWriter();
		out.print(userName+"购买了<br>");
		out.print(bookName);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
