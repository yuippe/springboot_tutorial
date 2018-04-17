package org.yuippe.jexltest.util;

import java.util.Map;

import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;
import org.apache.commons.jexl3.MapContext;

public class DyMethodUtil {
	
	private JexlContext jexlContext;
	private JexlEngine jexl;
	
	
	
	public DyMethodUtil(JexlContext jexlContext, JexlEngine jexl) {
		super();
		this.jexlContext = jexlContext;
		this.jexl = jexl;
	}



	public Object invokeMethod(String jexlExp, Map<String,Object> map) {
		
		for(String key:map.keySet()) {
			this.jexlContext.set(key, map.get(key)); 
		}
		
		JexlExpression je = jexl.createExpression(jexlExp);
		
		if(null==je.evaluate(jexlContext)) {
			return "";
		}
		return je.evaluate(jexlContext);
	}

}
