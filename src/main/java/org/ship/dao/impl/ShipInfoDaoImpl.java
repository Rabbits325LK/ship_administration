package org.ship.dao.impl;

import org.ship.dao.IShipInfoDao;
import org.ship.model.ShipInfo;
import org.springframework.stereotype.Repository;

@Repository("shipInfoDao")
public class ShipInfoDaoImpl extends BaseDaoImpl<ShipInfo, Long> implements IShipInfoDao{

}
