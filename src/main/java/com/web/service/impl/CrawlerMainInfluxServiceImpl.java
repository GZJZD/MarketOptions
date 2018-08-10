package com.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.dao.CrawlerMainInfluxDao;
import com.web.pojo.CrawlerMainInflux;
import com.web.service.CrawlerMainInfluxService;
@Service
@Transactional
public class CrawlerMainInfluxServiceImpl implements CrawlerMainInfluxService{
	@Autowired
	private CrawlerMainInfluxDao crawlerMainInfluxDao;
	
	@Override
	public List<CrawlerMainInflux> selectMainInfluxByParam(String code, String name){
		return crawlerMainInfluxDao.selectMainInfluxByParam(code, name);
	}
}
