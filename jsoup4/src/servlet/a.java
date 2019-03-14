package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import dao.database;


/**
 * Servlet implementation class a
 */
@WebServlet("/a")
public class a extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public a() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
//		for(int page=1;page<40;page++) {

		// TODO Auto-generated method stub
		//��ȡ��Ŀ,��ַ,���,ʱ��
		Document doc = Jsoup.connect("https://www.gcores.com/radios/104885").get();
		Elements links = doc.select("div.swiper-slide");

        for(int j = 1;j < links.size();j++){

        	String title = links.get(j).select("h1").text().split( " " )[0];
        	System.out.println(title);

            String time = links.get(j).select("a").attr("data-at");
            System.out.println(time);

            String info = links.get(j).select("p").text();
            System.out.println(info);

//            String url = links.get(j).select("p").select("a").attr("href");
//            System.out.println(url);

            String imgUrlTab =Jsoup.parseBodyFragment(links.get(j).select("textarea").text()).body().select("img").attr("src");
            System.out.println(imgUrlTab);
            
            Connection conn = database.getConnection();
          PreparedStatement pstmt = null;
  		String sql ="INSERT INTO audio104885 (title,info,imgurl,time) VALUES (?,?,?,?)";
  			try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, title);
	    			pstmt.setString(2, info);
	    			pstmt.setString(3, imgUrlTab);
	    			pstmt.setString(4, time);
	    			boolean rs = pstmt.execute();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}
//            
        }
    			
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
