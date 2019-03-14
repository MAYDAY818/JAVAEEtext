package listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class HttpSessionListenerImpl
 *
 */
@WebListener
public class HttpSessionListenerImpl implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public HttpSessionListenerImpl() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent httpsessionevent)  { 
    	ServletContext application = httpsessionevent.getSession().getServletContext();
    	int onlineNum = (Integer)application.getAttribute("onlineNum");
    	onlineNum = onlineNum + 1;
    	application.setAttribute("onlineNum", onlineNum);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent httpsessionevent)  { 
         // TODO Auto-generated method stub
    }
	
}
