package org.ship.service;

import java.util.List;

import org.ship.model.UserInfo;
import org.ship.util.PageResults;

public interface IUserInfoService {
	
	public Long queryByIdforCount(long userId);
	
	public List<UserInfo> queryByRoleId(long roleId);
	
	public UserInfo queryById(long userId);
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
	public PageResults<UserInfo> findByPage(int stratPage);
	
	
	public PageResults<UserInfo> findByPageAndRoleId(int startPage, long roleId);
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
