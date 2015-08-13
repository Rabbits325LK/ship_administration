package org.ship.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ship.model.RoleInfo;
import org.ship.model.UserInfo;
import org.ship.service.IRoleInfoService;
import org.ship.service.IUserInfoService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "classpath:spring.xml",
"classpath:spring-hibernate.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserSimulationTest {

	@Resource
	private IUserInfoService userInfoService;
	@Resource
	private IRoleInfoService roleInfoService;
	
	/**
	 * 模拟注册新用户
	 */
	//@Test
	public void signUser(){
		UserInfo user = new UserInfo();
		user.setUserName("testuser"); //设置用户名
		user.setNickName("测试帐号");//设置昵称
		user.setUserPwd("lk5115702");//设置密码
		user.setRoleId((long)2);//设置管理员权限
		user.setTel("073185115702");//设置固话
		user.setPhone("18676660220");//设置手机号
		user.setEmail("rabbits325@live.cn");//设置邮箱
		user.setQq("464020173");//设置QQ
		user.setAddress("湖南省天心区金盆岭通用时代国际社区12栋402房");//设置地址
		user.setUserIdcard("430103199002253016");//设置身份证号
		user.setGender(1);//设置性别
		userInfoService.save(user);
		System.out.println("save win");
	}
	
	/**
	 * 添加角色
	 */
	//@Test
	public void addRole(){
		RoleInfo role = new RoleInfo();
		role.setRoleName("APIuser");
		roleInfoService.save(role);
		System.out.println("save win");
	}
}
