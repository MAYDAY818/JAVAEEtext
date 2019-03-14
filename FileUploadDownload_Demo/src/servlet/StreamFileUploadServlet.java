package servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StreamFileUploadServlet
 */
@WebServlet("/StreamFileUploadServlet")
public class StreamFileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StreamFileUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		ServletInputStream in = request.getInputStream();
		//为提高读取效率，使用BufferedReader包装InputStreamReader，
		//将字节流处理成字符流，并放入缓冲流中。
		BufferedReader reader = new BufferedReader(new InputStreamReader(in,"UTF-8"));
		File file = new File("f:/a.txt");
		
//		//文件保存到一个相对路径
//		String path = getServletContext().getRealPath("/");
//		File file = new File(path+"b.txt");
		
		FileWriter fw = new FileWriter(file);
		//为提高写入效率，用BufferedWriter包装FileWriter
		BufferedWriter bw = new BufferedWriter(fw);
		String s = reader.readLine();
		while(s != null) {
			bw.write(s);
			bw.newLine();
			s = reader.readLine();
		}
		bw.flush();
		bw.close();
		in.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
