package org.yuippe.jexltest.util;

import java.util.regex.Pattern;

public class Util {
	
	public static boolean regMatch(String regEx, String str) {
		Pattern pattern = Pattern.compile(regEx);
		return pattern.matcher(str).matches();
	}
	
	public static boolean containsMethod(String oriString, String keyStr) {
		
		return oriString.contains(keyStr);
	}

}
