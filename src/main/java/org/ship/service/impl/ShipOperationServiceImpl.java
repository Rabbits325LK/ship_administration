package org.ship.service.impl;

import java.util.ArrayList;
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

	/**
	 * 查询预订列表
	 */
	@Override
	public List<ShipOperation> queryByShipState(long shipState) {
		// TODO Auto-generated method stub
		List<ShipOperation> shipOperations = new ArrayList<ShipOperation>();
		if (shipState == 0) {
			shipOperations = shipOperationDao
					.getListByHQL("from ShipOperation");
		} else {
			shipOperations = shipOperationDao.getListByHQL(
					"from ShipOperation where shipState=?", shipState);
		}
		return shipOperations;
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
		/*
		 * List<ShipOperation> sos = shipOperationDao .getListByHQL(
		 * "from ShipOperation where shipId=? and stratime>= ? and endtime <= ? and shipState = 2"
		 * , shipOperation.getShipId(), shipOperation.getStratime(),
		 * shipOperation.getStratime());
		 */
		List<ShipOperation> sos = shipOperationDao
				.getListBySQL("select * from ship_operation where ((stratime <= '"
						+ shipOperation.getStratime()
						+ "'and endtime >= '"
						+ shipOperation.getStratime()
						+ "')or ( stratime <='"
						+ shipOperation.getEndtime()
						+ "' and endtime >= '"
						+ shipOperation.getEndtime()
						+ "')) or ( stratime >= '"
						+ shipOperation.getStratime()
						+ "' and endtime <= '"
						+ shipOperation.getEndtime()
						+ "') and ship_state = 2 and ship_id = "
						+ shipOperation.getShipId());
		/*
		 * long count = 0; count = shipOperationDao
		 * .countByHql("select count(*) from ShipOperation where stratime>=" +
		 * shipOperation.getStratime()); System.out.println(count);
		 */
		System.out.println(sos.size());
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
	public PageResults<ShipOperation> queryOrderShipInfoState(int pageNo,
			long state) {
		// TODO Auto-generated method stub
		PageResults<ShipOperation> page = new PageResults<ShipOperation>();
		if (state == 0) {
			page = shipOperationDao.findPageByFetchedHql("from ShipOperation",
					"select count(*) from ShipOperation", pageNo, 10);
		} else {
			page = shipOperationDao
					.findPageByFetchedHql(
							"from ShipOperation where shipState=? order by shipOperationCode",
							"select count(*) from ShipOperation where shipState=?",
							pageNo, 10, state);
		}

		return page;
	}

	@Override
	public ShipOperation getByCode(long shipOperationCode) {
		// TODO Auto-generated method stub
		return shipOperationDao.get(shipOperationCode);
	}

	@Override
	public boolean getByCodeforStateOrder(long shipOperationCode) {
		// TODO Auto-generated method stub
		java.sql.Timestamp nowtime = new java.sql.Timestamp(
				System.currentTimeMillis());
		long count = shipOperationDao
				.countByHql(
						"select count(*) from ShipOperation where shipOperationCode=? and stratime > ? and shipState = 1",
						shipOperationCode, nowtime);
		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<ShipOperation> pastOrderShipInfo() {
		// TODO Auto-generated method stub
		java.sql.Timestamp nowtime = new java.sql.Timestamp(
				System.currentTimeMillis());
		return shipOperationDao
				.getListByHQL(
						"from ShipOperation where endtime < ? and shipState != 2 and shipState != 3 and shipState != 4",
						nowtime);
	}

	@Override
	public List<ShipOperation> pastUseShipInfo() {
		// TODO Auto-generated method stub
		java.sql.Timestamp nowtime = new java.sql.Timestamp(
				System.currentTimeMillis());
		return shipOperationDao
				.getListByHQL(
						"from ShipOpertion where endtim < ? and shipState = 2",
						nowtime);
	}

	@Override
	public ShipOperation queryByCodeAndState(long shipOperationCode,
			long shipState) {
		// TODO Auto-generated method stub
		return shipOperationDao
				.getByHQL(
						"from ShipOperation where shipOperationCode = ? and shipState = ?",
						shipOperationCode, shipState);
	}
}
