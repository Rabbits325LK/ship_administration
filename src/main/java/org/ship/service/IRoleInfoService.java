package org.ship.service;

import java.util.List;

import org.ship.model.RoleInfo;

public interface IRoleInfoService {
	
	/**
	 * 查询角色
	 */
	public List<RoleInfo> queryByAll();
	/**
	 * 根据编号查询角色
	 */
	public RoleInfo getById(long roleId);
	/**
	 * 添加角色
	 */
	public void save(RoleInfo roleInfo);
	/**
	 * 删除角色
	 */
	public void delete(RoleInfo roleInfo);
	/**
	 * 修改角色
	 */
	public void update(RoleInfo roleInfo);
}
