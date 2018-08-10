package com.web.service;

import java.util.List;

import com.web.pojo.CrawlerCompanyNews;

public interface CrawlerCompanyNewsService {
	List<CrawlerCompanyNews> selectCompanyNewsByParam(String code, String name);
}
