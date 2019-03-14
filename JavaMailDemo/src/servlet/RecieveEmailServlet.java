package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RecieveEmailServlet
 */
@WebServlet("/recieveEmail.do")
public class RecieveEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecieveEmailServlet() {
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
		//定义连接POP3服务器的属性信息
		String pop3Server = "pop.163.com";
		String protocol = "pop3";
		String userName = "zhangsan_email@163.com";
		String password = "zhangsan163sqm";
		
		Properties props = new Properties();
		//使用的协议
		props.setProperty("mail.store.protocol", protocol);
		//收件人的邮箱服务器地址
		props.setProperty("mail.pop3.host", pop3Server);
		//接收配置属性信息，初始化JavaMail环境
		Session session = Session.getDefaultInstance(props);
		//如果需要查看接收邮件的详细信息，需要设置Debug标志
		session.setDebug(false);
		try {
			//获取store对象。邮件操作只有发送或接收两种处理方式，JavaMail将这两种不同操作描述为传输（javax.mail.Transport）和存储（javax.mail.Store），传输对应邮件的发送，而存储对应邮件的接收
			Store store = session.getStore(protocol);
			//pop3服务器的登录认证
			store.connect(pop3Server,userName,password);
			//连接到 Store 之后，就可以获取一个 Folder，但必须先打开它，然后才能读里面的消息。
			//POP3 唯一可以用的文件夹是 INBOX。如果使用 IMAP，还可以用其它文件夹。
			Folder folder = store.getFolder("INBOX");
			//设置对邮件账户的访问权限
			folder.open(Folder.READ_WRITE);
			//得到邮箱账户中的所有邮件
			Message[] messages = folder.getMessages();
			
//		    //创建搜索条件  
//	        SearchTerm st=new AndTerm(new FromStringTerm("customer_service@jd.com"),new ReceivedDateTerm(ComparisonTerm.EQ,new Date()));  
//	        SearchTerm st=new AndTerm(new FromStringTerm("customer_service@jd.com"),null);  
//	        //搜索邮件  
//	        Message [] messages=folder.search(st);  
			
			//一旦读完邮件，要关闭与 folder 和 store 的连接。
			//传递给 folder 的 close() 方法的 boolean 表示是否清除已删除的消息从而更新 folder。
//			folder.close(true);
//			store.close();
			
			PrintWriter out = response.getWriter();
			for(Message message:messages) {
				//获得邮件主题
				String subject = message.getSubject();
				//获得发件者地址
				Address from = message.getFrom()[0];
				out.println("邮件的主题为：" + subject);
				out.println("邮件的发件人地址为：" + from);
				out.println("<br />");
			}
		} catch (NoSuchProviderException e) {
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
