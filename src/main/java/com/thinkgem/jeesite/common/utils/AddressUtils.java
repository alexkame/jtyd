package com.thinkgem.jeesite.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

 

/**
 * 根据IP地址获取详细的地域信息
 * 
 * @project:personGocheck
 * @class:AddressUtils.java
 * @author:heguanhua E-mail:37809893@qq.com
 * @date：Nov 14, 2012 6:38:25 PM
 */
public class AddressUtils {
	 public static void main(String[] args) {
		 System.out.println(getAddressByIP("101.227.131.247"));
	 } 
	 public final static String getIpAddress(HttpServletRequest request){  
	        // 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址  
	        String ip = request.getHeader("X-Forwarded-For");  
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	                ip = request.getHeader("Proxy-Client-IP");  
	            }  
	            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	                ip = request.getHeader("WL-Proxy-Client-IP");  
	            }  
	            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	                ip = request.getHeader("HTTP_CLIENT_IP");  
	            }  
	            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	                ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
	            }  
	            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	                ip = request.getRemoteAddr();  
	            }  
	        } else if (ip.length() > 15) {  
	            String[] ips = ip.split(",");  
	            for (int index = 0; index < ips.length; index++) {  
	                String strIp = (String) ips[index];  
	                if (!("unknown".equalsIgnoreCase(strIp))) {  
	                    ip = strIp;  
	                    break;  
	                }  
	            }  
	        }  
	        return ip;  
	}
	public  static String getAddressByIP(String strIP){
		if (StringUtils.isBlank(strIP)) {
			return "未知=未知";
		}
		StringBuffer result=null;
		try {
			URL	url = new URL("http://ip.taobao.com/service/getIpInfo.php?ip="+strIP);
			URLConnection conn = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "GBK"));
			String line = null;
			result = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				result.append(line);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JSONObject a =  JSONObject.fromObject(result.toString()); 
		if (null==a){
			return "未知=未知";
		}else{
			int flag = (int)a.get("code");
			if(flag==1){
				 return "未知=未知";
			}
		}
  	    JSONObject b = JSONObject.fromObject(a.get("data").toString()); 
  	    if (null==b) {
			return "未知=未知";
		}
	  	String province =(String) b.get("region");
		String city = (String) b.get("city");
		province = StringUtils.isNotBlank(province)?province:"未知";
		city = StringUtils.isNotBlank(city)==true?city:"未知";
		return province+"="+city;
	}
	/**
	 * unicode 转字符串
	 */
	public static String unicode2String(String unicode) {
		if (StringUtils.isBlank(unicode)) {
			return "未知";
		}
		try {
		    byte[] converttoBytes = unicode.getBytes("UTF-8");
		    return new String(converttoBytes, "UTF-8");
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return "未知";
	}
}
