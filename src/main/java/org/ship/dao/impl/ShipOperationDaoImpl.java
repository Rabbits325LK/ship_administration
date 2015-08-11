package org.ship.dao.impl;

import org.ship.dao.IShipOperationDao;
import org.ship.model.ShipOperation;
import org.springframework.stereotype.Repository;

@Repository("shipOperationDao")
public class ShipOperationDaoImpl extends BaseDaoImpl<ShipOperation, Long> implements IShipOperationDao{

}
