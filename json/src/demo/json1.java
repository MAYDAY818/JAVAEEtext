package demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class json1
 */
@WebServlet("/json1")
public class json1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public json1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  JSONArray jsonArray = new JSONArray();
		  //�½�һ��JSON����
		  JSONObject json1 = new JSONObject();
          json1.put("id", "1");
          json1.put("name", "����");
          json1.put("password", "123456");
          //��JSON������ӵ�JSON������ȥ
          jsonArray.add(json1);

          JSONObject json2 = new JSONObject();
          json2.put("id", "2");
          json2.put("name", "����");
          json2.put("password", "654321");
          jsonArray.add(json2);
          System.out.println("json�����������:" + jsonArray);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
