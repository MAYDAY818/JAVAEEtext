package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class CommonFileuploadServlet
 */
@WebServlet("/CommonFileuploadServletSimple")
public class CommonFileuploadServletSimple extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommonFileuploadServletSimple() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> list = upload.parseRequest(request);//得到所有的文件 
			for(FileItem item : list) {
				if(item.isFormField()) {
					out.println("文件描述:"+item.getString("utf-8")+"<br />");  
				}else {
					String value = item.getName(); //得到带有完整路径的文件名
					String fileName = value.substring(value.lastIndexOf("\\")+1);
					item.write(new File("D:\\upload\\",fileName));
					out.println(fileName+"上传成功");
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/** 
	 * 初始化目录（如果目录不存在，新建目录） 
	 * @param uploadPath 保存路径 
	 * @param tempPath 临时文件路径 
	 * @throws ServletException 
	 */  
	private void initDir(String uploadPath,String tempPath) throws ServletException{  
		File uploadFile = new File(uploadPath);  
		if (!uploadFile.exists()) {  
			uploadFile.mkdirs();  
		}  
		File tempPathFile = new File(tempPath);  
		if (!tempPathFile.exists()) {  
			tempPathFile.mkdirs();  
		}  
	} 

}
