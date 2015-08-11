package org.ship.service;

import org.ship.model.NewsInfo;
import org.ship.util.PageResults;

public interface INewsInfoService {
	
	/**
	 * 添加新闻
	 */
	public void save(NewsInfo newsInfo);
	/*分页查询新闻*/
	public PageResults<NewsInfo> findByPage(int pageNo);
	/*删除新闻*/
	public void delete(NewsInfo newsInfo);
	/*跟新新闻*/
	public void update(NewsInfo newsInfo);
	/*根据编号查询新闻*/
	public NewsInfo queryByCode(long newsCode);
}
