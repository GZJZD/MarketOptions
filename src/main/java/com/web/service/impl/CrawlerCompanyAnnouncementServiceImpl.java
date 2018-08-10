package com.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.dao.CrawlerCompanyAnnouncementDao;
import com.web.pojo.CrawlerCompanyAnnouncement;
import com.web.service.CrawlerCompanyAnnouncementService;
@Service
@Transactional
public class CrawlerCompanyAnnouncementServiceImpl implements CrawlerCompanyAnnouncementService{
	@Autowired
	private CrawlerCompanyAnnouncementDao crawlerCompanyAnnouncementDao;
	
	@Override
	public List<CrawlerCompanyAnnouncement> selectCompanyAnnounceByParam(String code, String name){
		return crawlerCompanyAnnouncementDao.selectCompanyAnnounceByParam(code, name);
	}
}
