package org.ship.test;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ship.model.Security;
import org.ship.model.UserInfo;
import org.ship.service.ISecurityService;
import org.ship.service.IUserInfoService;
import org.ship.util.Base64Utils;
import org.ship.util.HttpRequestUtil;
import org.ship.util.PageResults;
import org.ship.util.RSAUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring-hibernate.xml","classpath:spring-hibernate2.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ServiceTest {

	@Resource
	private IUserInfoService userInfoService;
	@Resource
	private ISecurityService securityService;
	//@Test
	public void testSay(){
		System.out.println("the ServiceTest");
	}
	
	//@Test
	public void userInfo_queryById(){
		UserInfo user = userInfoService.queryById((long)1);
		System.out.println(user.getNickName());
	}
	
	//@Test
	public void userInfo_queryByAll(){
		List<UserInfo> users = userInfoService.qeuryAll();
		for(UserInfo user : users ){
			System.out.println(user.getNickName());
		}
	}
	
	@SuppressWarnings({ "rawtypes"})
	//@Test
	public void userInfo_findByPage(){
		PageResults page = new PageResults();
		List<UserInfo> users = userInfoService.findByPage(page.getPageNo()).getResults();
		for(UserInfo user : users){
			System.out.println(user.getUserName());
		}
	}
	
	//@Test
	public void queryByIdforCount(){
		long count = userInfoService.queryByIdforCount((long)1);
		System.out.println(count);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void queryByAll_Security(){
		Security security = securityService.queryById((long)1);
		System.out.println(security.getProjectName());
		String url = "http://localhost:8080/ship_administration/APIship/RSAKey.do";
		String param = "";
		System.out.println(HttpRequestUtil.sendPost(url, param, false));
		String map = HttpRequestUtil.sendPost(url,param, false);
		Map<String,Object> map1 = (Map<String,Object>)JSON.parseObject(map);
		String val = map1.get("key").toString();
		System.out.println("VALUE:"+val);
		try {
			 byte[] encodedData = Base64Utils.decode(val);
		     byte[] decodedData = RSAUtils.decryptByPrivateKey(encodedData, security.getPrivateKey());  
		     String target = new String(decodedData);  
		     System.out.println("解密后文字: \r\n" + target);  
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("ERROR");
		}
	}
}
