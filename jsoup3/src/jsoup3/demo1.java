package jsoup3;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

public class demo1 {

	public static void main(String[] args) throws IOException {
		//��ȡ��Ŀ,��ַ,���,ʱ��
		org.jsoup.nodes.Document doc = Jsoup.connect("http://www.yystv.cn/b/recommend").get();
		System.out.println("ʱ�������:"+doc.toString());
        
	}

}
