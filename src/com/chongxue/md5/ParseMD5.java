package com.chongxue.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ParseMD5 {
	public static String parseStrToMd5L32(String str){  
        String reStr = null;  
        try {  
            MessageDigest md5 = MessageDigest.getInstance("MD5");  
            byte[] bytes = md5.digest(str.getBytes());  
            StringBuffer stringBuffer = new StringBuffer();  
            for (byte b : bytes){  
                int bt = b&0xff;  
                if (bt < 16){  
                    stringBuffer.append(0);  
                }   
                stringBuffer.append(Integer.toHexString(bt));  
            }  
            reStr = stringBuffer.toString();  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }  
        return reStr;  
    }  
	
	public static void main(String[] args) {
		String str = "123456Sunxin";
		//123456Baochx: 51c2a32972b764758de74e8aa20b1d10
		//123456baochx: efbdfb2b49fc9397029c1c355959e0b3
		System.out.println(ParseMD5.parseStrToMd5L32(str));

	}

}
