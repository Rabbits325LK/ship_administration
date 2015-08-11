package org.ship.service;

import java.util.List;

import org.ship.model.ShipOperation;
import org.ship.util.PageResults;

public interface IShipOperationService {

	/**
	 * 分页查询预订的游艇信息
	 * @param page
	 * @return
	 */
	public PageResults<ShipOperation> queryOrderShipInfo(int pageNo);
	
	public List<ShipOperation> queryByShipState(long shipState);
	
	public List<ShipOperation> queryByShipId(long shipId);
	
	public List<ShipOperation> queryByUserId(long userId);
	
	public List<ShipOperation> queryByAll();
	
	public boolean queryByShipTime(ShipOperation shipOperation);
	
	public void save(ShipOperation shipOperation);
	
	/**
	 * 修改船艇状态为使用通过
	 * @param shipOperation
	 */
	public void updateStatePass(ShipOperation shipOperation);
	
	/**
	 * 修改船艇状态为使用
	 * @param shipOperation
	 */
	public void updateStateUse(ShipOperation shipOperation);
	/**
	 * 修改船艇状态为作废
	 * @param shipOperation
	 */
	public void updateStateInvalid(ShipOperation shipOperation);
	
	public void delete(ShipOperation shipOperation);
	
	/**
	 * 根据编号查询
	 * @param shipOperationCode
	 * @return
	 */
	public ShipOperation getByCode(long shipOperationCode);
	
}
