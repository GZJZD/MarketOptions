package com.web.service;

import java.util.List;

import com.web.pojo.CrawlerCompanyAnnouncement;

public interface CrawlerCompanyAnnouncementService {
	List<CrawlerCompanyAnnouncement> selectCompanyAnnounceByParam(String code, String name);
}
