package org.ship.dao.impl;

import org.ship.dao.IRoleInfoDao;
import org.ship.model.RoleInfo;
import org.springframework.stereotype.Repository;

@Repository("roleInfoDao")
public class RoleInfoDaoImpl extends BaseDaoImpl<RoleInfo, Long> implements IRoleInfoDao{

}
