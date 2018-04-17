package org.yuippe.jexltest;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.jexl3.*;
import org.yuippe.jexltest.util.DyMethodUtil;
import org.yuippe.jexltest.util.Util;

public class JexlTest {
	
	public static void main(String[] args) {
		//RL();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("Util", new Util());
		map.put("str1", "12345678910");
		map.put("severity", 3);
		map.put("title", "abcd");
		map.put("title1", "abcd");
		
		String expression = "severity<4&&title==\"abc\"&&Util.containsMethod(str1, \"1\")";
		DyMethodUtil dmu = new DyMethodUtil(new MapContext() , new JexlBuilder().create());
		Object object = dmu.invokeMethod(expression, map);
		System.out.println(object);
		
		expression = "severity<4&&title==\"abcd\"&&Util.containsMethod(str1, \"1\")";
		object = dmu.invokeMethod(expression, map);
		System.out.println(object);
	}
	
	public static void  RL() {
		
		String str1 = "12345678910";
		
		JexlContext jexlContext = new MapContext();
		jexlContext.set("Util",new Util());
		jexlContext.set("str1",str1);
		jexlContext.set("severity", 3);
		jexlContext.set("title", "abc");

		String expression = "severity<4&&title==\"abc\"&&Util.containsMethod(str1, \"1\")";
		
		JexlEngine jexl = new JexlBuilder().create();
		
		JexlExpression je = jexl.createExpression(expression);

		Object o = je.evaluate(jexlContext);
		
		System.out.println(o);

		
	}
}
