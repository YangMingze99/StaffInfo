package com.artisan.util;

public class StringUtil {
	public static boolean isEmpty(String str) {
		if("".equals(str) || str == null) {        //2019/9/5 0:20     "".equals(str)写法原因是str.equlas("")会抛异常  
			return true;						   //注重字符串比较    == 比较的是地址
		}		
		return false;
		
	}
}
