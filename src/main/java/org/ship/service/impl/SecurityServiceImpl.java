package org.ship.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.ship.dao.ISecurityDao;
import org.ship.model.Security;
import org.ship.service.ISecurityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("securityService")
public class SecurityServiceImpl implements ISecurityService{

	@Resource
	private ISecurityDao securityDao;
	
	@Override
	public void addSecurity(Security security) {
		// TODO Auto-generated method stub
		securityDao.save(security);
	}

	@Override
	public Security queryById(long securityId) {
		// TODO Auto-generated method stub
		return securityDao.get(securityId);
	}

	@Override
	public List<Security> queryByAll() {
		// TODO Auto-generated method stub
		return securityDao.getListByHQL("from Security");
	}

	
}
