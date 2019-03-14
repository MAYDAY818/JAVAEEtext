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
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendEmailServlet
 */
@WebServlet("/sendEmail.do")
public class SendEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendEmailServlet() {
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
		String fm  = request.getParameter("fm");
		String tm = request.getParameter("tm");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Properties props = new Properties();
		//发送邮件所使用的邮件服务器的主机地址
		props.put("mail.smtp.host", "smtp.163.com");
		//发送邮件所使用的协议名称
		props.put("mail.transport.protocol", "smtp");
		//是否认证,是
		props.put("mail.smtp.auth", true);
		
		//创建认证抽象类的子类，通过用户名和密码(此密码为邮箱的客户端授权码)访问受保护的邮件服务器资源
		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fm,"zhangsan163sqm");
			}
		};
		//创建java程序端与邮件服务器的会话实例
		Session mailSession = Session.getInstance(props,auth);
		mailSession.setDebug(true);
		//新建邮件对象
		Message msg = new MimeMessage(mailSession);
		try {
			//设置邮件的发件人
			msg.setFrom(new InternetAddress(fm));
			//设置邮件的收件人  TO - 收件人；CC - 抄送人
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(tm));
			//设置邮件的标题
			msg.setSubject(title);
			//设置邮件的发送日期
			msg.setSentDate(new Date());
			//设置邮件内容
			msg.setText(content);
			
			//连接邮件服务器、发送邮件、关闭连接
			Transport.send(msg);
			
//			//**start 获取发送对象，连接发送，断开连接设置 。这几行代码加起来相当于Transport.send(msg)。
//			msg.saveChanges();
//			Transport transport = mailSession.getTransport();
//			transport.connect();
//			transport.sendMessage(msg,msg.getAllRecipients());;
//			transport.close();
//			//**end
			
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
