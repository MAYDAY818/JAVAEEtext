package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class OreillycosServlet
 */
@WebServlet("/OreillycosServlet")
public class OreillycosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OreillycosServlet() {
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
		PrintWriter out = response.getWriter();
		
		//文件上传后，保存在F:\\upload  
		String saveDirectory ="F:\\upload";  
		//每个文件最大5m,最多3个文件,所以  
		int maxPostSize =3 * 5 * 1024 * 1024 ;  
		
		//就这一句就完成上传了。采用缺省的文件名冲突解决策略,实现上传  
		MultipartRequest multi = new MultipartRequest(request, saveDirectory, maxPostSize,"UTF-8");  
		
//		//使用自己设置的文件名冲突解决策略，实现上传
//		RandomFileRenamePolicy rfrp=new RandomFileRenamePolicy();
//		MultipartRequest multi = new MultipartRequest(request, saveDirectory, maxPostSize,"gb2312",rfrp);
		
		//输出反馈信息  
		 Enumeration files = multi.getFileNames();  
		     while (files.hasMoreElements()) {  
		    	 String name = (String)files.nextElement();  
		    	 File f = multi.getFile(name);  
		    	 if(f!=null){  
		    		 String fileName = multi.getFilesystemName(name);  
		    		 String lastFileName= saveDirectory+"\\" + fileName;  
		    		 out.println("上传的文件:"+lastFileName);  
		    		 out.println("<hr>");  
		    	 }  
		     }  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
