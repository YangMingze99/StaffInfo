package com.artisan.util;

public class StringUtil {
	public static boolean isEmpty(String str) {
		if("".equals(str) || str == null) {        //2019/9/5 0:20     "".equals(str)д��ԭ����str.equlas("")�����쳣  
			return true;						   //ע���ַ����Ƚ�    == �Ƚϵ��ǵ�ַ
		}		
		return false;
		
	}
}
