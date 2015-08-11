package org.ship.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.ship.dao.INewsInfoDao;
import org.ship.model.NewsInfo;
import org.ship.service.INewsInfoService;
import org.ship.util.PageResults;
import org.springframework.stereotype.Service;

@Transactional
@Service("newsInfoService")
public class NewsInfoServiceImpl implements INewsInfoService {

	@Resource
	private INewsInfoDao newsInfoDao;

	@Override
	public void save(NewsInfo newsInfo) {
		// TODO Auto-generated method stub
		newsInfoDao.save(newsInfo);
	}

	@Override
	public PageResults<NewsInfo> findByPage(int pageNo) {
		// TODO Auto-generated method stub
		return newsInfoDao.findPageByFetchedHql("from NewsInfo order by newsCode", "select count(*) from RoleInfo",
				pageNo, 10);
	}

	@Override
	public void delete(NewsInfo newsInfo) {
		// TODO Auto-generated method stub
		newsInfoDao.delete(newsInfo);
	}

	@Override
	public void update(NewsInfo newsInfo) {
		// TODO Auto-generated method stub
		newsInfoDao.update(newsInfo);
	}

	@Override
	public NewsInfo queryByCode(long newsCode) {
		// TODO Auto-generated method stub
		return newsInfoDao.get(newsCode);
	}
}
