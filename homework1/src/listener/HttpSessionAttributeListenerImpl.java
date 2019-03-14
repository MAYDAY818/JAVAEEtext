package listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class HttpSessionAttributeListenerImpl
 *
 */
@WebListener
public class HttpSessionAttributeListenerImpl implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public HttpSessionAttributeListenerImpl() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent se)  { 
         String attributeName = se.getName();
         if("user".equals(attributeName)) {
        	 HttpSession session = se.getSession();
        	 ServletContext application = session.getServletContext();
        	 Object vipNumObj = application.getAttribute("vipNum");
        	 if(vipNumObj == null) {
        		 application.setAttribute("vipNum", 1);
        	 }else {
        		 int vipNum = (Integer)vipNumObj;
        		 vipNum++;
        		 application.setAttribute("vipNum", vipNum);
        	 }
         }
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	String attributeName = se.getName();
        if("user".equals(attributeName)) {
       	 HttpSession session = se.getSession();
       	 ServletContext application = session.getServletContext();
       	 Object vipNumObj = application.getAttribute("vipNum");
       	 if(vipNumObj != null) {
       		 int vipNum = (Integer)vipNumObj;
       		 if(vipNum > 0) {
       			 vipNum--;
       		 }else {
       			 vipNum = 0;
       		 }
       		 application.setAttribute("vipNum", vipNum);
       	 }
        }
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
