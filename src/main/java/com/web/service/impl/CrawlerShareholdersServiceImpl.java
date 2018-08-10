package com.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.dao.CrawlerShareholdersDao;
import com.web.pojo.CrawlerShareholders;
import com.web.service.CrawlerShareholdersService;
@Service
@Transactional
public class CrawlerShareholdersServiceImpl implements CrawlerShareholdersService{
	@Autowired
	private CrawlerShareholdersDao crawlerShareholdersDao;
	
	@Override
	public List<CrawlerShareholders> selectShareholdersByParam(String code, String name){
		return crawlerShareholdersDao.selectShareholdersByParam(code, name);
	}
}
