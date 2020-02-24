package com.kenan.utils.utils;


import java.util.Random;

public class StringUtils {

	public static boolean isEmpty(String str){
		if(str == null || "".equals(str)){
		    return true;	
		}
		
		return false;
	}

	/**
	 * 获取随机数
	 *
	 * @param rSum 位数
	 * @return
	 */
	public static String getRandom(int rSum) {
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < rSum; i++) {
			sb.append(r.nextInt(rSum));
		}
		return sb.toString();
	}


	/**
	 * 用于判断多个字符串当中是否有为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String... str) {

		for (String s : str) {
			if (isEmpty(s)) {
				return true;
			}
		}
		return false;
	}
}
