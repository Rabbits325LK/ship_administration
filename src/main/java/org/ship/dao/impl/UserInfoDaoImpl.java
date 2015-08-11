package org.ship.dao.impl;

import org.ship.dao.IUserInfoDao;
import org.ship.model.UserInfo;
import org.springframework.stereotype.Repository;

@Repository("userInfoDao")
public class UserInfoDaoImpl extends BaseDaoImpl<UserInfo, Long> implements IUserInfoDao {

}
