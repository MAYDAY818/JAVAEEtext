package lianxi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class demo {

	public void Test01(){
		//把数组数据转换成json格式
		String[] str = new String[]{"zs","sd"};
		String str1 = JSONArray.fromObject(str).toString();
		System.out.println(str1);
	}
	public void Test02(){
		//把一个bean对象的数据转换成json格式
		City city = new City(1, "xs", new String[]{"cxc"});
		String s = JSONObject.fromObject(city).toString();
		System.out.println(s);
	}
	

	public void Test03(){
		//把一个集合的数据转换成json的格式
		List<City> list = new ArrayList<City>();
		list.add(new City(1, "xs", new String[]{"cxc","sd","fs"}));
		list.add(new City(2, "fas", new String[]{"tq","gs","er"}));
		list.add(new City(3, "ga", new String[]{"hsc","gsA","hd"}));
		
		//得到的是一个数组，可以遍历读取
		//Object[] array = JSONArray.fromObject(list).toArray();
//		for(Object o : array){
//			System.out.println(o);
//		}
		String array = JSONArray.fromObject(list).toString();
		System.out.println(array);
	}

}
