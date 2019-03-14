package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginPageServlet
 */
@WebServlet("/LoginPageServlet")
public class LoginPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(request.getAttribute("msg")==null) {
			out.println(request.getAttribute("msg"));
		}
		out.print("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta http-equiv=\"Content-Type\" content=\"text/html\" charset=\"utf-8\">\r\n" + 
				"<title>login</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<div align=\"center\" style=\"margin: 100px 0px 100px 0px\">\r\n" + 
				"<form action=\"LoginCheckServlet\">\r\n" + 
				"<table border=\"1\" cellpadding=\"0\" bordercolor=\"#9DCFFF\">\r\n" + 
				"\r\n" + 
				"    <tr>\r\n" + 
				"        <td bgcolor=\"#E7FBFF\" align=\"right\">name：</td>\r\n" + 
				"        <td><input type=\"text\" name=\"userName\" size=\"20\" /></td>\r\n" + 
				"    </tr>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    <tr>\r\n" + 
				"        <td bgcolor=\"#E7FBFF\" align=\"right\">password：</td>\r\n" + 
				"     <td><input type=\"password\" name=\"password\" size=\"20\"></td>\r\n" + 
				"    </tr>\r\n" + 
				"\r\n" + 
				"    <tr>\r\n" + 
				"        <td bgcolor=\"#E7FBFF\" align=\"right\"></td>\r\n" + 
				"        <td><input type=\"checkbox\" name=\"dianji\">No more reminder in a week.</td>\r\n" + 
				"    </tr>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    <tr>\r\n" + 
				"        <td bgcolor=\"#E7FBFF\" align=\"right\"></td>\r\n" + 
				"        <td><input type=\"submit\" value=\"login\" name=\"\" size=\"30\"></td>\r\n" + 
				"    </tr>\r\n" + 
				"\r\n" + 
				"</table>\r\n" + 
				"</form>\r\n" + 
				"</div>\r\n" + 
				"</body>\r\n" + 
				"</html>\r\n" + 
				"");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
