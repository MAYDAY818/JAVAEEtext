package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServletContextListenerimpl
 *
 */
@WebListener
public class ServletContextListenerimpl implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ServletContextListenerimpl() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	System.out.println("ServletContextListenerImpl contextDestroyed");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	System.out.println("ServletContextListenerImpl contextIntialized");
    	System.out.println("初始化工作");
    	ServletContext appLication=sce.getServletContext();
    	appLication.setAttribute("onlineNum", 0);
    }
	
}
