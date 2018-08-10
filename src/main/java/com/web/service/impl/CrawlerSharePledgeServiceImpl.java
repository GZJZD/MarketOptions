package com.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.dao.CrawlerSharePledgeDao;
import com.web.pojo.CrawlerSharePledge;
import com.web.service.CrawlerSharePledgeService;
@Service
@Transactional
public class CrawlerSharePledgeServiceImpl implements CrawlerSharePledgeService{
	@Autowired
	private CrawlerSharePledgeDao crawlerSharePledgeDao;
	
	@Override
	public List<CrawlerSharePledge> selectSharePledgeByParam(String code, String name){
		return crawlerSharePledgeDao.selectSharePledgeByParam(code, name);
	}
}
