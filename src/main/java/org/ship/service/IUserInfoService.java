package org.ship.service;

import java.util.List;

import org.ship.model.UserInfo;
import org.ship.util.PageResults;

public interface IUserInfoService {
	
	/**
	 * queryAll
	 * @return List<UserInfo>
	 */
	public List<UserInfo> qeuryAll();
	
	/**
	 * findByPage
	 * @param stratPage
	 * @return PageResults
	 */
	@SuppressWarnings("rawtypes")
	public PageResults findByPage(int stratPage);
	
	/**
	 * save
	 * @param userInfo
	 */
	public void save(UserInfo userInfo);
	
	/**
	 * update
	 * @param userInfo
	 */
	public void update(UserInfo userInfo);
	
	/**
	 * save&Update
	 * @param userInfo
	 */
	public void saveOrUpdate(UserInfo userInfo);
	
	/**
	 * delete
	 * @param userInfo
	 */
	public void delete(UserInfo userInfo);
	
	/**
	 * deleteById
	 * @param userId
	 * @return true(success),false(error)
	 */
	public boolean deleteById(long userId);
	
	/**
	 * findByUserName
	 * @param userName
	 * @return true(success),false(error)
	 */
	public UserInfo queryByUserName(String userName);
}
