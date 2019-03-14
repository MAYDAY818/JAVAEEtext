package jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class demo01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 System.out.println("Hello World"); 
//		Document doc = Jsoup.connect("https://www.gcores.com/categories/1/originals").get();
//	//	Document doc = Jsoup.parse(connection.getInputStream(), "GBK", "https://www.gcores.com/categories/1/originals");
//	    Elements titleLinks = doc.select("div.showcase_text");    //解析来获取每条新闻的标题与链接地址
//	    Elements descLinks = doc.select("div.showcase_info");//解析来获取每条新闻的简介
//	    Elements timeLinks = doc.select("div.showcase_time");
//	    for(int j = 0;j < titleLinks.size();j++){
//		    String title = titleLinks.get(j).select("a").text();
//		    System.out.println(title);
//		    String uri = titleLinks.get(j).select("a").attr("href");
//		    System.out.println(uri);
//		    String desc = descLinks.get(j).text();
//		    System.out.println(desc);
//		    String time = timeLinks.get(j).text();
//		    System.out.println(time);
//	    }
	}

}
