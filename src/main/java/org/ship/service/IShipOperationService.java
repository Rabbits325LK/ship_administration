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
	public PageResults<ShipOperation> queryOrderShipInfoState(int pageNo, long state);
	
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
	
	/**
	 * 查询预订订单是否存在
	 * @param shipOperationCode
	 * @return
	 */
	public boolean getByCodeforStateOrder(long shipOperationCode);
	
	/**
	 * 查询过期未处理的订单
	 * @return
	 */
	public List<ShipOperation> pastOrderShipInfo();
	
	/**
	 * 查询过期已通过预订的订单
	 * @return
	 */
	public List<ShipOperation> pastUseShipInfo();
	
	/**
	 * 根据编号和状态查询
	 * @param shipOperationCode
	 * @param shipState
	 * @return
	 */
	public ShipOperation queryByCodeAndState(long shipOperationCode, long shipState);
}
