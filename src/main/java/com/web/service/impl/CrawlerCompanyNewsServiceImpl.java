package com.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.dao.CrawlerCompanyNewsDao;
import com.web.pojo.CrawlerCompanyNews;
import com.web.service.CrawlerCompanyNewsService;
@Service
@Transactional
public class CrawlerCompanyNewsServiceImpl implements CrawlerCompanyNewsService{
	@Autowired
	private CrawlerCompanyNewsDao crawlerCompanyNewsDao;
	
	@Override
	public List<CrawlerCompanyNews> selectCompanyNewsByParam(String code, String name){
		return crawlerCompanyNewsDao.selectCompanyNewsByParam(code, name);
	}
}
