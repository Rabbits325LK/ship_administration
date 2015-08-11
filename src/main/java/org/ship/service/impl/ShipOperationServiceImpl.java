package org.ship.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.ship.dao.IShipOperationDao;
import org.ship.model.ShipOperation;
import org.ship.service.IShipOperationService;
import org.ship.util.PageResults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("shipOperationService")
public class ShipOperationServiceImpl implements IShipOperationService {

	@Resource
	private IShipOperationDao shipOperationDao;

	@Override
	public List<ShipOperation> queryByShipState(long shipState) {
		// TODO Auto-generated method stub
		return shipOperationDao.getListByHQL(
				"from ShipOperation where shipState=?", shipState);
	}

	@Override
	public List<ShipOperation> queryByShipId(long shipId) {
		// TODO Auto-generated method stub
		return shipOperationDao.getListByHQL(
				"from ShipOperation where shipId=? order by shipOperationCode",
				shipId);
	}

	@Override
	public List<ShipOperation> queryByUserId(long userId) {
		// TODO Auto-generated method stub
		return shipOperationDao.getListByHQL(
				"from ShipOperation where userId=? order by shipOperationCode",
				userId);
	}

	@Override
	public List<ShipOperation> queryByAll() {
		// TODO Auto-generated method stub
		return shipOperationDao
				.getListByHQL("from ShipOperation order by shipOperationCode");
	}

	/**
	 * @return false （没有） true （有）
	 */
	@Override
	public boolean queryByShipTime(ShipOperation shipOperation) {
		// TODO Auto-generated method stub
		List<ShipOperation> sos = shipOperationDao
				.getListByHQL(
						"from ShipOperation where shipId=? and stratime>= ? and endtime <= ? and shipState = 2",
						shipOperation.getShipId(), shipOperation.getStratime(),
						shipOperation.getStratime());
		if (sos.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void save(ShipOperation shipOperation) {
		// TODO Auto-generated method stub
		shipOperationDao.save(shipOperation);
	}

	/**
	 * 跟新状态为通过
	 */
	@Override
	public void updateStatePass(ShipOperation shipOperation) {
		// TODO Auto-generated method stub
		shipOperation.setShipState((long) 2);
		shipOperationDao.update(shipOperation);
	}

	@Override
	public void delete(ShipOperation shipOperation) {
		// TODO Auto-generated method stub
		shipOperationDao.delete(shipOperation);
	}

	@Override
	public void updateStateUse(ShipOperation shipOperation) {
		// TODO Auto-generated method stub
		shipOperation.setShipState((long) 3);
		shipOperationDao.update(shipOperation);
	}

	@Override
	public void updateStateInvalid(ShipOperation shipOperation) {
		// TODO Auto-generated method stub
		shipOperation.setShipState((long) 4);
		shipOperationDao.update(shipOperation);
	}

	@Override
	public PageResults<ShipOperation> queryOrderShipInfo(int pageNo) {
		// TODO Auto-generated method stub
		return shipOperationDao
				.findPageByFetchedHql(
						"from ShipOperation where shipState=1 order by shipOperationCode",
						"select count(*) from ShipOperation where shipState=1",
						pageNo, 10);
	}

	@Override
	public ShipOperation getByCode(long shipOperationCode) {
		// TODO Auto-generated method stub
		return shipOperationDao.get(shipOperationCode);
	}
}
