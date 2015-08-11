package org.ship.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.ship.dao.IShipTypeDao;
import org.ship.model.ShipType;
import org.ship.service.IShipTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("shipTypeService")
public class ShipTypeServiceImpl implements IShipTypeService{

	@Resource
	private IShipTypeDao shipTypeDao;
	
	@Override
	public ShipType queryByCode(long shipTypeCode) {
		// TODO Auto-generated method stub
		return shipTypeDao.get(shipTypeCode);
	}

	@Override
	public ShipType queryByName(String shipTypeName) {
		// TODO Auto-generated method stub
		return shipTypeDao.getByHQL("from ShipType where shipTypeName", shipTypeName);
	}

	@Override
	public List<ShipType> queryByAll() {
		// TODO Auto-generated method stub
		return shipTypeDao.getListByHQL("from ShipType order by shipTypeCode");
	}

	@Override
	public void save(ShipType shipType) {
		// TODO Auto-generated method stub
		shipTypeDao.save(shipType);
	}

	@Override
	public void update(ShipType shipType) {
		// TODO Auto-generated method stub
		shipTypeDao.update(shipType);
	}

	@Override
	public void delete(ShipType shipType) {
		// TODO Auto-generated method stub
		shipTypeDao.delete(shipType);
	}

}
