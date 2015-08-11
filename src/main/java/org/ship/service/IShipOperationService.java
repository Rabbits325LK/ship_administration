package org.ship.service;

import java.util.Date;
import java.util.List;

import org.ship.model.ShipOperation;

public interface IShipOperationService {

	public List<ShipOperation> queryByShipState(long shipState);
	
	public List<ShipOperation> queryByShipId(long shipId);
	
	public List<ShipOperation> queryByUserId(long userId);
	
	public List<ShipOperation> queryByAll();
	
	public boolean queryByShipTime(Date date);
	
	public void save(ShipOperation shipOperation);
	
	public void update(ShipOperation shipOperation);
	
	public void delete(ShipOperation shipOperation);
	
}
