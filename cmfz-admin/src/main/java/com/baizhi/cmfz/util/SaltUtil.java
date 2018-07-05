package com.baizhi.cmfz.util;

import java.util.Random;

public class SaltUtil {
	public static String getRandomChars(){
		char[] chs = "0123456789abcdefghijklmnABCDEFGHIJKLMN".toCharArray();
		char[] vcode = new char[4];
		Random random = new Random();
		for (int i = 0; i < vcode.length; i++) {
			vcode[i]=chs[random.nextInt(38)];
		}
		return String.valueOf(vcode);
	}
	

}
