package org.ship.service;

import java.util.List;

import org.ship.model.ShipInfo;
import org.ship.util.PageResults;

public interface IShipInfoService {
	
	/**
	 * 通过ID查询是否存在，存在的条数
	 * @param shipId
	 * @return
	 */
	public Long queryByIdforCount(long shipId);
	/**
	 * 查询全部游艇信息
	 */
	public List<ShipInfo> queryByAll();
	/**
	 * 根据游艇编号查询游艇信息
	 */
	public ShipInfo getById(long shipId);
	/**
	 * 根据游艇名称查询游艇信息
	 */
	public ShipInfo queryByShipName(String shipName);
	/**
	 * 根据游艇类型查询游艇列表
	 */
	public List<ShipInfo> queryByShipType(long shipTypeCode);
	/**
	 * 添加游艇信息
	 */
	public void save(ShipInfo shipInfo);
	/**
	 * 修改游艇信息
	 */
	public void update(ShipInfo shipInfo);
	/**
	 * 删除游艇信息 
	 */
	public void delete(ShipInfo shipInfo);
	/**
	 * 根据尺寸查询游艇信息
	 */
	//public PageResults<ShipInfo> queryBySize(String shipSize, int symbol);
	/**
	 * 分页查询
	 */
	@SuppressWarnings("rawtypes")
	public PageResults findByPage(int pageNo);
}
