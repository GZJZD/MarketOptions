package com.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.dao.CrawlerRestrictedCirculationDao;
import com.web.pojo.CrawlerRestrictedCirculation;
import com.web.service.CrawlerRestrictedCirculationService;
@Service
@Transactional
public class CrawlerRestrictedCirculationServiceImpl implements CrawlerRestrictedCirculationService{
	@Autowired
	private CrawlerRestrictedCirculationDao crawlerRestrictedCirculationDao;
	
	@Override
	public List<CrawlerRestrictedCirculation> selectRestrictedCirculationByParam(String code, String name){
		return crawlerRestrictedCirculationDao.selectRestrictedCirculationByParam(code, name);
	}
}
