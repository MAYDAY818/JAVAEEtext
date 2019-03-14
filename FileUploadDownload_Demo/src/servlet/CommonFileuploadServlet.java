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
@WebServlet("/CommonFileuploadServlet")
public class CommonFileuploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommonFileuploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		String basePath = getServletContext().getRealPath("/");//得到项目的物理路径
		String uploadPath = basePath + "/upload";//设置上传目录
		System.out.println(uploadPath);
		//uploadPath = uploadPath +"/"+ date.getTime();//添加时间目录防止重复
		String tempPath = basePath + "/temp";//设置缓存目录
		this.initDir(uploadPath, tempPath); //如果目录不存在，新建目录
		
		factory.setSizeThreshold(4096); // 设置缓冲区大小，这里是4kb
		File tempPathFile = new File(tempPath);
		factory.setRepository(tempPathFile);// 设置缓冲区目录 
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		//限制上传文件大小
		upload.setFileSizeMax(1024 * 196);// 限制单个文件的大小不超过200kb 
		//upload.setSizeMax(5*1024*1024);//限制上传的总的文件大小不超过5M 

		//设置上传文件限制大小,-1表示无上限
//		upload.setSizeMax(-1);
		
		try {
			List<FileItem> list = upload.parseRequest(request);//得到所有的文件 
			for(FileItem item : list) {
				if(item.isFormField()) {//判断是否是文件流     
					 //如果是文本框，获取文本框的内容。表单参数名item.getFieldName()，表单参数值item.getString("utf-8")
					out.println("文件描述:"+item.getString("utf-8")+"<br />");  
				}else {//是文件流则读取文件，保存文件
					String value = item.getName(); //得到带有完整路径的文件名
					int start = value.lastIndexOf("\\");
					String fileName = value.substring(start+1);
					item.write(new File(uploadPath,fileName));
					
					out.println("上传文件的大小:"+item.getSize()+"<br />");  
					out.println("上传文件的类型:"+item.getContentType()+"<br />");  
					out.println("上传文件的名称:"+item.getName()+"<br />");  
					out.println("<a href=\"DownloadServlet?fileName="+fileName+"\">下载</a>");
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
