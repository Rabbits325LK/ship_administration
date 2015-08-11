package org.ship.service;

import java.util.List;

import org.ship.model.ShipType;

public interface IShipTypeService {
	
	/**
	 * queryByCode
	 * @param shipTypeCode
	 * @return ShipType
	 */
	public ShipType queryByCode(long shipTypeCode);
	
	/**
	 * queryByName
	 * @param shipTypeName
	 * @return shipType
	 */
	public ShipType queryByName(String shipTypeName);
	
	/**
	 * queryByAll
	 * @return List<ShipType>
	 */
	public List<ShipType> queryByAll();
	
	/**
	 * save
	 * @param shipType
	 */
	public void save(ShipType shipType);
	
	/**
	 * update 
	 * @param shipType
	 */
	public void update(ShipType shipType);
	
	/**
	 * delete
	 * @param shipType
	 */
	public void delete(ShipType shipType);
}
