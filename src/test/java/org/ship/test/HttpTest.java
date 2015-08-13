package org.ship.test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.ship.util.HttpRequestUtil;

public class HttpTest {

	public static void main(String[] args) {
		
		//String url = "http://localhost:8080/ship_administration/APIuser/OrderShip.do";
		//String param = "shipId=1&userId=1&start=2015-08-14 19:30:00&end=2015-08-14 20:30:00";
		String url = "http://localhost:8080/ship_administration/APIuser/UpdateUserInfo.do";
		String param = "userId=2&address=湖南省-天心区-通用时代国际社区-12栋-402房";
		System.out.println(HttpRequestUtil.sendPost(url, param, false));
	}

	
}
