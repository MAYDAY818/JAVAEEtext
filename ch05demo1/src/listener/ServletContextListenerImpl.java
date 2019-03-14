package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServletContextListenerImpl
 *
 */
@WebListener
public class ServletContextListenerImpl implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ServletContextListenerImpl() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("ServletContextListenerImpl contextDestroyed()");
    	System.out.println("清理工作");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	System.out.println("ServletContextListenerImpl contextInitialized()");
    	System.out.println("初始化工作");
    	ServletContext application = sce.getServletContext();
    	application.setAttribute("onlineNum", 0);
    	application.setAttribute("vipNum", 0);
    }
	
}
