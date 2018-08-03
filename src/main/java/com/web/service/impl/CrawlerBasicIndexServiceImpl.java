package com.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.dao.CrawlerBasicIndexDao;
import com.web.pojo.CrawlerBasicIndex;
import com.web.service.CrawlerBasicIndexService;
@Service
@Transactional
public class CrawlerBasicIndexServiceImpl implements CrawlerBasicIndexService{
	@Autowired
	private CrawlerBasicIndexDao crawlerBasicIndexDao;
	
	@Override
	public List<CrawlerBasicIndex> selectBasicIndexByParam(String code, String name){
		return crawlerBasicIndexDao.selectBasicIndexByParam(code, name);
	}
}
