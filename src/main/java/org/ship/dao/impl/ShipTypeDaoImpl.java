package org.ship.dao.impl;

import org.ship.dao.IShipTypeDao;
import org.ship.model.ShipType;
import org.springframework.stereotype.Repository;

@Repository("shipTypeDao")
public class ShipTypeDaoImpl extends BaseDaoImpl<ShipType, Long> implements IShipTypeDao {

}
