package org.ship.dao.impl;

import org.ship.dao.INewsInfoDao;
import org.ship.model.NewsInfo;
import org.springframework.stereotype.Repository;

@Repository("newsInfoDao")
public class NewsInfoDaoimpl extends BaseDaoImpl<NewsInfo, Long> implements INewsInfoDao{

}
