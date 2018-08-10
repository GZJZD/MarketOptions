package com.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.dao.CrawlerFinancialDisclosureDao;
import com.web.pojo.CrawlerFinancialDisclosure;
import com.web.service.CrawlerFinancialDisclosureService;
@Service
@Transactional
public class CrawlerFinancialDisclosureServiceImpl implements CrawlerFinancialDisclosureService{
	@Autowired
	private CrawlerFinancialDisclosureDao crawlerFinancialDisclosureDao;
	
	@Override
	public List<CrawlerFinancialDisclosure> selectFinancialDisclosureByParam(String code, String name){
		return crawlerFinancialDisclosureDao.selectFinancialDisclosureByParam(code, name);
	}
}
