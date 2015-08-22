package org.ship.test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import org.ship.util.HttpRequestUtil;
import org.ship.util.RSAUtils;

public class HttpTest {
	public static void main(String[] args) {
		String url = "http://localhost:8080/ship_administration/APIship/QueryShipInfo.do?shipId=1";
		String param = "";
		System.out.println(HttpRequestUtil.sendPost(url, param, false));
		try {
			Map<String, Object> keyMap = RSAUtils.genKeyPair();
			String publicKey = RSAUtils.getPublicKey(keyMap);
			String privateKey = RSAUtils.getPrivateKey(keyMap);
			 byte[] data = HttpRequestUtil.sendPost(url, param, false).getBytes();  
		     byte[] encodedData = RSAUtils.encryptByPublicKey(data, publicKey);
		     System.out.println("加密后文字：\r\n" + new String(encodedData));  
		     byte[] decodedData = RSAUtils.decryptByPrivateKey(encodedData, privateKey);  
		     String target = new String(decodedData);  
		     System.out.println("解密后文字: \r\n" + target);  
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
//String url = "http://localhost:8080/ship_administration/APIuser/OrderShip.do";
//String param = "shipId=1&userId=1&start=2015-08-14 19:30:00&end=2015-08-14 20:30:00";