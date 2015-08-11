package org.ship.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.ship.dao.IRoleInfoDao;
import org.ship.model.RoleInfo;
import org.ship.service.IRoleInfoService;
import org.springframework.stereotype.Service;

@Transactional
@Service("roleInfoService")
public class RoleInfoServiceImpl implements IRoleInfoService {

	@Resource
	private IRoleInfoDao roleInfoDao;
	
	@Override
	public List<RoleInfo> queryByAll() {
		// TODO Auto-generated method stub
		return roleInfoDao.getListByHQL("from RoleInfo order by roleId");
	}

	@Override
	public RoleInfo getById(long roleId) {
		// TODO Auto-generated method stub
		return roleInfoDao.get(roleId);
	}

	@Override
	public void save(RoleInfo roleInfo) {
		// TODO Auto-generated method stub
		roleInfoDao.save(roleInfo);
	}

	@Override
	public void delete(RoleInfo roleInfo) {
		// TODO Auto-generated method stub
		roleInfoDao.delete(roleInfo);
	}

	@Override
	public void update(RoleInfo roleInfo) {
		// TODO Auto-generated method stub
		roleInfoDao.update(roleInfo);
	}

}
