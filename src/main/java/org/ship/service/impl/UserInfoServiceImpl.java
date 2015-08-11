package org.ship.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.ship.dao.IUserInfoDao;
import org.ship.model.UserInfo;
import org.ship.service.IUserInfoService;
import org.ship.util.PageResults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {

	@Resource
	private IUserInfoDao userInfoDao;

	@Override
	public List<UserInfo> qeuryAll() {
		// TODO Auto-generated method stub
		return userInfoDao.getListByHQL("from UserInfo order by userId");
	}

	@SuppressWarnings("rawtypes")
	@Override
	public PageResults findByPage(int stratPage) {
		// TODO Auto-generated method stub
		return userInfoDao.findPageByFetchedHql(
				"from UserInfo order by userId",
				"select count(*) from UserInfo", stratPage, 10);
	}

	@Override
	public void save(UserInfo userInfo) {
		// TODO Auto-generated method stub
		userInfoDao.save(userInfo);
	}

	@Override
	public void update(UserInfo userInfo) {
		// TODO Auto-generated method stub
		userInfoDao.update(userInfo);
	}

	@Override
	public void saveOrUpdate(UserInfo userInfo) {
		// TODO Auto-generated method stub
		userInfoDao.saveOrUpdate(userInfo);
	}

	@Override
	public void delete(UserInfo userInfo) {
		// TODO Auto-generated method stub
		userInfoDao.delete(userInfo);
	}

	@Override
	public boolean deleteById(long userId) {
		// TODO Auto-generated method stub
		return userInfoDao.deleteById(userId);
	}

	@Override
	public UserInfo queryByUserName(String userName) {
		// TODO Auto-generated method stub
		return userInfoDao.getByHQL("from UserInfo where userName=?", userName);
	}

}
