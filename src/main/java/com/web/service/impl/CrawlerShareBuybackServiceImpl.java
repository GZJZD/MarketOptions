package com.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.dao.CrawlerShareBuybackDao;
import com.web.pojo.CrawlerShareBuyback;
import com.web.service.CrawlerShareBuybackService;
@Service
@Transactional
public class CrawlerShareBuybackServiceImpl implements CrawlerShareBuybackService{
	@Autowired
	private CrawlerShareBuybackDao crawlerShareBuybackDao;
	
	@Override
	public List<CrawlerShareBuyback> selectShareBuybackByParam(String code, String name){
		return crawlerShareBuybackDao.selectShareBuybackByParam(code, name);
	}
}
