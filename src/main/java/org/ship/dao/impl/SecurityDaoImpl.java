package org.ship.dao.impl;

import org.ship.dao.ISecurityDao;
import org.ship.model.Security;
import org.springframework.stereotype.Repository;

@Repository("securityDao")
public class SecurityDaoImpl extends BaseDaoImpl<Security, Long> implements ISecurityDao{

}
