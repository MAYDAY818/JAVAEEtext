package servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String fileName=request.getParameter("fileName");
		//设置文件MIME类型  
		response.setContentType(getServletContext().getMimeType(fileName));  
		//两种解决中文文件名乱码的方案
		//URLEncoder.encode(fileName,"utf-8")
		//new String(fileName.getBytes("gbk"),"iso-8859-1")
		//设置Content-Disposition,通知客户端以下载的方式接收数据  attachment表示作为附件下载
		response.setHeader("Content-Disposition", "attachment;filename="+fileName);  
		//读取目标文件，通过response将目标文件写到客户端  
		//获取目标文件的绝对路径  
		String basePath = getServletContext().getRealPath("/");//得到项目的物理路径
        String fullFileName = basePath + "upload\\" + fileName;  
		//读取文件  
		InputStream in = new FileInputStream(fullFileName);  
		OutputStream out = response.getOutputStream();  
		//写文件  
		int b;  
		while((b=in.read())!= -1)  
		{  
			out.write(b);  
		}  
		
		in.close();  
		out.close();  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
