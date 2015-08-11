package org.ship.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ship.dao.IUserInfoDao;
import org.ship.model.UserInfo;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;


@ContextConfiguration(locations = { "classpath:spring.xml",
		"classpath:spring-hibernate.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
// defaultRollback=true 不会改变数据库， false会改变数据库
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class DaoTest {

	@Resource
	private IUserInfoDao userInfoDao;
	
	@Test
	public void testUserInfoQueryAll(){
		List<UserInfo> users = userInfoDao.getListByHQL("from UserInfo order by userId");
		for(UserInfo user : users){
			System.out.println(user.getUserName());
			System.out.println(user.getNickName());
		}
	}
}
