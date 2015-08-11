package org.ship.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.ship.dao.IShipOperationDao;
import org.ship.model.ShipOperation;
import org.ship.service.IShipOperationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("shipOperationService")
public class ShipOperationServiceImpl implements IShipOperationService{

	@Resource
	private IShipOperationDao shipOperationDao;

	@Override
	public List<ShipOperation> queryByShipState(long shipState) {
		// TODO Auto-generated method stub
		return shipOperationDao.getListByHQL("from ShipOperation where shipState=?", shipState);
	}

	@Override
	public List<ShipOperation> queryByShipId(long shipId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShipOperation> queryByUserId(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShipOperation> queryByAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean queryByShipTime(Date date) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void save(ShipOperation shipOperation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ShipOperation shipOperation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ShipOperation shipOperation) {
		// TODO Auto-generated method stub
		
	}
}
