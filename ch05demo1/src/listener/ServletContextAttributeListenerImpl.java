package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServletContextAttributeListenerImpl
 *
 */
@WebListener
public class ServletContextAttributeListenerImpl implements ServletContextAttributeListener {

    /**
     * Default constructor. 
     */
    public ServletContextAttributeListenerImpl() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent servletcontextattributeevent)  { 
         System.out.println("在ServletContext中添加了属性");
         String name = servletcontextattributeevent.getName();
         int value = (Integer)servletcontextattributeevent.getValue();
         System.out.println(name+":"+value);
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent servletcontextattributeevent)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent servletcontextattributeevent)  { 
         // TODO Auto-generated method stub
    }
	
}
