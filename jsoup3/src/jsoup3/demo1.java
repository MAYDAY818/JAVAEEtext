package jsoup3;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

public class demo1 {

	public static void main(String[] args) throws IOException {
		//获取题目,网址,简介,时间
		org.jsoup.nodes.Document doc = Jsoup.connect("http://www.yystv.cn/b/recommend").get();
		System.out.println("时间点总数:"+doc.toString());
        
	}

}
