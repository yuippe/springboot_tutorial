package org.yuippe.jexltest;

import org.apache.commons.jexl3.*;
import org.yuippe.jexltest.util.Util;

public class JexlTest {
	
	public static void main(String[] args) {
		RL();	
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
