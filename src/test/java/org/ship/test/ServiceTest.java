package org.ship.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ship.model.UserInfo;
import org.ship.service.IUserInfoService;
import org.ship.util.PageResults;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring-hibernate.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ServiceTest {

	@Resource
	private IUserInfoService userInfoService;
	
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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
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
}
