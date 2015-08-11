package org.ship.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.ship.dao.IShipInfoDao;
import org.ship.model.ShipInfo;
import org.ship.service.IShipInfoService;
import org.ship.util.PageResults;
import org.springframework.stereotype.Service;

@Transactional
@Service("shipInfoService")
public class ShipInfoServiceImpl implements IShipInfoService {

	@Resource
	private IShipInfoDao shipInfoDao;

	@Override
	public List<ShipInfo> queryByAll() {
		// TODO Auto-generated method stub
		return shipInfoDao.getListByHQL("from ShipInfo order by shipId");
	}

	@Override
	public ShipInfo getById(long shipId) {
		// TODO Auto-generated method stub
		return shipInfoDao.get(shipId);
	}

	@Override
	public ShipInfo queryByShipName(String shipName) {
		// TODO Auto-generated method stub
		return shipInfoDao.getByHQL("from ShipInfo where shipName=?", shipName);
	}

	@Override
	public List<ShipInfo> queryByShipType(long shipTypeCode) {
		// TODO Auto-generated method stub
		return shipInfoDao.getListByHQL("from ShipInfo where shipTypeCode=?", shipTypeCode);
	}

	@Override
	public void save(ShipInfo shipInfo) {
		// TODO Auto-generated method stub
		shipInfoDao.save(shipInfo);
	}

	@Override
	public void update(ShipInfo shipInfo) {
		// TODO Auto-generated method stub
		shipInfoDao.update(shipInfo);
	}

	@Override
	public void delete(ShipInfo shipInfo) {
		// TODO Auto-generated method stub
		shipInfoDao.delete(shipInfo);
	}

	@Override
	public PageResults<ShipInfo> findByPage(int pageNo) {
		// TODO Auto-generated method stub
		return shipInfoDao.findPageByFetchedHql("from ShipInfo order by shipId", "select count(*) from ShipInfo",
				pageNo, 10);
	}

}
