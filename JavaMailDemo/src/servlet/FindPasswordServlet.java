package servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FindPasswordServlet
 */
@WebServlet("/findPassword.do")
public class FindPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPasswordServlet() {
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
		String tm = request.getParameter("tm");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.163.com");
		// 发送邮件协议名称  
		props.put("mail.transport.protocol", "smtp");
		// 是否认证  
		props.put("mail.smtp.auth", true);
		//创建java程序端与邮件服务器的会话实例
		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("javamail5678@163.com","javamail5678sqm");
			}
		};
		
		Session mailSession = Session.getInstance(props,auth);
		Message msg = new MimeMessage(mailSession);
		try {
			//用户密码
			String password = "123456";
			
			//设置邮件的发件人
			msg.setFrom(new InternetAddress("javamail5678@163.com"));
			//设置邮件的收件人
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(tm));
			msg.setSubject("找回密码");
			msg.setSentDate(new Date());
			//发送消息
			//msg.setText("1233");
			
			MimeBodyPart mbp = new MimeBodyPart();
			
			mbp.setContent("您的密码为："+password,"text/html;charset=UTF-8");
			MimeMultipart mm = new MimeMultipart();
			mm.addBodyPart(mbp);
			msg.setContent(mm);
			Transport.send(msg);
			response.sendRedirect("success.jsp");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
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

}
