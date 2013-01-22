package org.sommer.pm.application;

public class Util {

	public static String humaniseAmount(long amount) {
		String returnStr = "";
		long g = 0, s = 0, c = 0;
		
		g = amount / 10000;
		s = (amount / 100) % 100;
		c = amount % 100;
		
		if(g > 0) {
			returnStr += g + "g";
			returnStr += s + "s";
		} else if(s > 0) {
			returnStr += s + "s";
		}
		returnStr += c + "c";
		
		return returnStr;
	}
}
